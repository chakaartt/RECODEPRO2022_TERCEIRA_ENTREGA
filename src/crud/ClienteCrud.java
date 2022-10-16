package crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Dao.ClienteDao;
import modelo.Cliente;

public class ClienteCrud {

	public static void main (String[] args) {
		
		ClienteDao clienteDao = new ClienteDao();
		
		Scanner teclado = new Scanner(System.in);
		
		int opcao = 0;
		int posicao = 0;
		int id_cliente = 0;
		
		String nome_cliente = "";
		String email_cliente = "";
		String senha_cliente = "";
		
		List<Cliente> cliente =  new ArrayList<Cliente>();
		
		do {
			System.out.println("--- CRUD PARCEIRO----");
			System.out.println("1 - CADASTRO DO PARCEIRO");
			System.out.println("2 - CONSULTAR PARCEIRO");
			System.out.println("3 - DELETA PARCEIRO");
			System.out.println("4 - ATUALIZAR PARCEIRO");
			System.out.println("0 - SAIR");
			
			opcao = teclado.nextInt();
			teclado.nextLine();
			
			switch (opcao) {
			case 1:
			 System.out.println("**CADASTRO DO PARCEIROS");
			 
			 System.out.println("DIGITE SEU NOME :");
			 nome_cliente = teclado.nextLine();
			 
			 System.out.println("DIGITE SEU E-MAIL :");
			 email_cliente = teclado.nextLine();
			 
			 System.out.println("DIGITE SUA SENHA :");
			 senha_cliente = teclado.nextLine();
			 
			 Cliente client1 = new Cliente();
			 
			 client1.setNome_cliente(nome_cliente);
			 client1.setEmail_cliente(email_cliente);
			 client1.setSenha_cliente(senha_cliente);
			 
			 clienteDao.save(client1);
			 
			 System.out.println("\n***Cadastro**\n");
			 break;
			 
			case 2:
				for (Cliente a : clienteDao.getCliente()) {
					System.out.println("id: " + a.getId_cliente() + " nome: " + a.getNome_cliente());
					
				}

				System.out.println("Finalizada");
				break;
 //-----------------------------------------------------------//
			case 3:
				
				System.out.println("Passe o ID para exclusão: ");
				posicao = teclado.nextInt();
				
				clienteDao.deleteById(posicao);
				System.out.println("Excluindo");
				break;
				
				
			case 4:
				
				System.out.println("Digite o id da Parceiro: ");
				id_cliente = teclado.nextInt();

				System.out.println("Digite o novo nome da Parceiro: ");
				nome_cliente = teclado.next();
				
				System.out.println("Digite um novo email: ");
				email_cliente = teclado.next();
				
				System.out.println("Digite uma nova senha: ");
				senha_cliente = teclado.next();
				
				Cliente cliente2 = new Cliente( id_cliente, nome_cliente, email_cliente, senha_cliente);
				
				clienteDao.update(cliente2);
				System.out.println("Atualizado \n");
				break;

			}// final do switch
		
		
		} while (opcao != 0);
		teclado.close();
		System.out.println("*Finalizado*");
	}
	

}
