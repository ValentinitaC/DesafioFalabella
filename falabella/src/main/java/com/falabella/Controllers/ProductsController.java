package com.falabella.Controllers;

import com.falabella.Dto.ProductDto;
import com.falabella.Service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/falabella")
public class ProductsController {

    private ProductsService productsService;

    public ProductsController(ProductsService products){
        this.productsService = products;
    }

    @PostMapping("/save-product")
    public ResponseEntity<HttpStatus> createProduct(@RequestBody ProductDto product) {
        productsService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/list-all")
    public List<ProductDto> listAllProducts() {
        return productsService.listAllProducts();
    }

    @GetMapping("/{sku}")
    public ProductDto listProduct(@RequestParam String sku) {
        productsService.listProduct(sku);
        return productsService.listProduct(sku);
    }

    @PutMapping("/{sku}")
    public String updateProduct(@RequestBody ProductDto product) {
        productsService.updateProduct(product);
        return "Product "+ product.getSku() +" updated correctly";
    }

    @DeleteMapping("/{sku}")
    public String deleteProduct(@RequestParam String sku) {

        productsService.deleteProduct(sku);
        return "The product was removed successfully.";
    }



}
