package com.fixfor.webapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Document(collection = "sellers")
@Data @AllArgsConstructor @NoArgsConstructor
public class Seller {
    @Id
    private String id;
    private String designation;
    private String email;
    private String password;
    private double latitude;
    private double longitude;
    @DBRef
    private List<Fooditem> fooditems=new ArrayList<>();
    private String adhesionDate;

}
