package com.ohgiraffers.model.dto;

public class MenuDTO implements java.io.Serializable{
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderAbleStatus;

    public MenuDTO() {
    }
    public MenuDTO(String menuName, int menuPrice, int categoryCode, String orderAble, int menuCode) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderAbleStatus = orderAble;
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrderAble() {
        return orderAbleStatus;
    }

    public void setOrderAbleStatus(String orderAble) {
        this.orderAbleStatus = orderAble;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }
}
