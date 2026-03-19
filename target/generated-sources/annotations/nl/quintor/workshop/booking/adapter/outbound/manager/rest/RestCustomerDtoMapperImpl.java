package nl.quintor.workshop.booking.adapter.outbound.manager.rest;

import java.util.UUID;
import javax.annotation.processing.Generated;
import nl.quintor.workshop.booking.domain.port.outbound.GetOrCreateCustomerResponse;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-19T13:17:01+0100",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.45.0.v20260224-0835, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class RestCustomerDtoMapperImpl implements RestCustomerDtoMapper {

    @Override
    public GetOrCreateCustomerResponse toGetOrCreateCustomerResponse(RestCustomerResponseDto dto) {
        if ( dto == null ) {
            return null;
        }

        UUID customerId = null;

        customerId = dto.id();

        GetOrCreateCustomerResponse getOrCreateCustomerResponse = new GetOrCreateCustomerResponse( customerId );

        return getOrCreateCustomerResponse;
    }
}
