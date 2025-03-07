package com.management.category.model.dto;

public class CategoryDTO implements java.io.Serializable{

    private String categoryCode;
    private String categoryName;

    public CategoryDTO() {}

    public CategoryDTO(String categoryCode, String categoryName) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "카테고리 코드 : " + categoryCode +
                " 카테고리 이름 : " + categoryName;
    }

}
