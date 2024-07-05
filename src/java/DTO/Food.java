/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

public class Food {

    private int foodID;
    private String foodName;
    private Boolean foodStatus;
    private int productID;
    private String foodStep;
    private int foodPrice;
    private String foodImage;

    public Food() {
    }

    public Food(int foodID, String foodName, Boolean foodStatus, int productID, String foodStep, int foodPrice, String foodImage) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.foodStatus = foodStatus;
        this.productID = productID;
        this.foodStep = foodStep;
        this.foodPrice = foodPrice;
        this.foodImage = foodImage;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Boolean getFoodStatus() {
        return foodStatus;
    }

    public void setFoodStatus(Boolean foodStatus) {
        this.foodStatus = foodStatus;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getFoodStep() {
        return foodStep;
    }

    public void setFoodStep(String foodStep) {
        this.foodStep = foodStep;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }
}
