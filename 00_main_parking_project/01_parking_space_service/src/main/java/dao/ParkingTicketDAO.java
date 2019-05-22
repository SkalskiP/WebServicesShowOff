package dao;

import domain.ParkingTicketStatus;
import dto.ParkingSpotDTO;
import dto.ParkingTicketDTO;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParkingTicketDTO> query = criteriaBuilder.createQuery(ParkingTicketDTO.class);
        Root<ParkingTicketDTO> b = query.from(ParkingTicketDTO.class);
        query.select(b).where(criteriaBuilder.equal(b.get("parkingSpot"), parkingSpot.getId()));
        query.select(b).where(criteriaBuilder.notEqual(b.get("status"), ParkingTicketStatus.CLOSED));

        return entityManager.createQuery(query).getSingleResult();
    }
}
