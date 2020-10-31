package com.fixfor.webapp.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document(collection = "fooditems")
@Data
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
    private Seller seller;


}
