package project2;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Grades implements Serializable {

    private static final long serialVersionUID = 1L;

    private float Grade1;
    private float Grade2;
    private String StudentN;

    public Grades() {
    }

    public float getGrade1() {
        return Grade1;
    }

    public void setGrade1(float grade1) {
        Grade1 = grade1;
    }

    public float getGrade2() {
        return Grade2;
    }

    public void setNota2(float grade2) {
        Grade2 = grade2;
    }

    public String getStudentN() {
        return StudentN;
    }

    public void setAlunoN(String studentN) {
        StudentN = studentN;
    }

    public void inputNotasDetails() {
        Scanner viewer3 = new Scanner(System.in);

        try {
            System.out.println("|=============================================|");
            System.out.print("|Digite o nome completo do aluno: ");
            this.StudentN = viewer3.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Erro: Não foi possível criar o nome, tente novamente");
            System.out.println("|=============================================|");
        }

        try {
            System.out.print("|Digite a nota 1: ");
            this.Grade1 = viewer3.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Erro: Não foi possível processar a primeira nota, tente novamente");
            viewer3.nextLine();
            System.out.println("|=============================================|");
        }

        try {
            System.out.print("|Digite a nota 2: ");
            this.Grade2 = viewer3.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Erro: Não foi possível processar a segunda nota, tente novamente");
            viewer3.nextLine();
            System.out.println("|=============================================|");
        }
    }

    public void calcularMedia() {
        float media = (Grade1 + Grade2) / 2;
        System.out.println("|=============================================|");
        System.out.println("|Nome do aluno: " + StudentN);
        System.out.println("|Nota 1: " + Grade1);
        System.out.println("|Nota 2: " + Grade2);
        System.out.println("|Média: " + media);
        System.out.println("|=============================================|");

        if (media >= 7) {
            System.out.println("|            Situação: Aprovado               |");
            System.out.println("|=============================================|");
        } else {
            System.out.println("|            Situação: Reprovado              |");
            System.out.println("|=============================================|");
        }
    }

    public static void main(String[] args) {
        Grades grade = new Grades();
        grade.inputNotasDetails();
        grade.calcularMedia();

        String path = System.getProperty("user.home") + "\\Desktop\\";
        String filename = path + "grades.txt";
        saveTextToFile(grade, filename);
    }

    private static void saveTextToFile(Grades grade, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Nome do aluno: " + grade.getStudentN());
            writer.newLine();
            writer.write("Nota 1: " + grade.getGrade1());
            writer.newLine();
            writer.write("Nota 2: " + grade.getGrade2());
            writer.newLine();
            writer.write("Média: " + ((grade.getGrade1() + grade.getGrade2()) / 2));
            writer.newLine();
            System.out.println("Dados salvos com sucesso no arquivo: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}