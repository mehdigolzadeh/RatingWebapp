package uni.umons.ratingwebapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
@Table(name = "tbl_repository")
public class Repository  implements Serializable {

	@Id
	@Column(name = "id")
	private Long addrId;
	
	@Column(name = "name", length = 256)
	private String name;

	@Column(name = "created_at")
	private ZonedDateTime createdAt;

	@Column(name = "issue_count")
	private int issueCount;

	@Column(name = "pr_count")
	private int prCount;

	public Long getAddrId() {
		return addrId;
	}

	public void setAddrId(Long addrId) {
		this.addrId = addrId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(ZonedDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public int getIssueCount() {
		return issueCount;
	}

	public void setIssueCount(int issueCount) {
		this.issueCount = issueCount;
	}

	public int getPrCount() {
		return prCount;
	}

	public void setPrCount(int prCount) {
		this.prCount = prCount;
	}
}
