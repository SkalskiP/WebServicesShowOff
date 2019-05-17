package dao;

import dto.ParkingTicketDTO;

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

}
