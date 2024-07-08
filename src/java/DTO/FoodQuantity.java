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
public class FoodQuantity {

    Food food;
    int foodQuantity;

    public FoodQuantity() {
    }

    public FoodQuantity(Food food, int foodQuantity) {
        this.food = food;
        this.foodQuantity = foodQuantity;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

}
