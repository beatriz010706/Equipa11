package equipa11;

import java.util.ArrayList;
import java.util.Scanner;
public class Teste {

	public static void main(String[] args) {
		Scanner ler = new Scanner (System.in);
		Gestor gestor = new Gestor();
		
		// Pré-definidos
        gestor.registarEstudante("Alice", "alice@email.com", "1234", "Eng. Informática", 20);
        gestor.registarParceiro("TechCorp", "techcorp@email.com", "pass", "Porto");
        gestor.registoTipo("Educação");
        
        boolean sair = false;
        while(!sair) {
        	System.out.println(" MENU PRINCIPAL");
            System.out.println("1 - Registar Estudante");
            System.out.println("2 - Registar Parceiro");
            System.out.println("3 - Login");
            System.out.println("4 - Criar Programa");
            System.out.println("5 - Editar Programa");
            System.out.println("6 - Eliminar Programa");
            System.out.println("7 - Registar Tipo");
            System.out.println("8 - Imprimir Parceiros por Tipo");
            System.out.println("9 - Listar Programas");
            System.out.println("10 - Adicionar Programa a Estudante");
            System.out.println("11 - Registar Horas");
            System.out.println("12 - Emitir Certificado");
            System.out.println("13 - Consultar Programa Voluntariado");
            System.out.println("14 - Alterar Estado");
            System.out.println("15 - Imprimir por Estado");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = ler.nextInt();
            ler.nextLine(); // Consumir o \n

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nomeE = ler.nextLine();
                    System.out.print("Email: ");
                    String emailE = ler.nextLine();
                    System.out.print("Password: ");
                    String passE = ler.nextLine();
                    System.out.print("Curso: ");
                    String curso = ler.nextLine();
                    System.out.print("Idade: ");
                    int idade = ler.nextInt();
                    ler.nextLine();
                    gestor.registarEstudante(nomeE, emailE, passE, curso, idade);
                    break;

                case 2:
                    System.out.print("Nome: ");
                    String nomeP = ler.nextLine();
                    System.out.print("Email: ");
                    String emailP = ler.nextLine();
                    System.out.print("Password: ");
                    String passP = ler.nextLine();
                    System.out.print("Local: ");
                    String local = ler.nextLine();
                    gestor.registarParceiro(nomeP, emailP, passP, local);
                    break;

                case 3:
                    System.out.print("Email: ");
                    String loginEmail = ler.nextLine();
                    System.out.print("Password: ");
                    String loginPass = ler.nextLine();
                    gestor.login(loginEmail, loginPass);
                    break;

                case 4:
                    System.out.print("Titulo do Programa: ");
                    String titulo = ler.nextLine();
                    System.out.print("Descrição: ");
                    String desc = ler.nextLine();
                    System.out.print("Horas de Serviço: ");
                    int horas = ler.nextInt();
                    ler.nextLine();
                    System.out.print("Local: ");
                    String localP = ler.nextLine();
                    System.out.print("Vagas: ");
                    int vagas = ler.nextInt();
                    ler.nextLine();
                    gestor.criarPrograma(titulo, desc, horas, localP, vagas);
                    break;

                case 5:
                    System.out.print("Título antigo: ");
                    String tituloAntigo = ler.nextLine();
                    System.out.print("Novo título: ");
                    String novoTitulo = ler.nextLine();
                    System.out.print("Nova descrição: ");
                    String novaDesc = ler.nextLine();
                    System.out.print("Novas horas: ");
                    int novasHoras = ler.nextInt();
                    ler.nextLine();
                    System.out.print("Novo local: ");
                    String novoLocal = ler.nextLine();
                    System.out.print("Novas vagas: ");
                    int novasVagas = ler.nextInt();
                    ler.nextLine();
                    gestor.editarPrograma(tituloAntigo, novoTitulo, novaDesc, novasHoras, novoLocal, novasVagas);
                    break;

                case 6:
                    System.out.print("Título do programa a eliminar: ");
                    String tituloDel = ler.nextLine();
                    gestor.eliminarPrograma(tituloDel);
                    break;

                case 7:
                    System.out.print("Descrição do Tipo: ");
                    String tipoDesc = ler.nextLine();
                    gestor.registoTipo(tipoDesc);
                    break;

                case 8:
                    System.out.print("Descrição do Tipo para listar parceiros: ");
                    String tipoList = ler.nextLine();
                    gestor.imprimirParceiroPorTipo(tipoList);
                    break;

                case 9:
                    gestor.imprimirProgramas();
                    break;

                case 10:
                    // Adicionar programa a estudante: usar o primeiro estudante da lista
                    if (!gestor.getProgramaV().isEmpty() && !gestor.getEstudantes().isEmpty()) {
                        ProgramaEstudante pe = new ProgramaEstudante("2025-12-31", 0, false);
                        gestor.adicionarPrograma(pe);
                    } else {
                        System.out.println("Não existem programas ou estudantes para adicionar.");
                    }
                    break;

                case 11:
                    if (!gestor.getProgramaE().isEmpty()) {
                        System.out.print("Horas a adicionar: ");
                        int h = ler.nextInt();
                        ler.nextLine();
                        gestor.registarHoras(gestor.getProgramaE().get(0), h);
                    } else {
                        System.out.println("Não existem programas de estudantes.");
                    }
                    break;

                case 12:
                    if (!gestor.getProgramaE().isEmpty()) {
                        gestor.emitirCertificado(gestor.getProgramaE().get(0));
                    } else {
                        System.out.println("Não existem programas de estudantes.");
                    }
                    break;

                case 13:
                    if (!gestor.getProgramaE().isEmpty()) {
                        gestor.consultarProgramaVoluntariado(gestor.getProgramaE().get(0));
                    } else {
                        System.out.println("Não existem programas de estudantes.");
                    }
                    break;

                case 14:
                    System.out.print("Novo estado (Aceite/Em andamento/Recusada): ");
                    String est = ler.nextLine();
                    gestor.alterarEstado(new Estado(est));
                    break;

                case 15:
                    gestor.imprimirporEstado();
                    break;

                case 0:
                    sair = true;
                    System.out.println("A sair...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        	
        }//fim while
        
        ler.close();

	}//fim main

}//fim classe teste
