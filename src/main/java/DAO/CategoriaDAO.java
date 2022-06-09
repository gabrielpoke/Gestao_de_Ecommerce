package DAO;
import java.util.ArrayList;

import javax.servlet.ServletException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import VO.Categoria;
import VO.Produto;

public class CategoriaDAO extends BaseDAO {
	
	private Categoria vo;
	
	public CategoriaDAO(Categoria vo) {
		this.vo = vo;
	}
	
	public CategoriaDAO(){}
	
	public Categoria getCategoria(){
		return vo;
	}
	
	public Categoria load(int codigo) throws Exception{
		try {
		super.abrir();
		
		String sql = "SELECT codigo,nome,descricao FROM table_categoria where codigo=?";
		  
		PreparedStatement preparedStmt = getConn().prepareStatement(sql);
		preparedStmt.setInt(1, codigo);  
		  
		ResultSet rs =   preparedStmt.executeQuery();
		Categoria p= new Categoria();
		while (rs.next()) { 
			p.setCodigo(Integer.parseInt(rs.getString(1)) );
			p.setNome(rs.getString(2));	
			p.setDescricao(rs.getString(3));
			
		}
		
		rs.close();
		return p;
		
		}catch (Exception e) {
			throw e;
		}
	}
	
	public void setCategoria(Categoria categoria){
		this.vo = categoria;
	}
	
	public ArrayList<Categoria> getCategorias() throws Exception {		

		
		try {
			abrir();
			
			ArrayList <Categoria> lst = new ArrayList();
			
			Statement s = getConn().createStatement(); 
			
			String sql = "SELECT codigo,nome,descricao FROM table_categoria";
			
			ResultSet rs = s.executeQuery(sql);
		
			while (rs.next()) { 
				Categoria p= new Categoria();
				
				p.setCodigo(rs.getInt(1));
				
				p.setNome(rs.getString(2));	
				
				p.setDescricao(rs.getString(3));
				
				lst.add(p);
				
			}
		
			return lst;
		
		}catch (Exception e) {
			throw e;
		}
		
	}
	
	public ArrayList<Categoria> findCategorias(String nome)  throws Exception{
			
		try {
			super.abrir();
			ArrayList <Categoria> lst = new ArrayList();
			String sql = "SELECT codigo,nome FROM table_categoria where nome like ?";
			PreparedStatement preparedStmt = getConn().prepareStatement(sql);
			preparedStmt.setString (1, nome+'%');  
			ResultSet rs =   preparedStmt.executeQuery();
			while (rs.next()) { 
				Categoria p= new Categoria();
				p.setCodigo(Integer.parseInt(rs.getString(1)) );
				p.setNome(rs.getString(2));		
				lst.add(p);
			}
			
			preparedStmt.close();
			rs.close();
			fechar();
			return lst;}catch (Exception e) {
				throw new ServletException(e.getMessage());			}
	}

	public void save(Categoria p) throws Exception {
		try {
			  abrir();		
		      String query = " insert into table_categoria (nome, descricao)"
		    		  + " values (?, ?)";
		      PreparedStatement preparedStmt = getConn().prepareStatement(query);
		      preparedStmt.setString (1, p.getNome());  
		      preparedStmt.setString(2, p.getDescricao());
		      preparedStmt.execute();
		      fechar();
		}catch (Exception e) {
			throw e;
		}
		
	}
	
	public void editar(Categoria p)  throws Exception{
		try {
		  abrir();	
	      String query = " update table_categoria set nome=?, descricao=? where codigo=?";
	      PreparedStatement preparedStmt = getConn().prepareStatement(query);
	      preparedStmt.setString (1, p.getNome());  
	      preparedStmt.setString(2,p.getDescricao());
	      preparedStmt.setInt(3, p.getCodigo()); 
	      preparedStmt.execute();
	      fechar();
		}catch (Exception e) {
			throw e;
		}
		
	}
	
	public void delete(Categoria p) throws Exception{
		try {
		  abrir();
	      String query = " delete from table_categoria where codigo=?";
	      PreparedStatement preparedStmt = getConn().prepareStatement(query);
	      preparedStmt.setInt(1, p.getCodigo());    
	      preparedStmt.execute();
	      preparedStmt.close();
	      fechar();
	      }catch (Exception e) {
		}
	}

}
