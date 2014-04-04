
package jaxb_katalog;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TGatunek.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TGatunek">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="white"/>
 *     &lt;enumeration value="grey"/>
 *     &lt;enumeration value="black"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TGatunek", namespace = "urn:katalog")
@XmlEnum
public enum TGatunek {

    @XmlEnumValue("white")
    WHITE("white"),
    @XmlEnumValue("grey")
    GREY("grey"),
    @XmlEnumValue("black")
    BLACK("black");
    private final String value;

    TGatunek(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TGatunek fromValue(String v) {
        for (TGatunek c: TGatunek.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
