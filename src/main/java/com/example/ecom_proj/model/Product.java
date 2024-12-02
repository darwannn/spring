package com.example.ecom_proj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required") // Ensures the name is not null or empty
    @Size(max = 100, message = "Name cannot exceed 100 characters") // Limits name length
    private String name;

    @NotBlank(message = "Description is required") // Ensures the description is not null or empty
    @Size(max = 500, message = "Description cannot exceed 500 characters") // Limits description length
    private String description;

    @NotBlank(message = "Brand is required") // Ensures the brand is not null or empty
    @Size(max = 50, message = "Brand cannot exceed 50 characters") // Limits brand length
    private String brand;

    @NotNull(message = "Price is required") // Ensures price is not null
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0") // Ensures price is greater than 0
    private BigDecimal price;

    @NotBlank(message = "Category is required") // Ensures the category is not null or empty
    @Size(max = 50, message = "Category cannot exceed 50 characters") // Limits category length
    private String category;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotNull(message = "Release date is required") // Ensures release date is not null
    @PastOrPresent(message = "Release date must be in the past or today") // Ensures release date is not in the future
    private Date releaseDate;

    private boolean available;

    @Min(value = 0, message = "Quantity must be zero or greater") // Ensures quantity is not negative
    private int quantity;

//    private String imageName;
//    private String imageType;
////    @Lob
//    private byte[] imageData;

    // Default Constructor
    public Product() {
    }

    // All-Args Constructor
    public Product(int id, String name, String description, String brand, BigDecimal price,
                   String category, Date releaseDate, boolean available, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.category = category;
        this.releaseDate = releaseDate;
        this.available = available;
        this.quantity = quantity;
//        this.imageName = imageName;
//        this.imageType = imageType;
//        this.imageData = imageData;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    public String getImageName() {
//        return imageName;
//    }
//
//    public void setImageName(String imageName) {
//        this.imageName = imageName;
//    }
//
//    public String getImageType() {
//        return imageType;
//    }
//
//    public void setImageType(String imageType) {
//        this.imageType = imageType;
//    }
//
//    public byte[] getImageData() {
//        return imageData;
//    }
//
//    public void setImageData(byte[] imageData) {
//        this.imageData = imageData;
//    }

    // Overriding toString
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", available=" + available +
                ", releaseDate=" + releaseDate +
//                ", imageName='" + imageName + '\'' +
//                ", imageType='" + imageType + '\'' +
                '}';
    }
}
