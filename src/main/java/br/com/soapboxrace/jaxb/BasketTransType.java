//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2016.03.17 às 12:57:16 PM AMT 
//

package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Classe Java de BasketTransType complex type.
 * 
 * <p>
 * O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro
 * desta classe.
 * 
 * <pre>
 * &lt;complexType name="BasketTransType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Items" type="{http://jaxb.soapboxrace.com.br}ItemsType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BasketTransType", propOrder = { "items" })
@XmlRootElement(name = "BasketTrans")
public class BasketTransType {

	@XmlElement(name = "Items", required = true)
	protected ItemsType items;

	/**
	 * Obtém o valor da propriedade items.
	 * 
	 * @return possible object is {@link ItemsType }
	 * 
	 */
	public ItemsType getItems() {
		return items;
	}

	/**
	 * Define o valor da propriedade items.
	 * 
	 * @param value
	 *            allowed object is {@link ItemsType }
	 * 
	 */
	public void setItems(ItemsType value) {
		this.items = value;
	}

}
