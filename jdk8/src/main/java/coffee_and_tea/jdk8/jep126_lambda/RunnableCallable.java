package coffee_and_tea.jdk8.jep126_lambda;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        playWithRunnable();

        playWithCallable();
    }

    private static void playWithRunnable() {

        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Tea from runnable");
        };

        new Thread(runnable).start();
    }

    private static void playWithCallable() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Callable<String> callable = () -> {
            Thread.sleep(10000);
            System.out.println("Coffee from callable");
            return "Coffee";
        };

        Future<String> stringFuture = executorService.submit(callable);
        System.out.println("Print before anything else");
        // this will wait for callable method to return
        System.out.println(stringFuture.get() + " time");
        executorService.shutdown();
        System.out.println("Executor service shutdown completed");
    }
}
