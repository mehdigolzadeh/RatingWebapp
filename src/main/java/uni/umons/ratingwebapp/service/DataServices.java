package uni.umons.ratingwebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uni.umons.ratingwebapp.domain.EntityMappers;
import uni.umons.ratingwebapp.domain.GitUser;
import uni.umons.ratingwebapp.domain.Rate;
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
	public GitUserDto getNextGituser() {
		UserDetails user = SecurityUtil.getCurrentUser();
		List<Rate> rates = rateRepository.findAllByRater(userRepository.findByUsername(user.getUsername()));
		GitUser nextGitUser = null;
		do {
			if(rates.size() != 0 ){
				Long nextId = rates.get(rates.size()-1).getRateId();
				nextGitUser = gituserRepository.findByGitUserId(nextId);
			}else{
				nextGitUser = gituserRepository.findByGitUserId(Long.parseLong("1"));
			}
		}while (nextGitUser.getRates().size()>2);

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
	public GitUser getGitUser(String user,String repo) {
		logger.info("Authority group list is requested");
		return gituserRepository.findGitUsersByName(user);
	}

}
