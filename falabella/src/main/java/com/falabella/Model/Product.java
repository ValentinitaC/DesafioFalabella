package com.falabella.Model;

import lombok.*;
import javax.persistence.*;
import java.net.URL;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sku", unique = true, nullable = false)
    private String sku;
    @Column(name = "name", nullable = false, length = 50)
    private String productName;
    @Column(name = "brand", nullable = false, length = 50)
    private String brand;
    @Column(name = "size")
    private String size;
    @Column(name = "price", nullable = false)
    private String price;
    @Column(name = "image", nullable = false)
    private String principalImage;
   // @Column
   // private List<URL> otherImages;


}
