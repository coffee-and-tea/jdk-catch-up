package coffee_and_tea.jdk7.jsr203_NIO;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NioFileSystemsApi {

    public static void main(String [] args) throws IOException{
        // get current File System
        FileSystem currentFileSystem = FileSystems.getDefault();

        System.out.println("======= Current System File Stores =======");
        for (FileStore fileStore : currentFileSystem.getFileStores()) {
            System.out.print(fileStore);
            System.out.print(" ,type: " + fileStore.type());
            System.out.println(" , size: " + fileStore.getTotalSpace());
        }

        System.out.println("======= Current file system should be open =======");
        System.out.println("File system is open: " + currentFileSystem.isOpen());

        System.out.println("======= Current file system root directories =======");
        for(Path path : currentFileSystem.getRootDirectories()) {
            System.out.println(path);
        }

        System.out.println("======= Current file system path separator =======");
        System.out.println(currentFileSystem.getSeparator());

        System.out.println("======= Current file system file attributes =======");
        for(String attribute: currentFileSystem.supportedFileAttributeViews()){
            System.out.println(attribute);
        }
    }

}
