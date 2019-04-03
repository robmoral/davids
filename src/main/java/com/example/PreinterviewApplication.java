package com.example;

import aj.org.objectweb.asm.TypeReference;
import com.example.preinterview.entity.menuItems;
import com.example.preinterview.repository.MenuRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import org.springframework.boot.CommandLineRunner;
import com.example.preinterview.entity.MenuList;
import java.io.FileInputStream;
import java.net.URL;

@SpringBootApplication
public class PreinterviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreinterviewApplication.class, args);
	}
        
       
      	@Bean
        public CommandLineRunner run(MenuRepo repo) throws Exception {
            return new CommandLineRunner() {
                @Override
                public void run(String[] args) throws Exception {
                    // read json and write to db
                    ObjectMapper mapper = new ObjectMapper();
                    URL url = new URL("https://davids-restaurant.herokuapp.com/menu_items.json");
                    MenuList list = mapper.readValue(url.openStream(), MenuList.class);
                    for (Iterator<menuItems> it = list.getMenu_items().iterator();
                            it.hasNext();) {
                        menuItems m = it.next();
                        repo.save(m);                
                    }
                }
            };	        
        }
        
}