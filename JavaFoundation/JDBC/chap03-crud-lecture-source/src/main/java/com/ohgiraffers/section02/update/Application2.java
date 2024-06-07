package com.ohgiraffers.section02.update;

import com.ohgiraffers.model.dto.MenuDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {
        /* 1. 변경할 메뉴 코드, 이름, 가격 입력 받기
        * 2. MenuDTO 생성하여 입력받은 값으로 setting
        * 3. UpdateController 의 updateMenu 메소드 호출
        * 4. update 결과에 따라 성공, 실패 메세지 출력*/

        Scanner sc = new Scanner(System.in);
        MenuDTO menu = new MenuDTO();
        UpdateController updateController = new UpdateController();
        int result;

        System.out.println("변경할 메뉴의 코드를 입력해주세요.");
        int menuCode = sc.nextInt();
        menu.setMenuCode(menuCode);


        sc.nextLine();
        System.out.println("새로운 메뉴의 이름을 입력해주세요.");
        String menuName = sc.nextLine();
        menu.setMenuName(menuName);

        System.out.println("새로운 메뉴의 가격을 입력해주세요.");
        int menuPrice = sc.nextInt();
        menu.setMenuPrice(menuPrice);

        result = updateController.updateMenu(menu);

        if(result > 0){
            System.out.println("메뉴 변경 성공");
        } else {
            System.out.println("메뉴 변경 실패");
        }
    }
}
