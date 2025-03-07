package com.ohgiraffers.section03.delete;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        /* 1. 삭제할 메뉴 코드 입력받기
        * 2. DeleteController 의 deleteMenu() 메소드 호출
        * 3. delete 결과에 따라 성공 or 실패 출력*/
        Scanner sc = new Scanner(System.in);
        System.out.println("지울 메뉴의 코드를 입력해주세요");
        int menuCode = sc.nextInt();

        DeleteController deleteController = new DeleteController();
        int result = deleteController.deleteMenu(menuCode);
        if(result > 0){
            System.out.println("메뉴 삭제 성공!");
        } else {
            System.out.println("메뉴 삭제 실패 ㅜㅜ");
        }
    }
}
