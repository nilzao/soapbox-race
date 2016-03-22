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
 * Classe Java de ProfileDataType complex type.
 * 
 * <p>
 * O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro
 * desta classe.
 * 
 * <pre>
 * &lt;complexType name="ProfileDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Boost" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Cash" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IconIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Level" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Motto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PercentToLevel" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="PersonaId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Rating" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Rep" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RepAtCurrentLevel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ccar" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfileDataType", propOrder = { "boost", "cash", "iconIndex", "level", "motto", "name",
		"percentToLevel", "personaId", "rating", "rep", "repAtCurrentLevel", "ccar", "score" })
@XmlRootElement(name = "ProfileData")
public class ProfileDataType {

	@XmlElement(name = "Boost")
	protected int boost;
	@XmlElement(name = "Cash")
	protected int cash;
	@XmlElement(name = "IconIndex")
	protected int iconIndex;
	@XmlElement(name = "Level")
	protected int level;
	@XmlElement(name = "Motto", required = true)
	protected String motto;
	@XmlElement(name = "Name", required = true)
	protected String name;
	@XmlElement(name = "PercentToLevel")
	protected float percentToLevel;
	@XmlElement(name = "PersonaId")
	protected int personaId;
	@XmlElement(name = "Rating")
	protected float rating;
	@XmlElement(name = "Rep")
	protected int rep;
	@XmlElement(name = "RepAtCurrentLevel")
	protected int repAtCurrentLevel;
	@XmlElement(required = true)
	protected String ccar;
	@XmlElement(name = "Score")
	protected int score;

	/**
	 * Obtém o valor da propriedade boost.
	 * 
	 */
	public int getBoost() {
		return boost;
	}

	/**
	 * Define o valor da propriedade boost.
	 * 
	 */
	public void setBoost(int value) {
		this.boost = value;
	}

	/**
	 * Obtém o valor da propriedade cash.
	 * 
	 */
	public int getCash() {
		return cash;
	}

	/**
	 * Define o valor da propriedade cash.
	 * 
	 */
	public void setCash(int value) {
		this.cash = value;
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
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMotto() {
		return motto;
	}

	/**
	 * Define o valor da propriedade motto.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMotto(String value) {
		this.motto = value;
	}

	/**
	 * Obtém o valor da propriedade name.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Define o valor da propriedade name.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Obtém o valor da propriedade percentToLevel.
	 * 
	 */
	public float getPercentToLevel() {
		return percentToLevel;
	}

	/**
	 * Define o valor da propriedade percentToLevel.
	 * 
	 */
	public void setPercentToLevel(float value) {
		this.percentToLevel = value;
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
	 * Obtém o valor da propriedade rating.
	 * 
	 */
	public float getRating() {
		return rating;
	}

	/**
	 * Define o valor da propriedade rating.
	 * 
	 */
	public void setRating(float value) {
		this.rating = value;
	}

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
	 * Obtém o valor da propriedade repAtCurrentLevel.
	 * 
	 */
	public int getRepAtCurrentLevel() {
		return repAtCurrentLevel;
	}

	/**
	 * Define o valor da propriedade repAtCurrentLevel.
	 * 
	 */
	public void setRepAtCurrentLevel(int value) {
		this.repAtCurrentLevel = value;
	}

	/**
	 * Obtém o valor da propriedade ccar.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCcar() {
		return ccar;
	}

	/**
	 * Define o valor da propriedade ccar.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCcar(String value) {
		this.ccar = value;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
}
