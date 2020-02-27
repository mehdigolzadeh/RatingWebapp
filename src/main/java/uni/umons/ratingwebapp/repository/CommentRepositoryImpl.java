package uni.umons.ratingwebapp.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import uni.umons.ratingwebapp.domain.Comment;
import uni.umons.ratingwebapp.domain.GitUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Repository
@Qualifier(value = "commentRepository")
public class CommentRepositoryImpl extends BaseDaoImpl<Comment, Long> implements CommentRepository {

    private Logger logger = LogManager.getLogger(CommentRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    public CommentRepositoryImpl() {
        super(Comment.class);
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Comment> findAllByAuthor(GitUser gitUser) {
        try {
            TypedQuery<Comment> userTypedQuery = entityManager.createNamedQuery("Comment.findByAuthor", Comment.class);
            userTypedQuery.setParameter("author", gitUser.getGitUserId());

            return userTypedQuery.getResultList();

        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public List<Comment> findAllByAuthorId(Long id) {
        try {
            TypedQuery<Comment> userTypedQuery = entityManager.createNamedQuery("Comment.findByAuthorId", Comment.class);
            userTypedQuery.setParameter("id", id);

            return userTypedQuery.getResultList();

        } catch (Exception ex) {
            throw ex;
        }
    }
}
