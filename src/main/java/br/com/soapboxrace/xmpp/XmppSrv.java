package br.com.soapboxrace.xmpp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class XmppSrv {

	public static void main(String[] args) throws Exception {
		new XmppSrv();
	}

	public XmppSrv() {
		new XmppSrvRun().start();
	}

	private static class XmppSrvRun extends Thread {
		public void run() {
			try {
				System.out.println("Xmpp server is running.");
				int clientNumber = 0;
				ServerSocket listener = new ServerSocket(5222);
				try {
					while (true) {
						new Capitalizer(listener.accept(), clientNumber++).start();
					}
				} finally {
					listener.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static class Capitalizer extends Thread {
		private Socket socket;
		private int clientNumber;

		public Capitalizer(Socket socket, int clientNumber) {
			this.socket = socket;
			this.clientNumber = clientNumber;
			System.out.println("New connection with client# " + clientNumber + " at " + socket);
		}

		public void run() {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				// PrintWriter out = new PrintWriter(socket.getOutputStream(),
				// true);

				// out.println("Hello, you are client #" + clientNumber + ".");
				// out.println("Enter a line with only a period to quit\n");

				while (true) {
					String input = in.readLine();
					if (input == null) {
						break;
					}
					if (input.contains("</stream")) {
						System.out.println("disconnect!");
						break;
					}
					System.out.println(input);
				}
			} catch (IOException e) {
				System.out.println("Error handling client# " + clientNumber + ": " + e);
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					System.out.println("Couldn't close a socket, what's going on?");
				}
				System.out.println("Connection with client# " + clientNumber + " closed");
			}
		}

	}
}
