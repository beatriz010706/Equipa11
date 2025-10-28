/**
 * @author Diogo
 */
package equipa11;
import java.util.ArrayList; 
import jakarta.persistence.*;
/**
 * 
 */
@Entity
@Table (name = "Tipo")
public class Tipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTipo;//PK
	private String descriçaoTipo;
	ArrayList<Parceiro> tipoParceiros = new ArrayList<>();
	ArrayList<ProgramaVoluntariado> tipoPV = new ArrayList<>();
	
	public Tipo () {}

	public Tipo(long idTipo, String descriçaoTipo) {
		this.idTipo = idTipo;
		this.descriçaoTipo = descriçaoTipo;
		}

	public long getIdTipo() {
		return idTipo;
	}
	
	

	public void setDescriçaoTipo(String descriçaoTipo) {
		this.descriçaoTipo = descriçaoTipo;
	}

	public String getDescriçaoTipo() {
		return descriçaoTipo;
	}

	public ArrayList<Parceiro> getTipoParceiros() {
		return tipoParceiros;
	}

	public void setTipoParceiros(ArrayList<Parceiro> tipoParceiros) {
		this.tipoParceiros = tipoParceiros;
	}
	
	
	
}
