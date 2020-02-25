package uni.umons.ratingwebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import uni.umons.ratingwebapp.repository.UserRepository;
import uni.umons.ratingwebapp.repository.UserRoleRepository;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


@Component
public class UserDataLoader implements ApplicationListener<ContextRefreshedEvent> {
	
	private Logger logger = LogManager.getLogger(DataServices.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
//		User admin = new User();
//		admin.setUsername("admin");
//		admin.setPassword("123");
//		admin.setFirstName("Tom");
//		admin.setLastName("Mens");
//
//
//		UserRole adminRole = new UserRole();
//		adminRole.setUserRoleName("Administrator");
//		adminRole.setUser(admin);
//		Set<UserRole> adminRoles = new HashSet<UserRole>(0);
//		adminRoles.add(adminRole);
//
//		admin.setUserRoles(adminRoles);
//
//		userRepository.save(admin);
//		logger.debug("Saved admin ID: " + admin.getUserId());
//
//
//		User user1 = new User();
//		user1.setUsername("mehdi");
//		user1.setPassword("123");
//		user1.setFirstName("Mehdi");
//		user1.setLastName("Golzadeh");
//
//		UserRole userRole = new UserRole();
//		userRole.setUserRoleName("User");
//		userRole.setUser(user1);
//		Set<UserRole> userRoles = new HashSet<UserRole>(0);
//		userRoles.add(userRole);
//
//		user1.setUserRoles(userRoles);
//
//		userRepository.save(user1);
//		logger.debug("Saved user1 ID: " + user1.getUserId());
		
	}

}
