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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ItemsType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ItemsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BasketItemTrans" type="{http://jaxb.soapboxrace.com.br}BasketItemTransType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemsType", propOrder = {
    "basketItemTrans"
})
public class ItemsType {

    @XmlElement(name = "BasketItemTrans", required = true)
    protected BasketItemTransType basketItemTrans;

    /**
     * Obtém o valor da propriedade basketItemTrans.
     * 
     * @return
     *     possible object is
     *     {@link BasketItemTransType }
     *     
     */
    public BasketItemTransType getBasketItemTrans() {
        return basketItemTrans;
    }

    /**
     * Define o valor da propriedade basketItemTrans.
     * 
     * @param value
     *     allowed object is
     *     {@link BasketItemTransType }
     *     
     */
    public void setBasketItemTrans(BasketItemTransType value) {
        this.basketItemTrans = value;
    }

}
