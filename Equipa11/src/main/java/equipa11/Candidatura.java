package equipa11;
/**
 * @author gonçalo
 */

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table (name = "Candidatura")
public class Candidatura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCandidatura; //PK

	private String dataSubmissao;

	@ManyToOne
    @JoinColumn(name = "idEstudante") // FK para Estudante
    private Estudante estudante;
	
	@ManyToOne
    @JoinColumn(name = "idProgVoluntariado") // FK para ProgramaVoluntariado
    private ProgramaVoluntariado programaVoluntariado;
	
	@ManyToOne
    @JoinColumn(name = "idEstado") // FK para Estado
    private Estado estado;
	
	public Candidatura() {}
	public Candidatura(long idCandidatura, String dataSubmissao, Estudante estudante,
			ProgramaVoluntariado programaVoluntariado, Estado estado) {
		this.idCandidatura = idCandidatura;
		this.dataSubmissao = dataSubmissao;
		this.estudante = estudante;
		this.programaVoluntariado = programaVoluntariado;
		this.estado = estado;
	}

	public long getIdCandidatura() {return idCandidatura;}
	
	public String getDataSubmissao() {return dataSubmissao;}
	public void setDataSubmissao(String dataSubmissao) {this.dataSubmissao = dataSubmissao;}
	
	public Estudante getEstudante() {return estudante;}
	public void setEstudante(Estudante estudante) {this.estudante = estudante;}
	
	public ProgramaVoluntariado getProgramaVoluntariado() {return programaVoluntariado;}
	public void setProgramaVoluntariado(ProgramaVoluntariado programaVoluntariado) {this.programaVoluntariado = programaVoluntariado;}

	public Estado getEstado() {return estado;}
	public void setEstado(Estado estado) {this.estado = estado;}
	
	@Override
	public String toString() {
		return "Candidatura [idCandidatura=" + idCandidatura + ", dataSubmissao=" + dataSubmissao + ", estudante="
				+ estudante.getNome() + ", programaVoluntariado=" + programaVoluntariado.getTitulo() + ", estado=" + estado.getEstadoCandidatura() + "]";
	}
	
}//fim classe candidatura