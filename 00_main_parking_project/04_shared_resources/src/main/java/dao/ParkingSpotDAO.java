package dao;

import dto.ParkingSpotDTO;

import javax.persistence.TypedQuery;
import java.util.List;

public class ParkingSpotDAO extends AbstractDAO<ParkingSpotDTO> {

    private ParkingSpotDAO() {
        super(ParkingSpotDTO.class);
    }

    private static ParkingSpotDAO instance;

    public static ParkingSpotDAO getInstance() {
        if (instance == null) {
            synchronized (ParkingSpotDAO.class) {
                if (instance == null) {
                    instance = new ParkingSpotDAO();
                }
            }
        }
        return instance;
    }

    public List<ParkingSpotDTO> getByFirebaseUid(String uid) {
        TypedQuery query = entityManager.createQuery("SELECT spot FROM ParkingSpotDTO spot JOIN spot.street s JOIN s.zone z JOIN z.employee e WHERE e.firebaseUid = :uid", clazz);
        query.setParameter("uid", uid);
        return query.getResultList();
    }
}
