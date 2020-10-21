package coffee_and_tea.jdk7.jsr334_small_enhancements_project_coin;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TryWithResource {

    public static void main(String[] args) throws IOException {

        Path readme = Paths.get("README.md");

        // try with closable resource
        try(FileChannel fc = FileChannel.open(readme, StandardOpenOption.READ, StandardOpenOption.WRITE)){

            // read 14 bytes and output
            ByteBuffer bb = ByteBuffer.allocate(14);
            fc.read(bb);
            System.out.println("14 bytes: " + new String(bb.array()));
        }

        // try with resource will close the resource, no explicit call needed
    }
}
