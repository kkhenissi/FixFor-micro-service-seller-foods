package com.fixfor.webapp.domain;

import java.util.List;
import java.util.Optional;

public interface FoodService {

    List<Fooditem> findByDesignationAndSellerDesignation(String designation, String sellerDesignation);



}
