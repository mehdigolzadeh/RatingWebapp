package uni.umons.ratingwebapp.security;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public abstract class SecurityUtil {
    public static UserDetails getCurrentUser()
    {
        SecurityContext context = SecurityContextHolder.getContext();
        if((context!=null && context.getAuthentication() != null) && context.getAuthentication().getPrincipal() instanceof UserDetails)
        {
            return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        return null;
    }
}
