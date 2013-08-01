
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
 *         &lt;element ref="{http://www.example.org/sgomez}restaurant"/>
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
    "restaurant"
})
@XmlRootElement(name = "getRestaurantsResponse", namespace = "http://www.example.org/sgomez")
public class GetRestaurantsResponse {

    @XmlElement(namespace = "http://www.example.org/sgomez", required = true)
    protected Restaurant restaurant;

    /**
     * Gets the value of the restaurant property.
     * 
     * @return
     *     possible object is
     *     {@link Restaurant }
     *     
     */
    public Restaurant getRestaurant() {
        return restaurant;
    }

    /**
     * Sets the value of the restaurant property.
     * 
     * @param value
     *     allowed object is
     *     {@link Restaurant }
     *     
     */
    public void setRestaurant(Restaurant value) {
        this.restaurant = value;
    }

}
