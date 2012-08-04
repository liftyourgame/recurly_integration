package za.co.trf.recurly.api;

import za.co.trf.recurly.api.entity.Account;

import java.util.List;

public interface RecurlyAccountService {
    public List<Account> getAllAccounts();
    public Account getAccount(final String accountCode);
    public Account createAccount(Account account);
    public void updateAccount(Account account);
    public void closeAccount(final String accountCode);
    public void reopenAccount(final String accountCode);        
}
