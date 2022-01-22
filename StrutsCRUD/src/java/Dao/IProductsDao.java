/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Products;
import java.util.*;

/**
 *
 * @author oussa
 */
public interface IProductsDao {
    
    public void saveProduct(Products product);
    public void updateProduct(Products product);
    public void deleteProduct(Integer code);
    public List<Products> listOfProducts();
    public Products getProductById(Integer code);
}
