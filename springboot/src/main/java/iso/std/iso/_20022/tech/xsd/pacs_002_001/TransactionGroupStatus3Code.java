//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.07.08 at 03:43:34 PM EEST 
//


package iso.std.iso._20022.tech.xsd.pacs_002_001;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionGroupStatus3Code.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransactionGroupStatus3Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACTC"/>
 *     &lt;enumeration value="RCVD"/>
 *     &lt;enumeration value="PART"/>
 *     &lt;enumeration value="RJCT"/>
 *     &lt;enumeration value="PDNG"/>
 *     &lt;enumeration value="ACCP"/>
 *     &lt;enumeration value="ACSP"/>
 *     &lt;enumeration value="ACSC"/>
 *     &lt;enumeration value="ACWC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TransactionGroupStatus3Code")
@XmlEnum
public enum TransactionGroupStatus3Code {

    ACTC,
    RCVD,
    PART,
    RJCT,
    PDNG,
    ACCP,
    ACSP,
    ACSC,
    ACWC;

    public String value() {
        return name();
    }

    public static TransactionGroupStatus3Code fromValue(String v) {
        return valueOf(v);
    }

}
