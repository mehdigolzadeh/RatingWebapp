package uni.umons.ratingwebapp.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import uni.umons.ratingwebapp.domain.GitUser;

import javax.persistence.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Repository
@Qualifier(value = "gituserRepository")
public class GitUserRepositoryImpl extends BaseDaoImpl<GitUser, Long> implements GituserRepository {

    private Logger logger = LogManager.getLogger(GitUserRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    public GitUserRepositoryImpl() {
        super(GitUser.class);
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

//    public boolean checkUserPassword(String username, String password) {
//        try {
//            String result = entityManager
//                    .createNativeQuery(
//                            "SELECT FN_USER_IS_OK(:P_USER_NAME , :P_USER_PASSWORD) FROM DUAL"
//                    )
//                    .setParameter("P_USER_NAME", username)
//                    .setParameter("P_USER_PASSWORD", password)
//                    .getSingleResult().toString();
//
//            return result.equals("1");
//
//        } catch (Exception ex) {
//            throw ex;
//        }
//    }
//
//    public User getByUserName(String username) {
//        try {
//            TypedQuery<User> userTypedQuery = entityManager.createNamedQuery("User.findByName", User.class);
//            userTypedQuery.setParameter("name", username);
//
//            return userTypedQuery.getSingleResult();
//
//        } catch (Exception ex) {
//            throw ex;
//        }
//    }
//
//    public boolean changeUserPassword(Integer userId, String oldPassword, String newPassword) throws Exception {
//        try {
//            StoredProcedureQuery query = entityManager
//                    .createStoredProcedureQuery("PR_CHANGE_PASSWORD")
//                    .registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN)
//                    .registerStoredProcedureParameter(2, String.class, ParameterMode.IN)
//                    .registerStoredProcedureParameter(3, String.class, ParameterMode.IN)
//                    .registerStoredProcedureParameter(4, Integer.class, ParameterMode.OUT)
//                    .setParameter(1, userId)
//                    .setParameter(2, oldPassword)
//                    .setParameter(3, newPassword);
//
//            query.execute();
//            String result = query.getOutputParameterValue(4).toString();
//
//            if (result.equals("2"))
//                throw new OcspCustomException(ServiceExceptionErrorCode.Old_Password_Invalid);
//            if (result.equals("0"))
//                throw new Exception("Data base error");
//            return true;
//        } catch (Exception ex) {
//            throw ex;
//        }
//    }
//
//    public boolean setUserPassword(Integer userId, String password) {
//        try {
//            StoredProcedureQuery query = entityManager
//                    .createStoredProcedureQuery("PR_CHANGE_PASSWORD_PRIOR")
//                    .registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN)
//                    .registerStoredProcedureParameter(2, String.class, ParameterMode.IN)
//                    .registerStoredProcedureParameter(3, Integer.class, ParameterMode.OUT)
//                    .setParameter(1, userId)
//                    .setParameter(2, password);
//
//            query.execute();
//            String result = query.getOutputParameterValue(3).toString();
//
//            return result.equals("1");
//
//        } catch (Exception ex) {
//            return false;
//        }
//    }
//
//    public String getUserPassword(String userName) {
//        try {
//            return entityManager
//                    .createNativeQuery(
//                            "SELECT Fn_user_ret_password(:P_USER_NAME) FROM DUAL"
//                    )
//                    .setParameter("P_USER_NAME", userName)
//                    .getSingleResult().toString();
//
//        } catch (Exception ex) {
//            return null;
//        }
//    }

    @Override
    public GitUser findGitUsersByName(String username) {
        try {
            TypedQuery<GitUser> userTypedQuery = entityManager.createNamedQuery("GitUser.findByName", GitUser.class);
            userTypedQuery.setParameter("name", username);

            return userTypedQuery.getSingleResult();

        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public GitUser findByGitUserId(Long Id) {
        try {
            TypedQuery<GitUser> userTypedQuery = entityManager.createNamedQuery("GitUser.findById", GitUser.class);
            userTypedQuery.setParameter("id", Id);

            return userTypedQuery.getSingleResult();

        } catch (Exception ex) {
            throw ex;
        }
    }
}