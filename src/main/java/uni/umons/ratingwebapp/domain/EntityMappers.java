package uni.umons.ratingwebapp.domain;

import uni.umons.ratingwebapp.domain.dto.*;

import javax.activation.CommandMap;
import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class EntityMappers {

    public static GitUserDto GitUsertoGitUserDto(GitUser gitUser)
    {
        if(gitUser == null)
        {
            return null;
        }
        GitUserDto gitUserDto = new GitUserDto();
        gitUserDto.setGitUserId(gitUser.getGitUserId());
        gitUserDto.setName(gitUser.getName());
        gitUserDto.setRepository(gitUser.getRepository());
        gitUserDto.setComments(EntityMappers.CommentsToCommentsDto(gitUser.getComments()));
        gitUserDto.setRateDtos(EntityMappers.RatesToRatesDto(gitUser.getRates()));

        return gitUserDto;
    }

    public static CommentDto CommentToCommentDto(Comment comment)
    {
        if(comment == null)
        {
            return null;
        }
        CommentDto commentDto = new CommentDto();
        commentDto.setAuthor(comment.getGitUser().getName());
        commentDto.setId(comment.getId());
        commentDto.setCreatedAt(comment.getCreatedAt());
        commentDto.setBody(comment.getBody());
        return commentDto;
    }

    public static List<CommentDto> CommentsToCommentsDto(List<Comment> comments)
    {
        if (comments.size() == 0)
        {
            return null;
        }
        List<CommentDto> commentDtos = new ArrayList<>();
        for(Comment comment : comments)
        {
            commentDtos.add(EntityMappers.CommentToCommentDto(comment));
        }
        return commentDtos;
    }

    public static RateDto RateToRateDto(Rate rate)
    {
        if(rate == null)
        {
            return null;
        }
        RateDto rateDto = new RateDto();
        rateDto.setRateId(rate.getRateId());
        rateDto.setRatedAt(rate.getRatedAt());
        rateDto.setRate(rate.getRate());
        rateDto.setGitUserName(rate.getGitUser().getName());
        rateDto.setGitUserRepo(rate.getGitUser().getRepository());
        rateDto.setDescription(rate.getDescription());
        rateDto.setRaterName(rate.getRater().getUsername());
        rateDto.setRateDiffuculty(rate.getRateDiffuculty());
        rateDto.setGitUser(rate.getGitUser().getGitUserId());
        return rateDto;
    }

    public static List<RateDto> RatesToRatesDto(List<Rate> rates)
    {
        if (rates.size() == 0)
        {
            return null;
        }
        List<RateDto> rateDtos = new ArrayList<>();
        for(Rate rate : rates)
        {
            rateDtos.add(EntityMappers.RateToRateDto(rate));
        }
        return rateDtos;
    }

    public static UserDto UsertoUserDto(User user)
    {
        if(user == null)
        {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUsername(user.getUsername());
        userDto.setUserId(user.getUserId());
        userDto.setUserRoles(EntityMappers.RolestoRolesDto(user.getUserRoles()));
        return userDto;
    }

    public static UserRoleDto RoletoRoleDto(UserRole role)
    {
        if(role==null)
        {
            return null;
        }
        UserRoleDto roleDto = new UserRoleDto();

        roleDto.setUserid(role.getUserid());
        roleDto.setUserRoleId(role.getUserRoleId());
        roleDto.setUserRoleName(role.getUserRoleName());
        return roleDto;
    }

    public static List<UserRoleDto> RolestoRolesDto(List<UserRole> roles)
    {
        if (roles.size() == 0)
        {
            return null;
        }
        List<UserRoleDto> roleDtos = new ArrayList<>();
        for(UserRole role : roles)
        {
            roleDtos.add(EntityMappers.RoletoRoleDto(role));
        }
        return roleDtos;
    }
}
