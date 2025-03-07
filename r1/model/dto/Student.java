package hw1.model.dto;

public class Student extends Person{
    private int grade;      //private 변수 두가지
    private String major;

    public Student(){};     //기본 생성자

    public Student(String name, int age, double height,     //매개변수 생성자
                   double weight, int grade, String major){
        super(age, height, weight);     //부모 생성자 초기화
        setName(name);          //필드에 직접 접근 초기화
        this.grade = grade;
        this.major = major;
    }

    @Override
    public String information() {
        return super.information()
                + ", 학년 " + grade
                + ", 전공 + " + major;
    }
}


