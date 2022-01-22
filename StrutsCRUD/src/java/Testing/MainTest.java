/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import Dao.ProductsDao;
import Entities.Products;
import java.util.List;

/**
 *
 * @author oussa
 */
public class MainTest {
    
    public static void main(String args[]){
        
        ProductsDao dao = new ProductsDao();
        List<Products> products = dao.listOfProducts();
        
        for(Products product : products){
            System.out.println("Code : " + product.getCode());
            System.out.println("Designation : " + product.getDesignation());
            System.out.println("Prix " + product.getPrice());
            System.out.println("#########");
        }
    }
}
