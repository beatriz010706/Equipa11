package equipa11;
/**
 * 
 */

import java.util.ArrayList;

//a classe "Session" representa uma ligação entre a aplicação e a base de dados.
//através da "sessão" fazemos operações: guardar, atualizar, eliminar e consultar objetos.
import org.hibernate.Session;

//"SessionFactory" é responsável por criar objetos do tipo Session.
//é como uma “fábrica” de sessões para comunicar com a base de dados.
import org.hibernate.SessionFactory;

//"Configuration" é usada para configurar o hibernate
//lê o ficheiro 'hibernate.cfg.xml' e cria a SessionFactory com base nas definições que estão no ficheiro
import org.hibernate.cfg.Configuration;

public class Gestor {
	// Criação da SessionFactory
    private SessionFactory factory;
	
    private ArrayList<Estudante> estudantes;
    private ArrayList<Parceiro> parceiros;
    private ArrayList<Tipo> tipos;
    private ArrayList<ProgramaVoluntariado> programaV;
    private ArrayList<Utilizador> utilizadores;
    private ArrayList<ProgramaEstudante> programaE;
    private ArrayList<Estado> estado;

    // construtor
    public Gestor() {
        this.estudantes = new ArrayList<>();
        this.parceiros = new ArrayList<>();
        this.tipos = new ArrayList<>();
        this.utilizadores = new ArrayList<>();
        this.programaV = new ArrayList<>();
        this.programaE = new ArrayList<>();
        this.estado = new ArrayList<>();

        try {
            factory = new Configuration().configure().buildSessionFactory();
            System.out.println("Hibernate SessionFactory criada com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao criar SessionFactory:");
            e.printStackTrace();
        }
    }
		
	/**
	 * metodo para registar um ESTUDANTE
	 * @author beatriz silva
	 */
    // ESTUDANTES 
    public boolean registarEstudante(String nome, String email, String password, String curso, int idade) {
        for (Estudante e : estudantes) {
            if (e.getEmail().equals(email)) {
                System.out.println("Email já registado");
                return false;
            }
        }
        Estudante novoEstudante = new Estudante(nome, email, password, curso, idade);
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.persist(novoEstudante);
            session.getTransaction().commit();
            System.out.println("Estudante guardado na base de dados!");
        }
        estudantes.add(novoEstudante);
        System.out.println("Estudante registado com sucesso");
        return true;
    }
	
	/**
	 * método para registar um parceiro
	 * @author beatriz silva
	 */
    //  PARCEIROS 
    public boolean registarParceiro(String nome, String email, String password, String local) {
        for (Parceiro p : parceiros) {
            if (p.getEmail().equals(email)) {
                System.out.println("Email já registado");
                return false;
            }
        }
        Parceiro novoParceiro = new Parceiro(nome, email, password, local);
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.persist(novoParceiro);
            session.getTransaction().commit();
            System.out.println("Parceiro guardado na base de dados!");
        }
        parceiros.add(novoParceiro);
        System.out.println("Parceiro registado com sucesso");
        return true;
    }
	
	/**
	 * método para login (Estudante ou Parceiro)
	 * @author beatriz silva
	 */
    // LOGIN 
    public Utilizador login(String email, String password) {
        for (Estudante e : estudantes) {
            if (e.getEmail().equals(email) && e.getPassword().equals(password)) {
                System.out.println("Login de ESTUDANTE efetuado com sucesso");
                return e;
            }
        }
        for (Parceiro p : parceiros) {
            if (p.getEmail().equals(email) && p.getPassword().equals(password)) {
                System.out.println("Login de PARCEIRO efetuado com sucesso");
                return p;
            }
        }
        System.out.println("Email ou password incorretos");
        return null;
    }
	
	/**
	  * Regista um novo tipo de parceiro 
	  * @author Diogo
	  */
    // TIPOS 
    public void registoTipo(String descricaoTipo) {
        Tipo novoTipo = new Tipo();
        novoTipo.setDescricaoTipo(descricaoTipo); // corrigido acentuação
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.persist(novoTipo);
            session.getTransaction().commit();
            System.out.println("Tipo guardado na base de dados!");
        }
        tipos.add(novoTipo);
        System.out.println("Tipo: " + descricaoTipo + " registado com sucesso!");
    }

    public void imprimirParceiroPorTipo(String descricaoTipo) {
        for (Tipo t : tipos) {
            if (t.getDescriçaoTipo() != null && t.getDescriçaoTipo().equalsIgnoreCase(descricaoTipo)) {
                System.out.println("Parceiros do tipo: " + descricaoTipo);
                for (Parceiro p : t.getTipoParceiros()) {
                    System.out.println(p);
                }
                return;
            }
        }
        System.out.println("Tipo: " + descricaoTipo + " não encontrado!");
    }

	  /**
	   * metodo para criar um programa
	   * @author miguel silva
	   */ 
	  public void criarPrograma(String titulo, String descricao, int horasServiço, String local, int vagas) {
		  ProgramaVoluntariado novoPrograma = new ProgramaVoluntariado(titulo, descricao, horasServiço, local, vagas);
		  try (Session session = factory.openSession()) {
	            session.beginTransaction();
	            session.persist(novoPrograma);
	            session.getTransaction().commit();
	            System.out.println("Programa guardado na base de dados!");
	      }
		  getProgramaV().add(novoPrograma);
		  System.out.println("Programa criado com sucesso: "+ titulo);  
	  }
	  
	  /**
	   * metodo para editar um programa
	   * @author miguel silva
	   */ 
	  
	// PROGRAMAS
	    public void criarProgramaV(String titulo, String descricao, int horasServico, String local, int vagas) {
	        ProgramaVoluntariado novoPrograma = new ProgramaVoluntariado(titulo, descricao, horasServico, local, vagas);
	        try (Session session = factory.openSession()) {
	            session.beginTransaction();
	            session.persist(novoPrograma);
	            session.getTransaction().commit();
	            System.out.println("Programa guardado na base de dados!");
	        }
	        programaV.add(novoPrograma);
	        System.out.println("Programa criado com sucesso: " + titulo);
	    }

	    public void editarPrograma(String tituloAntigo, String novoTitulo, String novaDescricao, int novasHorasServico,
	                               String novoLocal, int novasVagas) {
	        for (ProgramaVoluntariado p : programaV) {
	            if (p.getTitulo().equalsIgnoreCase(tituloAntigo)) {
	                p.setTitulo(novoTitulo);
	                p.setDescricao(novaDescricao);
	                p.setHorasServico(novasHorasServico);
	                p.setLocal(novoLocal);
	                p.setVagas(novasVagas);
	                System.out.println("Programa: " + tituloAntigo + " editado com sucesso!");
	                return;
	            }
	        }
	        System.out.println("Programa com título: " + tituloAntigo + " não encontrado!");
	    }

	    public void eliminarPrograma(String titulo) {
	        for (int i = 0; i < programaV.size(); i++) {
	            if (programaV.get(i).getTitulo().equalsIgnoreCase(titulo)) {
	                programaV.remove(i);
	                System.out.println("Programa: " + titulo + " eliminado com sucesso!");
	                return;
	            }
	        }
	        System.out.println("Programa: " + titulo + " não encontrado!");
	    }

	    public void imprimirProgramas() {
	        if (programaV.isEmpty()) {
	            System.out.println("Não existem programas registados.");
	        } else {
	            System.out.println("Lista de Programas:");
	            for (ProgramaVoluntariado p : programaV) {
	                System.out.println("Titulo: " + p.getTitulo() + " | Local: " + p.getLocal() + " | Vagas: " + p.getVagas());
	            }
	        }
	    }
	  /**
	   * Regista um novo programa de voluntariado para um estudante.
	   * @author ines 
	   */
	  
	 // PROGRAMAS DE ESTUDANTE 
	    public void adicionarPrograma(ProgramaEstudante p) {
	        programaE.add(p);
	        System.out.println("Programa de voluntariado registado com sucesso!");
	    }

	    public void registarHoras(ProgramaEstudante programa, int horasAdicionais) {
	        int total = programa.getHorasFeitas() + horasAdicionais;
	        programa.setHorasFeitas(total);
	        System.out.println("Horas registadas com sucesso! Total atual: " + total + " horas.");
	        if (total >= 30 && !programa.isEmitirDiploma()) {
	            emitirCertificado(programa);
	        }
	    }

	    public void emitirCertificado(ProgramaEstudante programa) {
	        if (programa.getHorasFeitas() >= 30) {
	            programa.setEmitirDiploma(true);
	            System.out.println("Certificado emitido com sucesso!");
	        } else {
	            System.out.println("Ainda não atingiu as 30 horas para o certificado!");
	        }
	    }

	    public void consultarProgramaVoluntariado(ProgramaEstudante programa) {
	        System.out.println("=== Programa de Voluntariado ===");
	        System.out.println("Data de fim: " + programa.getDataFim());
	        System.out.println("Horas feitas: " + programa.getHorasFeitas());
	        System.out.println("Diploma emitido: " + (programa.isEmitirDiploma() ? "Sim" : "Não"));
	    }
	   
	   /**
	    * @author gonçalo
	    */
	 // ESTADOS
	    public void alterarEstado(Estado novoEstado) {
	        if (estado == null) {
	            estado = new ArrayList<>();
	        }
	        estado.add(novoEstado);
	    }

	    public void imprimirporEstado() {
	        ArrayList<Estado> aceite = new ArrayList<>();
	        ArrayList<Estado> andamento = new ArrayList<>();
	        ArrayList<Estado> recusado = new ArrayList<>();
	        for (Estado i : estado) {
	            if (i.getEstadoCandidatura().equalsIgnoreCase("Aceite")) {
	                aceite.add(i);
	            } else if (i.getEstadoCandidatura().equalsIgnoreCase("Em andamento")) {
	                andamento.add(i);
	            } else if (i.getEstadoCandidatura().equalsIgnoreCase("Recusada")) {
	                recusado.add(i);
	            }
	        }
	        System.out.println("Aceite: " + aceite);
	        System.out.println("Em andamento: " + andamento);
	        System.out.println("Recusada: " + recusado);
	    }

	    // GETS E SETS
	    public ArrayList<ProgramaEstudante> getProgramaE() { return programaE; }
	    public void setProgramaE(ArrayList<ProgramaEstudante> programaE) { this.programaE = programaE; }

	    public ArrayList<ProgramaVoluntariado> getProgramaV() { return programaV; }
	    public void setProgramaV(ArrayList<ProgramaVoluntariado> programaV) { this.programaV = programaV; }

	    public ArrayList<Estudante> getEstudantes() { return estudantes; }
	    public void setEstudantes(ArrayList<Estudante> estudantes) { this.estudantes = estudantes; }
	    
	   // FECHAR CONEXÃO 
	    public void fecharConexao() {
	        if (factory != null) {
	            factory.close();
	            System.out.println("Ligação ao Hibernate terminada.");
	        }
	    }

}//fim classe Gestor

