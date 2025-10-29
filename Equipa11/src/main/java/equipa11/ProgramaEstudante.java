package equipa11;
/**
 * @author ines rodrigues  
 */
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name="ProgramaEstudante")
public class ProgramaEstudante {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long idProgEstudante;
	
	private String dataFim;
	private int horasFeitas;
	private boolean emitirDiploma;
	
	@ManyToMany(mappedBy = "programas")
    private List<Estudante> estudantes = new ArrayList<>();
	
	public ProgramaEstudante() {}
	public ProgramaEstudante(String dataFim, int horasFeitas, boolean emitirDiploma) {
		super();
		this.dataFim = dataFim;
		this.horasFeitas = horasFeitas;
		this.emitirDiploma = emitirDiploma;
	}
	
	public long getIdProgEstudante() {return idProgEstudante;}
	
	public String getDataFim() {return dataFim;}
	public void setDataFim(String dataFim) {this.dataFim = dataFim;}
	
	public int getHorasFeitas() {return horasFeitas;}
	public void setHorasFeitas(int horasFeitas) {this.horasFeitas = horasFeitas;}
	
	public boolean isEmitirDiploma() {return emitirDiploma;}
	public void setEmitirDiploma(boolean emitirDiploma) {this.emitirDiploma = emitirDiploma;}
	
	public List<Estudante> getEstudantes() {return estudantes;}
	public void setEstudantes(List<Estudante> estudantes) {this.estudantes = estudantes;}
	
	@Override
	public String toString() {
		return "ProgramaEstudante [idProgEstudante=" + idProgEstudante + ", dataFim=" + dataFim + ", horasFeitas="
				+ horasFeitas + ", emitirDiploma=" + emitirDiploma + "]";
	}
	
}//fim classe ProgramaEstudante
