/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

public class Food {

    private String foodID;
    private String foodName;
    private Boolean foodStatus;
    private String productID;
    private String foodStep;
    private int foodPrice;
    private String foodImage;

    public Food() {

    }

    public Food(String foodID, String foodName, Boolean foodStatus, String productID, String foodStep, int foodPrice, String foodImage) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.foodStatus = foodStatus;
        this.productID = productID;
        this.foodStep = foodStep;
        this.foodPrice = foodPrice;
        this.foodImage = foodImage;
    }

    public String getfoodID() {
        return foodID;
    }

    public void setfoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getfoodName() {
        return foodName;
    }

    public String getfoodImage() {
        return foodImage;
    }

    public void setfoodImage(String foodImage) {
        this.foodImage = foodImage;
    }
    
    public void setfoodName(String foodName) {
        this.foodName = foodName;
    }

    public Boolean getfoodStatus() {
        return foodStatus;
    }

    public void setfoodStatus(Boolean foodStatus) {
        this.foodStatus = foodStatus;
    }

    public String getproductID() {
        return productID;
    }

    public void setproductID(String productID) {
        this.productID = productID;
    }

    public String getfoodStep() {
        return foodStep;
    }

    public void setfoodStep(String foodStep) {
        this.foodStep = foodStep;
    }

    public int getfoodPrice() {
        return foodPrice;
    }

    public void setfoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

}
