package teamTest.myQ.forwhile;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("단어를 입력해주세요 : ");
            String word = sc.nextLine();  //입력받은 단어

            for (int i = 0; i <= (word.length() / 2); i++){  //단어의 절반까지 검토
                if(word.charAt(i) != word.charAt(word.length()-1-i)){  //반대편 문자가 다를경우
                    System.out.println("뒤집었을 때 다른 단어입니다(X).");
                    break;  //즉시 반복 종료
                }

                if(i == (word.length()/2)){  //중간까지 도달했을 때 다른 글자가 없을 경우
                    System.out.println("뒤집었을 때 같은 단어입니다(O).");
                }
            }
        }

    }
}
