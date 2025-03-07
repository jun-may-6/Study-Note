package com.hw1.controller;

import com.hw1.model.dto.AniBook;
import com.hw1.model.dto.Book;
import com.hw1.model.dto.CookBook;
import com.hw1.model.dto.Member;

public class LibraryManger {

    /* variable */
    private Member mem = null;
    Book[] bList = new Book[5];

    {
        bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
        bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
        bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
        bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이헤정", "문학", false);
        bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
    }

    /* method */

    public void insertMember(Member mem){       //현재 클래스의 mem 에 할당
        this.mem = mem;
    }

    public Member myInfo(){             //현재 클래스의 mem 반환
        return mem;
    }
    public Book[] selectAll(){          //모든 책의 배열을 반환
        return bList;
    }
    public Book[] searchBook(String keyword)   {        //책 검색
        Book[] resultBook = new Book[5];                //최대 책이 5권이므로 길이 5의 검색 결과 배열 선언
        int result = 0;     //현재 일치하는 책
        for(Book book : bList){                         //bList 하나씩 반복
            if(book.getTitle().contains(keyword)){      //bList 의 result 번째 책이 키워드를 포함하면
                resultBook[result] = book;                  //검색 결과 배열에 일치하는 책을 할당
                result ++;                                  //result + 1
            }
        }
        return resultBook;
    }
    public int rentBook(int index){         //책 대여
        int result = 0;     //리턴할 결과값 선언과 0으로 초기화

        if(bList[index] instanceof AniBook){    //선택한 책의 클래스가 AniBook 을 참조할때
            if(((AniBook) bList[index]).getAccessAge() > mem.getAge()){ //만약 나이가 제한 나이보다 많다면
                result = 1;     //결과값 = 1
            }
        }
        if (bList[index] instanceof CookBook){  //선택한 책의 클래스가 CookBook 을 참조할때
            if(((CookBook) bList[index]).isCoupon()){   //만약 쿠폰이 존재한다면
                mem.setCouponCount(mem.getCouponCount() + 1);   //회원 정보의 쿠폰 + 1
                result = 2;     //결과값 = 2
            }
        }
        return result;      //결과값 리턴
    }

    /* setter/getter */
    public Member getMem() {
        return mem;
    }

    public void setMem(Member mem) {
        this.mem = mem;
    }

    public Book[] getbList() {
        return bList;
    }

    public void setbList(Book[] bList) {
        this.bList = bList;
    }
}
