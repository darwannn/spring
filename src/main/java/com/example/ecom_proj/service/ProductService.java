package com.example.ecom_proj.service;

import com.example.ecom_proj.model.Product;
import com.example.ecom_proj.dao.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepository;

    public List<Product> getAllProducts() {
    	  List<Product> products = productRepository.findAll();
          System.out.println("Returned Products: " + products); // This will use Lombok's @ToString
          return products;
    }
    
    public Product getProduct(int id) {
        return productRepository.findById(id).orElse(null);
    }
    
//    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
    public Product addProduct(Product product)  {    	
//        product.setImageName(imageFile.getOriginalFilename());
//        product.setImageType(imageFile.getContentType());
//        product.setImageData(imageFile.getBytes());

        return productRepository.save(product);
    }
    
    
    public Product updateProduct(int id, Product product) {

//        product.setImageName(imageFile.getOriginalFilename());
//        product.setImageType(imageFile.getContentType());
//        product.setImageData(imageFile.getBytes());
        return productRepository.save(product);
    }

    public void deleteProduct(int id) {
    	productRepository.deleteById(id);
    }


    public List<Product> searchProducts(String keyword) {
        return productRepository.searchProducts(keyword);
    }
}