package uni.umons.ratingwebapp.domain.dto;

import java.util.List;

public class GitUserDto implements BaseDto<uni.umons.ratingwebapp.domain.GitUser>{

	private Long gitUserId;
	
	private String name;

	private String repository;

	private Long commentInRepo;

	private Long repositoryCount;

	private Long allComments;

	private Boolean botInName;

	private Long fastResponse;

	private List<CommentDto> comments;

	private List<RateDto> rateDtos;

	public Long getGitUserId() {
		return gitUserId;
	}

	public void setGitUserId(Long gitUserId) {
		this.gitUserId = gitUserId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRepository() {
		return repository;
	}

	public void setRepository(String repository) {
		this.repository = repository;
	}

	public Long getCommentInRepo() {
		return commentInRepo;
	}

	public void setCommentInRepo(Long commentInRepo) {
		this.commentInRepo = commentInRepo;
	}

	public Long getRepositoryCount() {
		return repositoryCount;
	}

	public void setRepositoryCount(Long repositoryCount) {
		this.repositoryCount = repositoryCount;
	}

	public Long getAllComments() {
		return allComments;
	}

	public void setAllComments(Long allComments) {
		this.allComments = allComments;
	}

	public Boolean getBotInName() {
		return botInName;
	}

	public void setBotInName(Boolean botInName) {
		this.botInName = botInName;
	}

	public Long getFastResponse() {
		return fastResponse;
	}

	public void setFastResponse(Long fastResponse) {
		this.fastResponse = fastResponse;
	}

	public List<CommentDto> getComments() {
		return comments;
	}

	public void setComments(List<CommentDto> comments) {
		this.comments = comments;
	}

	public List<RateDto> getRateDtos() {
		return rateDtos;
	}

	public void setRateDtos(List<RateDto> rateDtos) {
		this.rateDtos = rateDtos;
	}

	@Override
	public uni.umons.ratingwebapp.domain.GitUser toEntity() {
		return null;
	}
}
