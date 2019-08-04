package pl.akademiakodu.shops.repository;

import org.springframework.data.repository.CrudRepository;
import pl.akademiakodu.shops.model.Comment;

public interface
CommentRepository extends
        CrudRepository
                <Comment, Integer> {
}
