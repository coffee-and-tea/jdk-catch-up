package coffee_and_tea.jdk9.jep266_more_concurrency_updates;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class FlowApi {

    public static void main(String[] args) throws InterruptedException {
        Publisher<Integer> fibPublisher = new FibPublisher();
        Subscriber<Integer> fibSubscriber1 = new FibSubscriber("Subscriber1");
        Subscriber<Integer> fibSubscriber2 = new FibSubscriber("Subscriber2");

        fibPublisher.subscribe(fibSubscriber1);

        Thread.sleep(20000);

        fibPublisher.subscribe(fibSubscriber2);
    }
}

class FibSubscriber implements Subscriber<Integer> {

    private String name;
    private Subscription subscription;
    private int request;
    private Instant requestTime;

    public FibSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        System.out.println(this.name + " subscribed");
        requestTime = Instant.now();
        subscription.request(request++);
    }

    @Override
    public void onNext(Integer item) {
        Duration responseTime = Duration.between(requestTime, Instant.now());
        System.out.println(this.name + " received response fib(" + (request - 1) + ") in " + responseTime.toNanos() / 1_000 + " microseconds: " + item);

        // sleep for 10 seconds then sends next request
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        requestTime = Instant.now();
        CompletableFuture future = CompletableFuture.runAsync(
            () -> subscription.request(request++)
        );
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public String toString() {
        return "FibSubscriber{" +
                "name='" + name + '\'' +
                '}';
    }
}

class FibPublisher implements Publisher<Integer> {

    Map<Subscriber, Subscription> subscriberSubscriptionMap = new HashMap<>();

    Map<Long, Integer> resultCache = new HashMap<>();

    @Override
    public void subscribe(Subscriber subscriber) {
        subscriber.onSubscribe(subscriberSubscriptionMap.computeIfAbsent(
                subscriber,
                s -> new FibSubscription(this, s)
        ));
    }

    public Integer getFib(long n) {
        return resultCache.computeIfAbsent(
                n,
                l -> Fib.fib(n)
        );
    }

    public void cancel(Subscriber subscriber) {
        subscriberSubscriptionMap.remove(subscriber);
    }
}

class FibSubscription implements Subscription {

    // one thread per subscription
    private final ExecutorService executorService = Executors.newFixedThreadPool(1);

    private final Subscriber subscriber;

    private final FibPublisher fibPublisher;

    public FibSubscription(FibPublisher fibPublisher, Subscriber subscriber) {
        this.fibPublisher = fibPublisher;
        this.subscriber = subscriber;
    }

    @Override
    public void request(long n) {
//        executorService.submit(
//                () -> subscriber.onNext(fibPublisher.getFib(n))
//        );

        CompletableFuture<Void> future =
               CompletableFuture.runAsync(
                        () -> subscriber.onNext(fibPublisher.getFib(n)), executorService);

        CompletableFuture<Void> completion = future.thenRun(() -> System.out.println("Supplied " + this.subscriber + "with fib(" + n + ")."));
        try {
            completion.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cancel() {
        fibPublisher.cancel(subscriber);
    }
}

class Fib {

    public synchronized static Integer fib(long i) {
        if (i == 0)
            return 0;
        if (i == 1 || i == 2) {
            return 1;
        } else {
            return fib(i - 1) + fib(i - 2);
        }
    }
}
