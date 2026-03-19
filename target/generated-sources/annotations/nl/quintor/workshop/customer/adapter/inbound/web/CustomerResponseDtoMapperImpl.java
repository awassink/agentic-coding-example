package nl.quintor.workshop.customer.adapter.inbound.web;

import java.util.UUID;
import javax.annotation.processing.Generated;
import nl.quintor.workshop.customer.domain.model.Customer;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-19T13:17:01+0100",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.45.0.v20260224-0835, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class CustomerResponseDtoMapperImpl implements CustomerResponseDtoMapper {

    @Override
    public CustomerResponseDto toResponseDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        UUID id = null;
        String name = null;
        String phoneNumber = null;

        id = customer.getId();
        name = customer.getName();
        phoneNumber = customer.getPhoneNumber();

        CustomerResponseDto customerResponseDto = new CustomerResponseDto( id, name, phoneNumber );

        return customerResponseDto;
    }
}
