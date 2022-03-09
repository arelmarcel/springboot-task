package com.example.demo.service;


import com.example.demo.dto.ProductDto;
import com.example.demo.dto.UpdateStockDto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity add(ProductDto request){
        ProductEntity product = new ProductEntity();
        product.setName(request.getProductName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());

        //todo : save into db

        return productRepository.save(product);
    }

    public List<ProductEntity> fetchAll(){

        return (List<ProductEntity>) productRepository.findAll();
    }

    public void delete(long id){
        productRepository.deleteById(id);
    }

    public ProductEntity fetchById(long id){
        return productRepository.findById(id).orElse(new ProductEntity());
    }

    public ProductEntity updateStock(UpdateStockDto request){
        //1 get product data by id in db
        ProductEntity result = fetchById(request.getId());

        //2 update stock
        long currentStock = result.getStock();
        long updatedStock = currentStock + request.getNumberOfStock();
        result.setStock(updatedStock);
        //3 save updated stock to db
        return productRepository.save(result);
    }

//    public List<ProductEntity> fetch(boolean isInStock){
//        if (isInStock){
//            //fetch
//            return  fetchAllInStock();
//        } else {
//            return fetchAll();
//        }
//
//    }

    public List<ProductEntity> fetch(long maxPrice){
        if (maxPrice == 0){
            //fetch
            return fetchAll();
        } else {
            return  fetchAllInPrice(maxPrice);
        }

    }

//    public List<ProductEntity> fetchAllInStock() {
//        return productRepository.findByPriceLessThanEqual();
//    }
    public List<ProductEntity> fetchAllInPrice(long price) {
        return productRepository.findByPriceLessThanEqual(price);
    }
}
