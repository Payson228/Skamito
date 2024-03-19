package com.example.skamito.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "text")
    private String text;
    @Column(name = "author", length = 100, nullable = false)
    private String author;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}