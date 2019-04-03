/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.preinterview.repository;

import com.example.preinterview.entity.menuItems;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author robmoral
 */
    
public interface MenuRepo extends JpaRepository<menuItems, Long>  {
        List<menuItems> findByName(String name);
}
