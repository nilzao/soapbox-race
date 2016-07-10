package br.com.soapboxrace.xmpp.offline;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

import br.com.soapboxrace.engine.Router;
import br.com.soapboxrace.engine.Session;
import br.com.soapboxrace.jaxb.util.MarshalXML;
import br.com.soapboxrace.xmpp.IXmppSender;
import br.com.soapboxrace.xmpp.jaxb.XMPP_MessageType;

public class XmppSrv implements IXmppSender {

	public static ConcurrentHashMap<Long, XmppTalk> xmppClients = new ConcurrentHashMap<Long, XmppTalk>();

	public static void addXmppClient(long personaId, XmppTalk xmppClient) {
		xmppClients.put(personaId, xmppClient);
	}

	private static void sendMsg(long personaId, String msg) {
		if (xmppClients.containsKey(personaId)) {
			XmppTalk xTalk = xmppClients.get(personaId);
			if (xTalk != null) {
				xTalk.write(msg);
			} else {
				System.err.println("xmppClient with the personaId " + personaId + " is attached to a null XmppTalk instance!");
			}
		} else {
			System.err.println("xmppClients doesn't contain personaId " + personaId);
		}
	}

	public static void removeXmppClient(int personaId) {
		xmppClients.remove(personaId);
	}

	public XmppSrv() {
		System.setProperty("jsse.enableCBCProtection", "false");
		XmppSrvRun xmppSrvRun = new XmppSrvRun();
		xmppSrvRun.start();
	}

	private static class XmppSrvRun extends Thread {
		public void run() {
			try {
				System.out.println("Xmpp server is running.");
				System.out.println("");
				ServerSocket listener = new ServerSocket(Session.getXmppPort());
				try {
					while (true) {
						new Capitalizer(listener.accept()).start();
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
		private XmppTalk xmppTalk;

		public Capitalizer(Socket socket) {
			this.socket = socket;
			xmppTalk = new XmppTalk(this.socket);
			System.out.println("New connection at " + socket);
		}

		public void run() {
			try {
				new XmppHandShake(xmppTalk);
				XmppHandler xmppHandler = new XmppHandler(xmppTalk);
				while (true) {
					String input = xmppHandler.read();
					if (input == null || input.contains("</stream:stream>")) {
						break;
					}
				}
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					System.out.println("Couldn't close a socket, what's going on?");
				}
				XmppSrv.removeXmppClient(xmppTalk.getPersonaId());
				System.out.println("Connection with client closed");
			}
		}

	}

	public static XmppTalk get(Long personaId) {
		return xmppClients.get(personaId);
	}

	@Override
	public void send(String msg, Long to) {
		XMPP_MessageType messageType = new XMPP_MessageType();
		messageType.setFrom("nfsw.engine.engine@" + Session.getXmppIp() + "/EA_Chat");
		messageType.setToPersonaId(to);
		messageType.setBody(msg);
		messageType.setSubject(Router.calculateHash(messageType.getTo().toCharArray(), msg.toCharArray()));
		String packet = MarshalXML.marshal(messageType);
		sendMsg(to, packet);
	}

	@Override
	public void send(Object object, Long to) {
		String responseXmlStr = MarshalXML.marshal(object);
		this.send(responseXmlStr, to);
	}

	@Override
	public void createUpdatePersona(Long id, String password) {
	}

}
