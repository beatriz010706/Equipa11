package equipa11;
/**
 * @author gonçalo
 */

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table (name = "Estado")

public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEstado; //(PK)
	
	private String estadoCandidatura;

	@OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Candidatura> candidaturas = new ArrayList<>();
	
	public Estado() {}
	public Estado(String estadoCandidatura) {
		this.estadoCandidatura = estadoCandidatura;
	}
	
	public long getIdEstado() {return idEstado;}

	public String getEstadoCandidatura() {return estadoCandidatura;}
	public void setEstadoCandidatura(String estadoCandidatura) {this.estadoCandidatura = estadoCandidatura;}
	
	@Override
	public String toString() {
		return "Estado [idEstado=" + idEstado + ", estadoCandidatura=" + estadoCandidatura +"]";
	}
	
}//fim classe estado