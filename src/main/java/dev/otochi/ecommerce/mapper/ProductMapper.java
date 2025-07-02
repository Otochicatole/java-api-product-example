package dev.otochi.ecommerce.mapper;

import dev.otochi.ecommerce.dto.ProductDTO;
import dev.otochi.ecommerce.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductEntity toProductEntity(ProductDTO productDTO);
    ProductDTO toProductDTO(ProductEntity productEntity);
}
