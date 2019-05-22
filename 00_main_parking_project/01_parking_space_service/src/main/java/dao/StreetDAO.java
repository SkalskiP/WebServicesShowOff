package dao;

import dto.StreetDTO;

public class StreetDAO extends AbstractDAO<StreetDTO> {

    private StreetDAO() {
        super(StreetDTO.class);
    }

    private static StreetDAO instance;

    public static StreetDAO getInstance() {
        if (instance == null) {
            synchronized (StreetDAO.class) {
                if (instance == null) {
                    instance = new StreetDAO();
                }
            }
        }
        return instance;
    }

}
