package com.sheryians.major.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long Id;
    private String Name;
    private int categoryId;
    private double price;
    private double weight;
    private String description;
    private String imageName;
}
