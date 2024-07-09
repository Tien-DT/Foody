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
public class MenuDetail {

    private int menuID;
    private String menuName;
    private int menuDay;
    private String foodName;


    public MenuDetail() {
    }

    public MenuDetail(int menuID, String menuName, int menuDay, String foodName) {
        this.menuID = menuID;
        this.menuName = menuName;
        this.menuDay = menuDay;
        this.foodName = foodName;
    }

    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }


    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getMenuDay() {
        return menuDay;
    }

    public void setMenuDay(int menuDay) {
        this.menuDay = menuDay;
    }

}
