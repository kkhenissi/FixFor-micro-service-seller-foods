package com.fixfor.webapp.infrastructure;

import com.fixfor.webapp.domain.Fooditem;
import com.fixfor.webapp.domain.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface SellerRepository extends MongoRepository<Seller, String> {

    List<Seller> findByDesignation(@Param("Designation") String Designation);


}
