package net.etfbl.webshop.repositories;

import net.etfbl.webshop.models.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query("SELECT o FROM Comment o WHERE o.offer.id=:id")
    List<Comment> findAllCommentsByIdOffer(Integer id);

}
