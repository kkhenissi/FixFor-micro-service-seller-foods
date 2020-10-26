package com.fixfor.webapp.infrastructure;

import java.util.List;

import com.fixfor.webapp.domain.Fooditem;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface FoodRepository extends MongoRepository<Fooditem, String> {

    List<Fooditem> findBySellerDesignation(@Param("sellerDesignation") String sellerDesignation);

    List<Fooditem> findByDesignation(@Param("designation") String designation);

}
