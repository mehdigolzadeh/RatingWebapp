package uni.umons.ratingwebapp.domain.dto;

import uni.umons.ratingwebapp.domain.BotStats;
import uni.umons.ratingwebapp.domain.Stats;

import java.util.List;
import java.util.Map;

public class UserStatisticDto {

	private String name;
	private Stats stats;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}
}
