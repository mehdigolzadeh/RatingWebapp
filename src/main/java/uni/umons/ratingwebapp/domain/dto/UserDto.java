package uni.umons.ratingwebapp.domain.dto;

import java.util.List;
import java.util.Set;

public class UserDto implements BaseDto<uni.umons.ratingwebapp.domain.User>{

	private Long userId;
	
	private String username;

	private String password;
	
	private String firstName;

	private String lastName;

	private Set<UserRoleDto> userRoles;

	private List<RateDto> rateDtos;


	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the userRoles
	 */
	public Set<UserRoleDto> getUserRoles() {
		return userRoles;
	}

	/**
	 * @param userRoles the userRoles to set
	 */
	public void setUserRoles(Set<UserRoleDto> userRoles) {
		this.userRoles = userRoles;
	}

	public List<RateDto> getRateDtos() {
		return rateDtos;
	}

	public void setRateDtos(List<RateDto> rateDtos) {
		this.rateDtos = rateDtos;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username
				+ ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName
				+ ", userRoles=" + userRoles + "]";
	}

	@Override
	public uni.umons.ratingwebapp.domain.User toEntity() {
		return null;
	}
}
