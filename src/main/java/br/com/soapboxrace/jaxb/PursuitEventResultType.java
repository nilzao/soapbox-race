//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2016.03.20 às 06:44:05 PM AMT 
//

package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Classe Java de PursuitEventResultType complex type.
 * 
 * <p>
 * O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro
 * desta classe.
 * 
 * <pre>
 * &lt;complexType name="PursuitEventResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Accolades" type="{http://jaxb.soapboxrace.com.br}AccoladesType"/>
 *         &lt;element name="Durability" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="EventId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="EventSessionId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ExitPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="InviteLifetimeInMilliseconds" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="LobbyInviteId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PersonaId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Heat" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PursuitEventResultType", propOrder = { "accolades", "durability", "eventId", "eventSessionId",
		"exitPath", "inviteLifetimeInMilliseconds", "lobbyInviteId", "personaId", "heat" })
@XmlRootElement(name = "PursuitEventResult")
public class PursuitEventResultType {

	@XmlElement(name = "Accolades", required = true)
	protected AccoladesType accolades;
	@XmlElement(name = "Durability")
	protected int durability;
	@XmlElement(name = "EventId")
	protected int eventId;
	@XmlElement(name = "EventSessionId")
	protected int eventSessionId;
	@XmlElement(name = "ExitPath", required = true)
	protected String exitPath;
	@XmlElement(name = "InviteLifetimeInMilliseconds")
	protected int inviteLifetimeInMilliseconds;
	@XmlElement(name = "LobbyInviteId")
	protected int lobbyInviteId;
	@XmlElement(name = "PersonaId")
	protected int personaId;
	@XmlElement(name = "Heat")
	protected int heat;

	/**
	 * Obtém o valor da propriedade accolades.
	 * 
	 * @return possible object is {@link AccoladesType }
	 * 
	 */
	public AccoladesType getAccolades() {
		return accolades;
	}

	/**
	 * Define o valor da propriedade accolades.
	 * 
	 * @param value
	 *            allowed object is {@link AccoladesType }
	 * 
	 */
	public void setAccolades(AccoladesType value) {
		this.accolades = value;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
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
	 * Obtém o valor da propriedade eventSessionId.
	 * 
	 */
	public int getEventSessionId() {
		return eventSessionId;
	}

	/**
	 * Define o valor da propriedade eventSessionId.
	 * 
	 */
	public void setEventSessionId(int value) {
		this.eventSessionId = value;
	}

	/**
	 * Obtém o valor da propriedade exitPath.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getExitPath() {
		return exitPath;
	}

	/**
	 * Define o valor da propriedade exitPath.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setExitPath(String value) {
		this.exitPath = value;
	}

	/**
	 * Obtém o valor da propriedade inviteLifetimeInMilliseconds.
	 * 
	 */
	public int getInviteLifetimeInMilliseconds() {
		return inviteLifetimeInMilliseconds;
	}

	/**
	 * Define o valor da propriedade inviteLifetimeInMilliseconds.
	 * 
	 */
	public void setInviteLifetimeInMilliseconds(int value) {
		this.inviteLifetimeInMilliseconds = value;
	}

	/**
	 * Obtém o valor da propriedade lobbyInviteId.
	 * 
	 */
	public int getLobbyInviteId() {
		return lobbyInviteId;
	}

	/**
	 * Define o valor da propriedade lobbyInviteId.
	 * 
	 */
	public void setLobbyInviteId(int value) {
		this.lobbyInviteId = value;
	}

	/**
	 * Obtém o valor da propriedade personaId.
	 * 
	 */
	public int getPersonaId() {
		return personaId;
	}

	/**
	 * Define o valor da propriedade personaId.
	 * 
	 */
	public void setPersonaId(int value) {
		this.personaId = value;
	}

	/**
	 * Obtém o valor da propriedade heat.
	 * 
	 */
	public int getHeat() {
		return heat;
	}

	/**
	 * Define o valor da propriedade heat.
	 * 
	 */
	public void setHeat(int value) {
		this.heat = value;
	}

}
