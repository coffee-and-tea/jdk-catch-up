package coffee_and_tea.jdk11.jep321_http_client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.concurrent.CompletionStage;

public class WebSocketDemo {

    public static void main(String[] args) throws InterruptedException {

        var socketFuture = HttpClient.newHttpClient().newWebSocketBuilder().buildAsync(URI.create("wss://echo.websocket.org"), new WebSocket.Listener() {
            @Override
            public void onOpen(WebSocket webSocket) {
                System.out.println("Socket connected");
                webSocket.sendText("Hello", true);
                WebSocket.Listener.super.onOpen(webSocket);
            }

            @Override
            public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
                System.out.println("Received: " + data.toString());
                return WebSocket.Listener.super.onText(webSocket, data, last);
            }

            @Override
            public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
                System.out.println("Closing connection: " + statusCode);
                return WebSocket.Listener.super.onClose(webSocket, statusCode, reason);
            }
        });

        var socket = socketFuture.join();

        Thread.sleep(2000);

        var close = socket.sendClose(WebSocket.NORMAL_CLOSURE, "ok");

        close.join();

        Thread.sleep(2000);
    }
}
