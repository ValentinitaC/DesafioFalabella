package com.falabella.Repository;


import com.falabella.Dto.ProductDto;
import com.falabella.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductsRepository extends JpaRepository<ProductDto, Long> {

    public ProductDto findBySku(String sku);


}
