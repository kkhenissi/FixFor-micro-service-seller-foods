package com.fixfor.webapp.interfaces;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import com.fixfor.webapp.domain.Fooditem;
import com.fixfor.webapp.domain.FoodService;
import com.fixfor.webapp.infrastructure.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletContext;


@RestController
public class FoodController {

    @Autowired
    private FoodService foodService;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    ServletContext context;

    @RequestMapping(path = "/findBydesignationAndSellerDesignation", method = RequestMethod.GET)
    public List<Fooditem> findBydesignationAndSellerDesignation(@RequestParam("designation") String designation,
                                                                @RequestParam("sellerDesignation") String sellerDesignation) {

        return foodService.findByDesignationAndSellerDesignation(designation, sellerDesignation);

    }

    @RequestMapping(path = "/findByDesignation", method = RequestMethod.GET)
    public List<Fooditem> findByDesignation(@RequestParam("designation") String designation) {

        return foodRepository.findByDesignation(designation);

    }
    @PostMapping("/fooduploadphoto/{id}")
    public void handelPhotoUoload(@RequestBody MultipartFile file, @PathVariable String id)  {
        try {
            Files.write(Paths.get(System.getProperty("user.home")+"/fixforImages/foods/"+id+".jpg"), file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
    @PutMapping("/fooduploadphoto/{id}")
    public void handelPhotoUoloadUpdate(@RequestBody MultipartFile file, @PathVariable String id)  {
        try {
            Files.write(Paths.get(System.getProperty("user.home")+"/fixforImages/foods/"+id+".jpg"), file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    @GetMapping(path = "/foodPhoto/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getFoodPhoto(@PathVariable("id") String id) {
        Fooditem foodItem = foodRepository.findById(id).get();
        try {
            return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"\\fixforImages\\foods\\" +id+".jpg"));
        } catch (IOException e) {
             e.printStackTrace();
             return null;
        }

    }


    @DeleteMapping(path = { "foodproducts/{id}" })
    public void deleteFoodItem(@PathVariable("id") String id)  throws Exception {
        Fooditem fooditem = new Fooditem();
        fooditem = foodRepository.findById(id).get();
        if(!fooditem.isActive()) {
            System.out.println("what is in foodItem");
            System.out.println(!fooditem.isActive());
         //   foodRepository.deleteById(id);
        } else {
            System.out.println(fooditem.isActive());
            System.out.println(" Product is Active you c'ant delete it !!");
        }

    }

}
