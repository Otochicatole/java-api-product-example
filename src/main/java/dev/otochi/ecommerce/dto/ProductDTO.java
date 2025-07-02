package dev.otochi.ecommerce.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigInteger;
import java.net.URL;

@Data
public class ProductDTO {
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private BigInteger price;
    @NotNull
    private BigInteger offerPrice;
    @NotNull
    private BigInteger quantity;
    @NotNull
    private URL image;
}