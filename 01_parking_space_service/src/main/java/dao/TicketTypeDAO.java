package dao;

import dto.TicketTypeDTO;

public class TicketTypeDAO extends AbstractDAO<TicketTypeDTO> {

    private TicketTypeDAO() {
        super(TicketTypeDTO.class);
    }

    private static TicketTypeDAO instance;

    public static TicketTypeDAO getInstance() {
        if (instance == null) {
            synchronized (TicketTypeDAO.class) {
                if (instance == null) {
                    instance = new TicketTypeDAO();
                }
            }
        }
        return instance;
    }

}
