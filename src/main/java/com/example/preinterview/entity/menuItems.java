/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.preinterview.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author robmoral
 */
@Entity
public class menuItems implements Serializable{
    
    @Id
    private Long   id;        
    private String  short_name;
    private String  name;
    private String  description;
    private String  price_small;
    private String  price_large;
    private String  small_portion_name;
    private String  large_portion_name;

    public menuItems() {
    }

    public menuItems(Long id, String short_name, String name, String description, String price_small, String price_large, String small_portion_name, String large_portion_name) {
        this.id = id;
        this.short_name = short_name;
        this.name = name;
        this.description = description;
        this.price_small = price_small;
        this.price_large = price_large;
        this.small_portion_name = small_portion_name;
        this.large_portion_name = large_portion_name;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice_small() {
        return price_small;
    }

    public void setPrice_small(String price_small) {
        this.price_small = price_small;
    }

    public String getPrice_large() {
        return price_large;
    }

    public void setPrice_large(String price_large) {
        this.price_large = price_large;
    }

    public String getSmall_portion_name() {
        return small_portion_name;
    }

    public void setSmall_portion_name(String small_portion_name) {
        this.small_portion_name = small_portion_name;
    }

    public String getLarge_portion_name() {
        return large_portion_name;
    }

    public void setLarge_portion_name(String large_portion_name) {
        this.large_portion_name = large_portion_name;
    }
    

  
    
}
