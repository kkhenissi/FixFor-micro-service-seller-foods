package com.fixfor.webapp.interfaces;

import com.fixfor.webapp.domain.Fooditem;
import com.fixfor.webapp.domain.Seller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestController {

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public Fooditem test() {

        final Fooditem fooditem = new Fooditem();
        fooditem.setDesignation("firstname_toto");
        fooditem.setDescription("lastname_toto");
        fooditem.setImageUrl("26");
        fooditem.setSaledate(new Date("2020-03-20"));
        final Seller seller = new Seller();
        fooditem.setSeller(seller);

        return fooditem;

    }

}
