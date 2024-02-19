package com.ohgiraffers.test.view;

import com.ohgiraffers.test.controller.BookManager;
import com.ohgiraffers.test.model.dto.BookDTO;

import java.util.Scanner;

public class BookMenu {
    Scanner sc = new Scanner(System.in);
    public BookMenu() {}
    public void menu(){
        BookManager bm = new BookManager();
        while (true){
            System.out.println("1. 도서 추가");
            System.out.println("2. 도서 삭제 (번호)");
            System.out.println("3. 도서 목록");
            System.out.println("4. 도서 검색 (제목)");
            System.out.println("5. 도서 정렬 (장르)");
            System.out.println("6. 도서 출력 (번호)");
            int select = sc.nextInt();
            switch (select){
                case (1):
                    bm.addBook(inputBook());break;
                case (2):
                    System.out.println("삭제하실 책 번호를 입력해주세요.");
                    int delBNo = sc.nextInt();
                    bm.deleteBook(delBNo);break;
                case (3):
                    bm.printBookList(bm.getBooks());break;
                case (4):
                    sc.nextLine();
                    System.out.println(bm.searchBook(inputBookTitle()) + "권의 책이 검색되었습니다.");break;
                case (5):
                    System.out.println("1. 오름차순  2. 내림차순");
                    int how = sc.nextInt();
                    bm.sortedBook(how);break;
                case (6):
                    System.out.println("도서 번호를 입력해주세요.");
                    int bookNo = sc.nextInt();
                    bm.printBook(bookNo);break;
            }
        }

    }
    public BookDTO inputBook(){
        System.out.println("도서 번호를 입력해주세요");
        int bNo = sc.nextInt();

        sc.nextLine();
        System.out.println("제목을 입력해주세요.");
        String bookTitle = sc.nextLine();

        System.out.println("저자를 입력해주세요");
        String author = sc.nextLine();

        System.out.println("장르를 입력해주세요.");
        System.out.println("[1. 인문] [2. 자연과학] [3. 의료] [4. 기타]");
        int category = sc.nextInt();

        BookDTO newBook = new BookDTO(bNo, category, bookTitle, author);

        return newBook;
    }
    public String inputBookTitle(){
        System.out.println("검색하실 책 제목을 입력해주세요.");
        String title = sc.nextLine();
        return title;
    }
}
