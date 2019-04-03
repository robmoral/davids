package com.example;

import com.example.preinterview.entity.menuItems;
import com.example.preinterview.repository.MenuRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.*;
import org.springframework.boot.CommandLineRunner;
import com.example.preinterview.entity.MenuList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PreinterviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(PreinterviewApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner run(MenuRepo repo, RestTemplate restTemplate) throws Exception {
        return new CommandLineRunner() {
            @Override
            public void run(String[] args) throws Exception {
                // read json and write to db
                //ObjectMapper mapper = new ObjectMapper();
                HttpHeaders headers = new HttpHeaders();
                headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
                HttpEntity<MenuList> entity = new HttpEntity<>(headers);
                MenuList list = restTemplate.exchange("https://davids-restaurant.herokuapp.com/menu_items.json", HttpMethod.GET, entity, MenuList.class).getBody();
                for (menuItems m : list.getMenu_items()) {
                    repo.save(m);
                }
            }
        };
    }

}
