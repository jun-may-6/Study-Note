package com.ohgiraffers.common;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Product> items;

    /* 기본적으로 생성자가 호출될 때 ArrayList 가 만들어질 수 있도록 함 */
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product item){
        this.items.add(item);
    }
    public List<Product> getItems(){
        return this.items;
    }
}
