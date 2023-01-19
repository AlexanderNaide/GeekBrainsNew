package ru.gb.spring_boot_and_hibernate.service;

//import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.gb.spring_boot_and_hibernate.model.Customer;
import ru.gb.spring_boot_and_hibernate.model.Product;
import ru.gb.spring_boot_and_hibernate.repository.CustomerRepository;
import ru.gb.spring_boot_and_hibernate.repository.ProductRepository;

@Component
public class CustomerDataGenerator {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CustomerDataGenerator(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void generateDataOnStartup(){
//        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer();
//            customer.setName(faker.name().fullName());
            customer.setName("user" + i);

//            customer.setPhoneNumber(faker.number().digits(9));
            customer.setPhoneNumber("8-999-228-" + (1234 + i * 927));

//            customer.setAge(faker.number().numberBetween(20, 60));
            customer.setAge(20 + (3 * i));

            customerRepository.save(customer);
        }

        for (int i = 0; i < 20; i++) {
            Product product = new Product();
            product.setTitle("product_" + i);
            product.setPrice(264.75 + (i * 117.05));
            productRepository.save(product);
        }
    }

}
