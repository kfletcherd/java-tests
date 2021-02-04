package test.server;

import test.server.ClientThread;

import java.net.Socket;
import java.net.ServerSocket;

class Server {

	private static ServerSocket serverzor;

	public static void main(String[] a){
		try {
			if(a.length == 0)
				throw new Exception("Provide a port");

			int port = Integer.parseInt(a[0]);
			if(port < 1024)
				throw new Exception("Port shouldn't be below 1024");
			serverzor = new ServerSocket(port);

			listen();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// TODO: Does any janky/weird stuff happen with these threads? (live forever and/or get prematurely killed if the var is overwritten?)
	private static void listen(){
		TestAPI api = new TestAPI();

		while(true) {
			try {
				Socket client = serverzor.accept();
				ClientThread ct = new ClientThread(client, api);
				ct.start();
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}

