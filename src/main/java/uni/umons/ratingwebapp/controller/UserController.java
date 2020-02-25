package uni.umons.ratingwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import uni.umons.ratingwebapp.domain.GitUser;
import uni.umons.ratingwebapp.domain.dto.GitUserDto;
import uni.umons.ratingwebapp.service.DataServices;

import java.util.List;


@RequestMapping(value = "/user/")
@Controller
public class UserController {

	@Autowired
	private DataServices dataServices;

	@PreAuthorize("hasRole('User') or hasRole('Administrator')")
	@RequestMapping(value = "home" , method = RequestMethod.GET)
	public String home() {

		return "user/home";
	}

	@PreAuthorize("hasRole('User') or hasRole('Administrator')")
	@RequestMapping(value = "rate" , method = RequestMethod.GET)
	public String rate() {
		
		return "user/rate";
	}

	@PreAuthorize("hasRole('User') or hasRole('Administrator')")
	@RequestMapping(value = "rateditems",method = RequestMethod.GET)
	public String rateditems() {

		return "user/rateditems";
	}

	@PreAuthorize("hasRole('User') or hasRole('Administrator')")
	@RequestMapping(value = "description",method = RequestMethod.GET)
	public String description() {
		return "user/description";
	}

	@PreAuthorize("hasRole('User') or hasRole('Administrator')")
	@RequestMapping(value = "givemeNextGituser" , method = RequestMethod.POST
			,produces = "application/json")
	public @ResponseBody
	GitUserDto GivemeNextGituser()
	{
		return dataServices.getNextGituser();
	}

}
