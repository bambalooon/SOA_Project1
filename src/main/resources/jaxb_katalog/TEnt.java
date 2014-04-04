
package jaxb_katalog;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TEnt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TEnt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="liczba-sloi" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="gatunek" type="{urn:katalog}TGatunek" />
 *       &lt;attribute name="imie" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TEnt", namespace = "urn:katalog")
public class TEnt {

    @XmlAttribute(name = "liczba-sloi")
    protected Integer liczbaSloi;
    @XmlAttribute(name = "gatunek")
    protected TGatunek gatunek;
    @XmlAttribute(name = "imie")
    protected String imie;

    /**
     * Gets the value of the liczbaSloi property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLiczbaSloi() {
        return liczbaSloi;
    }

    /**
     * Sets the value of the liczbaSloi property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLiczbaSloi(Integer value) {
        this.liczbaSloi = value;
    }

    /**
     * Gets the value of the gatunek property.
     * 
     * @return
     *     possible object is
     *     {@link TGatunek }
     *     
     */
    public TGatunek getGatunek() {
        return gatunek;
    }

    /**
     * Sets the value of the gatunek property.
     * 
     * @param value
     *     allowed object is
     *     {@link TGatunek }
     *     
     */
    public void setGatunek(TGatunek value) {
        this.gatunek = value;
    }

    /**
     * Gets the value of the imie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImie() {
        return imie;
    }

    /**
     * Sets the value of the imie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImie(String value) {
        this.imie = value;
    }

}
