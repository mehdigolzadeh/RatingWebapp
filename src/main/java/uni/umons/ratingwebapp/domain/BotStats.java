package uni.umons.ratingwebapp.domain;

import java.io.Serializable;
import java.math.BigInteger;

public class BotStats implements Serializable
{
    Integer userId;

    BigInteger totalRate;
    BigInteger humanRate;
    BigInteger botRate;
    BigInteger idkRate;

    public BotStats(Integer userId, BigInteger totalRate, BigInteger humanRate, BigInteger botrate, BigInteger idkRate){
        this.userId = userId;
        this.totalRate = totalRate;
        this.humanRate= humanRate;
        this.botRate=botrate;
        this.idkRate=idkRate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigInteger getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(BigInteger totalRate) {
        this.totalRate = totalRate;
    }

    public BigInteger getHumanRate() {
        return humanRate;
    }

    public void setHumanRate(BigInteger humanRate) {
        this.humanRate = humanRate;
    }

    public BigInteger getBotRate() {
        return botRate;
    }

    public void setBotRate(BigInteger botRate) {
        this.botRate = botRate;
    }

    public BigInteger getIdkRate() {
        return idkRate;
    }

    public void setIdkRate(BigInteger idkRate) {
        this.idkRate = idkRate;
    }
}
