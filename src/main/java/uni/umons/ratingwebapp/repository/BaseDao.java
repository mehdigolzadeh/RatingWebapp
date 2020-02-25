package uni.umons.ratingwebapp.repository;

import javax.persistence.LockModeType;
import java.util.List;

public interface BaseDao<T, ID> {

    T getById(ID id);

    T getById(ID id, LockModeType lockModeType);

    int getAllCount();

    List<T> getAll();

    void create(T entity);

    void delete(ID id);

    void update(T entity);
}
