package com.falabella.Service;

import com.falabella.Dto.ProductDto;

import java.util.List;

public interface ProductsService {


    public void createProduct(ProductDto product);

    public List<ProductDto> listAllProducts();

    public ProductDto listProduct(String sku);

    public ProductDto updateProduct(ProductDto product);

    public void deleteProduct(String sku);

}
