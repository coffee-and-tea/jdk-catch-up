package coffee_and_tea.jdk8.jep155_concurrency_updates;

public class ThreadRunnable {

    public static void main(String[] args) throws InterruptedException {

        Thread threadExample = new ThreadExample();
        Thread runnableExample = new Thread(runnable);

        threadExample.start();
        runnableExample.start();
        threadExample.interrupt();
        threadExample.join();
        System.out.println(Thread.currentThread());
    }

    static Runnable runnable = () ->
        System.out.println("Runnable execution");

}

class ThreadExample extends Thread {

    @Override
    public void run() {
        try {
            sleep(10000);
            System.out.println("Thread example execution after sleep 10 seconds");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


