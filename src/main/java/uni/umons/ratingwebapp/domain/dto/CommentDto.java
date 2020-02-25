package uni.umons.ratingwebapp.domain.dto;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class CommentDto implements BaseDto<uni.umons.ratingwebapp.domain.Comment>{

	private Long id;
	private String author;
	private String issueType;
	private String issueNumber;
	private LocalDateTime createdAt;
	private String body;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	@Override
	public uni.umons.ratingwebapp.domain.Comment toEntity() {
		return null;
	}
}
