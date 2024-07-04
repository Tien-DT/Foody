/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author USER
 */
public class Product {
    private String productID;
    private String productName;
    private boolean productStatus;
    private int productPrice;
    public Product() {
    }

    public Product(String productID, String productName, boolean productStatus) {
        this.productID = productID;
        this.productName = productName;
        this.productStatus = productStatus;
        this.productPrice = productPrice;
    }

    public String getproductID() {
        return productID;
    }

    public void setproductID(String productID) {
        this.productID = productID;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
    
    public String getproductName() {
        return productName;
    }

    public void setproductName(String productName) {
        this.productName = productName;
    }

    public boolean isproductStatus() {
        return productStatus;
    }

    public void setproductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }
    
    
}
