package uni.umons.ratingwebapp.domain;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class TimeSeriesStats {
    Integer userId;
    String name;
    BigInteger total;
    String ratedAt;

    public TimeSeriesStats(Integer userId, BigInteger total, String ratedAt){
        this.userId = userId;
        this.total = total;
        this.ratedAt = ratedAt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRatedAt() {
        return ratedAt;
    }

    public void setRatedAt(String ratedAt) {
        this.ratedAt = ratedAt;
    }
}
