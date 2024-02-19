package com.ohgiraffers.test.model.dto;

public class BookDTO {
    private int bNo;
    private int category;
    private String title;
    private String author;

    public BookDTO() {
    }

    public BookDTO(int bNo, int category, String title, String author) {
        this.bNo = bNo;
        this.category = category;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        String categoryString = "";
        switch (category){
            case (1):categoryString = "인문"; break;
            case (2):categoryString = "자연과학"; break;
            case (3):categoryString = "의료"; break;
            case (4):categoryString = "기타"; break;
            default:categoryString = "알 수 없음";break;
        }
        return "[No. "  + bNo +
                "] [제목 : " + title +
                "] [저자 : " + author +
                "] [장르 " + categoryString +
                "]";
    }

    public void setbNo(int bNo){
        this.bNo = bNo;
    }
    public void setCategory(int category){
        this.category = category;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public int getbNo() {
        return bNo;
    }
    public int getCategory() {
        return category;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
}
