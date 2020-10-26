package com.fixfor.webapp.infrastructure;

import java.util.ArrayList;
import java.util.List;

import com.fixfor.webapp.domain.Fooditem;
import com.fixfor.webapp.domain.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public List<Fooditem> findByDesignationAndSellerDesignation(String designation, String sellerDesignation) {

        List<Fooditem> fooditems = new ArrayList<>();

        Query searchQuery = new Query();
        searchQuery.addCriteria(Criteria.where("designation").is(designation).and("seller.designation").is(sellerDesignation));
        fooditems = mongoOperations.find(searchQuery, Fooditem.class);

        return fooditems;

    }

}
