package dev.otochi.ecommerce.repository;

import dev.otochi.ecommerce.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, UUID> {
    Optional<List<CategoryEntity>> findAllByParentCategoryIsNull();
    List<CategoryEntity> findAllByParentCategoryId(UUID parentId);
}
