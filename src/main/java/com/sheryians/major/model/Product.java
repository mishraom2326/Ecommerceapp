package com.sheryians.major.model;

import lombok.Data;

import javax.persistence.*;
@Entity
@Data
public class Product {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long Id;
    private String Name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id",referencedColumnName = "category_id")
    private Category category;
    private double price;
    private double weight;
    private String description;
    private String imageName;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

}
