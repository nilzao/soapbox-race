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
 * <p>Classe Java de AccoladesType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="AccoladesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FinalRewards" type="{http://jaxb.soapboxrace.com.br}FinalRewardsType"/>
 *         &lt;element name="HasLeveledUp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LuckyDrawInfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OriginalRewards" type="{http://jaxb.soapboxrace.com.br}OriginalRewardsType"/>
 *         &lt;element name="RewardInfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccoladesType", propOrder = {
    "finalRewards",
    "hasLeveledUp",
    "luckyDrawInfo",
    "originalRewards",
    "rewardInfo"
})
public class AccoladesType {

    @XmlElement(name = "FinalRewards", required = true)
    protected FinalRewardsType finalRewards;
    @XmlElement(name = "HasLeveledUp", required = true)
    protected String hasLeveledUp;
    @XmlElement(name = "LuckyDrawInfo", required = true)
    protected String luckyDrawInfo;
    @XmlElement(name = "OriginalRewards", required = true)
    protected OriginalRewardsType originalRewards;
    @XmlElement(name = "RewardInfo", required = true)
    protected String rewardInfo;

    /**
     * Obtém o valor da propriedade finalRewards.
     * 
     * @return
     *     possible object is
     *     {@link FinalRewardsType }
     *     
     */
    public FinalRewardsType getFinalRewards() {
        return finalRewards;
    }

    /**
     * Define o valor da propriedade finalRewards.
     * 
     * @param value
     *     allowed object is
     *     {@link FinalRewardsType }
     *     
     */
    public void setFinalRewards(FinalRewardsType value) {
        this.finalRewards = value;
    }

    /**
     * Obtém o valor da propriedade hasLeveledUp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHasLeveledUp() {
        return hasLeveledUp;
    }

    /**
     * Define o valor da propriedade hasLeveledUp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHasLeveledUp(String value) {
        this.hasLeveledUp = value;
    }

    /**
     * Obtém o valor da propriedade luckyDrawInfo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLuckyDrawInfo() {
        return luckyDrawInfo;
    }

    /**
     * Define o valor da propriedade luckyDrawInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLuckyDrawInfo(String value) {
        this.luckyDrawInfo = value;
    }

    /**
     * Obtém o valor da propriedade originalRewards.
     * 
     * @return
     *     possible object is
     *     {@link OriginalRewardsType }
     *     
     */
    public OriginalRewardsType getOriginalRewards() {
        return originalRewards;
    }

    /**
     * Define o valor da propriedade originalRewards.
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalRewardsType }
     *     
     */
    public void setOriginalRewards(OriginalRewardsType value) {
        this.originalRewards = value;
    }

    /**
     * Obtém o valor da propriedade rewardInfo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRewardInfo() {
        return rewardInfo;
    }

    /**
     * Define o valor da propriedade rewardInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRewardInfo(String value) {
        this.rewardInfo = value;
    }

}
