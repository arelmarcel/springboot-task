package com.example.demo.repository;

import com.example.demo.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    //List<ProductEntity> findByStockGreaterThan(long jumlah);
    List<ProductEntity> findByPriceLessThanEqual(long harga);
    
}
