package coffee_and_tea.jdk7.jsr203_NIO;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class NioWatchServiceApi {
    public static void main(String[] args) throws IOException, InterruptedException {

        // get system default watch service implementation platform dependent
        WatchService watchService = FileSystems.getDefault().newWatchService();

        // Path 1, 2 to watch a folder as example
        // Watch jdk7 folder
        Path jdk7 = Paths.get("jdk7");

        // Watch jdk8 folder
        Path jdk8 = Paths.get("jdk8");

        // watch key 1: register path 1 to watch service
        WatchKey jdk7WatchKey = jdk7.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.OVERFLOW);

        // watch key 2: register path 2 to watch service
        WatchKey jdk8WatchKey = jdk8.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.OVERFLOW);

        // actions on path 1 and path 2
        Path jdk7temp = Paths.get("jdk7/jdk7.txt");
        Files.createFile(jdk7temp);

        Path jdk8temp = Paths.get("jdk8/jdk8.txt");
        Files.createFile(jdk8temp);


        // take watch key from watch service, check key 1 or 2
        // wait for 2 seconds to try a key, allow time watch service to process above event
        // could use watchService.take() as well, although it may pose the thread
        // in my environment it takes up to 10 seconds for watchService to get the key ready
        System.out.println("Start to retrieve key 1:" + LocalDateTime.now());
        WatchKey eventKey = watchService.poll(10, TimeUnit.SECONDS);
        System.out.println("Key retrieved:" + LocalDateTime.now());

        // print events
        printWatchKeyEvent(jdk7WatchKey, eventKey);

        // take another key from watch service, check key 1 and key 2
        System.out.println("Start to retrieve key 2:" + LocalDateTime.now());
        eventKey = watchService.poll(5, TimeUnit.SECONDS);
        System.out.println("Key retrieved:" + LocalDateTime.now());


        // print events
        printWatchKeyEvent(jdk7WatchKey, eventKey);

        // delete temp files
        Files.deleteIfExists(jdk7temp);
        Files.deleteIfExists(jdk8temp);
    }

    private static void printWatchKeyEvent(WatchKey jdk7WatchKey, WatchKey eventKey) {
        if (eventKey == null)
            return;
        if(eventKey == jdk7WatchKey){
            System.out.println("JDK7 event observed:");
        }else{
            System.out.println("JDK8 event observed:");
        }
        eventKey.pollEvents().stream().forEach(watchEvent -> {
                    System.out.println(watchEvent.kind());
                    System.out.println(watchEvent.count());
                    System.out.println(watchEvent.context());
                }
        );
    }
}
