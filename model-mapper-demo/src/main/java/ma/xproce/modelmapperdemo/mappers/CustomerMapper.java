package ma.xproce.modelmapperdemo.mappers;

import ma.xproce.modelmapperdemo.dtos.CustomerDTO;
import ma.xproce.modelmapperdemo.dtos.CustomerDtoNew;
import ma.xproce.modelmapperdemo.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    private final ModelMapper mapper = new ModelMapper();

    // Mapper Customer vers CustomerDTO
    public CustomerDTO fromCustomer(Customer customer) {
        return this.mapper.map(customer, CustomerDTO.class);
    }

    // Mapper Customer vers CustomerDtoNew
    public CustomerDtoNew fromCustomerToNew(Customer customer) {
        return this.mapper.map(customer, CustomerDtoNew.class);
    }

    // Mapper CustomerDtoNew vers Customer
    public Customer fromNewDtoToCustomer(CustomerDtoNew customerDtoNew) {
        return this.mapper.map(customerDtoNew, Customer.class);
    }
}
