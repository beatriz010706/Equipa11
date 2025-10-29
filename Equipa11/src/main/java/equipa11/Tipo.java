package equipa11;
/**
 * @author diogo
 */
import java.util.ArrayList; 
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table (name = "Tipo")
public class Tipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTipo;//PK
	
	private String descriçaoTipo;
	
	@OneToMany(mappedBy = "tipo")
    private List<Parceiro> parceiros = new ArrayList<>();
	
	@OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProgramaVoluntariado> programas = new ArrayList<>();
	
	public Tipo () {}
	public Tipo(long idTipo, String descriçaoTipo) {
		this.idTipo = idTipo;
		this.descriçaoTipo = descriçaoTipo;
		}

	public long getIdTipo() {return idTipo;}
	
	public String getDescriçaoTipo() {return descriçaoTipo;}
	public void setDescriçaoTipo(String descriçaoTipo) {}

	public List<Parceiro> getParceiros() { return parceiros; }
    public void setParceiros(List<Parceiro> parceiros) { this.parceiros = parceiros; }
    
    public List<ProgramaVoluntariado> getProgramas() { return programas; }
    public void setProgramas(List<ProgramaVoluntariado> programas) { this.programas = programas; }
	
    @Override
	public String toString() {
		return "Tipo [idTipo=" + idTipo + ", descriçaoTipo=" + descriçaoTipo + "]";
	}
    
	public String getDescricaoTipo() {return null;}
	public Parceiro[] getTipoParceiros() {return null;}
	public void setDescricaoTipo(String descricaoTipo) {}
}//fim classe
