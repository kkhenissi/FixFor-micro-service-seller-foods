package com.fixfor.webapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document(collection = "fooditems")
@Data @AllArgsConstructor @NoArgsConstructor
public class Fooditem {

    @Id
    private String id;

    private String designation;
    private String description;
    private byte[] photo;
    private String imageUrl;
    private double price;
    private boolean active;
    private Date saledate;
    @DBRef
    private Seller seller;


}
