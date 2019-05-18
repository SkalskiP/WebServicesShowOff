package domain;

public enum ParkingTicketStatus {
    UNPAID("UNPAID"),
    PAID("PAID"),
    ALARM("ALARM"),
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
