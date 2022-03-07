package com.sheryians.major.repository;

import com.sheryians.major.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
   public List<Product> findProductByCategory_Id(int id);
}
