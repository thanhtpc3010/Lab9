package Service;

import Entity.Customer;
import IGeneric.IGeneralService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerService implements IGeneralService<Customer> {
    private List<Customer> customers = new ArrayList<>();

    @Override
    public void update(Customer customer) {
        Customer existingCustomer = getById(customer.getId());
        if (existingCustomer != null) {
            existingCustomer.setDiscount(customer.getDiscount());
        }
    }

    @Override
    public List<Customer> sortByName() {
        return customers.stream()
                .sorted(Comparator.comparing(Customer::getName))
                .collect(Collectors.toList());
    }

    @Override
    public Customer getById(int id) {
        return customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Customer> getByName(String name) {
        return customers.stream()
                .filter(c -> c.getName().contains(name))
                .collect(Collectors.toList());
    }
}
