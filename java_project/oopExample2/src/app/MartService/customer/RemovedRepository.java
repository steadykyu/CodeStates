package app.MartService.customer;

public class RemovedRepository {
    private CustomerRepository customerRepository;
    public RemovedRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }
}
