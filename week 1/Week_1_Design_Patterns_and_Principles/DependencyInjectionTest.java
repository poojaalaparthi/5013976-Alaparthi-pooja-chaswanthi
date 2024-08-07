interface CustomerRepository {
    Customer findCustomerById(int id);
}
class CustomerRepositoryImpl implements CustomerRepository {
    public Customer findCustomerById(int id) {
        return new Customer(id, "John Doe");
    }
}
class CustomerService {
    private final CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public Customer getCustomerById(int id) {
        return customerRepository.findCustomerById(id);
    }
}
class Customer {
    private int id;
    private String name;
    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public String toString() {
        return "Customer{id=" + id + ", name='" + name + "'}";
    }
}
public class DependencyInjectionTest {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);
        Customer customer = customerService.getCustomerById(1);
        System.out.println(customer);
    }
}
