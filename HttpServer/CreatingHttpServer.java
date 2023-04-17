package HttpServer;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CreatingHttpServer {
    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 7000), 0);

            server.createContext("/welcome", new MyHttpHandler());
            server.createContext("/test",new MyHttpHandler());
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

            server.setExecutor(threadPoolExecutor);
            server.start();
            System.out.println("Server Started at "+server.getAddress());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyHttpHandler implements HttpHandler {

    @Override

    public void handle(HttpExchange httpExchange) throws IOException {

        String requestParamValue=null;
        OutputStream outputStream = null;
        if("GET".equals(httpExchange.getRequestMethod())) {

            System.out.println("Running GET method");
            requestParamValue = handleGetRequest(httpExchange);
            System.out.println(requestParamValue);
            handleResponse(httpExchange,"this is response to GET request");

        }else if("POST".equals(httpExchange.getRequestMethod())) {
            System.out.println("Running POST method");
            requestParamValue = handlePostRequest(httpExchange);
            System.out.println(requestParamValue);
            handleResponse(httpExchange,"This is response to POST request method");

        }
    }

    private String handlePostRequest(HttpExchange httpExchange) {
        return httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1];
    }

    private String handleGetRequest(HttpExchange httpExchange) {
        System.out.println(httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1]) ;
        return httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1];
    }
    private void handleResponse(HttpExchange httpExchange, String requestParamValue)  throws  IOException {
        OutputStream outputStream = httpExchange.getResponseBody();

        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html>").append("<body>").
                append("<h1>").append("Welcome Page ")
                .append(requestParamValue)
                .append("</h1>")
                .append("</body>")
                .append("</html>");
        // encode HTML content
        String htmlResponse = htmlBuilder.toString();
        // this line is a must
        httpExchange.sendResponseHeaders(200, htmlResponse.length());
        outputStream.write(htmlResponse.getBytes());
        outputStream.flush();
        outputStream.close();
    }
}