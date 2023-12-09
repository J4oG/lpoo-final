package project2;

import java.time.Year;
import java.util.Scanner;

class Professor extends Person {
		
		private String discipline;
		private int Yoe;
		private int id_prof;
	
	public Professor (String name, int age, String discipline, int yoe, int id_prof) {
		super(name, age);
		this.setDiscipline(discipline);
		this.setYoe(yoe);
		this.setId_prof(id_prof);
	}
	
	public Professor() {
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	public int getYoe() {
		return Yoe;
	}

	public void setYoe(int yoe) {
		Yoe = yoe;
	}
	
	public int getId_prof() {
		return id_prof;
	}

	public void setId_prof(int id_prof) {
		this.id_prof = id_prof;
	}
	
	private void inputProfessorDetails() {
		inputAPersonInfo();
        Scanner viewer1 = new Scanner(System.in);

        System.out.print("|Digite sua Disciplina: ");
        this.discipline = viewer1.nextLine();

        System.out.print("|Digite seus anos de Experiência na área: ");
        this.Yoe = viewer1.nextInt();
    }

	private void ShowProfessorinfo() {
		
		System.out.println("|=============================================|");
		System.out.println("|Seu Nome: " +name);
		System.out.println("|Sua Idade: " +age);
		System.out.println("|=============================================|");
		
	}
	
    private void calculateIdProfandDetails() {
    	int currentYear = Year.now().getValue();
    	this.id_prof = getName().length() + currentYear + Yoe;
    	System.out.println("|ID do Professor calculado: " + id_prof);
    	System.out.println("|Sua Disciplina: " + discipline);
        System.out.println("|Seus anos de Experiência: " + Yoe);
        System.out.println("|=============================================|");
    }
	 public static void main(String[] args) {

		 Professor prof = new Professor();
		 prof.inputProfessorDetails();
		 prof.ShowProfessorinfo();
		 prof.calculateIdProfandDetails();
	 }
}  