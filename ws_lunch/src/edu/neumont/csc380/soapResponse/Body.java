
package edu.neumont.csc380.soapResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.example.org/sgomez}getRestaurantsResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getRestaurantsResponse"
})
@XmlRootElement(name = "Body", namespace = "http://www.w3.org/2001/12/soap-envelope")
public class Body {

    @XmlElement(namespace = "http://www.example.org/sgomez", required = true)
    protected GetRestaurantsResponse getRestaurantsResponse;

    /**
     * Gets the value of the getRestaurantsResponse property.
     * 
     * @return
     *     possible object is
     *     {@link GetRestaurantsResponse }
     *     
     */
    public GetRestaurantsResponse getGetRestaurantsResponse() {
        return getRestaurantsResponse;
    }

    /**
     * Sets the value of the getRestaurantsResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetRestaurantsResponse }
     *     
     */
    public void setGetRestaurantsResponse(GetRestaurantsResponse value) {
        this.getRestaurantsResponse = value;
    }

}
