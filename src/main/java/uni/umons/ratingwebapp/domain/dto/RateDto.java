package uni.umons.ratingwebapp.domain.dto;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class RateDto implements BaseDto<uni.umons.ratingwebapp.domain.Rate> {

	private Long rateId;

	private Long gitUser;

	private LocalDateTime ratedAt;

	private String raterName;

	private Long rate;

	private Long rateDiffuculty;

	private String description;

	public Long getRateId() {
		return rateId;
	}

	public void setRateId(Long rateId) {
		this.rateId = rateId;
	}

	public LocalDateTime getRatedAt() {
		return ratedAt;
	}

	public void setRatedAt(LocalDateTime ratedAt) {
		this.ratedAt = ratedAt;
	}

	public Long getRate() {
		return rate;
	}

	public void setRate(Long rate) {
		this.rate = rate;
	}

	public Long getRateDiffuculty() {
		return rateDiffuculty;
	}

	public void setRateDiffuculty(Long rateDiffuculty) {
		this.rateDiffuculty = rateDiffuculty;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getGitUser() {
		return gitUser;
	}

	public void setGitUser(Long gitUser) {
		this.gitUser = gitUser;
	}

	public String getRaterName() {
		return raterName;
	}

	public void setRaterName(String raterName) {
		this.raterName = raterName;
	}

	@Override
	public uni.umons.ratingwebapp.domain.Rate toEntity() {
		return null;
	}
}
