package com.ohgiraffers.section01.insert;

import com.ohgiraffers.model.dto.MenuDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {
        /* 1. 메뉴의 이름, 가격, 카테고리 코드, 판매여부를 입력받기 (Scanner 이용) */
        Scanner sc = new Scanner(System.in);

        System.out.println("메뉴의 이름을 입력해주세요.");
        String menuName = sc.nextLine();

        System.out.println("메뉴의 가격을 입력해주세요.");
        int menuPrice = sc.nextInt();

        System.out.println("메뉴의 카테고리 코드를 입력해주세요.");
        int categoryCode = sc.nextInt();

        sc.nextLine();
        System.out.println("메뉴의 주문 가능 여부를 입력해주세요.");
        String orderAble = sc.nextLine().toUpperCase();


        /* MenuDTO 객체를 생성하여 입력받은 값으로 setting */
        MenuDTO menu = new MenuDTO();
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);
        menu.setCategoryCode(categoryCode);
        menu.setOrderAbleStatus(orderAble);

        /* InsertController 의 insertMenu() 메소드 호출*/
        InsertController insertMenu = new InsertController();
        int result = insertMenu.insertMenu(menu);

        /* Insert 결과에 따라서 성공이면 '메뉴 등록 성공!', 실패이면 '메뉴 등록 실패!' 출력*/

        if(result > 0){
            System.out.println("메뉴 등록 성공!");
        } else  {
            System.out.println("메뉴 등록 실패!");
        }
    }
}

