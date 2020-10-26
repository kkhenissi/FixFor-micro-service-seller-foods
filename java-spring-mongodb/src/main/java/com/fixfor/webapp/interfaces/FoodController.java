package com.fixfor.webapp.interfaces;

import java.util.List;

import com.fixfor.webapp.domain.Fooditem;
import com.fixfor.webapp.domain.FoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FoodController {

    @Autowired
    private FoodService foodService;

    @RequestMapping(path = "/findBydesignationAndSellerDesignation", method = RequestMethod.GET)
    public List<Fooditem> findBydesignationAndSellerDesignation(@RequestParam("designation") String designation,
                                                                @RequestParam("sellerDesignation") String sellerDesignation) {

        return foodService.findByDesignationAndSellerDesignation(designation, sellerDesignation);

    }

}
