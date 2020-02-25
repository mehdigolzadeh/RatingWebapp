package uni.umons.ratingwebapp.domain;



import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_rate")
public class Rate  implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long rateId;

	@ManyToOne
	@JoinColumn(name = "gituser")
	private GitUser gitUser;


	@Column(name = "rated_at")
	private LocalDateTime ratedAt;

	@ManyToOne
	@JoinColumn(name = "rater_id")
	private User rater;

	@Column(name = "rate")
	private Long rate;

	@Column(name = "rate_diffuculty")
	private Long rateDiffuculty;

	@Column(name = "description",length = 255)
	private String description;

	public Long getRateId() {
		return rateId;
	}

	public void setRateId(Long rateId) {
		this.rateId = rateId;
	}

	public GitUser getGitUser() {
		return gitUser;
	}

	public void setGitUser(GitUser gitUser) {
		this.gitUser = gitUser;
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

	public User getRater() {
		return rater;
	}

	public void setRater(User rater) {
		this.rater = rater;
	}
}
