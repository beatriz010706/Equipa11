package equipa11;
/**
 * @author beatriz silva
 */

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table (name = "Estudante")
@PrimaryKeyJoinColumn(name = "idUtilizador")
public class Estudante extends Utilizador{

	private String curso;
	private int idade;
	
	@OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Candidatura> candidaturas = new ArrayList<>();
	
	@ManyToMany
    @JoinTable(name = "estudante_programa",
        joinColumns = @JoinColumn(name = "idUtilizador"),
        inverseJoinColumns = @JoinColumn(name = "idPrograma"))
    private List<ProgramaEstudante> programas = new ArrayList<>();
	
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
	
	public List<Candidatura> getCandidaturas() { return candidaturas; }
    public void setCandidaturas(List<Candidatura> candidaturas) { this.candidaturas = candidaturas; }
	
    public List<ProgramaEstudante> getProgramas() { return programas; }
    public void setProgramas(List<ProgramaEstudante> programas) { this.programas = programas; }
	
	@Override
	public String toString() {
		return "Estudante [id=" + getIdUtilizador() + "nome=" + getNome() + "curso=" + curso + ", idade=" + idade + "]";
	}

}//fim classe Estudante