package equipa11;
/**
 * @author beatriz silva
 */
import java.util.ArrayList; 
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table (name = "Parceiro")
@PrimaryKeyJoinColumn(name = "idUtilizador")
public class Parceiro extends Utilizador{

	private String local;
	
	  @ManyToOne
	    @JoinColumn(name = "idTipo") // FK na tabela Parceiro
	    private Tipo tipo;
	
	@OneToMany(mappedBy = "parceiro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProgramaVoluntariado> programas = new ArrayList<>();

	public Parceiro() {}
	public Parceiro(String nome, String email, String password, String local) {
		super(nome, email, password);
		this.local = local;
	}

	public String getLocal() {return local;}
	public void setLocal(String local) {this.local = local;}
	
	public List<ProgramaVoluntariado> getProgramas() { return programas; }
    public void setProgramas(List<ProgramaVoluntariado> programas) { this.programas = programas; }
	
	@Override
	public String toString() {
		return "Parceiro [id=" + getIdUtilizador() + "nome=" + getNome() + "local=" + local + "]";
	}
	
}//fim classe Parceiro