package Controller;

import Entity.Customer;
import Service.CustomerService;

import java.util.List;

public class CustomerController {
    private List<Customer> customers;
    private CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    public Customer getById(int id) {
        Customer customer = customerService.getById(id);
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("Customer not found");
        }
        return customer;
    }
}
