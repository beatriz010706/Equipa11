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
	
	@Override
	public String toString() {
		return "Estudante [curso=" + curso + ", idade=" + idade + "]";
	}

}//fim classe Estudante
