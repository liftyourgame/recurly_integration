package za.co.trf.recurly.api.implementation;

import za.co.trf.recurly.api.RecurlyAccountService;
import za.co.trf.recurly.api.entity.Account;
import za.co.trf.recurly.api.entity.AccountList;

import java.util.List;

public class RecurlyAccountServiceImpl extends RecurlyServiceBase implements RecurlyAccountService {

    public List<Account> getAllAccounts() {
        log.debug("Retrieving list of accounts");
        String url = RECURLY_API_BASE_URL + RECURLY_ACCOUNTS_URL_SUFFIX;
        return recurlyRestTemplate.getForObject(url, AccountList.class).accountList;
    }

    public Account getAccount(String accountCode) {
        log.debug("Retrieving account with account code " + accountCode);
        String url = RECURLY_API_BASE_URL + RECURLY_ACCOUNTS_URL_SUFFIX + "/{accountCode}";
        return recurlyRestTemplate.getForObject(url, Account.class, accountCode);
    }

    public Account createAccount(Account account) {
        log.debug("Creating new account with account code " + account.getAccountCode());
        String url = RECURLY_API_BASE_URL + RECURLY_ACCOUNTS_URL_SUFFIX;
        return recurlyRestTemplate.postForObject(url, account, Account.class);
    }

    public void updateAccount(Account account) {
        log.debug("Updating account with account code " + account.getAccountCode());
        String url = RECURLY_API_BASE_URL + RECURLY_ACCOUNTS_URL_SUFFIX + "/{accountCode}";
        recurlyRestTemplate.putXml(url, account, Account.class, account.getAccountCode());
    }

    public void closeAccount(String accountCode) {
        log.debug("Closing account with account code " + accountCode);
        String url = RECURLY_API_BASE_URL + RECURLY_ACCOUNTS_URL_SUFFIX + "/{accountCode}";
        recurlyRestTemplate.deleteXml(url, accountCode);
    }

    public void reopenAccount(String accountCode) {
        log.debug("Reopening account with account code " + accountCode);
        String url = RECURLY_API_BASE_URL + RECURLY_ACCOUNTS_URL_SUFFIX + "/{accountCode}/reopen";
        recurlyRestTemplate.putXml(url, null, Account.class, accountCode);
    }
    
}
