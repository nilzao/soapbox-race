package br.com.soapboxrace.xmpp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class XmppTalk {

	private Socket socket;
	private BufferedReader reader;
	private BufferedWriter writer;

	public XmppTalk(Socket socket) {
		this.socket = socket;
		setReaderWriter();
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
		setReaderWriter();
	}

	public Socket getSocket() {
		return socket;
	}

	private void setReaderWriter() {
		try {
			reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String read() {
		String msg = null;
		char[] buffer = new char[8192];
		int charsRead = 0;
		try {
			if ((charsRead = reader.read(buffer)) != -1) {
				msg = new String(buffer).substring(0, charsRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("C->S [" + msg + "]");
		return msg;
	}

	public void write(String msg) {
		try {
			System.out.println("S->C [" + msg + "]");
			writer.write(msg);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}