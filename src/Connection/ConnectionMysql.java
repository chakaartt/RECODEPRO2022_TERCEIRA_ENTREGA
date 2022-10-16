package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMysql {

	// nome do usuario no mysql 
		public static final String USERNAME = "root";

		// senha do bando de dados
		public static final String SENHA = "Priscil@213@1";

		// caminho do banco de dados . porta
		public static final String URL = "jdbc:mysql://localhost:3306/agencia_viagem";
		
		/*
		 * CONEXÃO COM BANCO DE DADOS
		 */
		public static Connection createConnectionMySQL() throws Exception {
			// faz com o que a Class seja carregada pela JVM
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//CRIA UMA CONEXÃO COM BANCO DE DADOS
			Connection connection = DriverManager.getConnection(URL,USERNAME,SENHA);
			
			return connection;
	}
		public static void  main (String[] args) throws Exception {
			//recuperar uma conexão com banco de dados
			Connection con = createConnectionMySQL();
			
			//testa a conexao for nula
			if(con!=null) {
				System.out.println("conexão obtida com sucesso");
				con.close();
			}
			
		}
}
