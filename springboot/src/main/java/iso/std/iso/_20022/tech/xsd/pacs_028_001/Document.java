//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.07.08 at 03:43:34 PM EEST 
//


package iso.std.iso._20022.tech.xsd.pacs_028_001;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Document complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Document">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FIToFIPmtStsReq" type="{urn:iso:std:iso:20022:tech:xsd:pacs.028.001.01}FIToFIPaymentStatusRequestV01"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", propOrder = {
    "fiToFIPmtStsReq"
})
public class Document {

    @XmlElement(name = "FIToFIPmtStsReq", required = true)
    protected FIToFIPaymentStatusRequestV01 fiToFIPmtStsReq;

    /**
     * Gets the value of the fiToFIPmtStsReq property.
     * 
     * @return
     *     possible object is
     *     {@link FIToFIPaymentStatusRequestV01 }
     *     
     */
    public FIToFIPaymentStatusRequestV01 getFIToFIPmtStsReq() {
        return fiToFIPmtStsReq;
    }

    /**
     * Sets the value of the fiToFIPmtStsReq property.
     * 
     * @param value
     *     allowed object is
     *     {@link FIToFIPaymentStatusRequestV01 }
     *     
     */
    public void setFIToFIPmtStsReq(FIToFIPaymentStatusRequestV01 value) {
        this.fiToFIPmtStsReq = value;
    }

}
