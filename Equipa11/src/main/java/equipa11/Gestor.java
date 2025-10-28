package equipa11;
/**
 * 
 */
import java.util.ArrayList;
public class Gestor {
	
	private ArrayList<Estudante> estudantes;
	private ArrayList<Parceiro> parceiros;
	private ArrayList<Tipo> tipos;
	private ArrayList<ProgramaVoluntariado> programas;
	private ArrayList<Utilizador> utilizadores; // Estudantes e Parceiros
	private ArrayList<ProgramaEstudante>programas; // Programas de voluntariado dos estudantes
	private ArrayList<Estado> estado;
	
	
	public Gestor() {
		this.estudantes = new ArrayList<>();
		this.parceiros = new ArrayList<>();
		this.tipos = new ArrayList<>();
		this.utilizadores = new ArrayList<>();
		this.programas = new ArrayList<>();
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
	  * @author Diogo
	  */
	  public void registoTipo(String descricao) {

		  Tipo novoTipo = new Tipo();
		  // Como o atributo é privado, adicionamos um setter simples na classe Tipo
		  novoTipo.setDescriçaoTipo(descricao);
		  tipos.add(novoTipo);
		  System.out.println("Tipo: " + descricao +" registado com sucesso!");
		  System.out.println("Tipo \"" + descricao + "\" registado com sucesso!");
	  }
	  
	  /**
	  * Lista todos os parceiros associados a um determinado tipo.
	  * @author diogo
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
		  System.out.println("Tipo: " + descricao +" não encontrado!");
	  }

	  /**
	   * metodo para criar um programa
	   * @author miguel silva
	   */ 
	  public void criarPrograma(String titulo, String descricao, int horasServiço, String local, int vagas) {
		  ProgramaVoluntariado novoPrograma = new ProgramaVoluntariado(titulo, descricao, horasServiço, local, vagas);
		  programas.add(novoPrograma);
		  System.out.println("Programa criado com sucesso: "+ titulo);  
	  }
	  
	  /**
	   * metodo para editar um programa
	   * @author miguel silva
	   */ 
	  
	  public void editarPrograma(String tituloAntigo, String novoTitulo, String novaDescricao, int novasHorasServiço, String novoLocal, int novasVagas) {
		  for (ProgramaVoluntariado p : programas) {
			  if (p.getTitulo().equalsIgnoreCase(tituloAntigo)) {
				  p.setTitulo(novoTitulo);
				  p.setDescrição(novaDescricao);
				  p.setHorasServiço(novasHorasServiço);
				  p.setLocal(novoLocal);
				  p.setVagas(novasVagas);
				  System.out.println("Programa: " + tituloAntigo +" editado com sucesso!");
				  return;
			  }
		  }
		  System.out.println("Programa com título: " + tituloAntigo +" não encontrado!");
	  }

	  
	  /**
	   * metodo para eleminar um programa
	   * @author miguel silva
	   */ 
	  
	  public void eliminarPrograma(String titulo) {
		  for (int i = 0; i < programas.size(); i++) {
			  if (programas.get(i).getTitulo().equalsIgnoreCase(titulo)) {
				  programas.remove(i);
				  System.out.println("Programa: "+ titulo +" eliminado com sucesso!");
				  return;
			  }
		  }
		  System.out.println("Programa: " + titulo +" não encontrado!");
	  }

	 
	  /**
	   * metodo para listar um programa
	   * @author miguel silva
	   */ 
	  
	  public void listarProgramas() {
		  if (programas.isEmpty()) {
			  System.out.println("Não existem programas registados.");
		  } else {
			  System.out.println("Lista de Programas:");
			  for (ProgramaVoluntariado p : programas) {
				  System.out.println("Titulo: " + p.getTitulo() + " | Local: " + p.getLocal() + " | Vagas: " + p.getVagas());
			  }
		  }
	  }
	  
}//fim classe Gestor

		  System.out.println("Tipo \"" + descricao + "\" não encontrado!");
	  }
	 
	  /**
	   * Regista um novo programa de voluntariado para um estudante.
	   * @author ines 
	   */
	   public void adicionarPrograma(ProgramaEstudante p) {
		   programas.add(p);
		   System.out.println("Programa de voluntariado registado com sucesso!");		
	   }
	   /**
	   * Método para registar horas de um estudante.
	   * Se atingir 30 horas, o diploma é automaticamente emitido.
	   * @author ines
	   */
	   public void registarHoras(ProgramaEstudante programa, int horasAdicionais) {
		   int total = programa.getHorasFeitas() + horasAdicionais;
		   programa.setHorasFeitas(total);
		   System.out.println("Horas registadas com sucesso! Total atual: " + total + " horas.");
		   // Verifica se o estudante já tem direito a diploma
		   if (total >= 30 && !programa.isEmitirDiploma()) {
			   	emitirCertificado(programa);
		   	}
	   }
	 /**
	  * Emite o certificado se o estudante tiver 30 ou mais horas feitas.
	  * @author ines
	  */
	 public void emitirCertificado(ProgramaEstudante programa) {
		 if (programa.getHorasFeitas() >= 30) {
			 programa.setEmitirDiploma(true); // ativa o diploma diretamente
			 System.out.println("Certificado emitido com sucesso!");
		 } else {
			 System.out.println("Ainda não atingiu as 30 horas para o certificado!");
		 }
	 }
	 /**
	   * Consulta e mostra os dados do programa de voluntariado de um estudante.
	   * @author ines
	   */
	   public void consultarProgramaVoluntariado(ProgramaEstudante programa) {
		   System.out.println("=== Programa de Voluntariado ===");
		   System.out.println("Data de fim: " + programa.getDataFim());
		   System.out.println("Horas feitas: " + programa.getHorasFeitas());
		   System.out.println("Diploma emitido: " + (programa.isEmitirDiploma() ? "Sim" : "Não"));
	   }
	   /**
	    * @author gonçalo
	    */
	   public void alterarEstado(Estado novoEstado) {
			if (estado == null){
				estado = new ArrayList<>();
			}
			estado.add(novoEstado);
		}
	   /**
	    * @author gonçalo
	    */
		
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

}//fim classe Gestor

