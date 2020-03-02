package uni.umons.ratingwebapp.domain;

import java.io.Serializable;
import java.math.BigInteger;

public class Stats implements Serializable
{
    Integer userId;

    BigInteger totalRate;
    BigInteger humanRate;
    BigInteger botRate;
    BigInteger idkRate;

    BigInteger veryEasyRate;
    BigInteger easyRate;
    BigInteger difficultRate;
    BigInteger veryDifficultRate;
    BigInteger noDifficulty;

    public Stats(Integer userId, BigInteger totalRate, BigInteger humanRate, BigInteger botrate,BigInteger idkRate
            ,BigInteger veryEasyRate,BigInteger easyRate, BigInteger difficultRate,BigInteger veryDifficultRate, BigInteger noDifficulty){
        this.userId = userId;
        this.totalRate = totalRate;
        this.humanRate= humanRate;
        this.botRate=botrate;
        this.idkRate=idkRate;

        this.veryEasyRate= veryEasyRate;
        this.easyRate= easyRate;
        this.difficultRate= difficultRate;
        this.veryDifficultRate= veryDifficultRate;
        this.noDifficulty= noDifficulty;
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

    public BigInteger getVeryEasyRate() {
        return veryEasyRate;
    }

    public void setVeryEasyRate(BigInteger veryEasyRate) {
        this.veryEasyRate = veryEasyRate;
    }

    public BigInteger getEasyRate() {
        return easyRate;
    }

    public void setEasyRate(BigInteger easyRate) {
        this.easyRate = easyRate;
    }

    public BigInteger getDifficultRate() {
        return difficultRate;
    }

    public void setDifficultRate(BigInteger difficultRate) {
        this.difficultRate = difficultRate;
    }

    public BigInteger getVeryDifficultRate() {
        return veryDifficultRate;
    }

    public void setVeryDifficultRate(BigInteger veryDifficultRate) {
        this.veryDifficultRate = veryDifficultRate;
    }

    public BigInteger getNoDifficulty() {
        return noDifficulty;
    }

    public void setNoDifficulty(BigInteger noDifficulty) {
        this.noDifficulty = noDifficulty;
    }
}
