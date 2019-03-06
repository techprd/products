package com.example.fedtest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Product Data Object
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    Integer index;
    @JsonProperty("isSale")
    boolean isSale;
    String price;
    String productImage;
    String productName;
    String type;
}
