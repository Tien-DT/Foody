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
    private String ProductID;
    private String ProductName;
    private boolean ProductStatus;

    public Product() {
    }

    public Product(String ProductID, String ProductName, boolean ProductStatus) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.ProductStatus = ProductStatus;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public boolean isProductStatus() {
        return ProductStatus;
    }

    public void setProductStatus(boolean ProductStatus) {
        this.ProductStatus = ProductStatus;
    }
    
    
}
