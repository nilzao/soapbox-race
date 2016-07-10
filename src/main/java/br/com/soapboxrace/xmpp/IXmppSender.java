package br.com.soapboxrace.xmpp;

public interface IXmppSender {

	public void send(String msg, Long to);

	public void send(Object object, Long to);

	public void createUpdatePersona(Long id, String password);

}
