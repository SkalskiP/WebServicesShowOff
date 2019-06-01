package domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ParkingTicketStatusConverter implements AttributeConverter<ParkingTicketStatus, String> {

    public String convertToDatabaseColumn(ParkingTicketStatus value) {
        if ( value == null ) {
            return null;
        }

        return value.getCode();
    }

    public ParkingTicketStatus convertToEntityAttribute(String value) {
        if ( value == null ) {
            return null;
        }

        return ParkingTicketStatus.fromCode(value);
    }

}
