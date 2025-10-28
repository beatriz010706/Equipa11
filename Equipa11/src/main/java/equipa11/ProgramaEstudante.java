package equipa11;
/**
 * @author ines rodrigues 
 */
import jakarta.persistence.*;

@Entity
@Table (name="ProgramaEstudante")
public class ProgramaEstudante {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long idProgEstudante;
	
	private String dataFim;
	private int horasFeitas;
	private boolean emitirDiploma;
	
	public ProgramaEstudante() {}
	public ProgramaEstudante(String dataFim, int horasFeitas, boolean emitirDiploma) {
		super();
		this.dataFim = dataFim;
		this.horasFeitas = horasFeitas;
		this.emitirDiploma = emitirDiploma;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	public int getHorasFeitas() {
		return horasFeitas;
	}
	public void setHorasFeitas(int horasFeitas) {
		this.horasFeitas = horasFeitas;
	}
	public boolean isEmitirDiploma() {
		return emitirDiploma;
	}
	
	public void setEmitirDiploma(boolean emitirDiploma) {
		this.emitirDiploma = emitirDiploma;
		}
}//fim classe ProgramaEstudante
