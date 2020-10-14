package coffee_and_tea.jdk7.jsr203_NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class NioChannelApi {

    public static void main(String [] args) throws IOException, ExecutionException, InterruptedException {

        playWithFileChannel();

        playWithAsynchronousChannel();
    }

    private static void playWithAsynchronousChannel() throws IOException, ExecutionException, InterruptedException {
        // create AsyncronousServerSocketChannel with local port 8888
        AsynchronousServerSocketChannel server =
                AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(8888));

        // server handles client connection with Future styple
        Future<AsynchronousSocketChannel> future = server.accept();

        // create new thread to handle client connection does not block current thread when use future.get()
        handleServerSideTraffic(future);

        // create AsyncronousSocket Channel to connect to server channel
        AsynchronousSocketChannel client =
                AsynchronousSocketChannel.open();

        // get connection
        Future<Void> conResult = client.connect(new InetSocketAddress(8888));
        // wait for connection established
        conResult.get();

        // client write and read back from server with call back style
        String clientMsg = "Hello from client";
        ByteBuffer replyFromServer = ByteBuffer.allocate(100);
        client.write(ByteBuffer.wrap(clientMsg.getBytes()));
        // wait for 1 sec for server reply
        Thread.sleep(1000);
        client.read(replyFromServer);
        System.out.println("Server replyed: " + new String(replyFromServer.array()));
    }

    private static void handleServerSideTraffic(Future<AsynchronousSocketChannel> future) {
        Runnable runnable = () -> {
            try(AsynchronousSocketChannel client = future.get()){
                String hello = "Hello from server";
                client.write(ByteBuffer.wrap(hello.getBytes()));

                // wait for 1 sec to read client message
                Thread.sleep(1000);
                ByteBuffer clientMsg = ByteBuffer.allocate(100);
                client.read(clientMsg);
                System.out.println("Client message: " + new String(clientMsg.array()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private static void playWithFileChannel() throws IOException {
        // play with readme file
        Path readme = Paths.get("README.md");

        // open channel for read write
        try(FileChannel fc = FileChannel.open(readme, StandardOpenOption.READ, StandardOpenOption.WRITE)){
            // read 15 bytes and output
            ByteBuffer bb = ByteBuffer.allocate(14);
            fc.read(bb);
            System.out.println("14 bytes: " + new String(bb.array()));

            long currentSize = fc.size();

            // write to the end
            fc.position(currentSize);
            String addEndText = "that's it bye!";
            ByteBuffer writeBytes = ByteBuffer.wrap(addEndText.getBytes());
            fc.write(writeBytes);

            // restore file to what it was
            fc.truncate(currentSize);
        }
    }
}
