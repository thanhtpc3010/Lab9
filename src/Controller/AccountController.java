package Controller;

import Entity.Account;
import Service.AccountService;

import java.util.List;

public class AccountController {
    private List<Account> accounts;
    private AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    public List<Account> getAccounts() {}
}
