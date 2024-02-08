package hw1.run;

import hw1.model.dto.Employee;
import hw1.model.dto.Student;

import java.util.Scanner;

public class Run2 {
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
        /*=================Run2. 변수에 값을 저장한 뒤 한번에 객체 할당=================*/

        Employee[] employees = new Employee[10];        //최대 10칸 입력 가능

        int insertedEmployee = 0;
        while(true){                        //입력 반복
            System.out.print("이름을 입력해주세요 : ");
            String name = sc.nextLine();
            System.out.print("나이를 입력해주세요 : ");
            int age = sc.nextInt();
            System.out.print("키를 입력해주세요 : ");
            double height = sc.nextDouble();
            System.out.print("몸무게를 입력해주세요 : ");
            Double weight = sc.nextDouble();
            System.out.print("급여 입력해주세요 : ");
            int salary = sc.nextInt();
            sc.nextLine();      //스킵방지
            System.out.print("부서를 입력해주세요 : ");
            String dept = sc.nextLine();

            employees[insertedEmployee] = new Employee(name, age, height, weight, salary, dept);
            insertedEmployee++;
            if(insertedEmployee == 10){
                break;
            }

            System.out.println("계속 하려면 y를 입력해주세요.");
            if(!sc.nextLine().toUpperCase().equals("Y")){
                break;
            }
        }

        for (Employee now : employees){
            System.out.println(now.information());
            insertedEmployee--;
            if(insertedEmployee == 0){
                break;
            }
        }
    }
}
