package com.example.skamito.services;

import com.example.skamito.models.Comment;
import com.example.skamito.models.Image;
import com.example.skamito.models.Product;
import com.example.skamito.repositories.CommentRepository;
import com.example.skamito.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CommentRepository commentRepository;

    public List<Product> listProducts(String title) {
        if(title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    public void saveProduct(Product product, MultipartFile file1,MultipartFile file2,MultipartFile file3) throws IOException {
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPrewievImage(true);
            product.addImageToProduct(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            product.addImageToProduct(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            product.addImageToProduct(image3);
        }
        log.info("Saving new Product. Title: {}; Author: {}", product.getTitle(), product.getAuthor());
        Product productFromDb = productRepository.save(product);
        productFromDb.setPreviewImageId(productFromDb.getImages().get(0).getId());
        productRepository.save(product);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void updateProduct(Long id, Product updatedProduct) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setTitle(updatedProduct.getTitle());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setCity(updatedProduct.getCity());
            product.setAuthor(updatedProduct.getAuthor());
            // Сохраняем обновленный продукт в базе данных
            productRepository.save(product);
        } else {
            // Если продукт с указанным id не найден
            throw new IllegalArgumentException("Product with id " + id + " not found");
        }
    }

    public void updateComment(Long commentId, Comment updatedComment) {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        if (commentOptional.isPresent()) {
            Comment comment = commentOptional.get();
            comment.setAuthor(updatedComment.getAuthor());
            comment.setText(updatedComment.getText());
            commentRepository.save(comment);
        } else {
            // Если продукт с указанным id не найден
            throw new IllegalArgumentException("Product with id " + commentId + " not found");
        }

    }
    public void addCommentToProduct(Long productId, Comment comment) {
        Product product = getProductById(productId);
        if (product != null) {
            comment.setProduct(product);
            commentRepository.save(comment);
        }
    }

    public void deleteCommentFromProduct(Long productId, Long commentId) {
        Product product = getProductById(productId);
        if (product != null) {
            Comment comment = commentRepository.findById(commentId).orElse(null);
            if (comment != null) {
                product.getComments().remove(comment);
                commentRepository.delete(comment);
            }
        }
    }



    /*public void editCommentToProduct( Long commentId, String comment) {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        if (commentOptional.isPresent()) {
            Comment updatedcomment = commentOptional.get();
            updatedcomment.setText(comment);
            commentRepository.save(updatedcomment);
        }*/
}
