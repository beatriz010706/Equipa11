package equipa11;
/**
 * @author beatriz silva
 */
import java.util.ArrayList;
import jakarta.persistence.*;

@Entity
@Table (name = "Parceiro")
public class Parceiro extends Utilizador{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idParceiro;//PK
	private long idUtilizador;//FK
	private long idTipo;//FK
	private String local;
	private ArrayList<ProgramaVoluntariado> programaV = new ArrayList<>();

	public Parceiro() {}
	public Parceiro(String nome, String email, String password, String local) {
		super(nome, email, password);
		this.local = local;
	}

	public String getLocal() {return local;}
	public void setLocal(String local) {this.local = local;}
	public ArrayList<ProgramaVoluntariado> getProgramaV() {return programaV;}
	public void setProgramaV(ArrayList<ProgramaVoluntariado> programaV) {this.programaV = programaV;}
	
	@Override
	public String toString() {
		return "Parceiro [local=" + local + "]";
	}

}//fim classe Parceiro