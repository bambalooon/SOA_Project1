
package jaxb_katalog;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TZagajnik complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TZagajnik">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ent" type="{urn:katalog}TEnt" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="powierzchnia" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TZagajnik", namespace = "urn:katalog", propOrder = {
    "ent"
})
public class TZagajnik {

    @XmlElement(namespace = "urn:katalog")
    protected List<TEnt> ent;
    @XmlAttribute(name = "powierzchnia")
    protected Integer powierzchnia;

    /**
     * Gets the value of the ent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TEnt }
     * 
     * 
     */
    public List<TEnt> getEnt() {
        if (ent == null) {
            ent = new ArrayList<TEnt>();
        }
        return this.ent;
    }

    public void removeEnt(int index) {
        ent.remove(index);
    }

    /**
     * Gets the value of the powierzchnia property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPowierzchnia() {
        return powierzchnia;
    }

    /**
     * Sets the value of the powierzchnia property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPowierzchnia(Integer value) {
        this.powierzchnia = value;
    }

}
