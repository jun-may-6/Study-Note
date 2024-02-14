package com.hw1.model.dto;

public class CookBook extends Book{
    private boolean coupon;

    /* constructor*/

    public CookBook() {
    }
    public CookBook(String title, String author, String publisher, boolean coupon) {
        super(title, author, publisher);
        this.coupon = coupon;
    }

    @Override
    public String toString() {
        return super.toString() + ", 쿠폰 유무 : " + coupon;
    }

    /* setter/getter */

    public void setCoupon(boolean coupon) {
        this.coupon = coupon;
    }
    public boolean isCoupon() {
        return coupon;
    }

}
