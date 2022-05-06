package com.example.demo1.controller;

import com.example.demo1.Models.Product;
import com.example.demo1.Models.ResponseObject;
import com.example.demo1.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Products")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping("")
    List<Product> getAllProducts(){
    return repository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id){
        Optional<Product> foundProduct = repository.findById(id);
        if(foundProduct.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","Query product successfully ",foundProduct)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("false","Can not find product with id = ",""));
        }
    }
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct){
        List<Product> foundProduct = repository.findByProductName(newProduct.getProductName().trim());
        if(foundProduct.size()>0){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("false","Product already exist","")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Insert successfully",repository.save(newProduct))
        );
    }
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct, @PathVariable Long id) {
        Product updatedProduct = repository.findById(id)//updatedProduct cos gia tri khi co return
                .map(product -> {//trung nen luu de
                    product.setProductName(newProduct.getProductName());
                    product.setYear(newProduct.getYear());
                    product.setPrice(newProduct.getPrice());
                    return repository.save(product);// truyen ham product vao day
                }).orElseGet(() -> {// insert moi
                    newProduct.setId(id);
                    return repository.save(newProduct);
                });
        return ResponseEntity.status(HttpStatus.OK).body(//ok
                new ResponseObject("ok", "Update Product successfully", updatedProduct)
        );
    }
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long id){
        boolean exist = repository.existsById(id);
        if(exist){
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","Delete product successfully","")) ;
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("false","can not find product to delete","")) ;
    }
}
