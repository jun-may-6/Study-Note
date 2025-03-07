package com.hw1.model.dto;

public class AniBook extends Book{
    private int accessAge;

    /* constructor */

    public AniBook() {
    }
    public AniBook(String title, String author, String publisher, int accessAge) {
        super(title, author, publisher);
        this.accessAge = accessAge;
    }
    /* setter/getter */

    public int getAccessAge() {
        return accessAge;
    }

    public void setAccessAge(int accessAge) {
        this.accessAge = accessAge;
    }
}
