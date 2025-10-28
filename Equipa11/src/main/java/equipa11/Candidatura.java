package equipa11;

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
	private ArrayList <Estado> estado;
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
	public ArrayList<Estado> getEstado() {
		return estado;
	}
	public void setEstado(ArrayList<Estado> estado) {
		this.estado = estado;
	}
	
	public void alterarEstado(Estado novoEstado) {
		if (estado == null){
			estado = new ArrayList<>();
		}
		estado.add(novoEstado);
	}
	
	public void listarporEstado() {
		ArrayList <Estado> aceite = new ArrayList<>();;
		ArrayList <Estado> andamento = new ArrayList<>();;
		ArrayList <Estado> recusado = new ArrayList<>();;
		for (Estado i : estado) {
			if(i.getEstadoCandidatura().equalsIgnoreCase("Aceite")) {
				aceite.add(i);
			}
			if(i.getEstadoCandidatura().equalsIgnoreCase("Em andamento")) {
				andamento.add(i);
			}
			if(i.getEstadoCandidatura().equalsIgnoreCase("Recusada")) {
				recusado.add(i);
			}
		}
		System.out.println("Aceite: " + aceite);
		System.out.println("Em andamento: " + andamento);
		System.out.println("Recusada: " + recusado);
	}
}
