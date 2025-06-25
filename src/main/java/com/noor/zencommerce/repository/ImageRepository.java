package com.noor.zencommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noor.zencommerce.model.Image;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByProductId(Long id);
}
