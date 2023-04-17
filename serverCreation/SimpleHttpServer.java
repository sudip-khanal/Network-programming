package serverCreation;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleHttpServer {
    public static void main(String[] args) throws IOException {
        // Create an HTTP server on port 8000
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost",7000), 0);

        // Create a simple HTTP handler
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                // Define the response body
                String response = "Hello, World! This is an example HTTP server in Java.";

                // Set the response headers
                exchange.getResponseHeaders().add("Content-Type", "text/plain");
                exchange.getResponseHeaders().add("Content-Length", Integer.toString(response.length()));

                // Send the response
                exchange.sendResponseHeaders(200, response.length());
                OutputStream outputStream = exchange.getResponseBody();
                outputStream.write(response.getBytes());
                outputStream.close();
            }
        });

        // Start the HTTP server
        server.start();

        System.out.println("HTTP server is running on port 7000...");
    }
}
