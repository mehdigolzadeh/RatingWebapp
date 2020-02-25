package uni.umons.ratingwebapp.domain;



import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_rate")
public class Rate  implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long rateId;

	@Basic(optional = false)
	@NotNull
	@Column(name = "gituser")
	private Long gitUserId;

	@JsonBackReference
	@JoinColumn(name = "gituser", referencedColumnName = "id", insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private GitUser gitUser;

	@Column(name = "rated_at")
	private LocalDateTime ratedAt;

	@Basic(optional = false)
	@NotNull
	@Column(name = "rater_id")
	private Long raterid;

	@JsonBackReference
	@JoinColumn(name = "rater_id", referencedColumnName = "id", insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private User rater;

	@Column(name = "rate")
	private Short rate;

	@Column(name = "rate_diffuculty")
	private Short rateDiffuculty;

	@Column(name = "description",length = 255)
	private String description;

	public Long getRateId() {
		return rateId;
	}

	public void setRateId(Long rateId) {
		this.rateId = rateId;
	}

	public Long getGitUserId() {
		return gitUserId;
	}

	public void setGitUserId(Long gitUserId) {
		this.gitUserId = gitUserId;
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

	public Long getRaterid() {
		return raterid;
	}

	public void setRaterid(Long raterid) {
		this.raterid = raterid;
	}

	public User getRater() {
		return rater;
	}

	public void setRater(User rater) {
		this.rater = rater;
	}

	public Short getRate() {
		return rate;
	}

	public void setRate(Short rate) {
		this.rate = rate;
	}

	public Short getRateDiffuculty() {
		return rateDiffuculty;
	}

	public void setRateDiffuculty(Short rateDiffuculty) {
		this.rateDiffuculty = rateDiffuculty;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
