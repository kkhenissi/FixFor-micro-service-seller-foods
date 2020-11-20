package com.fixfor.webapp.domain;

import java.util.List;


public interface FoodService {

    List<Fooditem> findByDesignationAndSellerDesignation(String designation, String sellerDesignation);



}
