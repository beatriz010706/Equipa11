package equipa11;
/**
 * @author beatriz silva
 */

import java.util.ArrayList;
import jakarta.persistence.*;

@Entity
@Table (name = "Estudante")
public class Estudante extends Utilizador{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEstudante;//PK
	private long idUtilizador;//FK
	private long idProgEstudante;//FK
	private String curso;
	private int idade;
	private ArrayList<Candidatura> candidaturaE = new ArrayList<>();
	private ArrayList<ProgramaEstudante> programaE = new ArrayList<>();
	
	public Estudante () {}
	public Estudante(String nome, String email, String password, String curso, int idade) {
		super(nome, email, password);
		this.curso = curso;
		this.idade = idade;
	}

	public String getCurso() {return curso;}
	public void setCurso(String curso) {this.curso = curso;}
	public int getIdade() {return idade;}
	public void setIdade(int idade) {this.idade = idade;}
	public ArrayList<Candidatura> getCandidaturaE() {return candidaturaE;}
	public void setCandidaturaE(ArrayList<Candidatura> candidaturaE) {this.candidaturaE = candidaturaE;}
	public ArrayList<ProgramaEstudante> getProgramaE() {return programaE;}
	public void setProgramaE(ArrayList<ProgramaEstudante> programaE) {this.programaE = programaE;}
	
	@Override
	public String toString() {
		return "Estudante [idEstudante=" + idEstudante + ", idUtilizador=" + idUtilizador + ", idProgEstudante="
				+ idProgEstudante + ", curso=" + curso + ", idade=" + idade + "]";
	}
	
	

}//fim classe Estudante
