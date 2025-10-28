package equipa11;
/**
 * 
 */
import java.util.ArrayList;
public class Gestor {
	
	private ArrayList<Estudante> estudantes;
	private ArrayList<Parceiro> parceiros;
	private ArrayList<Tipo> tipos;
	
	public Gestor() {
		this.estudantes = new ArrayList<>();
		this.parceiros = new ArrayList<>();
		this.tipos = new ArrayList<>();
	}
	
	/**
	 * metodo para registar um ESTUDANTE
	 * @author beatriz silva
	 */
	public boolean registarEstudante(String nome, String email, String password, String curso, int idade) {
		//verificar se já existe um utilizador com o mesmo email
		for(Estudante e: estudantes) {
			if(e.getEmail().equals(email)) {
				System.out.println("email já registado");
				return false;
			}
		}
		//criar novo estudante e adicionar à lista
		Estudante novoEstudante = new Estudante (nome, email, password, curso, idade);
		estudantes.add(novoEstudante);
		System.out.println("estudante registado com sucesso");
		return true;
	}
	
	/**
	 * método para registar um parceiro
	 * @author beatriz silva
	 */
	public boolean registarParceiro(String nome, String email, String password, String local) {
		//verificar se já exite um utilizador com o mesmo email
		for(Parceiro p: parceiros) {
			if(p.getEmail().equals(email)) {
				System.out.println("email já registado");
				return false;
			}
		}
		//criar novo parceiro e adicionar à lista
		Parceiro novoParceiro = new Parceiro(nome, email, password, local);
		parceiros.add(novoParceiro);
		System.out.println("parceiro registado com sucesso");
		return true;
	}
	
	/**
	 * método para login (Estudante ou Parceiro)
	 * @author beatriz silva
	 */
	public Utilizador login(String email, String password) {
		//verificar estudantes
		for(Estudante e: estudantes) {
			if(e.getEmail().equals(email) && e.getPassword().equals(password)) {
				System.out.println("login de ESTUDANTE efetuado com suesso");
				return e;
			}
		}
		//verificar parceiros
		for(Parceiro p: parceiros) {
			if(p.getEmail().equals(email) && p.getPassword().equals(password)) {
				System.out.println("ogin de PARCEIRO efetuado com sucesso");
				return p;
			}
		}
		System.out.println("email ou password incorretos");
		return null;
	}
	
	/**
	  * Regista um novo tipo de parceiro 
	  */
	  public void registoTipo(String descricao) {
	  Tipo novoTipo = new Tipo();
	  // Como o atributo é privado, adicionamos um setter simples na classe Tipo
	  novoTipo.setDescriçaoTipo(descricao);
	  tipos.add(novoTipo);
	  System.out.println("Tipo \"" + descricao + "\" registado com sucesso!");
	  }
	  /**
	  * Lista todos os parceiros associados a um determinado tipo.
	  */
	  public void listarParceiroPorTipo(String descricao) {
	  for (Tipo t : tipos) {
	  if (t.getDescriçaoTipo().equalsIgnoreCase(descricao)) {
	  System.out.println("Parceiros do tipo: " + descricao);
	  for (Parceiro p : t.getTipoParceiros()) {
	  System.out.println(p);
	  }
	  return;
	  }
	  }
	  System.out.println("Tipo \"" + descricao + "\" não encontrado!");
	  }

	

}//fim classe Gestor
