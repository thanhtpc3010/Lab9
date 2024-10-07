import Entity.Account;
import Entity.Customer;
import Entity.Gender;
import Entity.Invoice;
import Service.AccountService;
import Service.CustomerService;
import Service.InvoiceService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<Customer>();
        CustomerService cs = new CustomerService();
        Customer customer1 = new Customer(1, "Alice", Gender.F, 10);
        Customer customer2 = new Customer(2, "Bob", Gender.M, 5);
        Customer customer3 = new Customer(3, "Charlie",Gender.M, 8);

        AccountService accountService = new AccountService();
        InvoiceService invoiceService = new InvoiceService();
        Invoice invoice1 = new Invoice(1, customer1, 4500.0, LocalDateTime.now());
        Invoice invoice2 = new Invoice(2, customer2, 1200.0, LocalDateTime.now().minusDays(10));
        Invoice invoice3 = new Invoice(3, customer3, 7000.0, LocalDateTime.now().minusMonths(1));

        accountService.getAccountsWithBalanceEnoughToPayInvoice(Arrays.asList(invoice1, invoice2, invoice3))
                .forEach(System.out::println);

        accountService.getAccountsNotEnoughBalanceToPayInvoice(Arrays.asList(invoice1, invoice2, invoice3))
                .forEach(System.out::println);

        invoiceService.applyDiscountForAugustFemaleCustomers();

    }
}