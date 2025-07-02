package dev.otochi.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private String description;

    // Relación con la categoría padre (muchas categorías pueden tener una misma categoría padre)
    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    @JsonBackReference
    private CategoryEntity parentCategory;

    // Relación con las subcategorías (una categoría puede tener muchas subcategorías)
    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private List<CategoryEntity> subcategories;
}
