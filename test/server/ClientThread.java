package test.server;

import java.net.Socket;

import java.io.InputStream;
import java.io.PrintWriter;
//import java.io.PrintStream;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;

import java.util.StringTokenizer;

final class ClientThread extends Thread {

	private Socket client;
	private Router router;

	public ClientThread(Socket clientSocket, Router r){
		client = clientSocket;
		router = r;
	}

	public void run(){
		Response res = new Response();

		try (
//			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			//PrintStream out = new PrintStream(client.getOutputStream(), true);
		) {
//			StringBuilder rawReq = new StringBuilder(256);
//			String rawReqChunk;
//			while(in.ready() && (rawReqChunk = in.readLine()) != null){
//				//if(rawReqChunk.isEmpty()) break;
//				rawReq.append(rawReqChunk);
//				rawReq.append("\r\n");
//			}

			InputStream in = client.getInputStream();
			String rawReq = new String(in.readNBytes(in.available()));

			System.out.println(rawReq);

			try {
				Request req = new Request(rawReq.toString());
				router.executeRoute(req, res);
			} catch(Exception e) {
				res.setCode(500);
				res.setBody("ITS ALL FUUUUUUUUCKED");
				System.out.println(e.getMessage());
			}

			out.println(res.getResponse());

		} catch(Exception e) {
			System.out.println("Client Error: " + e.getMessage());
		}

		try {
			client.close();
		} catch(Exception e){
			System.out.println("Couldn't close client: " + e.getMessage());
		}

		System.out.println("Request complete");
	}

}

