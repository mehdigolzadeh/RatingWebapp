package uni.umons.ratingwebapp.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uni.umons.ratingwebapp.domain.Comment;
import uni.umons.ratingwebapp.domain.GitUser;

import java.util.List;

public interface CommentRepository extends BaseDao<Comment, Long> {
    List<Comment> findAllByAuthor(GitUser gitUser);
    List<Comment> findAllByAuthorId(Long id);
}
