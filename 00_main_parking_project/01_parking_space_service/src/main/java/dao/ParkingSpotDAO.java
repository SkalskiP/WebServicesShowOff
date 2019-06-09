package dao;

import dto.ParkingSpotDTO;

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
}
