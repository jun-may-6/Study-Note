package com.hw1.view;

import com.hw1.controller.LibraryManger;
import com.hw1.model.dto.Book;
import com.hw1.model.dto.Member;

import java.util.Scanner;

public class LibraryMenu {
    /* variable */
    private LibraryManger im = new LibraryManger();
    Scanner sc = new Scanner(System.in);

    /* method */
    public void mainMenu(){         //기본 화면
        System.out.println("이름을 입력해주세요. ");
        String name = sc.nextLine();
        System.out.println("나이를 입력해주세요. ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("성별을 입력해주세요. ");
        char gender = sc.nextLine().charAt(0);

        Member mem = new Member(name, age, gender);     //Member 의 생성자를 사용하여 mem 인스턴스 생성

        im.insertMember(mem);       //LibraryManger 의 insertMember 메소드를 사용하여 저장

        while (true) {              //무한반복
            System.out.println("===== 메뉴 =====");
            System.out.println("1. 마이페이지");
            System.out.println("2. 도서 전체 조회");
            System.out.println("3. 도서 검색");
            System.out.println("4. 도서 대여하기");
            System.out.println("0. 프로그램 종료하기");
            int choice = sc.nextInt();      //입력받은 정수
            if(choice == 1){
                System.out.println(im.myInfo());        //myInfo 메소드를 사용하여 기본적으로 사용되는 toString 자동 사용
            }
            else if(choice == 2){
                selectAll();
            } else if (choice == 3){
                searchBook();
            } else if(choice == 4){
                rentBook();
            } else if(choice == 0){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }

    public void selectAll(){        //모든 책 출력
        for(Book book : im.selectAll()){
            System.out.println(book);
        }
    }
    public void searchBook(){       //책 제목 검색
        System.out.println("검색할 제목 키워드를 입력해주세요.");
        sc.nextLine();
        String keyword = sc.nextLine();
        Book[] resultBook = im.searchBook(keyword);     //결과값 배을은 만든 뒤 searchBook 메소드를 활용하여 할당
        for(Book book : resultBook){            //결과값 배열을 출력하는데
            if (book != null){                  //배열이 비어있을 경우 출력을 건너뜀
                System.out.println(book);
            }
        }
    }
    public void rentBook(){     //책 대여
        for(int i = 0 ; i < im.selectAll().length ; i ++){      //책 번호와 목록 나열
            System.out.println(i + "번 도서. " + im.selectAll()[i]);
        }
        System.out.println("대여할 도서 번호를 선택해주세요.");
        int index = sc.nextInt();
        int result = im.rentBook(index);        //입력받은 인덱스의 도서를 빌렸을때 결과값
        if(result == 0){
            System.out.println("성공적으로 대여되었습니다.");
        } else if(result == 1){
            System.out.println("나이 제한으로 대여 불가능입니다.");
        } else if(result == 2){
            System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었습니다. 마이페이지를 통해 확인해주세요.");
        }
    }

    /* setter/getter */
    public LibraryManger getIm() {
        return im;
    }

    public void setIm(LibraryManger im) {
        this.im = im;
    }
}
