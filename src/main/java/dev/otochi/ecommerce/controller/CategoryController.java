package dev.otochi.ecommerce.controller;

import dev.otochi.ecommerce.dto.CategoryDTO;
import dev.otochi.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        return ResponseEntity.ok(service.getAllAsDTO());
    }

    @GetMapping("/root")
    public ResponseEntity<List<CategoryDTO>> getRootCategories() {
        return ResponseEntity.ok(service.getRootCategoriesAsDTO());
    }

    @GetMapping("/subcategories/{parentId}")
    public ResponseEntity<List<CategoryDTO>> getSubcategories(@PathVariable UUID parentId) {
        return ResponseEntity.ok(service.getSubcategoriesAsDTO(parentId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable UUID id) {
        return service.getByIdAsDTO(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Opción avanzada: recibir DTO y mapear a Entity (aún no implementado)
    // @PostMapping
    // public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO dto) {
    //     CategoryEntity entity = mapper.toEntity(dto); // <- se necesitaría el mapper inverso
    //     CategoryEntity saved = service.create(entity);
    //     return ResponseEntity.ok(mapper.toDTO(saved));
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
