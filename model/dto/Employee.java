package hw1.model.dto;

public class Employee extends Person{
    private int salary;         //private 변수 두가지
    private String dept;


    public Employee(){}         //기본 생성자
    public Employee(String name, int age, double height,        //매개변수를 갖는 생성자
                    double weight, int salary, String dept){
        super(age, height, weight);
        super.name = name;          //super활용
        this.salary = salary;
        this.dept = dept;
    }

    @Override
    public String information() {       //오버라이딩, 슈퍼 사용
        return super.information()
                + ", 급여" + salary
                + ", 부서" + dept;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }
    public void setDept(String dept){
        this.dept = dept;
    }
    public int getSalary(){
        return salary;
    }
    public String getDept(){
        return dept;
    }
}
