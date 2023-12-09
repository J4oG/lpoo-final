package project2;

import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;


class Student extends Person {
    private int registration;
    private String cnumber;
    
    public Student() {
    	
    }

    public Student(String name, int age, int registration, String cnumber) {
        super(name, age);
        this.registration = registration;
        this.cnumber = cnumber;
    }

    public int getRegistration() {
        return registration;
    }

    public String getCnumber() {
        return cnumber;
    }

    private void inputStudentDetails() {
    	inputAPersonInfo();
        Scanner viewer2 = new Scanner(System.in);
        System.out.print("|Digite o numero da sua turma: ");
        this.cnumber = viewer2.nextLine();
    }

    public void calculateRegistration() {
    	int currentYear = Year.now().getValue();
        this.registration = currentYear + getName().length() + getAge();
    }
    
    private void displayStudentsDetails() {
        displayDetails();
        System.out.println("|Sua Turma: " + cnumber);
        System.out.println("|Matrícula do Aluno: " + registration);
        System.out.println("|=============================================|");
    }
    
    public static void main(String args[]) {
    	
    	Student scholar = new Student();
    	scholar.inputStudentDetails();
    	scholar.calculateRegistration();
    	scholar.displayStudentsDetails();
    }

}
