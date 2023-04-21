package DataToServer;



import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class WritingDataToServer {
    public static void main(String[] args) {
        try {
            URL u = new URL("https://www.youtube.com/");
            // open the connection and prepare it to POST
            URLConnection uc = u.openConnection();
            uc.setDoOutput(true);
            OutputStream raw = uc.getOutputStream();
            OutputStream buffered = new BufferedOutputStream(raw);
            OutputStreamWriter out = new OutputStreamWriter(buffered);
            out.write("first=example&middle=&last=Networking&work=String+Quartet\r\n");
            System.out.println("data has been sent..");
            out.flush();
            out.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}