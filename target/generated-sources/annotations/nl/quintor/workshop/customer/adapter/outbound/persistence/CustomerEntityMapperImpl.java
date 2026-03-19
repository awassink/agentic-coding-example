package nl.quintor.workshop.customer.adapter.outbound.persistence;

import javax.annotation.processing.Generated;
import nl.quintor.workshop.customer.domain.model.Customer;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-19T13:17:01+0100",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.45.0.v20260224-0835, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class CustomerEntityMapperImpl implements CustomerEntityMapper {

    @Override
    public CustomerEntity toEntity(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerEntity.CustomerEntityBuilder customerEntity = CustomerEntity.builder();

        customerEntity.id( customer.getId() );
        customerEntity.name( customer.getName() );
        customerEntity.phoneNumber( customer.getPhoneNumber() );
        customerEntity.status( map( customer.getStatus() ) );

        return customerEntity.build();
    }

    @Override
    public Customer toDomain(CustomerEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Customer.CustomerBuilder customer = Customer.builder();

        customer.id( entity.getId() );
        customer.name( entity.getName() );
        customer.phoneNumber( entity.getPhoneNumber() );
        customer.status( map( entity.getStatus() ) );

        return customer.build();
    }
}
