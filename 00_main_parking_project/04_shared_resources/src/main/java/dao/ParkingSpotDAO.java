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

    public Long getFilteredCount(String zone, String street) {
        TypedQuery query = entityManager.createQuery("SELECT COUNT(spot) FROM ParkingSpotDTO spot JOIN spot.street s JOIN s.zone z JOIN z.employee e WHERE lower(z.name) LIKE :zone AND lower(s.name) LIKE :street", Long.class);
        if (zone != null) {
            query.setParameter("zone", "%" + zone + "%");
        } else {
            query.setParameter("zone", "%%");
        }

        if (street != null) {
            query.setParameter("street", "%" + street + "%");
        } else {
            query.setParameter("street", "%%");
        }

        return (Long) query.getSingleResult();
    }

    public List<ParkingSpotDTO> getFiltered(String zone, String street, Integer offset, Integer limit) {
        TypedQuery query = entityManager.createQuery("SELECT spot FROM ParkingSpotDTO spot JOIN spot.street s JOIN s.zone z JOIN z.employee e WHERE lower(z.name) LIKE :zone AND lower(s.name) LIKE :street", clazz);
        if (zone != null) {
            query.setParameter("zone", "%" + zone + "%");
        } else {
            query.setParameter("zone", "%%");
        }

        if (street != null) {
            query.setParameter("street", "%" + street + "%");
        } else {
            query.setParameter("street", "%%");
        }

        query.setFirstResult(offset); // equivalent to OFFSET
        query.setMaxResults(limit); // equivalent to LIMIT
        return query.getResultList();
    }

    public Long getByFirebaseUidCount(String zone, String street, String uid) {
        TypedQuery query = entityManager.createQuery("SELECT COUNT(spot) FROM ParkingSpotDTO spot JOIN spot.street s JOIN s.zone z JOIN z.employee e WHERE lower(z.name) LIKE :zone AND e.firebaseUid = :uid AND lower(s.name) LIKE :street", Long.class);
        if (zone != null) {
            query.setParameter("zone", "%" + zone + "%");
        } else {
            query.setParameter("zone", "%%");
        }

        if (street != null) {
            query.setParameter("street", "%" + street + "%");
        } else {
            query.setParameter("street", "%%");
        }

        query.setParameter("uid", uid);

        return (Long) query.getSingleResult();
    }

    public List<ParkingSpotDTO> getByFirebaseUid(String zone, String street, Integer offset, Integer limit, String uid) {
        TypedQuery query = entityManager.createQuery("SELECT spot FROM ParkingSpotDTO spot JOIN spot.street s JOIN s.zone z JOIN z.employee e WHERE lower(z.name) LIKE :zone AND e.firebaseUid = :uid AND lower(s.name) LIKE :street", clazz);
        if (zone != null) {
            query.setParameter("zone", "%" + zone + "%");
        } else {
            query.setParameter("zone", "%%");
        }

        if (street != null) {
            query.setParameter("street", "%" + street + "%");
        } else {
            query.setParameter("street", "%%");
        }

        query.setParameter("uid", uid);
        query.setFirstResult(offset); // equivalent to OFFSET
        query.setMaxResults(limit); // equivalent to LIMIT
        return query.getResultList();
    }
}
