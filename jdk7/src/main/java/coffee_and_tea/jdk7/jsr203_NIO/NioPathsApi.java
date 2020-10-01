package coffee_and_tea.jdk7.jsr203_NIO;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NioPathsApi {

    public static void main(String [] args) throws IOException {
        Path workingDir = Paths.get("");
        System.out.println("======= Current working directory =======");
        System.out.print(workingDir.toAbsolutePath());
        System.out.println(" having: " + workingDir.getNameCount() + " files");
    }
}
