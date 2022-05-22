package com.falabella.Dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String sku;
    private String productName;
    private String brand;
    private String size;
    private String price;
    private String principalImage;
   // private List<String> otherImages;


}
