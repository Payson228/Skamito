package com.example.skamito.services;

import com.example.skamito.models.Comment;
import com.example.skamito.models.Product;
import com.example.skamito.repositories.ProductRepository;
import com.example.skamito.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor

public class CommentService {
    private CommentRepository commentRepository;

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    /*public List<Comment> (Long productId) {
        if(productId!= null) return commentRepository.findByProductId(productId);
        return commentRepository.findAll();
    }*/


    // Метод добавления комментария к объявлению
    /*public Comment addComment(Long productID, Comment commentary) {
        Optional<Product> optionalProduct = productRepository.findById(productID);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            commentary.setProduct(product);
            return commentRepository.save(commentary);
        } else {
            throw new IllegalArgumentException("Товар с указанным ID не найден");
        }
    }*/

    // Метод удаления комментария
/*public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }


    // Метод редактирования комментария
public Comment updateComment(Long commentId, Comment updatedComment) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        if (optionalComment.isPresent()) {
            Comment comment = optionalComment.get();
            comment.setCommentary(updatedComment.getCommentary());
            return commentRepository.save(comment);
        } else {
            throw new IllegalArgumentException("Комментарий с указанным ID не найден");
        }
    }*/

}
