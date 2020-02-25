package uni.umons.ratingwebapp.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uni.umons.ratingwebapp.domain.GitUser;
import uni.umons.ratingwebapp.domain.Rate;
import uni.umons.ratingwebapp.domain.User;

import java.util.List;

@Repository
@Qualifier(value = "rateRepository")
public interface RateRepository extends CrudRepository<Rate, Long> {
    public List<Rate> findAllByRater(User rater);
    public List<Rate> findAllByGitUser(GitUser gitUser);
}
