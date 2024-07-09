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

    private int menuID;
    private int menuDate;
    private int userID;
    private String menuName;
    private boolean menuStatus;
    private String menuTag;
    private boolean menuRole;
    public Menu() {
    }

    public Menu(int menuID, int menuDate, int userID, String menuName, boolean menuStatus, String menuTag, boolean menuRole) {
        this.menuID = menuID;
        this.menuDate = menuDate;
        this.userID = userID;
        this.menuName = menuName;
        this.menuStatus = menuStatus;
        this.menuTag = menuTag;
        this.menuRole = menuRole;
    }

    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }


    public int getMenuDate() {
        return menuDate;
    }

    public void setMenuDate(int menuDate) {
        this.menuDate = menuDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public boolean isMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(boolean menuStatus) {
        this.menuStatus = menuStatus;
    }

    public String getMenuTag() {
        return menuTag;
    }

    public void setMenuTag(String menuTag) {
        this.menuTag = menuTag;
    }

    public boolean isMenuRole() {
        return menuRole;
    }

    public void setMenuRole(boolean menuRole) {
        this.menuRole = menuRole;
    }
    
}
