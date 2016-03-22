//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2016.03.18 às 09:12:31 PM AMT 
//

package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Classe Java de ArrayOfPersonaBaseType complex type.
 * 
 * <p>
 * O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro
 * desta classe.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPersonaBaseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PersonaBase" type="{http://jaxb.soapboxrace.com.br}PersonaBaseType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPersonaBaseType", propOrder = { "personaBase" })
@XmlRootElement(name = "ArrayOfPersonaBase")
public class ArrayOfPersonaBaseType {

	@XmlElement(name = "PersonaBase", required = true)
	protected PersonaBaseType personaBase;

	/**
	 * Obtém o valor da propriedade personaBase.
	 * 
	 * @return possible object is {@link PersonaBaseType }
	 * 
	 */
	public PersonaBaseType getPersonaBase() {
		return personaBase;
	}

	/**
	 * Define o valor da propriedade personaBase.
	 * 
	 * @param value
	 *            allowed object is {@link PersonaBaseType }
	 * 
	 */
	public void setPersonaBase(PersonaBaseType value) {
		this.personaBase = value;
	}

}
