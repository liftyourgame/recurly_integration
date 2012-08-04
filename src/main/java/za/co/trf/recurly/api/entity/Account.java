package za.co.trf.recurly.api.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Recurly REST API Object for a customer's Account Account.
 */
@XmlRootElement(name="account")
public class Account {

    private String accountCode;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String companyName;
    private Integer balanceInCents;
    private Date createdAt;
    private BillingInformation billingInformation;
    private String state;

    public Account(){}

    public Account(final String accountCode){
    	this.accountCode = accountCode;
    }

    @XmlElement(name="account_code")
    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    @XmlElement(name="username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlElement(name="first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement(name="last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement(name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement(name="company_name")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @XmlElement(name="balance_in_cents")
    public Integer getBalanceInCents() {
        return balanceInCents;
    }

    public void setBalanceInCents(Integer balanceInCents) {
        this.balanceInCents = balanceInCents;
    }

    @XmlElement(name="created_at")
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @XmlElement(name="billing_info")
    public BillingInformation getBillingInformation() {
        return billingInformation;
    }

    public void setBillingInformation(BillingInformation billingInformation) {
        this.billingInformation = billingInformation;
    }

    @XmlElement(name="state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder("Recurly Account [");
        ans.append("accountCode: ").append(accountCode).append(" | ");
        ans.append("firstName: ").append(firstName).append(" | ");
        ans.append("lastName: ").append(lastName).append(" | ");
        ans.append("companyName: ").append(companyName).append(" | ");
        ans.append("email: ").append(email);
        ans.append("]");
        return ans.toString();
    }

}