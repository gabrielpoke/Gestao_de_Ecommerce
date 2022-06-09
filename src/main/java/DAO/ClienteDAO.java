package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import VO.Categoria;
import VO.Cliente;

public class ClienteDAO extends BaseDAO {
	
	private Cliente vo;
	
	public ClienteDAO(Cliente vo){
		this.vo = vo;
	}
	
	public ClienteDAO(){}

	public void delete(Cliente c) throws Exception {
		try {
			  abrir();
		      String query = " delete from table_cliente where codigo=?";
		      PreparedStatement preparedStmt = getConn().prepareStatement(query);
		      preparedStmt.setInt(1, c.getCodigo());    
		      preparedStmt.execute();
		      preparedStmt.close();
		      fechar();
		      }catch (Exception e) {
			
		      }
	}
	
	public void save(Cliente c) throws Exception {
		try {
			  abrir();		
		      String query = " insert into table_cliente (nome, email, telefone, enderco, bairro, cidade, cep, cpf, ativo)"
		    		  + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		      PreparedStatement preparedStmt = getConn().prepareStatement(query);
		      preparedStmt.setString (1, c.getNome());  
		      preparedStmt.setString(2, c.getEmail());
		      preparedStmt.setString(3, c.getTelefone());
		      preparedStmt.setString(4, c.getEndereco());
		      preparedStmt.setString(5, c.getBairro());
		      preparedStmt.setString(6, c.getCidade());
		      preparedStmt.setInt(7, c.getCep());
		      preparedStmt.setInt(8, c.getCpf());
		      preparedStmt.setBoolean(9, c.getAtivo());
		      preparedStmt.execute();
		      fechar();
		}catch (Exception e) {
			throw e;
		}
	}
	
	public void editar(Cliente c) throws Exception{
		try {
			  abrir();	
		      String query = " update table_cliente set nome=?, email=?, telefone=?,enderco=?, bairro=?, cidade=?, cep=?, cpf=?, ativo=? where codigo=?";
		      PreparedStatement preparedStmt = getConn().prepareStatement(query);
		      preparedStmt.setString (1, c.getNome());  
		      preparedStmt.setString(2,c.getEmail());
		      preparedStmt.setString(3,c.getTelefone());
		      preparedStmt.setString(4,c.getEndereco());
		      preparedStmt.setString(5,c.getBairro());
		      preparedStmt.setString(6,c.getCidade());
		      preparedStmt.setInt(7,c.getCep());
		      preparedStmt.setInt(8,c.getCpf());
		      preparedStmt.setBoolean(9,c.getAtivo());
		      preparedStmt.setInt(10, c.getCodigo()); 
		      preparedStmt.execute();
		      fechar();
			}catch (Exception e) {
				throw e;
			}
	}
	
	public Cliente load(int codigo) throws Exception{
		try {
			super.abrir();
			
			String sql = "SELECT codigo, nome, email, telefone, enderco, bairro, cidade, cep, cpf, ativo FROM table_cliente where codigo=?";
			  
			PreparedStatement preparedStmt = getConn().prepareStatement(sql);
			preparedStmt.setInt(1, codigo);  
			  
			ResultSet rs =   preparedStmt.executeQuery();
			Cliente p= new Cliente();
			while (rs.next()) { 
				
				p.setCodigo(Integer.parseInt(rs.getString(1)) );
				
				p.setNome(rs.getString(2));	
				
				p.setEmail(rs.getString(3));
				
				p.setTelefone(rs.getString(4));
				
				p.setEndereco(rs.getString(5));
				
				p.setBairro(rs.getString(6));
				
				p.setCidade(rs.getString(7));
				
				p.setCep(rs.getInt(8));
				
				p.setCpf(rs.getInt(9));
				
				p.setAtivo(rs.getBoolean(10));
				
			}
			
			rs.close();
			return p;
			
			}catch (Exception e) {
				throw e;
			}
	}
	
	public Cliente getCliente(){
		return vo;
	}
	
	public void setCliente(Cliente cliente){
		this.vo = cliente;
	}

	public ArrayList<Cliente> getAllClientes() throws Exception{
		
		try {
			abrir();
			
			ArrayList <Cliente> lst = new ArrayList();
			
			Statement s = getConn().createStatement(); 
			
			String sql = "SELECT codigo, nome, email, telefone, enderco, bairro, cidade, cep, cpf, ativo FROM table_cliente";
			
			ResultSet rs = s.executeQuery(sql);
		
			while (rs.next()) { 
				Cliente p= new Cliente();
				
				p.setCodigo(rs.getInt(1));
				
				p.setNome(rs.getString(2));	
				
				p.setEmail(rs.getString(3));
				
				p.setTelefone(rs.getString(4));
				
				p.setEndereco(rs.getString(5));
				
				p.setBairro(rs.getString(6));
				
				p.setCidade(rs.getString(7));
				
				p.setCep(rs.getInt(8));
				
				p.setCpf(rs.getInt(9));
				
				p.setAtivo(rs.getBoolean(10));
				
				lst.add(p);
				
			}
		
			return lst;
		
		}catch (Exception e) {
			throw e;
		}
	}
}
