package com.fixfor.webapp.interfaces;


import com.fixfor.webapp.domain.Seller;
import com.fixfor.webapp.domain.SellerService;
import com.fixfor.webapp.infrastructure.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@RestController
public class SellerController {


    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    ServletContext context;

//    @RequestMapping(path = "/findBydesignation", method = RequestMethod.GET)
//    public List<Seller> findBydesignation(@RequestParam("designation") String designation) {
//
//        return sellerService.findByDesignation(designation);
//
//    }

    @PostMapping("/selleruploadphoto/{id}")
    public void handelPhotoUoload(@RequestBody MultipartFile file, @PathVariable String id)  {
        try {
            Files.write(Paths.get(System.getProperty("user.home")+"/fixforImages/profiles/"+id+".jpg"), file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
    @PutMapping("/selleruploadphoto/{id}")
    public void handelPhotoUoloadUpdate(@RequestBody MultipartFile file, @PathVariable String id)  {
        try {
            Files.write(Paths.get(System.getProperty("user.home")+"/fixforImages/profiles/"+id+".jpg"), file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    @GetMapping(path = "/sellerPhoto/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getSellerPhoto(@PathVariable("id") String id) {
        Seller seller = sellerRepository.findById(id).get();
        try {
            return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"\\fixforImages\\profiles\\" +id+".jpg"));
        } catch (IOException e) {
             e.printStackTrace();
             return null;
        }

    }


    @DeleteMapping(path = { "sellers/{id}" })
    public void deleteSeller(@PathVariable("id") String id)  throws Exception {
        Seller seller = new Seller();
        seller = sellerRepository.findById(id).get();
//        if(!fooditem.isActive()) {
//            System.out.println("what is in foodItem");
//            System.out.println(!fooditem.isActive());
//         //   foodRepository.deleteById(id);
//        } else {
//            System.out.println(fooditem.isActive());
//            System.out.println(" Product is Active you c'ant delete it !!");
//        }

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
