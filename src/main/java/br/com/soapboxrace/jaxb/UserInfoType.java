//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2016.03.12 às 09:30:44 PM AMT 
//

package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Classe Java de UserInfoType complex type.
 * 
 * <p>
 * O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro
 * desta classe.
 * 
 * <pre>
 * &lt;complexType name="UserInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="defaultPersonaIdx" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="personas" type="{http://getpermanentsession.jaxb.soapboxrace.com.br}personasType"/>
 *         &lt;element name="user" type="{http://getpermanentsession.jaxb.soapboxrace.com.br}userType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserInfoType", propOrder = { "defaultPersonaIdx", "personas", "user" })
@XmlRootElement(name = "UserInfo")
public class UserInfoType {

	protected int defaultPersonaIdx;
	@XmlElement(required = true)
	protected PersonasType personas;
	@XmlElement(required = true)
	protected UserType user;

	/**
	 * Obtém o valor da propriedade defaultPersonaIdx.
	 * 
	 */
	public int getDefaultPersonaIdx() {
		return defaultPersonaIdx;
	}

	/**
	 * Define o valor da propriedade defaultPersonaIdx.
	 * 
	 */
	public void setDefaultPersonaIdx(int value) {
		this.defaultPersonaIdx = value;
	}

	/**
	 * Obtém o valor da propriedade personas.
	 * 
	 * @return possible object is {@link PersonasType }
	 * 
	 */
	public PersonasType getPersonas() {
		return personas;
	}

	/**
	 * Define o valor da propriedade personas.
	 * 
	 * @param value
	 *            allowed object is {@link PersonasType }
	 * 
	 */
	public void setPersonas(PersonasType value) {
		this.personas = value;
	}

	/**
	 * Obtém o valor da propriedade user.
	 * 
	 * @return possible object is {@link UserType }
	 * 
	 */
	public UserType getUser() {
		return user;
	}

	/**
	 * Define o valor da propriedade user.
	 * 
	 * @param value
	 *            allowed object is {@link UserType }
	 * 
	 */
	public void setUser(UserType value) {
		this.user = value;
	}

}
