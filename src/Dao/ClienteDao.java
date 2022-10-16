package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import Connection.ConnectionMysql;
import modelo.Cliente;

public class ClienteDao {
	
	public void save(Cliente cliente) {
		String sql = "INSERT INFO cliente (nome_cliente, email_cliente,senha_cliente) VALUES \r\n" + "(?,?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMysql.createConnectionMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, cliente.getNome_cliente());
			pstm.setString(2, cliente.getEmail_cliente());
			pstm.setString(3, cliente.getSenha_cliente());
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {

			// fecha conexões

			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	// metodo read 
	
	public List<Cliente> getCliente (){
		String sql = "SELECT * FROM cliente ";
		
		List<Cliente> cliente = new ArrayList<Cliente>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionMysql.createConnectionMySQL();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Cliente cliente1 = new Cliente();
				
				cliente1.setId_cliente(rset.getInt("id_cliente"));
				cliente1.setNome_cliente(rset.getString("nome_cliente"));
				cliente1.setEmail_cliente(rset.getString("email_cliente"));
				cliente1.setSenha_cliente(rset.getString("senha_cliente"));
				
				cliente.add(cliente1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(rset != null) {
					rset.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return cliente;
	}
	
// metodo update
	
	public void update (Cliente cliente) {
		String sql = "UPDATE cliente SET nome_cliente = ?,email_cliente = ?,senha_cliente = ?, WHERE id_cliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMysql.createConnectionMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, cliente.getNome_cliente());
			pstm.setString(2, cliente.getEmail_cliente());
			pstm.setString(3, cliente.getSenha_cliente());
			pstm.setInt(4, cliente.getId_cliente());
			
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	
	}
	
 public void deleteById (int id_cliente) {
	 
	 String sql = "DELETE FROM cliente WHERE id_cliente = ?";
	 
	 Connection conn = null;
	 PreparedStatement pstm = null;
	 
	 try {
		 conn = ConnectionMysql.createConnectionMySQL();
			
		 pstm = (PreparedStatement) conn.prepareStatement(sql);
		 
		 pstm.setInt(1,id_cliente);
		 
		 pstm.execute();
	 }catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm != null) {
				pstm.close();
			} 	if (conn != null) {
				conn.close();
			}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
