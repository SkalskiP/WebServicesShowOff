package dao;

import dto.EmployeeDTO;

import javax.persistence.TypedQuery;

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

    public EmployeeDTO getByFirebaseUid(String uid) {
        TypedQuery query = entityManager.createQuery("SELECT data FROM " + className + " data WHERE data.firebaseUid = :uid", clazz);
        query.setParameter("uid", uid);
        return (EmployeeDTO) query.getSingleResult();
    }
}
