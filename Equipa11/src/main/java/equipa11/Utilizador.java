package equipa11;
/**
 * @author beatriz silva
 */
import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table (name = "Utilizador")
public class Utilizador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUtilizador;
	private String nome;
	private String email;
	private String password;
	
	public Utilizador() {}
	public Utilizador(String nome, String email, String password) {
		super();
		this.nome = nome;
		this.email = email;
		this.password = password;
	}

	public String getPassword() {return password;}
	public void setPassword(String password) {
		if (password.length() < 8) {  // Se a password tiver menos de 8 caracteres
			System.out.println("A password deve ter pelo menos 8 caracteres!");
		} else {
			this.password = password;  // Senão, guarda a password
		}
	}
	public String getNome() {return nome;}
	public String getEmail() {return email;}
	
	@Override
	public String toString() {
		return "Utilizador [idUtilizador=" + idUtilizador + ", nome=" + nome + ", email=" + email + ", password="
				+ password + "]";
	}
}//fim classe Utilizador
