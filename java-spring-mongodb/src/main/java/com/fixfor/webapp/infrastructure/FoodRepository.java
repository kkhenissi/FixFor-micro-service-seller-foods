package com.fixfor.webapp.infrastructure;

import java.util.List;

import com.fixfor.webapp.domain.Fooditem;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface FoodRepository extends MongoRepository<Fooditem, String> {

    List<Fooditem> findBySellerId(@Param("sellerId") String sellerId);

    List<Fooditem> findByDesignation(@Param("designation") String designation);



}
