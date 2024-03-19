package com.example.skamito.controllers;

import com.example.skamito.models.Comment;
import com.example.skamito.models.Product;
import com.example.skamito.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String products(@RequestParam(name = "title", required = false) String title,Model model) {
        model.addAttribute("products", productService.listProducts(title));
        return "products";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("images",product.getImages());
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(@RequestParam("file1") MultipartFile file1,
                                @RequestParam("file2") MultipartFile file2,
                                @RequestParam("file3") MultipartFile file3,
                                Product product) throws IOException {
        productService.saveProduct(product,file1,file2,file3);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }

    @GetMapping("/product/edit/{id}")
    public String editProductForm(@PathVariable Long id,Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "edit-product";
    }

    @PostMapping("/product/edit/{id}")
    public String editProduct(@PathVariable Long id, Product product) {
      productService.updateProduct(id,product);
      return "redirect:/";
    }

    @PostMapping("/product/{productId}/comment")
    public String addCommentToProduct(@PathVariable Long productId, @ModelAttribute Comment comment) {
        productService.addCommentToProduct(productId, comment);
        return "redirect:/product/" + productId;
    }

    /*@PostMapping("/product/{id}/comment")
    public String addComment(@PathVariable("id") Long id, @RequestParam("commentText") String commentText) {
        Product product = productService.getProductById(id);
        Comment comment = new Comment();
        comment.setText(commentText);
        comment.setProduct(product);
        commentService.saveComment(comment);
        return "redirect:/product/" + id;
    }*/
}