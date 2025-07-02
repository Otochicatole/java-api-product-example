package dev.otochi.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.net.URL;
import java.util.UUID;

@Entity
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String description;
    private BigInteger price;
    private BigInteger offerPrice;
    private BigInteger quantity;
    private URL image;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
}