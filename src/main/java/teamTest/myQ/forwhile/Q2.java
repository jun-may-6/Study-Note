package teamTest.myQ.forwhile;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("이름을 입력해주세요! ");
        String name = sc.nextLine();
        char surname = name.charAt(0);

        switch (surname) {
            case ('김') : System.out.println("축하합니다! 보조배터리를 선물로 드립니다!"); break;
            case ('이') : System.out.println("축하합니다! 텀블러를 선물로 드립니다!"); break;
            default:
                System.out.println("꽝입니다!");
        }
    }
}
