package domain;

public enum ParkingTicketStatus {
    // the user arrived no earlier than 3 minutes ago but has not yet purchased a ticket
    ARRIVED("ARRIVED"),
    // the user arrived earlier than 3 minutes ago but has not yet purchased a ticket
    UNPAID("UNPAID"),
    // the user arrived earlier than 3 minutes ago and has purchased a ticket
    PAID("PAID"),
    // the user exceeded the paid parking time
    ALARM("ALARM"),
    // the user drove off
    CLOSED("CLOSED");

    private String code;

    ParkingTicketStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static ParkingTicketStatus fromCode(String code) {
        for (ParkingTicketStatus status :ParkingTicketStatus.values()){
            if (status.getCode().equals(code)){
                return status;
            }
        }
        throw new UnsupportedOperationException(
                "The code " + code + " is not supported!");
    }
}
