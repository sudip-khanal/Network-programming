import java.net.URI;
import java.net.URISyntaxException;


public class URIClassExample {

    public static void main(String[] args) {
        try {
            URI DemoUrl = URI.create( "https://www.google.com/search?q=educba+treemap&oq=educba+treemap+&aqs=chrome..69i57j69i60.12298j1j7&sourceid=chrome&ie=UTF-8");

            // methods of uri class
            System.out.println("Host of the URI is:  " + DemoUrl.getHost());
            System.out.println("Port of the URI is: = " + DemoUrl.getPath());
            System.out.println("Raw Path of the URI is: = " + DemoUrl.getRawPath());
            System.out.println("Query of the URI is: = " + DemoUrl.getQuery());
            System.out.println("Raw Query of the URI is: = " + DemoUrl.getRawQuery());
            System.out.println("Fragment of the URI is: = " + DemoUrl.getFragment());
            System.out.println("Raw Fragment of the URI is: = " + DemoUrl.getRawFragment());
            System.out.println("Raw Authority of the URI is: = " + DemoUrl.getRawAuthority());
            System.out.println("scheme of the URI is: = " + DemoUrl.getScheme());
            System.out.println("Scheme Specific Part of the URI is: = " + DemoUrl.getSchemeSpecificPart());
            System.out.println("Raw User Info of the URI is: = " + DemoUrl.getRawUserInfo());
            System.out.println("User Info of the URI is: = " + DemoUrl.getUserInfo());
            System.out.println("port of the URI is: = " + DemoUrl.getPort());
            System.out.println("Class of the URI is: = " + DemoUrl.getClass());


        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());

        }
    }
}