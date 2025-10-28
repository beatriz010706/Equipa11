package equipa11;

/**
 * @author miguel silva
 */
import java.util.ArrayList;
import jakarta.persistence.*;


@Entity
@Table (name = "ProgramaVoluntariado")
public class ProgramaVoluntariado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProgVoluntariado; //PK
	private long idParceiro;//FK
	private long idProgEstudante;//FK
	
	private String titulo;
	private String descrição;
	private int horasServiço;
	private String local;
	private int vagas;
	private ArrayList<Candidatura> candidaturaE;
	private ArrayList<ProgramaEstudante> programaE;
	
	public ProgramaVoluntariado() {}
	
	public ProgramaVoluntariado(String titulo, String descrição, int horasServiço, String local, int vagas) {
		this.titulo = titulo;
		this.descrição = descrição;
		this.horasServiço = horasServiço;
		this.local = local;
		this.vagas = vagas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public int getHorasServiço() {
		return horasServiço;
	}

	public void setHorasServiço(int horasServiço) {
		this.horasServiço = horasServiço;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}
	
	
	
	
	
	
	
}