
package uni.umons.ratingwebapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PreDestroy;
import javax.annotation.security.RolesAllowed;


@RequestMapping(value = "/admin/")
@Controller
public class AdminController {

	@PreAuthorize("hasRole('Administrator')")
	@RequestMapping(value = "dashboard")
	public String dashboard() {
		return "dashboard";
	}

	@PreAuthorize("hasRole('Administrator')")
	@RequestMapping(value = "home")
	public String home() {
		return "admin/home";
	}

	@PreAuthorize("hasRole('Administrator')")
	@RequestMapping(value = "analyzed")
	public String AnalyzedItems() {
		return "admin/analyzed";
	}

	@PreAuthorize("hasRole('Administrator')")
	@RequestMapping(value = "edititems")
	public String editItems() {
		return "admin/edititems";
	}

	@PreAuthorize("hasRole('Administrator')")
	@RequestMapping(value = "results")
	public String results() {
		return "admin/results";
	}
}
