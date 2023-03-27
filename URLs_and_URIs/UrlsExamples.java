package URLs_and_URIs;

import java.net.*;
public class UrlsExamples {

    public static void main(String args[]) {
        String[] url = {
                "https://www.gmail.com#home",
                "https://mukeshmahara@www.mukeshmahara.com.np:3000/home/profile/?birthday='2054/08/08'#profile-section",
                "https://www.instagram.com/?q='hello there'",
                "http://localuser@www.localhost:3000/index/?='home dashboard'#home-section"
        };

        for (int i = 0; i < url.length; i++) {
            try {
                URL u = new URL(url[i]);
                System.out.println("The URL is " + u);
                System.out.println("The scheme is " + u.getProtocol());
                System.out.println("The user info is " + u.getUserInfo());
                String host = u.getHost();
                if (host != null) {
                    int atSign = host.indexOf('@');
                    if (atSign != -1) host = host.substring(atSign + 1);
                    System.out.println("The host is " + host);
                } else {
                    System.out.println("The host is null.");
                }
                System.out.println("The port is " + u.getPort());
                System.out.println("The path is " + u.getPath());
                System.out.println("The ref is " + u.getRef());
                System.out.println("The query string is " + u.getQuery());
            } catch (MalformedURLException ex) {
                System.err.println(url[i] + " is not a URL I understand.");
            }
            System.out.println();
        }
    }
}