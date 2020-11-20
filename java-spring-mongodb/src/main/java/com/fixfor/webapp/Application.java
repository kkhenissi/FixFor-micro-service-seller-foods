package com.fixfor.webapp;

import com.fixfor.webapp.domain.Fooditem;
import com.fixfor.webapp.domain.Seller;
import com.fixfor.webapp.infrastructure.FoodRepository;
import com.fixfor.webapp.infrastructure.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.stream.Stream;

@SpringBootApplication
@EnableMongoRepositories
public class Application {
     @Autowired
	 private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
  @Bean
	CommandLineRunner start(SellerRepository sellerRepository, FoodRepository foodRepository) {
	return args -> {
    /*   sellerRepository.deleteAll();

		Stream.of("Gyross", "Merzak", "Obun's").forEach(s -> {
			sellerRepository.save(new Seller(null,s,125.235,356.256, new ArrayList<Fooditem>(),null));
		});*/
/*		sellerRepository.save(new Seller(null,"Gyross", null,null , 120.1225,120.1225,null,null));
		sellerRepository.save(new Seller(null,"Obuns", null,null , 120.1225,120.1225,null,null));
		sellerRepository.save(new Seller(null,"Merzak", null,null , 120.1225,120.1225,null,null));
		sellerRepository.save(new Seller(null,"Obuns", null,null , 120.1225,120.1225,null,null));*/

	//	sellerRepository.findAll().forEach(System.out::println);
/*		Stream.of("p1", "p2", "p3", "p4").forEach(designation -> {
			Seller s1 = sellerRepository.findById("5fb1bace86268e3818db6cfc").get();
//			System.out.println("sssssssssssssssssss");
//			System.out.println(s1);
//			System.out.println(s1.getFooditems());
		  Fooditem fooditem =	foodRepository.save((new Fooditem(null,designation, designation, null,null,0,true,null,s1)));
		 s1.getFooditems().add(fooditem);
		 sellerRepository.save(s1);
		 System.out.println("kkkkkkkkkkkkkkkkkkkk");
		//	System.out.println(s1.getFooditems());
		});

		Stream.of("p5", "p6", "p7", "p8").forEach(designation -> {
			Seller s2 = sellerRepository.findById("5fb1bace86268e3818db6cfd").get();
			Fooditem fooditem =	foodRepository.save((new Fooditem(null,designation,designation, null,null,0,true,null, s2)));
			s2.getFooditems().add(fooditem);
			sellerRepository.save(s2);
		});

		Stream.of("p10", "p11", "p12", "p13").forEach(designation -> {
			Seller s3 = sellerRepository.findById("5fb1bace86268e3818db6cfe").get();
			Fooditem fooditem =		foodRepository.save((new Fooditem(null,designation,designation, null,null,0,true,null,s3)));
			s3.getFooditems().add(fooditem);
			sellerRepository.save(s3);
		});

		foodRepository.findAll().forEach(fd -> {
			System.out.println(fd.toString());
		});
		sellerRepository.findAll().forEach(sl->{
			System.out.println(sl.toString());
		});*/
	};
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		this.repositoryRestConfiguration.exposeIdsFor(Fooditem.class);
		this.repositoryRestConfiguration.exposeIdsFor(Seller.class);
		System.out.println("55555555555555555555555555555555555555555555555555555555");
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:8086");
				registry.addMapping("/**").allowedOrigins("http://localhost:4200")
						.allowedOrigins(CrossOrigin.DEFAULT_ORIGINS)
						.allowedHeaders(CrossOrigin.DEFAULT_ALLOWED_HEADERS)
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
						.maxAge(3600L);

			}
		};
	}
}


