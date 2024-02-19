package com.ohgiraffers.hw1.controller;

import com.ohgiraffers.hw1.comparator.AscBookNo;
import com.ohgiraffers.hw1.comparator.DescBookNo;
import com.ohgiraffers.hw1.comparator.DescBookTitle;
import com.ohgiraffers.hw1.model.dto.BookDTO;
import com.ohgiraffers.hw1.comparator.AscBookTitle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager {
    ArrayList <BookDTO> bookList;
    Scanner sc = new Scanner(System.in);

    public BookManager() {
        bookList = new ArrayList<>();
    }

    public void addBook(BookDTO book){
        this.bookList.add(book);
    }
    public void deleteBook(int bNo){
        int index = 0;                          //인덱스 변수 선언
        for(BookDTO book : bookList){
            if(bNo == book.getbNo()){           //bookList 에 입력받은 번호와 같은 책이 있을 경우
                index = bookList.indexOf(book); //인덱스를 저장
            }
        }
        this.bookList.remove(index);            //해당 인덱스의 책 제거
    }
    public void searchBook(String title){
        ArrayList <BookDTO> resultBook = new ArrayList<>();
        int count = 0;
        for (BookDTO book : this.bookList){
            if(book.getTitle().contains(title)){
                resultBook.add(book);
                count++;
            }
        }
        if (count == 0){
            System.out.println("조회된 도서가 목록에 없습니다.");
        } else {
            for(BookDTO book : resultBook){
                System.out.println(book);
            }
        }
    }
    public void displayAll(){
        for(BookDTO book : bookList){
            System.out.println(book);
        }
    }
    public List<BookDTO> sortedBookList(int type){
        switch (type){
            case (1): this.bookList.sort(new AscBookNo());break;
            case (2): this.bookList.sort(new DescBookNo());break;
            case (3): this.bookList.sort(new AscBookTitle());break;
            case (4): this.bookList.sort(new DescBookTitle());break;
        }
        return this.bookList;
    }
    public void printBookList(List<BookDTO> printList){
        for(BookDTO book : printList){
            System.out.println(book);
        }
    }
}
