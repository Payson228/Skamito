package com.example.skamito.repositories;

import com.example.skamito.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;


    public interface ImageRepository extends JpaRepository<Image, Long> {
}
