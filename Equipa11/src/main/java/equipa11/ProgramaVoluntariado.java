package equipa11;
/**
 * @author miguel silva 
 */

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table (name = "ProgramaVoluntariado")
public class ProgramaVoluntariado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProgVoluntariado; //PK
	
	
	private String titulo;
	private String descrição;
	private int horasServiço;
	private String local;
	private int vagas;
	
	@ManyToOne
    @JoinColumn(name = "idParceiro")
    private Parceiro parceiro;
	
	@OneToMany(mappedBy = "programaVoluntariado", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Candidatura> candidaturaE = new ArrayList<>();
	
	@ManyToMany
    @JoinTable(name = "programa_voluntariado_estudante",
    	joinColumns = @JoinColumn(name = "idProgVoluntariado"),
        inverseJoinColumns = @JoinColumn(name = "idProgEstudante"))
	private List<ProgramaEstudante> programaE = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "idTipo") // cria a FK na tabela ProgramaVoluntariado
	private Tipo tipo;

	public Tipo getTipo() { return tipo; }
	public void setTipo(Tipo tipo) { this.tipo = tipo; }
	
	public ProgramaVoluntariado() {}
	
	public ProgramaVoluntariado(String titulo, String descrição, int horasServiço, String local, int vagas) {
		this.titulo = titulo;
		this.descrição = descrição;
		this.horasServiço = horasServiço;
		this.local = local;
		this.vagas = vagas;
	}

	public long getIdProgVoluntariado() {return idProgVoluntariado;}
	
	public Parceiro getParceiro() {return parceiro;}
	public void setParceiro(Parceiro parceiro) {this.parceiro = parceiro;}
	
	public List<Candidatura> getCandidaturaE() {return candidaturaE;}
	public void setCandidaturaE(ArrayList<Candidatura> candidaturaE) {this.candidaturaE = candidaturaE;}

	public 
	List<ProgramaEstudante> getProgramaE() {return programaE;}
	public void setProgramaE(ArrayList<ProgramaEstudante> programaE) {this.programaE = programaE;}

	public String getTitulo() {return titulo;}
	public void setTitulo(String titulo) {this.titulo = titulo;}

	public String getDescrição() {return descrição;}
	public void setDescrição(String descrição) {this.descrição = descrição;}

	public int getHorasServiço() {return horasServiço;}
	public void setHorasServiço(int horasServiço) {this.horasServiço = horasServiço;}

	public String getLocal() {return local;}
	public void setLocal(String local) {this.local = local;}

	public int getVagas() {return vagas;}
	public void setVagas(int vagas) {this.vagas = vagas;}

	@Override
	public String toString() {
		return "ProgramaVoluntariado [idProgVoluntariado=" + idProgVoluntariado + ", titulo=" + titulo + ", descrição="
				+ descrição + ", horasServiço=" + horasServiço + ", local=" + local + ", vagas=" + vagas + "]";
	}

	public void setDescricao(String novaDescricao) {}

	public void setHorasServico(int novasHorasServico) {}
	
}//fim classe