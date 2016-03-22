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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de OriginalRewardsType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="OriginalRewardsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Rep" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Tokens" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OriginalRewardsType", propOrder = {
    "rep",
    "tokens"
})
public class OriginalRewardsType {

    @XmlElement(name = "Rep")
    protected int rep;
    @XmlElement(name = "Tokens")
    protected int tokens;

    /**
     * Obtém o valor da propriedade rep.
     * 
     */
    public int getRep() {
        return rep;
    }

    /**
     * Define o valor da propriedade rep.
     * 
     */
    public void setRep(int value) {
        this.rep = value;
    }

    /**
     * Obtém o valor da propriedade tokens.
     * 
     */
    public int getTokens() {
        return tokens;
    }

    /**
     * Define o valor da propriedade tokens.
     * 
     */
    public void setTokens(int value) {
        this.tokens = value;
    }

}
