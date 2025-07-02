package dev.otochi.ecommerce.mapper;

import dev.otochi.ecommerce.dto.CategoryDTO;
import dev.otochi.ecommerce.entity.CategoryEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "subcategories", source = "subcategories")
    CategoryDTO categoryEntityToCategoryDTO(CategoryEntity category, @Context CycleAvoidingMappingContext context);

    List<CategoryDTO> categoryEntityListToDTOList(List<CategoryEntity> categories, @Context CycleAvoidingMappingContext context);

    @BeforeMapping
    default <T> T getMappedInstance(Object source, @TargetType Class<T> targetType, @Context CycleAvoidingMappingContext context) {
        return context.getMappedInstance(source, targetType);
    }

    @AfterMapping
    default void storeMappedInstance(Object source, @MappingTarget Object target, @Context CycleAvoidingMappingContext context) {
        context.storeMappedInstance(source, target);
    }
}
