package com.falabella.Service;

import com.falabella.Dto.ProductDto;
import com.falabella.Exceptions.ProductAlreadyExistsException;
import com.falabella.Exceptions.ProductDoesNotExistException;
import com.falabella.Repository.ProductsRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {

    private ProductsRepository productsRepository;
    @Override
    public void createProduct(ProductDto product){

        Optional<ProductDto> productDto = Optional.ofNullable(productsRepository.findBySku("FA-" + product.getSku()));
        if(productDto != null ){
            throw new ProductAlreadyExistsException("This product already exists ", product.getSku());
        }else {
            String newSku = "FA-" + product.getSku();
            product.setSku(newSku);
            productsRepository.save(product);
        }
    }
    @Override
    public List<ProductDto> listAllProducts(){
        return productsRepository.findAll(Sort.by("sku").ascending());
    }

    @Override
    public ProductDto listProduct(String sku){
        Optional<ProductDto> productOptional = Optional.ofNullable(productsRepository.findBySku(sku));

        if(productOptional.isEmpty()){
            throw new ProductDoesNotExistException("The product doesn't exist, sorry.");
        }
        return productOptional.get();

    }

    @Override
    public ProductDto updateProduct(ProductDto product){
        Optional<ProductDto> productOptional = Optional.ofNullable(productsRepository.findBySku(product.getSku()));
        if (productOptional.isEmpty()){
            throw new ProductDoesNotExistException("The product doesn't exist, sorry.");
        }else {
            return productsRepository.save(productOptional.get());


        }
    }
    @Override
    public void deleteProduct(String sku){
        Optional<ProductDto> productOptional = Optional.ofNullable(productsRepository.findBySku(sku));

        if(productOptional.isEmpty()){
            throw new ProductDoesNotExistException("Product doesn't exist, sorry.");
        }

        productsRepository.deleteById(Long.valueOf(sku));


    }

}
