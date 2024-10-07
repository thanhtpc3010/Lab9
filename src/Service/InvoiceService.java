package Service;

import Entity.Invoice;
import IGeneric.IGeneralService;

import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InvoiceService implements IGeneralService<Invoice> {
    private List<Invoice> invoices;

    @Override
    public void update(Invoice invoice) {
        Invoice existingInvoice = getById(invoice.getId());
        if (existingInvoice != null) {
            existingInvoice.setAmount(invoice.getAmount());
            existingInvoice.setDatetime(invoice.getDatetime());
        }
    }

    @Override
    public List<Invoice> sortByName() {
        return invoices.stream()
                .sorted(Comparator.comparing(i -> i.getCustomer().getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Invoice getById(int id) {
        return invoices.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Invoice> getByName(String name) {
        return invoices.stream()
                .filter(i -> i.getCustomer().getName().contains(name))
                .collect(Collectors.toList());
    }

    public void applyDiscountForAugustFemaleCustomers() {
        invoices.stream()
                .filter(invoice -> invoice.getDatetime().getMonth() == Month.AUGUST &&
                        "f".equalsIgnoreCase(invoice.getCustomer().getGender()))
                .forEach(invoice -> invoice.setAmount(invoice.getAmount() * 0.9));
    }

}
