package soap.parkingSpot;

import dao.ParkingSpotDAO;
import dao.ParkingTicketDAO;
import domain.ParkingTicketStatus;
import dto.ParkingSpotDTO;
import dto.ParkingTicketDTO;
import guard.Guard;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@WebService()
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ParkingSpotServiceImpl implements ParkingSpotService {

    @WebMethod
    @WebResult(name="operationOutcome")
    public Boolean occupyParkingSpot(@WebParam(name="spotId")Integer spotId) {
        ParkingSpotDTO parkingSpot = ParkingSpotDAO.getInstance().getItem(spotId);

        if (!parkingSpot.getOccupied()) {
            String uniqueID = UUID.randomUUID().toString();
            parkingSpot.setOccupied(true);
            parkingSpot.setTriggerEventUuid(uniqueID);
            ParkingSpotDAO.getInstance().updateItem(parkingSpot);
            ParkingTicketDTO newTicket = new ParkingTicketDTO(parkingSpot);
            Optional<Integer> ticketId = ParkingTicketDAO.getInstance().addItem(newTicket);
            Guard.getInstance().scheduleTicketValidation(ticketId.get(), uniqueID);
            return true;
        }
        else {
            return false;
        }
    }

    @WebMethod
    @WebResult(name="operationOutcome")
    public Boolean releaseParkingSpot(@WebParam(name="spotId")Integer spotId) {
        ParkingSpotDTO parkingSpot = ParkingSpotDAO.getInstance().getItem(spotId);

        if (parkingSpot.getOccupied()) {
            parkingSpot.setOccupied(false);
            parkingSpot.setTriggerEventUuid(null);
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
