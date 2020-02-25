package uni.umons.ratingwebapp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_comment")
@NamedQueries({
		@NamedQuery(name = "Comment.findAll", query = "SELECT u FROM Comment u"),
		@NamedQuery(name = "Comment.findByAuthor", query = "SELECT u FROM Comment u WHERE u.gitUser = :author"),
		@NamedQuery(name = "Comment.findByAuthorId", query = "SELECT u FROM Comment u WHERE u.gitUser = :id")
})
public class Comment implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id" , unique = true, nullable = false)
	private Long id;

	@JsonBackReference
	@JoinColumn(name = "gituser", referencedColumnName = "id", insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private GitUser gitUser;

	@Column(name = "issue_type")
	private String issueType;

	@Column(name = "issue_number")
	private String issueNumber;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "body")
	private String body;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GitUser getGitUser() {
		return gitUser;
	}

	public void setGitUser(GitUser gitUser) {
		this.gitUser = gitUser;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public String getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(String issueNumber) {
		this.issueNumber = issueNumber;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
