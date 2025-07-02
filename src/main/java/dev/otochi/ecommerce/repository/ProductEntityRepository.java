package dev.otochi.ecommerce.repository;

import dev.otochi.ecommerce.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, UUID> {
}