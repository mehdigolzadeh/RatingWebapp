package uni.umons.ratingwebapp.domain.dto;

public class UserRoleDto implements BaseDto<uni.umons.ratingwebapp.domain.UserRole>{
	
	private Integer userRoleId;
	
	private String userRoleName;
	
	private UserDto user;

	/**
	 * @return the userRoleId
	 */
	public Integer getUserRoleId() {
		return userRoleId;
	}

	/**
	 * @param userRoleId the userRoleId to set
	 */
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	/**
	 * @return the userRoleName
	 */
	public String getUserRoleName() {
		return userRoleName;
	}

	/**
	 * @param userRoleName the userRoleName to set
	 */
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	/**
	 * @return the user
	 */
	public UserDto getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserDto user) {
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", userRoleName="
				+ userRoleName + "]";
	}

	@Override
	public uni.umons.ratingwebapp.domain.UserRole toEntity() {
		return null;
	}
}
