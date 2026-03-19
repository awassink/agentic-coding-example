package nl.quintor.workshop.booking.adapter.outbound.persistence;

import javax.annotation.processing.Generated;
import nl.quintor.workshop.booking.domain.model.Booking;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-19T13:17:01+0100",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.45.0.v20260224-0835, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class BookingEntityMapperImpl implements BookingEntityMapper {

    @Override
    public BookingEntity toEntity(Booking booking) {
        if ( booking == null ) {
            return null;
        }

        BookingEntity bookingEntity = new BookingEntity();

        bookingEntity.setCustomerId( booking.getCustomerId() );
        bookingEntity.setDateTime( booking.getDateTime() );
        bookingEntity.setFromLocation( booking.getFromLocation() );
        bookingEntity.setId( booking.getId() );
        bookingEntity.setPassengerAmount( booking.getPassengerAmount() );
        bookingEntity.setStatus( booking.getStatus() );
        bookingEntity.setToLocation( booking.getToLocation() );

        return bookingEntity;
    }

    @Override
    public Booking toDomain(BookingEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Booking.BookingBuilder booking = Booking.builder();

        booking.customerId( entity.getCustomerId() );
        booking.dateTime( entity.getDateTime() );
        booking.fromLocation( entity.getFromLocation() );
        booking.id( entity.getId() );
        booking.passengerAmount( entity.getPassengerAmount() );
        booking.status( entity.getStatus() );
        booking.toLocation( entity.getToLocation() );

        return booking.build();
    }
}
