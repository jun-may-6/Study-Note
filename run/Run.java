package hw1.run;

import hw1.model.dto.Employee;
import hw1.model.dto.Person;
import hw1.model.dto.Student;

import java.util.Locale;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[3];
        students[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
        students[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
        students[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");

        for(Student now : students){            //now 에 배열을 하나씩 할당하여 출력
            System.out.println(now.information());
        }

        /*학생 종료*/

        Employee[] employees = new Employee[10];        //최대 10칸 입력 가능
        int nowEmploy = 0;  //현재 추가된 인원 수
        while(true){        //무한 반복으로 입력받기

            employees[nowEmploy] = new Employee();  //employees[nowEmploy] 칸에 새로운 객체 할당

            System.out.print("이름을 입력해주세요 : ");      //setter 메소드를 이용하여 현재 배열에 필드에 할당
            employees[nowEmploy].setName(sc.nextLine());
            System.out.print("나이를 입력해주세요 : ");
            employees[nowEmploy].setAge(sc.nextInt());
            System.out.print("키를 입력해주세요 : ");
            employees[nowEmploy].setHeight(sc.nextDouble());
            System.out.print("몸무게 입력해주세요 : ");
            employees[nowEmploy].setWeight(sc.nextDouble());
            System.out.print("급여를 입력해주세요 : ");
            employees[nowEmploy].setSalary(sc.nextInt());
            sc.nextLine();      //스킵 방지용
            System.out.print("부서를 입력해주세요 : ");
            employees[nowEmploy].setDept(sc.nextLine());

            nowEmploy++;    //현재 인원 + 1

            if(nowEmploy == 10){        //만약 현재 인원이 10명이면 종료
                break;
            }
            System.out.println(nowEmploy + "명을 작성하였습니다. 추가하시겠습니까? (y 또는 아무키)");
            String yes = sc.nextLine();
            if(!yes.toUpperCase().equals("Y")){        //만약 입력받은게 y나 Y가 아니라면 종료
                break;
            }
            }

        for(Employee now : employees){
            System.out.println(now.information());
            nowEmploy--;
            if(nowEmploy == 0){             //현재 인원이 0이 될때까지 출력
                break;
            }
        }
    }
}
