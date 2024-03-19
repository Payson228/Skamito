package com.example.skamito.controllers;

import com.example.skamito.models.Comment;
import com.example.skamito.models.Product;
import com.example.skamito.services.CommentService;
import com.example.skamito.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommentController {
   /* @Autowired
    private ProductService productService;

    @Autowired
    private CommentService commentService;

    @PostMapping("/product/{productId}/comment")
    public String addComment(@PathVariable("productId") Long productId, @RequestParam("commentText") String commentText) {
        Product product = productService.getProductById(productId);
        Comment comment = new Comment();
        comment.setText(commentText);
        comment.setProduct(product);
        commentService.saveComment(comment);
        return "redirect:/product/" + productId;
    }*/
    /*private final CommentService commentService;

    *//*@GetMapping("/products/{id}")
    public String comments(@PathVariable Long productId) {
        model.addAttribute("comments", commentService.getCommentsByProduct(product));
        return "product-info";*//*
    }

    @PostMapping("/products/{productId}")
    public String addComment(@PathVariable("productId") Long productId, Comment comment) {
        commentService.addComment(productId, comment);
        return "redirect:/products/" + productId;
    }

    @GetMapping("/products/{productId}/comments/{commentId}/delete")
    public String deleteComment(@PathVariable("productId") Long productId, @PathVariable("commentId") Long commentId) {
        commentService.deleteComment(commentId);
        return "redirect:/products/" + productId;
    }

    @PostMapping("/products/{productId}/comments/{commentId}/edit")
    public String updateComment(@PathVariable("productId") Long productId, @PathVariable("commentId") Long commentId, Comment updatedComment) {
        commentService.updateComment(commentId, updatedComment);
        return "redirect:/products/" + productId;
    }*/

}
