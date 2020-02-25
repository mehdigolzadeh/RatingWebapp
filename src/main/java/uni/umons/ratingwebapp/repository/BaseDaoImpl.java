package uni.umons.ratingwebapp.repository;


import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public abstract class BaseDaoImpl<T,ID extends Serializable> implements BaseDao<T,ID> {

    private Class<T> entityClass;
    private Logger logger = LogManager.getLogger(BaseDaoImpl.class);

    protected abstract EntityManager getEntityManager();

    public BaseDaoImpl(Class<T> entityClass)
    {
        this.entityClass = entityClass;
    }

    public T getById(ID id) {
        try {
            return getEntityManager().find(entityClass, id);
        }
        catch (Exception e){
            logger.error("Argument is not valid type for entity", e);
            return null;
        }
    }

    public T getById(ID id, LockModeType lockModeType) {
        try {
            return getEntityManager().find(entityClass, id, lockModeType);
        }
        catch (Exception e){
            logger.error("Argument is not valid type for entity", e);
            return null;
        }
    }

    public List<T> getAll() {
        Query q = getEntityManager().createNamedQuery(entityClass.getSimpleName() + ".findAll");
        return (List<T>) q.getResultList();
    }

    public int getAllCount(){
        return ((Long) getEntityManager().createQuery(
                "SELECT COUNT(*) FROM " + entityClass.getSimpleName() + " AS o").getSingleResult()).intValue();
    }


    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void delete(ID id) {
        getEntityManager().remove(getById(id));
    }

    public void update(T entity) {
        getEntityManager().merge(entity);
    }
}

