package za.co.trf.recurly.api.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Wrapper object for a list of Recurly  {@link Account}s
 */
@XmlRootElement(name = "accounts")
public class AccountList {

	@XmlElement(name = "account")
	public List<Account> accountList;

}
