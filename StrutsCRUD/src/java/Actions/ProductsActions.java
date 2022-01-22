/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Dao.ProductsDao;
import Entities.Products;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

/**
 *
 * @author oussa
 */
public class ProductsActions extends ActionSupport {

    public ProductsDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductsDao productDao) {
        this.productDao = productDao;
    }

    public List<Products> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(List<Products> allProducts) {
        this.allProducts = allProducts;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Products getMyProduct() {
        return myProduct;
    }

    public void setMyProduct(Products myProduct) {
        this.myProduct = myProduct;
    }
    
    private ProductsDao productDao = new ProductsDao();
    private Products myProduct = new Products();
    private List<Products> allProducts = new ArrayList<Products>();
    private Integer code;
    private String designation;
    private float price;
    
    public String AllProducts(){
        allProducts = productDao.listOfProducts();
        return SUCCESS;
    }
    
    public String SaveProduct(){
        Products product = new Products(code,designation,price);
        productDao.saveProduct(product);
        return SUCCESS;
    }
    
    public String deleteProduct(){
        HttpServletRequest request;
        request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        productDao.deleteProduct(Integer.parseInt(request.getParameter("code")));
        return SUCCESS;
    }
    
    public String editProduct(){
        HttpServletRequest request;
        request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        myProduct = productDao.getProductById(Integer.parseInt(request.getParameter("code")));
        return SUCCESS;
    }
    
    public String saveEditProduct(){
        Products product = productDao.getProductById(code);
        product.setDesignation(designation);
        product.setPrice(price);
        productDao.updateProduct(product);
        return SUCCESS;
    }
    
}
