package soap.parkingSpot;

import dao.ParkingSpotDAO;
import dao.ParkingTicketDAO;
import domain.ParkingTicketStatus;
import dto.ParkingSpotDTO;
import dto.ParkingTicketDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.time.LocalDateTime;

@WebService
public class ParkingSpotServiceImpl implements ParkingSpotService {

    @WebMethod
    public Boolean occupyParkingSpot(Integer spotId) {
        ParkingSpotDTO parkingSpot = ParkingSpotDAO.getInstance().getItem(spotId);

        if (!parkingSpot.getOccupied()) {
            parkingSpot.setOccupied(true);
            ParkingSpotDAO.getInstance().updateItem(parkingSpot);
            ParkingTicketDTO newTicket = new ParkingTicketDTO(parkingSpot);
            ParkingTicketDAO.getInstance().addItem(newTicket);
            return true;
        }
        else {
            return false;
        }
    }

    @WebMethod
    public Boolean releaseParkingSpot(Integer spotId) {
        ParkingSpotDTO parkingSpot = ParkingSpotDAO.getInstance().getItem(spotId);

        if (parkingSpot.getOccupied()) {
            parkingSpot.setOccupied(false);
            ParkingSpotDAO.getInstance().updateItem(parkingSpot);
            ParkingTicketDTO activeTicket = ParkingTicketDAO.getInstance().findActiveTicketForSpot(parkingSpot);
            activeTicket.setEndTime(LocalDateTime.now());
            activeTicket.setStatus(ParkingTicketStatus.CLOSED);
            ParkingTicketDAO.getInstance().updateItem(activeTicket);
            return true;
        }
        else {
            return false;
        }
    }
}
