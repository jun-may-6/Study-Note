package teamTest.myQ.array;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] intStorage = new int[10];
        int sum = 0;

        for(int i = 0; i < 10; i++){
            System.out.print(i + 1 + "번째 정수를 입력해주세요 : ");
            intStorage[i] = sc.nextInt();
            if (intStorage[i] % 2 == 0) {
                sum++;
            }
        }

        System.out.println("숫자의 배열");

        for(int i = 0; i < 10; i++){
            System.out.print(intStorage[i] + " ");
        }

        System.out.println();

        System.out.println("짝수는 " + sum + "개 입니다.");
    }
}