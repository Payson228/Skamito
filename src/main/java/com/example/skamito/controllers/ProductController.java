package com.example.skamito.controllers;

import com.example.skamito.models.Comment;
import com.example.skamito.models.Product;
import com.example.skamito.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PostMapping("/create/product")
    public String createProduct(@RequestParam("file1") MultipartFile file1,
                                @RequestParam("file2") MultipartFile file2,
                                @RequestParam("file3") MultipartFile file3,
                                Product product) throws IOException {
        productService.saveProduct(product,file1,file2,file3);
        return "redirect:/";
    }

    @PostMapping("/delete/product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }

    @GetMapping("/edit/product/{id}")
    public String editProductForm(@PathVariable Long id,Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "edit-product";
    }

    @PostMapping("/edit/product/{id}")
    public String editProduct(@PathVariable Long id, Product product) {
      productService.updateProduct(id,product);
      return "redirect:/";
    }

    @PostMapping("/create/comment/{productId}")
    public String addCommentToProduct(@PathVariable Long productId, @ModelAttribute Comment comment) {
        productService.addCommentToProduct(productId, comment);
        return "redirect:/product/" + productId;
    }

    @PostMapping("/delete/product/comment/{productId}/{commentId}")
    public String deleteCommentFromProduct(@PathVariable Long productId, @PathVariable Long commentId) {
        productService.deleteCommentFromProduct(productId, commentId);
        return "redirect:/product/" + productId;
    }
    @GetMapping("/edit/product/comment/{commentId}")
    public String editCommentForm(@PathVariable Long commentId, Model model) {
        model.addAttribute("comment",productService.getCommentById(commentId));
        return "edit-comment";
    }

    @PostMapping("/edit/product/comment/{commentId}")
    public String editComment(@PathVariable Long commentId, Comment comment) {
        productService.updateComment(commentId, comment);
        return "redirect:/";
    }

    /*@PostMapping("/product/{productId}/delete/{commentId}")
    public String deleteCommentToProduct(@PathVariable  Long productId,@PathVariable Long commentId) {
        productService.deleteCommentToProduct(commentId);
        return "redirect:/product/" + productId;
    }*/

    /*@PostMapping("/product/{productId}/comment/{commentId}")
    public String editCommentToProduct(@PathVariable Long productId, @PathVariable Long commentId, String comment) {
        productService.editCommentToProduct(commentId,comment);
        return "redirect:/product/" + productId;
    }*/
}