package com.ohgiraffers.section01.object.book;

public class Book {

    private int number;
    private String title;
    private String author;
    private int price;

    //========================      생성자
    public Book() {
    } //기본생성자

    public Book(int number, String title, String author, int price) {       //필드 초기화
        this.number = number;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    /*toString() 오버라이딩*/
    @Override
    public String toString() {
        return "BookVO [number=" + this.number
                + ", title=" + title
                + ", author=" + author
                + ", price=" + price
                + "]";
    }
    /* equals() 오버라이딩*/

    @Override
    public boolean equals(Object obj) {
        if(this == obj){        //해시코드가 같을 경우 true 반환
            return true;
        }
        if(obj == null){        //this 는 null 값일 수 없지만 obj 가 null 일 경우 false 를 반환
            return false;
        }
        Book other = (Book)obj; //obj 를 Book 으로 형변환 하여 필드별로 비교할 수 있게 만듬
        if(this.number != other.number){
            return false;
        }
        if(this.title == null){     //만약 타이틀이 null 이면서 비교하는 타이틀은 null 이 아닐 경우 false 반환
            if(other.title !=null){
                return false;
            }
        } else if (!this.title.equals(other.title)){        //타이틀 필드가 null 이 아닐 경우 두 타이틀을 비교한 불린의 반댓값 (같다면 false 다르다면 true 반환)
            return false;       /*equals 를 오버라이딩 하는 중에 사용하는 equals 는 기본 기능대로 작동한다.
            문자열을 비교하는 equals() 메소드는 String 클래스가 equals() 메소드를 오버라이딩해서 문자열의 내용이 같은지 재정의 된 메소드이다.*/
        }
        if(this.author == null){
            if(other.author != null){
                return false;
            }
        } else if(!this.author.equals(other.author)){
            return false;
        }
        if(this.price != other.price){
            return false;
        }
        return true; // 모든 조건을 통과했을 경우 두 인스턴스의 모든 필드는 같은 값을 가지므로 true 반환
    }


    /*hashCode 오버라이딩*/

    @Override
    public int hashCode() {
        int result = 1;
        /*필드마다 곱해줄 소수값 선언
        * 31은 소수이기 때문에 연산 시 동일한 hashCode 값이 나오지 않을 확률을 증가시킨다.
        * 31이 통상적인 관례이며 String 클래스의 hashCode 에서도 사용한 값이다.*/
        final int PRIME = 31;
        /*31과 필드값을 이용하여 새로운 hashCode 를 연산한다.
        * 여기서 포인트는 필드값이 같은 경우 동일한 hashCode 를 반환하면 된다.*/
        result = PRIME * result + this.number;
        result = PRIME * result + this.title.hashCode();
        /*String 클래스의 hasoCode 메소드는 같은 값을 가지는 문자열에
        동일한 hashCode 값을 반환한다.*/
        result = PRIME * result + this.author.hashCode();
        result = PRIME * result + this.price;
        return result;
    }
}
