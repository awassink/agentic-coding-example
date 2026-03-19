package nl.quintor.workshop.booking.adapter.outbound.manager.spring;

import java.util.UUID;
import javax.annotation.processing.Generated;
import nl.quintor.workshop.booking.domain.port.outbound.GetOrCreateCustomerRequest;
import nl.quintor.workshop.booking.domain.port.outbound.GetOrCreateCustomerResponse;
import nl.quintor.workshop.customer.domain.port.inbound.GetOrCreateCustomerCommand;
import nl.quintor.workshop.customer.domain.port.inbound.GetOrCreateCustomerReply;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-19T13:17:01+0100",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.45.0.v20260224-0835, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class SpringCustomerMapperImpl implements SpringCustomerMapper {

    @Override
    public GetOrCreateCustomerCommand toCommand(GetOrCreateCustomerRequest request) {
        if ( request == null ) {
            return null;
        }

        String name = null;
        String phoneNumber = null;

        name = request.name();
        phoneNumber = request.phoneNumber();

        GetOrCreateCustomerCommand getOrCreateCustomerCommand = new GetOrCreateCustomerCommand( name, phoneNumber );

        return getOrCreateCustomerCommand;
    }

    @Override
    public GetOrCreateCustomerResponse fromReply(GetOrCreateCustomerReply reply) {
        if ( reply == null ) {
            return null;
        }

        UUID customerId = null;

        customerId = reply.customerId();

        GetOrCreateCustomerResponse getOrCreateCustomerResponse = new GetOrCreateCustomerResponse( customerId );

        return getOrCreateCustomerResponse;
    }
}
