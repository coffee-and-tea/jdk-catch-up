package coffee_and_tea.jdk7.jsr203_NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;

public class NioFileAttributesApi {

    public static void main(String[] args) throws IOException {
        playWithBasicFileAttributes();

        playWithPosixFileAttributes();

        playWithDosFileAttributes();
    }

    private static void playWithDosFileAttributes() throws IOException {
        Path readme = Paths.get("README.md");
        DosFileAttributeView readmeView =
                Files.getFileAttributeView(readme, DosFileAttributeView.class);
        if (readmeView != null) {
            System.out.println("View name: " + readmeView.name());
            DosFileAttributes readmeAttrs = readmeView.readAttributes();
            System.out.println("File created: " + readmeAttrs.creationTime());
            System.out.println("File key: " + readmeAttrs.fileKey());
            System.out.println("Is directory: " + readmeAttrs.isDirectory());
            System.out.println("Is other(not folder, not regular, not symbolic link): " + readmeAttrs.isOther());
            System.out.println("Is regular file: " + readmeAttrs.isRegularFile());
            System.out.println("Is symbolic link: " + readmeAttrs.isSymbolicLink());
            System.out.println("Last access time: " + readmeAttrs.lastAccessTime());
            System.out.println("Last modified time: " + readmeAttrs.lastModifiedTime());
            System.out.println("Size: " + readmeAttrs.size());
            System.out.println("Is archive: " + readmeAttrs.isArchive());
        } else {
            System.out.println("Not Dos based OS");
        }
    }

    private static void playWithPosixFileAttributes() throws IOException {
        Path readme = Paths.get("README.md");
        PosixFileAttributeView readmeView =
                Files.getFileAttributeView(readme, PosixFileAttributeView.class);

        if (readmeView != null) {
            System.out.println("View name: " + readmeView.name());
            PosixFileAttributes readmeAttrs = readmeView.readAttributes();
            System.out.println("File created: " + readmeAttrs.creationTime());
            System.out.println("File key: " + readmeAttrs.fileKey());
            System.out.println("Is directory: " + readmeAttrs.isDirectory());
            System.out.println("Is other(not folder, not regular, not symbolic link): " + readmeAttrs.isOther());
            System.out.println("Is regular file: " + readmeAttrs.isRegularFile());
            System.out.println("Is symbolic link: " + readmeAttrs.isSymbolicLink());
            System.out.println("Last access time: " + readmeAttrs.lastAccessTime());
            System.out.println("Last modified time: " + readmeAttrs.lastModifiedTime());
            System.out.println("Size: " + readmeAttrs.size());
            System.out.println("Group: " + readmeAttrs.group());
            System.out.println("Owner: " + readmeAttrs.owner());
            System.out.println("Permission: " + readmeAttrs.permissions());
        } else {
            System.out.println("Not Posix based OS");
        }
    }

    private static void playWithBasicFileAttributes() throws IOException {
        Path readme = Paths.get("README.md");
        BasicFileAttributeView readmeView =
                Files.getFileAttributeView(readme, BasicFileAttributeView.class);

        System.out.println("View name: " + readmeView.name());
        BasicFileAttributes readmeAttrs = readmeView.readAttributes();
        System.out.println("File created: " + readmeAttrs.creationTime());
        System.out.println("File key: " + readmeAttrs.fileKey());
        System.out.println("Is directory: " + readmeAttrs.isDirectory());
        System.out.println("Is other(not folder, not regular, not symbolic link): " + readmeAttrs.isOther());
        System.out.println("Is regular file: " + readmeAttrs.isRegularFile());
        System.out.println("Is symbolic link: " + readmeAttrs.isSymbolicLink());
        System.out.println("Last access time: " + readmeAttrs.lastAccessTime());
        System.out.println("Last modified time: " + readmeAttrs.lastModifiedTime());
        System.out.println("Size: " + readmeAttrs.size());
    }
}
