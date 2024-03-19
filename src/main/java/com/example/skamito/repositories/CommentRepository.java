package com.example.skamito.repositories;

import com.example.skamito.models.Comment;
import com.example.skamito.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
