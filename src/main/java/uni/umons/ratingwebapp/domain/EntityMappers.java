package uni.umons.ratingwebapp.domain;

import uni.umons.ratingwebapp.domain.dto.CommentDto;
import uni.umons.ratingwebapp.domain.dto.GitUserDto;
import uni.umons.ratingwebapp.domain.dto.RateDto;

import javax.activation.CommandMap;
import java.util.ArrayList;
import java.util.List;

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

    public static RateDto RatesToRatsDto(Rate rate)
    {
        if(rate == null)
        {
            return null;
        }
        RateDto rateDto = new RateDto();
        rateDto.setRateId(rate.getRateId());
        rateDto.setRatedAt(rate.getRatedAt());
        rateDto.setRate(rate.getRate());
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
            rateDtos.add(EntityMappers.RatesToRatsDto(rate));
        }
        return rateDtos;
    }
}
