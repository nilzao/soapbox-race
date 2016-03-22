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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ChallengeType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ChallengeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ChallengeId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LeftSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Pattern" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RightSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChallengeType", propOrder = {
    "challengeId",
    "leftSize",
    "pattern",
    "rightSize"
})
public class ChallengeType {

    @XmlElement(name = "ChallengeId", required = true)
    protected String challengeId;
    @XmlElement(name = "LeftSize")
    protected int leftSize;
    @XmlElement(name = "Pattern", required = true)
    protected String pattern;
    @XmlElement(name = "RightSize")
    protected int rightSize;

    /**
     * Obtém o valor da propriedade challengeId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChallengeId() {
        return challengeId;
    }

    /**
     * Define o valor da propriedade challengeId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChallengeId(String value) {
        this.challengeId = value;
    }

    /**
     * Obtém o valor da propriedade leftSize.
     * 
     */
    public int getLeftSize() {
        return leftSize;
    }

    /**
     * Define o valor da propriedade leftSize.
     * 
     */
    public void setLeftSize(int value) {
        this.leftSize = value;
    }

    /**
     * Obtém o valor da propriedade pattern.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * Define o valor da propriedade pattern.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPattern(String value) {
        this.pattern = value;
    }

    /**
     * Obtém o valor da propriedade rightSize.
     * 
     */
    public int getRightSize() {
        return rightSize;
    }

    /**
     * Define o valor da propriedade rightSize.
     * 
     */
    public void setRightSize(int value) {
        this.rightSize = value;
    }

}
