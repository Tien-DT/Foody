/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

public class Food {

    private String FoodID;
    private String FoodName;
    private Boolean FoodStatus;
    private String ProductID;
    private String FoodStep;
    private int FoodPrice;

    public Food() {

    }

    public Food(String FoodID, String FoodName, Boolean FoodStatus, String ProductID, String FoodStep, int FoodPrice) {
        this.FoodID = FoodID;
        this.FoodName = FoodName;
        this.FoodStatus = FoodStatus;
        this.ProductID = ProductID;
        this.FoodStep = FoodStep;
        this.FoodPrice = FoodPrice;
    }

    public String getFoodID() {
        return FoodID;
    }

    public void setFoodID(String FoodID) {
        this.FoodID = FoodID;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String FoodName) {
        this.FoodName = FoodName;
    }

    public Boolean getFoodStatus() {
        return FoodStatus;
    }

    public void setFoodStatus(Boolean FoodStatus) {
        this.FoodStatus = FoodStatus;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public String getFoodStep() {
        return FoodStep;
    }

    public void setFoodStep(String FoodStep) {
        this.FoodStep = FoodStep;
    }

    public int getFoodPrice() {
        return FoodPrice;
    }

    public void setFoodPrice(int FoodPrice) {
        this.FoodPrice = FoodPrice;
    }

}
