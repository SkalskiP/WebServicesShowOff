package dao;

import dto.ZoneDTO;

public class ZoneDAO extends AbstractDAO<ZoneDTO> {

    private ZoneDAO() {
        super(ZoneDTO.class);
    }

    private static ZoneDAO instance;

    public static ZoneDAO getInstance() {
        if (instance == null) {
            synchronized (ZoneDAO.class) {
                if (instance == null) {
                    instance = new ZoneDAO();
                }
            }
        }
        return instance;
    }

}
