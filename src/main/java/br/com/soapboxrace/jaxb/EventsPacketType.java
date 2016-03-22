//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2016.03.20 às 12:35:46 PM AMT 
//

package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Classe Java de EventsPacketType complex type.
 * 
 * <p>
 * O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro
 * desta classe.
 * 
 * <pre>
 * &lt;complexType name="EventsPacketType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Events" type="{http://jaxb.soapboxrace.com.br}EventsType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventsPacketType", propOrder = { "events" })
@XmlRootElement(name = "EventsPacket")
public class EventsPacketType {

	@XmlElement(name = "Events", required = true)
	protected EventsType events;

	/**
	 * Obtém o valor da propriedade events.
	 * 
	 * @return possible object is {@link EventsType }
	 * 
	 */
	public EventsType getEvents() {
		return events;
	}

	/**
	 * Define o valor da propriedade events.
	 * 
	 * @param value
	 *            allowed object is {@link EventsType }
	 * 
	 */
	public void setEvents(EventsType value) {
		this.events = value;
	}

}
