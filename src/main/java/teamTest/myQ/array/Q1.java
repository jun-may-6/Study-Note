package teamTest.myQ.array;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int randomNum = (int)(Math.random() * 20) + 1;

        String[] engWord = new String[5];
        String[] korWord = new String[5];
        int score = 0;

        for(int i = 1 ; i <= 5 ; i++){ //다섯개의 단어와 뜻을 입력받는 반복문
            System.out.print(i + "번째 영어 단어를 입력해주세요 : ");
            engWord[i - 1] = sc.nextLine();
            System.out.print(engWord[i - 1] + "의 뜻을 입력해주세요 : ");
            korWord[i - 1] = sc.nextLine();
        }

        System.out.println("================================");
        System.out.println("시험을 시작합니다.");
        System.out.println("================================");

        for(int i = 1 ; i <= 5 ; i++){    //다섯개의 문제를 푸는 반복문
            System.out.println(engWord[i-1] + "의 뜻은?");
            String ans = sc.nextLine();
            if(korWord[i-1].equals(ans)){
                System.out.println("정답입니다!");
                score++; //맞출경우 점수를 +1
            } else {
                System.out.println("오답입니다!");
            }
        }
        System.out.println("5문제 중 " + score + "문제를 맞추셨습니다!");
    }
}
