package coffee_and_tea.jdk9.jep102_process_api;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class ProcessApi {

    public static void main(String[] args) throws IOException, URISyntaxException {

        File workingDir = Paths.get(ProcessApi.class.getClassLoader().getResource("helloWorld.sh")
                .toURI()).toFile();

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(workingDir.getAbsolutePath());
        Process process = processBuilder.start();
        System.out.println("Hello world process pid: " + process.pid());
        process.toHandle().onExit().thenAccept( (p) -> System.out.println("Hello world exit with: " + process.exitValue()));

        ProcessHandle.allProcesses().forEach(
                p -> {
                    System.out.println(p.info());
                }
        );
    }
}