package uni.umons.ratingwebapp.domain.dto;

import uni.umons.ratingwebapp.domain.BotStats;
import uni.umons.ratingwebapp.domain.Stats;
import uni.umons.ratingwebapp.domain.TimeSeriesStats;

import java.util.List;

public class HomePageStats {
    private List<UserStatisticDto> userStats;
    private List<BotStats> botStats;
    private List<TimeSeriesStats> lastMonthStats;

    public List<UserStatisticDto> getUserStats() {
        return userStats;
    }

    public void setUserStats(List<UserStatisticDto> userStats) {
        this.userStats = userStats;
    }

    public List<BotStats> getBotStats() {
        return botStats;
    }

    public void setBotStats(List<BotStats> botStats) {
        this.botStats = botStats;
    }

    public List<TimeSeriesStats> getLastMonthStats() {
        return lastMonthStats;
    }

    public void setLastMonthStats(List<TimeSeriesStats> lastMonthStats) {
        this.lastMonthStats = lastMonthStats;
    }
}
