package com.ohgiraffers.section01.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2_1 {
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

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        String query;

        Properties prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml"));
            query = prop.getProperty("insertMenu");
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, menuName);
            pstmt.setInt(2, menuPrice);
            pstmt.setInt(3, categoryCode);
            pstmt.setString(4, orderAble);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
