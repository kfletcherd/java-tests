package test.server.url;

import java.net.URL;
import java.net.URI;

class TestURL {

	public static void main(String[] a){
		System.out.println("--- URL Class\n");
		testUrl("https://asdf.bcd.com:80/index.php?id=1&butt=toot#interestingnado");
		testUrl("http://www.net");
		testUrl("spagethie factornards");
		testUrl("/yes/no/stuff?id=1");
		testUrl("yes/no/stuff?id=1");
		testUrl("#here");

		System.out.println("\n--- URI Class\n");
		testUri("https://asdf.bcd.com:80/index.php?id=1&butt=toot#interestingnado");
		testUri("http://www.net");
		testUri("spagethie factornards");
		testUri("/yes/no/stuff?id=1");
		testUri("yes/no/stuff?id=1");
		testUri("#here");
	}


	private static void testUrl(String url){
		System.out.println("Trying this url: " + url);

		try {
			URL u = new URL(url);
			System.out.println("I have the AUTHORITY : " + u.getAuthority());
			System.out.println("HOST shotgun : " + u.getHost());
			System.out.println("PATH to the treasure : " + u.getPath());
			System.out.println("PORT in any storm : " + u.getPort());
			System.out.println("Follow the PROTOCOL son : " + u.getProtocol());
			System.out.println("Jonny ; drop table -- QUERY : " + u.getQuery());
			System.out.println("Is this a good enough REF? : " + u.getRef());
			System.out.println("Stole your USER info : " + u.getUserInfo());
			System.out.println();
		} catch(Exception e) {
			System.out.println("Exception thrown: " + e.getMessage() + "\n");
		}

	}

	private static void testUri(String url){
		System.out.println("Trying this url: " + url);

		try {
			URI u = new URI(url);
			System.out.println("I have the AUTHORITY : " + u.getAuthority());
			System.out.println("Nice sentence FRAGMENT : " + u.getFragment());
			System.out.println("HOST shotgun : " + u.getHost());
			System.out.println("PATH to the treasure : " + u.getPath());
			System.out.println("PORT in any storm : " + u.getPort());
			System.out.println("Jonny ; drop table -- QUERY : " + u.getQuery());
			System.out.println();
		} catch(Exception e) {
			System.out.println("Exception thrown: " + e.getMessage() + "\n");
		}

	}

}

