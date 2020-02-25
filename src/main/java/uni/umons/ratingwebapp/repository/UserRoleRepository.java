package uni.umons.ratingwebapp.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uni.umons.ratingwebapp.domain.UserRole;

@Repository
@Qualifier(value = "userRoleRepository")
public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {

}
