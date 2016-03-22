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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de PersonaBaseType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="PersonaBaseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Badges" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IconIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Level" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Motto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PersonaId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Presence" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Score" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonaBaseType", propOrder = {
    "badges",
    "iconIndex",
    "level",
    "motto",
    "name",
    "personaId",
    "presence",
    "score",
    "userId"
})
public class PersonaBaseType {

    @XmlElement(name = "Badges", required = true)
    protected String badges;
    @XmlElement(name = "IconIndex")
    protected int iconIndex;
    @XmlElement(name = "Level")
    protected int level;
    @XmlElement(name = "Motto", required = true)
    protected String motto;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "PersonaId")
    protected int personaId;
    @XmlElement(name = "Presence")
    protected int presence;
    @XmlElement(name = "Score")
    protected int score;
    @XmlElement(name = "UserId")
    protected int userId;

    /**
     * Obtém o valor da propriedade badges.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBadges() {
        return badges;
    }

    /**
     * Define o valor da propriedade badges.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBadges(String value) {
        this.badges = value;
    }

    /**
     * Obtém o valor da propriedade iconIndex.
     * 
     */
    public int getIconIndex() {
        return iconIndex;
    }

    /**
     * Define o valor da propriedade iconIndex.
     * 
     */
    public void setIconIndex(int value) {
        this.iconIndex = value;
    }

    /**
     * Obtém o valor da propriedade level.
     * 
     */
    public int getLevel() {
        return level;
    }

    /**
     * Define o valor da propriedade level.
     * 
     */
    public void setLevel(int value) {
        this.level = value;
    }

    /**
     * Obtém o valor da propriedade motto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotto() {
        return motto;
    }

    /**
     * Define o valor da propriedade motto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotto(String value) {
        this.motto = value;
    }

    /**
     * Obtém o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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
     * Obtém o valor da propriedade presence.
     * 
     */
    public int getPresence() {
        return presence;
    }

    /**
     * Define o valor da propriedade presence.
     * 
     */
    public void setPresence(int value) {
        this.presence = value;
    }

    /**
     * Obtém o valor da propriedade score.
     * 
     */
    public int getScore() {
        return score;
    }

    /**
     * Define o valor da propriedade score.
     * 
     */
    public void setScore(int value) {
        this.score = value;
    }

    /**
     * Obtém o valor da propriedade userId.
     * 
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Define o valor da propriedade userId.
     * 
     */
    public void setUserId(int value) {
        this.userId = value;
    }

}
