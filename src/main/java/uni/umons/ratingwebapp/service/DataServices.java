package uni.umons.ratingwebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uni.umons.ratingwebapp.domain.EntityMappers;
import uni.umons.ratingwebapp.domain.GitUser;
import uni.umons.ratingwebapp.domain.Rate;
import uni.umons.ratingwebapp.domain.User;
import uni.umons.ratingwebapp.domain.dto.GitUserDto;
import uni.umons.ratingwebapp.domain.dto.RateDto;
import uni.umons.ratingwebapp.domain.dto.UserDto;
import uni.umons.ratingwebapp.repository.*;
import uni.umons.ratingwebapp.security.SecurityUtil;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;


@Service("services")
public class DataServices {

	private Logger logger = LogManager.getLogger(DataServices.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private RateRepository rateRepository;

	@Autowired
	private GituserRepository gituserRepository;

	@Transactional
	public User getCurrentUserDetail(){
		return userRepository.findByUsername(SecurityUtil.getCurrentUser().getUsername());
	}

	@Transactional
	public Rate getLastIncompleteRate(){
		return rateRepository.findRateByRaterAndRate(getCurrentUserDetail(),Short.parseShort("0"));
	}

	@Transactional
	public GitUserDto getNextGituser() {
		User user = getCurrentUserDetail();
		GitUser nextGitUser = null;
		Rate rate = rateRepository.findRateByRaterAndRate(user,Short.parseShort("0"));
		if(rate != null){
			nextGitUser = gituserRepository.findByGitUserId(rate.getGitUserId());
		}else {
			nextGitUser = gituserRepository.findNextUser(user.getUserId());
			rate = new Rate();
			rate.setGitUserId(nextGitUser.getGitUserId());
			rate.setRaterid(user.getUserId());
			rate.setRate(Short.parseShort("0"));
			rateRepository.save(rate);
		}
		logger.info("Next GitUser retrieved.");
		return EntityMappers.GitUsertoGitUserDto(nextGitUser);
	}

	@Transactional
	public void RecordNewRate(RateDto ratedto)
	{
		logger.info("New rate added");
		Rate rate = ratedto.toEntity();
		rate.setRaterid(userRepository.findByUsername(ratedto.getRaterName()).getUserId());
		rateRepository.save(rate);
	}

	@Transactional
	public void UpdateRate(Rate rate)
	{
		logger.info("Rate updated.");
		rateRepository.save(rate);
	}

	@Transactional
	public GitUser getGitUser(String user,String repo) {
		logger.info("Authority group list is requested");
		return gituserRepository.findGitUsersByName(user);
	}

	@Transactional
	public List<RateDto> getUserRates(){
		logger.info("load user rates");
		return EntityMappers.RatesToRatesDto(rateRepository.findAllByRater(userRepository.findByUsername(SecurityUtil.getCurrentUser().getUsername())));
	}

}
