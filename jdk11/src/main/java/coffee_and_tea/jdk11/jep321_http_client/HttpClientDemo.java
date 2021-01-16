package coffee_and_tea.jdk11.jep321_http_client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class HttpClientDemo {

    public static void main(String[] args) {

        http1_1Client();

        http2Client();
    }

    private static void http1_1Client() {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://www.google.com"))
                .GET()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        var response = HttpClient.newBuilder()
                .build()
                .sendAsync(httpRequest, HttpResponse.BodyHandlers.ofLines());

        response = response.whenComplete( (s, e) -> {
            System.out.println(s.version());
            s.body().forEach(System.out::println);
        });

        response.join();
    }

    private static void http2Client() {

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://www.google.com"))
                .GET()
                .version(HttpClient.Version.HTTP_2)
                .build();
        CompletableFuture<HttpResponse<String>> response
                = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
        response = response.whenCompleteAsync((s, e) -> {
            System.out.println("Response: " + s.uri() + " version " + s.version());
            System.out.println("\t" + s.headers().toString());
//            System.out.println("\t" + s.body());
        });

        response.join();
    }
}
