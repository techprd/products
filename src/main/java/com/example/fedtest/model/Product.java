package com.example.fedtest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Product Data Object
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    Integer index;
    boolean isSale;
    String price;
    String productImage;
    String productName;
    String type;
}
