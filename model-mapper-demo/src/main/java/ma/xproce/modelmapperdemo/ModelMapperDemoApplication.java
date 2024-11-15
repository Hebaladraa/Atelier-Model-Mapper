package ma.xproce.modelmapperdemo;

import ma.xproce.modelmapperdemo.dtos.CustomerDTO;
import ma.xproce.modelmapperdemo.entities.Customer;
import ma.xproce.modelmapperdemo.entities.CustomerRepository;
import ma.xproce.modelmapperdemo.mappers.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class ModelMapperDemoApplication {
    @Autowired
    private CustomerMapper customerMapper;

    public static void main(String[] args) {
        SpringApplication.run(ModelMapperDemoApplication.class, args);
    }


    @Bean
    CommandLineRunner start(CustomerRepository customerRepository) {
        return args -> {
            // Création des Customers
            Customer customer1 = Customer.builder()
                    .name("heba")
                    .email("heba@example.com")
                    .password("password1")
                    .build();

            Customer customer2 = Customer.builder()
                    .name("hiba")
                    .email("hiba@example.com")
                    .password("password2")
                    .build();

            Customer customer3 = Customer.builder()
                    .name("ibtissam")
                    .email("ibtissam@example.com")
                    .password("password3")
                    .build();

            // Sauvegarde des Customers dans la base de données
            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);

            // Affichage des données de la base de données
            customerRepository.findAll().forEach(System.out::println);
        };
    }
}

