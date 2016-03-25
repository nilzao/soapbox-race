package br.com.soapboxrace.xmpp;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class TlsWrapper {

	/*
	 * genkey command keytool -genkey -keyalg RSA -alias selfsigned -keystore
	 * keystore.jks \ -storepass 123456 -validity 360 -keysize 2048
	 * 
	 * need to run with vm param -Djsse.enableCBCProtection=false
	 */
	public static void wrapXmppTalk(XmppTalk xmppTalk) {
		try {
			Socket socket = xmppTalk.getSocket();
			KeyStore ksKeys = KeyStore.getInstance("JKS");
			ksKeys.load(new FileInputStream("keystore.jks"), "123456".toCharArray());
			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
			kmf.init(ksKeys, "123456".toCharArray());
			InputStream keyStoreIS = new FileInputStream("keystore.jks");
			char[] keyStorePassphrase = "123456".toCharArray();
			ksKeys.load(keyStoreIS, keyStorePassphrase);
			kmf.init(ksKeys, keyStorePassphrase);
			KeyStore ksTrust = KeyStore.getInstance("JKS");
			TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
			tmf.init(ksTrust);
			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
			InetSocketAddress remoteAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			SSLSocketFactory sf = sslContext.getSocketFactory();
			SSLSocket s = (SSLSocket) (sf.createSocket(socket, remoteAddress.getHostName(), socket.getPort(), true));
			s.setUseClientMode(false);
			xmppTalk.setSocket(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
