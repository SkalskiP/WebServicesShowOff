package dao;

import dto.EmployeeDTO;

public class EmployeeDAO extends AbstractDAO<EmployeeDTO> {

    private EmployeeDAO() {
        super(EmployeeDTO.class);
    }

    private static EmployeeDAO instance;

    public static EmployeeDAO getInstance() {
        if (instance == null) {
            synchronized (EmployeeDAO.class) {
                if (instance == null) {
                    instance = new EmployeeDAO();
                }
            }
        }
        return instance;
    }

}
