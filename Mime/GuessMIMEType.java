package Mime;



import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GuessMIMEType {
    public static void main(String[] args) {

        try {
            URL url = new URL("https://www.youtube.com");
            URLConnection uc = url.openConnection();
            uc.connect();
            System.out.println("url Connection created...");
            InputStream in = uc.getInputStream();
            BufferedInputStream buffer = new BufferedInputStream(in);
            System.out.println(
                    URLConnection.guessContentTypeFromStream(buffer)

            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}