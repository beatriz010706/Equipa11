package equipa11;
/**
 * @author gonçalo
 */

import jakarta.persistence.*;

@Entity
@Table (name = "Estado")

public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEstado; //(PK)
	private String estadoCandidatura;

	
	public Estado(String estadoCandidatura) {
		this.estadoCandidatura = estadoCandidatura;
	}
	

	public long getIdEstado() {
		return idEstado;
	}


	public void setIdEstado(long idEstado) {
		this.idEstado = idEstado;
	}


	public String getEstadoCandidatura() {
		return estadoCandidatura;
	}


	public void setEstadoCandidatura(String estadoCandidatura) {
		this.estadoCandidatura = estadoCandidatura;
	}
}//fim classe estado