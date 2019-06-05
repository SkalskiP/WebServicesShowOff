package rest.parking_ticket;

import dto.ParkingTicketDTO;

import java.io.Serializable;
import java.util.List;

public class TicketReportData implements Serializable {
    public List<ParkingTicketDTO> data;
    public Long totalCount;

    public TicketReportData(List<ParkingTicketDTO> data, Long count) {
        this.data = data;
        this.totalCount = count;
    }
}
