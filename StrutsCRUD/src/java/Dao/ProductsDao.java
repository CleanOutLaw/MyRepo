/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Products;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author oussa
 */
public class ProductsDao implements IProductsDao {
    
    private EntityManagerFactory EMF;
    private EntityManager entityManager;
    private EntityTransaction transaction;
    
    public ProductsDao(){
        EMF = Persistence.createEntityManagerFactory("StrutsCRUDPU");
        entityManager = EMF.createEntityManager();
    }

    @Override
    public void deleteProduct(Integer code) {
        Products product = getProductById(code);
        if(product != null){
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(product);
            transaction.commit();
        }
        else{
            System.out.println("NO PRODUCT TO DELETE");
        }
    }

    @Override
    public List<Products> listOfProducts() {
        Query request = entityManager.createNamedQuery("Products.findAll");
        return request.getResultList();
    }

    @Override
    public Products getProductById(Integer code) {
        Products product;
        product = entityManager.find(Products.class,code);
        return product;
    }

    @Override
    public void saveProduct(Products product) {
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(product);
            transaction.commit();
            System.out.println("Added successfuly");
        }
        catch(Exception ex){
            System.out.println("ERROR : " + ex.getMessage());
        }
    }

    @Override
    public void updateProduct(Products product) {
        transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(product);
        transaction.commit();
    }
    
}
