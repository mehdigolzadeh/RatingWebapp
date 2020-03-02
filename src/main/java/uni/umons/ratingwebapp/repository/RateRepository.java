package uni.umons.ratingwebapp.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uni.umons.ratingwebapp.domain.*;

import java.util.List;

@Repository
@Qualifier(value = "rateRepository")
public interface RateRepository extends CrudRepository<Rate, Long> {
    public List<Rate> findAllByRater(User rater);
    public List<Rate> findAll();
    public List<Rate> findAllByGitUser(GitUser gitUser);
    public Rate findRateByRaterAndRate(User user,Short rate);

    @Query(nativeQuery = true)
    public List<Stats> getStats();

    @Query(nativeQuery = true)
    public List<BotStats> getBotStats();

    @Query(nativeQuery = true)
    public List<TimeSeriesStats> getUserTimely();
}
