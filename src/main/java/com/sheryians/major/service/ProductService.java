package com.sheryians.major.service;

import com.sheryians.major.model.Product;
import com.sheryians.major.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
 @Autowired
 ProductRepository productRepository;

 public List<Product> getAllProd() {
  return productRepository.findAll();
 }

 public void addProducts(Product product) {
  productRepository.save(product);
 }

 public void removeProductById(long id) {

  productRepository.deleteById(id);

 }
 public Optional findProductById(long id){
  return productRepository.findById(id);
 }
 public List<Product> getAllProdByCat(int id){
  return productRepository.findProductByCategory_Id(id);

 }
}