package com.ohgiraffers.test.controller;

import com.ohgiraffers.test.model.comparator.AscCategory;
import com.ohgiraffers.test.model.comparator.DescCategory;
import com.ohgiraffers.test.model.dto.BookDTO;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BookManager {
    ArrayList<BookDTO> books;
    public BookManager() {
        books = new ArrayList<>();
    }
    public void addBook(BookDTO book){
        this.books.add(book);
    }
    public void deleteBook(int bNo){
        for(BookDTO book : books){
            if (book.getbNo() == bNo){
                int index = books.indexOf(book);
                books.remove(index);
                System.out.println(bNo + "번 도서가 삭제되었습니다.");
                return;
            }
        }
        System.out.println("일치하는 번호의 도서가 없습니다.");
    }
    public int searchBook(String title){
        int count = 0;
        for(BookDTO book : books){
            if(book.getTitle().contains(title)){
                System.out.println(book);
                count++;
            }
        }
        return count;
    }
    public void printBook(int bNo){
        for(BookDTO book : books){
            if(book.getbNo() == bNo){
                System.out.println(book);
            }
        }
    }
    public ArrayList<BookDTO> sortedBook(int select){
        if(select == 1){
            books.sort(new AscCategory());
        } else if(select == 2){
            books.sort(new DescCategory());
        }
        return books;
    }
    public void printBookList(ArrayList<BookDTO> br){
        for(BookDTO book : br){
            System.out.println(book);
        }
    }
    public ArrayList<BookDTO> getBooks(){
        return books;
    }

}
