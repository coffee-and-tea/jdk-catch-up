package coffee_and_tea.jdk8.jep155_concurrency_updates;

import java.time.Instant;
import java.time.LocalTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {

    public static void main(String[] args) {

        fixedThreadPoolDemo();

        cachedThreadPoolDemo();

        executorServiceSubmitForFutureTask();

        scheduledExecutorServiceDemo();
    }

    private static void scheduledExecutorServiceDemo() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.schedule(() -> System.out.println("Print in 10 seconds at " + LocalTime.now()), 10, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(() -> System.out.println("Print every 10 seconds at " + LocalTime.now()), 0, 10, TimeUnit.SECONDS);
        executorService.scheduleWithFixedDelay( () -> {
            System.out.println("Print and wait for 20 seconds until next print at " + LocalTime.now());

        }, 0, 20, TimeUnit.SECONDS);
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    private static void executorServiceSubmitForFutureTask() {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        BankAccountWithTransferWithLock account1 = new BankAccountWithTransferWithLock("0", 0);
        BankAccountWithTransferWithLock account2 = new BankAccountWithTransferWithLock("1", 0);

        Runnable runnable1 = () -> {
            System.out.println("Thread: " + Thread.currentThread() + " run transfer from account 1 to account 2");
            account1.transfer(account2, 10);
            System.out.println("Thread: " + Thread.currentThread() + " completed");
        };
        Runnable runnable2 = () -> {
            System.out.println("Thread: " + Thread.currentThread() + " run transfer from account 2 to account 1");
            account2.transfer(account1, 10);
            System.out.println("Thread: " + Thread.currentThread() + " completed");
        };

        Future run1Result = executor.submit(runnable1);
        Future<BankAccountWithTransferWithLock> run2Result = executor.submit(runnable2, account2);

        try {
            run1Result.get();
            System.out.println("Runnable 1 completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {
            BankAccountWithTransferWithLock account =  run2Result.get();
            System.out.println("Runnable 2 completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

    private static void cachedThreadPoolDemo() {
        ExecutorService executor = Executors.newCachedThreadPool();

        BankAccountWithTransferWithLock account1 = new BankAccountWithTransferWithLock("0", 0);
        BankAccountWithTransferWithLock account2 = new BankAccountWithTransferWithLock("1", 0);

        Runnable runnable1 = () -> {
            System.out.println("Cached thread: " + Thread.currentThread() + " run transfer from account 1 to account 2");
            account1.transfer(account2, 10);
            System.out.println("Cached thread: " + Thread.currentThread() + " completed");
        };
        Runnable runnable2 = () -> {
            System.out.println("Cached thread: " + Thread.currentThread() + " run transfer from account 2 to account 1");
            account2.transfer(account1, 10);
            System.out.println("Cached thread: " + Thread.currentThread() + " completed");
        };

        executor.execute(runnable1);
        executor.execute(runnable2);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.execute(runnable1);
        executor.execute(runnable2);

        executor.shutdown();
    }

    private static void fixedThreadPoolDemo() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        BankAccountWithTransferWithLock account1 = new BankAccountWithTransferWithLock("0", 0);
        BankAccountWithTransferWithLock account2 = new BankAccountWithTransferWithLock("1", 0);

        Runnable runnable1 = () -> {
            System.out.println("Thread: " + Thread.currentThread() + " run transfer from account 1 to account 2");
            account1.transfer(account2, 10);
            System.out.println("Thread: " + Thread.currentThread() + " completed");
        };
        Runnable runnable2 = () -> {
            System.out.println("Thread: " + Thread.currentThread() + " run transfer from account 2 to account 1");
            account2.transfer(account1, 10);
            System.out.println("Thread: " + Thread.currentThread() + " completed");
        };

        executor.execute(runnable1);
        executor.execute(runnable2);
        executor.execute(runnable1);
        executor.execute(runnable2);

        executor.shutdown();
    }
}
