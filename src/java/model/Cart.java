/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class Cart {
    private Map<String, Pizza> lists;

    public Cart() {
    }
    

    public Cart(Map<String, Pizza> lists) {
        this.lists = lists;
    }

    public Map<String, Pizza> getLists() {
        return lists;
    }

    public void setLists(Map<String, Pizza> lists) {
        this.lists = lists;
    }

    public boolean add(Pizza pizza) {
        boolean check = false;
        
        try {
            if(this.lists == null) {
                lists = new HashMap<>();
            }
            if(this.lists.containsKey(pizza.getProductID())) {
            int crQuantity = this.lists.get(pizza.getProductID()).getQuantity();
            pizza.setQuantity(pizza.getQuantity() + crQuantity);
            } 
            this.lists.put(pizza.getProductID(), pizza);
        check = true;
        } catch(Exception e) {
            e.printStackTrace();
        } 
        return check;
    }
    
    public boolean edit(String pizzaID, int quantity) {
        boolean check = false;
        if(this.lists != null) {
            if(lists.containsKey(pizzaID)) {
                Pizza pizza = lists.get(pizzaID);
                pizza.setQuantity(quantity);
                lists.replace(pizzaID, pizza);
                check = true;
            }
        }   
        return check;
    }
    
    public boolean remove(String pizzaID) {
        boolean check = false;
        
        if(this.lists != null) {
            if(this.lists.containsKey(pizzaID)) {
                lists.remove(pizzaID);
                check = true;
            }
        }
        
        return check;
    }
    
    public double getTotalPrice() {
        double total = 0;
        for(Pizza pizz : this.lists.values()) {
            total += pizz.getPrice() * pizz.getQuantity();
        }
        return total;
    }
    
    public int getTotalQuantity() {
        int quantity = 0;
        for(Pizza pizz : this.lists.values()) {
            quantity += pizz.getQuantity();
        }
        return quantity;
    }
}
