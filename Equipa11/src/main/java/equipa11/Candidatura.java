package equipa11;
/**
 * @author gonçalo
 */

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table (name = "Candidatura")
public class Candidatura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCandidatura; //PK
	private long idEstado; //FK
	private long idProgVoluntariado; //FK
	private String dataSubmissao;
	/**
	 * @param dataSubmissao
	 * @param estado
	 */
	public Candidatura(String dataSubmissao, ArrayList<Estado> estado) {
		this.dataSubmissao = dataSubmissao;
		estado = new ArrayList<>();;
	}
	public long getIdCandidatura() {
		return idCandidatura;
	}
	public void setIdCandidatura(long idCandidatura) {
		this.idCandidatura = idCandidatura;
	}
	public long getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(long idEstado) {
		this.idEstado = idEstado;
	}
	public long getIdProgVoluntariado() {
		return idProgVoluntariado;
	}
	public void setIdProgVoluntariado(long idProgVoluntariado) {
		this.idProgVoluntariado = idProgVoluntariado;
	}
	public String getDataSubmissao() {
		return dataSubmissao;
	}
	public void setDataSubmissao(String dataSubmissao) {
		this.dataSubmissao = dataSubmissao;
	}
		
}//fim classe candidatura