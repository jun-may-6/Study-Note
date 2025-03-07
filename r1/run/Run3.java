package hw1.run;

import hw1.model.dto.Employee;
import hw1.model.dto.Student;

import java.util.Scanner;

public class Run3 {
    public static void main(String[] args) {

        /*학생 종료*/

        Employee[] employees = new Employee[10];        //최대 10칸 입력 가능
        /*객체 배열에 객체를 선언하지 않을 경우 오류가 나게 됨*/
//        System.out.println(employees[0].information());
        for(int i = 0 ; i <10 ; i++){
            employees[i] = new Employee();
        }
        System.out.println(employees[0].information());

    }
}
