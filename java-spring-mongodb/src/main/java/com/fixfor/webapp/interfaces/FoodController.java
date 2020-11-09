package com.fixfor.webapp.interfaces;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.List;
import org.apache.commons.io.FileUtils;

import ch.qos.logback.core.util.FileUtil;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fixfor.webapp.domain.Fooditem;
import com.fixfor.webapp.domain.FoodService;

import com.fixfor.webapp.infrastructure.FoodRepository;

import org.apache.catalina.connector.Response;

import org.apache.commons.io.FilenameUtils;

import org.bson.json.JsonParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
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
/*    @PostMapping("/foodItems")
    public ResponseEntity<Response> addFoodItem(@RequestParam("file") MultipartFile file,
                                                @RequestParam("item") String item) throws JsonParseException, JsonMappingException, Exception {


        System.out.println("Ok ...................");
        Fooditem fooditem = new ObjectMapper().readValue(item, Fooditem.class);
        boolean isExist = new File(context.getRealPath("Images/")).exists();
        if(!isExist) {
            new File (context.getRealPath("/Images/")).mkdir();
            System.out.println("mkdir .....................");
        }
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File(context.getRealPath("/Images"+File.separator+newFileName));
        try {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile, file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        fooditem.setImageUrl(filename);
        Fooditem fooditem1 = foodRepository.save(fooditem);
        if(fooditem1 != null) {
            return new ResponseEntity<Response>(new Response(), HttpStatus.MULTI_STATUS.OK);
        } else {
            return new ResponseEntity<Response>(new Response(), HttpStatus.MULTI_STATUS.BAD_REQUEST);
        }
    }*/

}
