package com.example.ecom_proj.contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecom_proj.service.ProductService;


import error.ApiResponse;
import jakarta.validation.Valid;

import com.example.ecom_proj.model.ErrorResponse;
import com.example.ecom_proj.model.Product;
import error.ResponseHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService service;


    
    @GetMapping("/success")
    public ResponseEntity<ApiResponse<String>> getSuccessResponse() {
        String data = "This is a successful response!";
        return ResponseEntity.ok(ApiResponse.success("Operation succeeded", data));
    }

    @GetMapping("/failure")
    public ResponseEntity<ApiResponse<Object>> getFailureResponse() {
    	ErrorResponse error = new ErrorResponse(
    		    "ERR_001",
    		    "Operation failed due to some issues",
    		    Arrays.asList("Detail 1", "Detail 2")
    		);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(ApiResponse.failure("Operation failed", error));
    }
    
    @GetMapping("/rdd")
	public ResponseEntity<Object> getCityWithPincode() {
    	String data = "This is a successful response!";
		

		return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, data, 2);
	}
    
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {

        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        Product product = service.getProduct(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/product")
//    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile) {
    public ResponseEntity<?> addProduct(@Valid @RequestBody Product product) {
        try {
        	
//            Product product1 = service.addProduct(product, imageFile);
        	Product product1 = service.addProduct(product);
        	
        	return new ResponseEntity<>(product1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);


        }
    }
    
    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product product) {

        Product product1 = null;
        product1 = service.updateProduct(id, product);
        if (product1 != null) {
            return new ResponseEntity<>("updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
        }


    }


    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        Product product = service.getProduct(id);
        if (product != null) {
            service.deleteProduct(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword) {

        List<Product> products = service.searchProducts(keyword);
        System.out.println("searching with " + keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


  
}