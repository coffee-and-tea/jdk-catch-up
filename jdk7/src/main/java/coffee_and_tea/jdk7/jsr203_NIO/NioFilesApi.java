package coffee_and_tea.jdk7.jsr203_NIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class NioFilesApi {

    public static void main(String[] args) throws IOException {

        playWithCopyFiles();

        //create folder
        playWithCreateDirectories();

        //create file
        playWithFileCreation();

        //create link
        playWithLinks();

        //create symbolic link
        playWithSymbolicLinks();

        //create temp folder
        playWithTempFolder();

        //create temp file
        playWithTempFile();

        //lines
        playWithLines();

        //list folder
        playWithList();

        //move
        playWithMove();

        //interoperability
        playWithInteroperability();

        //size
        playWithSize();

        //walk
        playWithWalk();

        //write
        playWithWrite();

        //owner
        playWithOwner();
    }

    private static void playWithOwner() throws IOException {
        Path readme = Paths.get("README.md");
        UserPrincipal user = Files.getOwner(readme);
        System.out.println("File " + readme + " owned by user " + user.getName());
    }

    private static void playWithWrite() throws IOException {
        Path tempFile = Paths.get("temp.txt");
        List<String> lines = Arrays.asList("line1", "line2", "line3");
        Files.write(tempFile, lines);
        Files.delete(tempFile);
    }

    private static void playWithWalk() throws IOException {
        Path crrtDir = Paths.get(".");
        System.out.println("Walking through current directory: " + crrtDir.toAbsolutePath());
        Files
                .walk(crrtDir)
                .filter(path -> !(path.startsWith("./.git") || path.startsWith("./.idea")))
                .forEach(System.out::println);

        Files
                .walkFileTree(crrtDir, new SimpleFileVisitor() {
                    @Override
                    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
                        FileVisitResult result = super.visitFile(file, attrs);
                        System.out.println(file);
                        return result;
                    }
                });
    }

    private static void playWithSize() throws IOException {
        Path readme = Paths.get("README.md");
        long readmeSize = Files.size(readme);
        System.out.println(readme + "'s size: " + readmeSize + " bytes");
    }

    private static void playWithInteroperability() throws IOException {
        // from io File to nio Path
        File file = new File("README.md");
        Path readme = file.toPath();

        // from nio to io Reader
        BufferedReader readmeBReader = Files.newBufferedReader(readme, StandardCharsets.UTF_8);
        readmeBReader.lines().forEach(System.out::println);
        readmeBReader.close();

        // from nio to InputStream
        InputStream readmeIStream = Files.newInputStream(readme);
        readmeIStream.close();

        Path newFile = Paths.get("newFile.txt");

        // from nio to id Writer
        BufferedWriter readmeBWriter = Files.newBufferedWriter(newFile);
        readmeBWriter.close();

        // from nio to OutputStream
        OutputStream readmeOStream = Files.newOutputStream(newFile);
        readmeOStream.close();

        Files.delete(newFile);
    }

    private static void playWithMove() throws IOException {
        Path newFile = Paths.get("newFile.txt");
        Path renameFile = Paths.get("renameFile.txt");

        // create a file
        Files.createFile(newFile);
        System.out.println("File " + newFile.toAbsolutePath() + " created");

        // rename file
        Files.move(newFile, renameFile);
        System.out.println("File " + newFile + " to " + renameFile + " renamed");

        Files.delete(renameFile);
    }

    private static void playWithList() throws IOException {
        Path currentDir = Paths.get("");
        Stream<Path> dirContent = Files.list(currentDir);
        dirContent.forEach(System.out::println);
    }

    private static void playWithLines() throws IOException {
        Path readme = Paths.get("README.md");

        // read file content to stream of lines
        Stream<String> fileContent = Files.lines(readme);
        fileContent.forEach(System.out::println);
    }

    private static void playWithTempFile() throws IOException {
        // create temp file in default tmp location
        Path tmpFile = Files.createTempFile("tmp", ".file");
        System.out.println("Temp file create: " + tmpFile.toAbsolutePath());

        boolean deleted = Files.deleteIfExists(tmpFile);
        System.out.println("Temp file " + tmpFile + " deleted: " + deleted);
    }

    private static void playWithTempFolder() throws IOException {
        // create temp folder in default tmp location
        Path tmpDir = Files.createTempDirectory("tmp");
        System.out.println("Temp folder create: " + tmpDir.toAbsolutePath());

        boolean deleted = Files.deleteIfExists(tmpDir);
        System.out.println("Temp folder " + tmpDir + " deleted: " + deleted);
    }

    private static void playWithSymbolicLinks() throws IOException {
        Path newFile = Paths.get("newFile.txt");
        Path link = Paths.get("newFile.txt.symlnk");

        // create a file
        Files.createFile(newFile);
        System.out.println("File " + newFile.toAbsolutePath() + " created");

        // create a symbolic link
        Files.createSymbolicLink(link, newFile);
        System.out.println("Symbol link " + link + " to " + newFile + " created.");

        System.out.println(newFile + " and " + link + " are the same file: " + Files.isSameFile(newFile, link));

        // delete link, different between hard and symbolic links:
        // if remove original file, hard link will keep working, symbolic link will lost reference
        Files.delete(newFile);
        Files.delete(link);
    }

    private static void playWithLinks() throws IOException {
        Path newFile = Paths.get("newFile.txt");
        Path link = Paths.get("newFile.txt.lnk");

        // create a file
        Files.createFile(newFile);
        System.out.println("File " + newFile.toAbsolutePath() + " created");

        // create a hard link
        Files.createLink(link, newFile);
        System.out.println("Link " + link + " to " + newFile + " created.");

        System.out.println(newFile + " and " + link + " are the same file: " + Files.isSameFile(newFile, link));

        // delete link
        Files.delete(newFile);
        Files.delete(link);
    }

    private static void playWithFileCreation() throws IOException {
        Path newFile = Paths.get("newFile.txt");

        // create new file
        newFile = Files.createFile(newFile);
        System.out.println("File " + newFile.toAbsolutePath() + " created");

        // delete file after created
        boolean deleted = Files.deleteIfExists(newFile);
        System.out.println("File " + newFile + " deleted: " + deleted);
    }

    private static void playWithCreateDirectories() throws IOException {
        Path newfolder = Paths.get("new");
        Path anotherLayer = Paths.get(newfolder.toString(), "folder");

        // create all needed parent directory
        Files.createDirectories(anotherLayer);

        // delete folders created
        Files.delete(anotherLayer);
        Files.delete(newfolder);
    }

    private static void playWithCopyFiles() throws IOException {
        Path readme = Paths.get("README.md");
        Path readmeBackup = Paths.get("README.md.back");

        // copy attributes and replace if exists
        Files.copy(
                readme,
                readmeBackup,
                StandardCopyOption.COPY_ATTRIBUTES,
                StandardCopyOption.REPLACE_EXISTING
        );

        // delete copied files
        Files.delete(readmeBackup);
    }
}
