package dev.otochi.ecommerce.service;

import dev.otochi.ecommerce.dto.CategoryDTO;
import dev.otochi.ecommerce.entity.CategoryEntity;
import dev.otochi.ecommerce.mapper.CategoryMapper;
import dev.otochi.ecommerce.mapper.CycleAvoidingMappingContext;
import dev.otochi.ecommerce.repository.CategoryEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryEntityRepository repository;
    private final CategoryMapper mapper;


    public List<CategoryDTO> getAllAsDTO() {
        List<CategoryEntity> entities = repository.findAll();
        return mapper.categoryEntityListToDTOList(entities, new CycleAvoidingMappingContext());
    }

    public List<CategoryDTO> getRootCategoriesAsDTO() {
        List<CategoryEntity> roots = repository.findAllByParentCategoryIsNull().orElse(List.of());
        return mapper.categoryEntityListToDTOList(roots, new CycleAvoidingMappingContext());
    }

    public List<CategoryDTO> getSubcategoriesAsDTO(UUID parentId) {
        List<CategoryEntity> subs = repository.findAllByParentCategoryId(parentId);
        return mapper.categoryEntityListToDTOList(subs, new CycleAvoidingMappingContext());
    }

    public Optional<CategoryDTO> getByIdAsDTO(UUID id) {
        return repository.findById(id)
                .map(entity -> mapper.categoryEntityToCategoryDTO(entity, new CycleAvoidingMappingContext()));
    }


    public CategoryEntity create(CategoryEntity category) {
        return repository.save(category);
    }

    public CategoryDTO createFromDTO(CategoryDTO dto) {
        CategoryEntity entity = mapper.categoryDTOToEntity(dto);
        CategoryEntity saved = repository.save(entity);
        return mapper.categoryEntityToCategoryDTO(saved, new CycleAvoidingMappingContext());
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public Optional<CategoryEntity> getByIdEntity(UUID id) {
        return repository.findById(id);
    }

    public List<CategoryEntity> getAllEntities() {
        return repository.findAll();
    }
}
