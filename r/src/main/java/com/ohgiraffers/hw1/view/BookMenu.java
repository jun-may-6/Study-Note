package com.ohgiraffers.hw1.view;

import com.ohgiraffers.hw1.controller.BookManager;
import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.List;
import java.util.Scanner;

public class BookMenu {
    Scanner sc = new Scanner(System.in);
    BookManager bm = new BookManager();

    public BookMenu() {}

    public void mainMenu(){
        while (true){
            System.out.println("1. 새 도서 추가");
            System.out.println("2. 도서 정보 정렬 후 출력");
            System.out.println("3. 도서 삭제");
            System.out.println("4. 도서 검색출력");
            System.out.println("5. 전체 출력");
            System.out.println("6. 끝내기");

            int choose = sc.nextInt();
            switch (choose){
                case(1):bm.addBook(inputBook());break;
                case(2):bm.printBookList(selectSortedBook());break;
                case(3):bm.deleteBook(inputBookNo());break;
                case(4):bm.searchBook(inputBookTitle());break;
                case(5):bm.displayAll();break;
                case(6):return;
                default:
                    System.out.println("잘못된 값을 입력하셨습니다.");break;
            }
        }
    }
    public BookDTO inputBook(){
        System.out.println("도서의 번호를 입력해주세요.");
        int bNo = sc.nextInt();
        sc.nextLine();

        System.out.println("도서의 제목을 입력해주세요.");
        String bookTitle = sc.nextLine();

        System.out.println("도서의 장르를 입력해주세요.");
        System.out.println("[1. 인문] [2. 자연과학] [3. 의료] [4. 기타]");
        int bookCategory = sc.nextInt();

        sc.nextLine();

        System.out.println("도서의 저자를 입력해주세요.");
        String bookAuthor = sc.nextLine();


        return new BookDTO(bookCategory, bookTitle, bookAuthor, bNo);
    }
    public int inputBookNo(){
        System.out.println("도서의 번호를 입력해주세요.");
        int bookNo = sc.nextInt();
        return bookNo;
    }
    public String inputBookTitle(){
        System.out.println("도서의 제목을 입력해주세요.");
        sc.nextLine();
        String bookTitle = sc.nextLine();
        return bookTitle;
    }
    public List <BookDTO> selectSortedBook(){
        System.out.println("도서 정렬 방식을 입력해주세요.");
        System.out.println("[1. 도서번호 오름차순]");
        System.out.println("[2. 도서번호 내림차순]");
        System.out.println("[3. 책 제목 오름차순]");
        System.out.println("[4. 책 제목 내림차순]");
        int sort = sc.nextInt();
        return bm.sortedBookList(sort);
    }
}
