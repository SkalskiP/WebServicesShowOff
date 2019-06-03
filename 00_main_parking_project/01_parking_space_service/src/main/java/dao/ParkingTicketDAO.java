package dao;

import domain.ParkingTicketStatus;
import dto.ParkingSpotDTO;
import dto.ParkingTicketDTO;

import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

public class ParkingTicketDAO extends AbstractDAO<ParkingTicketDTO> {

    private ParkingTicketDAO() {
        super(ParkingTicketDTO.class);
    }

    private static ParkingTicketDAO instance;

    public static ParkingTicketDAO getInstance() {
        if (instance == null) {
            synchronized (ParkingTicketDAO.class) {
                if (instance == null) {
                    instance = new ParkingTicketDAO();
                }
            }
        }
        return instance;
    }

    public ParkingTicketDTO findActiveTicketForSpot(ParkingSpotDTO parkingSpot) {
        TypedQuery query = entityManager.createQuery("SELECT c FROM " + className + " c WHERE c.parkingSpot = :parkingSpot AND c.status != :status ORDER BY c.paymentTime DESC", clazz);
        query.setParameter("parkingSpot", parkingSpot);
        query.setParameter("status", ParkingTicketStatus.CLOSED);
        return (ParkingTicketDTO) query.getSingleResult();
    }

    public List<ParkingTicketDTO> findTicketsFromTimePeriod(LocalDateTime from, LocalDateTime to, Integer limit, Integer offset) {
        TypedQuery query = entityManager.createQuery(
                "SELECT c FROM " + className + " c WHERE c.arrivalTime BETWEEN :fromDate AND :toDate ORDER BY c.arrivalTime DESC", clazz);
        query.setParameter("fromDate", from);
        query.setParameter("toDate", to);
        query.setFirstResult(offset); // equivalent to OFFSET
        query.setMaxResults(limit); // equivalent to LIMIT
        return query.getResultList();
    }
}
