package coffee_and_tea.jdk14.jep349_jfr_event_streaming;

import jdk.jfr.consumer.RecordingStream;

import java.time.Duration;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JFRStream {

    public static void main(String[] args) throws InterruptedException {
        // create a thread to recording stream from current JVM

        Executor executor = Executors.newFixedThreadPool(2);

        Runnable runnable = () -> {
            try (var recordingStream = new RecordingStream()) {
                recordingStream.enable("jdk.CPULoad").withPeriod(Duration.ofSeconds(1));
                recordingStream.enable("jdk.JavaMonitorEnter").withThreshold(Duration.ofMillis(10));
                recordingStream.onEvent("jdk.CPULoad", event -> {
                    System.out.println("CPU total usage:" + event.getFloat("machineTotal"));
                });
                recordingStream.onEvent("jdk.JavaMonitorEnter", event -> {
                    System.out.println("monitoring: " + event.getClass("monitorClass"));
                });
                recordingStream.start();
            }
        };

        executor.execute(runnable);

        Thread.sleep(10000);
        System.out.println("Main thread completed");
    }
}
