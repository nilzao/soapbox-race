//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2016.03.20 às 07:11:17 PM AMT 
//

package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Classe Java de SessionInfoType complex type.
 * 
 * <p>
 * O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro
 * desta classe.
 * 
 * <pre>
 * &lt;complexType name="SessionInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Challenge" type="{http://jaxb.soapboxrace.com.br}ChallengeType"/>
 *         &lt;element name="EventId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SessionId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SessionInfoType", propOrder = { "challenge", "eventId", "sessionId" })
@XmlRootElement(name = "SessionInfo")
public class SessionInfoType {

	@XmlElement(name = "Challenge", required = true)
	protected ChallengeType challenge;
	@XmlElement(name = "EventId")
	protected int eventId;
	@XmlElement(name = "SessionId")
	protected int sessionId;

	/**
	 * Obtém o valor da propriedade challenge.
	 * 
	 * @return possible object is {@link ChallengeType }
	 * 
	 */
	public ChallengeType getChallenge() {
		return challenge;
	}

	/**
	 * Define o valor da propriedade challenge.
	 * 
	 * @param value
	 *            allowed object is {@link ChallengeType }
	 * 
	 */
	public void setChallenge(ChallengeType value) {
		this.challenge = value;
	}

	/**
	 * Obtém o valor da propriedade eventId.
	 * 
	 */
	public int getEventId() {
		return eventId;
	}

	/**
	 * Define o valor da propriedade eventId.
	 * 
	 */
	public void setEventId(int value) {
		this.eventId = value;
	}

	/**
	 * Obtém o valor da propriedade sessionId.
	 * 
	 */
	public int getSessionId() {
		return sessionId;
	}

	/**
	 * Define o valor da propriedade sessionId.
	 * 
	 */
	public void setSessionId(int value) {
		this.sessionId = value;
	}

}
