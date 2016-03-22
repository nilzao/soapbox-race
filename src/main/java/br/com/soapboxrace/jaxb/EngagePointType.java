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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de EngagePointType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="EngagePointType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="X" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Y" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Z" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EngagePointType", propOrder = {
    "x",
    "y",
    "z"
})
public class EngagePointType {

    @XmlElement(name = "X")
    protected float x;
    @XmlElement(name = "Y")
    protected float y;
    @XmlElement(name = "Z")
    protected float z;

    /**
     * Obtém o valor da propriedade x.
     * 
     */
    public float getX() {
        return x;
    }

    /**
     * Define o valor da propriedade x.
     * 
     */
    public void setX(float value) {
        this.x = value;
    }

    /**
     * Obtém o valor da propriedade y.
     * 
     */
    public float getY() {
        return y;
    }

    /**
     * Define o valor da propriedade y.
     * 
     */
    public void setY(float value) {
        this.y = value;
    }

    /**
     * Obtém o valor da propriedade z.
     * 
     */
    public float getZ() {
        return z;
    }

    /**
     * Define o valor da propriedade z.
     * 
     */
    public void setZ(float value) {
        this.z = value;
    }

}
