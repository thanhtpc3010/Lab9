package Service;

import Entity.Account;
import Entity.Invoice;
import IGeneric.IGeneralService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class AccountService implements IGeneralService<Account> {
    private List<Account> accounts = new ArrayList<>();

    @Override
    public void update(Account account) {
        Account existingAccount = getById(account.getId());
        if (existingAccount != null) {
            existingAccount.setBalance(account.getBalance());
        }
    }

    @Override
    public List<Account> sortByName() {
        return accounts.stream()
                .sorted(Comparator.comparing(a -> a.getCustomer().getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Account getById(int id) {
        return accounts.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Account> getByName(String name) {
        return accounts.stream()
                .filter(a -> a.getCustomer().getName().contains(name))
                .collect(Collectors.toList());
    }

    public List<Account> getAccountsWithBalanceEnoughToPayInvoice(List<Invoice> invoices) {
        return accounts.stream()
                .filter(account -> invoices.stream()
                        .anyMatch(invoice -> account.getCustomer().getId() == invoice.getCustomer().getId() &&
                                account.getBalance() >= invoice.getAmount() * (1 - account.getCustomer().getDiscount() / 100.0)))
                .collect(Collectors.toList());
    }

    public List<Account> getAccountsNotEnoughBalanceToPayInvoice(List<Invoice> invoices) {
        return accounts.stream()
                .filter(account -> invoices.stream()
                        .anyMatch(invoice -> account.getCustomer().getId() == invoice.getCustomer().getId() &&
                                account.getBalance() < invoice.getAmount()))
                .collect(Collectors.toList());
    }
}

