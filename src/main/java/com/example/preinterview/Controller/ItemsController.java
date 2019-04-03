/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.preinterview.Controller;


import com.example.preinterview.entity.menuItems;
import com.example.preinterview.repository.MenuRepo;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author robmoral
 */
@RestController
public class ItemsController {
    
    @Autowired
    private MenuRepo repo;
    
    @RequestMapping(value = {"/items", "/items/{category}"}, method = RequestMethod.GET)
    public List<menuItems> getItems(@PathVariable(name = "category", required=false) String category){
        if(category==null){
            return repo.findAll();
        }
        return repo.findAll().stream().filter(menuItems ->menuItems.getShort_name().startsWith(category)).collect(Collectors.toList());
    }
 
    

}
