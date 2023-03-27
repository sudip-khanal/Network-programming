

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

// Main class

    public class URLExample {

    // Main driver method
    public static void main(String[] args) {
        try {

            // Creating a URL with a protocol,hostname,and path
            URL url2 = new URL("http", "www.google.com", "/jvm-works-jvm-architecture/");
            URL url3 = new URL("http", "www.google.com", "/jvm-works-jvm-architecture/");

            // Printing the string representation of the URL
            System.out.println(url2.toString());
            System.out.println();

            //printing the return value of different methods of URL class
            System.out.println("Protocol: " + url2.getProtocol());
            System.out.println("Host Name: " + url2.getHost());
            System.out.println("File Name: " + url2.getFile());

            System.out.println("Protocol: " + url3.getProtocol());
            System.out.println("Host Name: " + url3.getHost());
            System.out.println("File Name: " + url3.getFile());
            System.out.println("Query String:" + url3.getQuery());
            System.out.println("port:" + url3.getDefaultPort());
            System.out.println("Authority:" + url3.getAuthority());
            System.out.println("Path:" + url3.getPath());
            System.out.println("equals or not:" + url3.equals(url2));
            System.out.println("UserInfo:" + url3.getUserInfo());
            System.out.println("anchor:" + url3.getRef());

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* using openconection method to access the content of given url */
            try {
            URL u = new URL("https://www.zdnet.com/article/best-smart-ring/");
            URLConnection con = u.openConnection();
            System.out.println("content="+con);
            InputStream on = u.openStream();
            int c;
            while ((c=on.read()) != -1)
                System.out.write(c);
                on.close();
        } catch (IOException ex){
                System.err.println(ex);
            }
        }
    }

