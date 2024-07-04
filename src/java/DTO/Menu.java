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
public class Menu {
    private String menuID;
    private String foodID;
    private String menuDate;
    private String userID;

    public Menu() {
    }

    public Menu(String menuID, String foodID, String menuDate, String userID) {
        this.menuID = menuID;
        this.foodID = foodID;
        this.menuDate = menuDate;
        this.userID = userID;
    }

    public String getmenuID() {
        return menuID;
    }

    public void setmenuID(String menuID) {
        this.menuID = menuID;
    }

    public String getfoodID() {
        return foodID;
    }

    public void setfoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getmenuDate() {
        return menuDate;
    }

    public void setmenuDate(String menuDate) {
        this.menuDate = menuDate;
    }

    public String getuserID() {
        return userID;
    }

    public void setuserID(String userID) {
        this.userID = userID;
    }
    
    
}
