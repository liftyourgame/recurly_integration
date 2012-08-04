package za.co.trf.recurly.api.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Recurly REST API Object for a Credit Card.
 */
@XmlRootElement(name="credit_card")
public class CreditCard {

    private String number;
    private String lastFour;
    private String type;
    private String verificationValue;
    private Integer expirationMonth;
    private Integer expirationYear;

    public CreditCard() {
    }

    @XmlElement(name="number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @XmlElement(name="last_four")
    public String getLastFour() {
        return lastFour;
    }

    public void setLastFour(String lastFour) {
        this.lastFour = lastFour;
    }

    @XmlElement(name="type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement(name="verification_value")
    public String getVerificationValue() {
        return verificationValue;
    }

    public void setVerificationValue(String verificationValue) {
        this.verificationValue = verificationValue;
    }

    @XmlElement(name="month")
    public Integer getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Integer expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    @XmlElement(name="year")
    public Integer getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }

}
