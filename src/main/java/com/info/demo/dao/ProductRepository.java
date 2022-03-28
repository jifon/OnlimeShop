package com.info.demo.dao;

import java.util.List;

import com.info.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	public List<Product> findByCategory_CategoryId(long CategoryId);
	
}
