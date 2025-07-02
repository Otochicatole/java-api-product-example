package dev.otochi.ecommerce.service;

import dev.otochi.ecommerce.dto.ProductDTO;
import dev.otochi.ecommerce.entity.ProductEntity;
import dev.otochi.ecommerce.mapper.ProductMapper;
import dev.otochi.ecommerce.repository.ProductEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductEntityRepository productEntityRepository;

    public ProductEntity createProduct(ProductDTO productCreateDTO) {
        ProductEntity product = ProductMapper.INSTANCE.toProductEntity(productCreateDTO);
        return productEntityRepository.save(product);
    }


    public List<ProductEntity> getAllProducts() {
        return productEntityRepository.findAll();
    }

    public Optional<ProductEntity> getProductById(UUID id) {
        return productEntityRepository.findById(id);
    }

    public void deleteProductById(UUID id) {
        productEntityRepository.deleteById(id);
    }

    public ProductEntity updateProduct(UUID id, ProductDTO updatedProduct) {
        ProductEntity productEntity = productEntityRepository.findById(id).orElse(null);
        if (productEntity != null) {
            productEntity = ProductMapper.INSTANCE.toProductEntity(updatedProduct);
            return productEntityRepository.save(productEntity);
        }
        return null;
    }

}