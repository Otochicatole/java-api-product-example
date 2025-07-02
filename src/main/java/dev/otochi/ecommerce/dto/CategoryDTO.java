package dev.otochi.ecommerce.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CategoryDTO {

    private UUID id;
    private String name;
    private String description;
    private List<CategoryDTO> subcategories;
}
