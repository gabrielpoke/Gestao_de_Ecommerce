package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import VO.Cargo;
import VO.Cliente;
import VO.Colaborador;

public class ColaboradorDAO extends BaseDAO{
	
	private Colaborador vo;
	
	public ColaboradorDAO(){}
	
	public ColaboradorDAO(Colaborador colaborador){
		this.vo = colaborador;
	}
	
	public void save(Colaborador c) throws Exception{
		try {
			  abrir();		
		      String query = " insert into table_colaborador (nome, codigo_cargo, email, observacao, ativo)"
		    		  + " values (?, ?, ?, ?, ?)";
		      PreparedStatement preparedStmt = getConn().prepareStatement(query);
		      preparedStmt.setString (1, c.getNome()); 
		      preparedStmt.setInt(2, c.getCargo().getCodigo());
		      preparedStmt.setString(3, c.getEmail());
		      preparedStmt.setString(4, c.getObservacao());
		      preparedStmt.setBoolean(5, c.getAtivo());
		      preparedStmt.execute();
		      fechar();
		}catch (Exception e) {
			throw e;
		}
	}
	
	public void delete(Colaborador c) throws Exception{
		try {
			  abrir();
		      String query = " delete from table_colaborador where codigo=?";
		      PreparedStatement preparedStmt = getConn().prepareStatement(query);
		      preparedStmt.setInt(1, c.getCodigo());    
		      preparedStmt.execute();
		      preparedStmt.close();
		      fechar();
		      }catch (Exception e) {
			
		      }
	}
	
	public void editar(Colaborador colaborador) throws Exception{
		try {
			  abrir();	
		      
			  String query = " update table_colaborador set nome=?, codigo_cargo=?, email=?, observacao=?, ativo=? where codigo=?";
		      
		      PreparedStatement preparedStmt = getConn().prepareStatement(query);
		      
		      preparedStmt.setString (1, colaborador.getNome()); 
		      
		      preparedStmt.setInt(2, colaborador.getCargo().getCodigo());
		      
		      preparedStmt.setString(3, colaborador.getEmail());
		      
		      preparedStmt.setString(4, colaborador.getObservacao());
		      
		      preparedStmt.setBoolean(5, colaborador.getAtivo());
		      
		      preparedStmt.setInt(6, colaborador.getCodigo());
		      
		      preparedStmt.execute();
		      
		      fechar();
			}catch (Exception e) {
				throw e;
			}
	}
	
	public Colaborador load(int codigo) throws Exception{
		try {
			super.abrir();
			
			String sql = "SELECT codigo, nome, codigo_cargo, email, observacao, ativo FROM table_colaborador where codigo=?";
			  
			PreparedStatement preparedStmt = getConn().prepareStatement(sql);
			preparedStmt.setInt(1, codigo);  
			  
			ResultSet rs =   preparedStmt.executeQuery();
			Colaborador p= new Colaborador();
			Cargo c = new Cargo();
			
			while (rs.next()) { 
				
				p.setCodigo(Integer.parseInt(rs.getString(1)));
				
				p.setNome(rs.getString(2));	
				
				c.setCodigo(rs.getInt(3));
				
				p.setCargo(c);
				
				p.setEmail(rs.getString(4));
				
				p.setEmail(rs.getString(4));
				
				p.setObservacao(rs.getString(5));
				
				p.setAtivo(rs.getBoolean(6));
				
			}
			
			rs.close();
			return p;
			
			}catch (Exception e) {
				throw e;
			}
	}
	
	public ArrayList<Colaborador> getAllColaboradores() throws Exception{
		try {
			abrir();
			
			ArrayList <Colaborador> lst = new ArrayList();
			
			Statement s = getConn().createStatement(); 
			
			String sql = "SELECT p.codigo, p.nome, c.nome, p.email, p.observacao, p.ativo FROM table_colaborador p INNER JOIN table_cargo c WHERE p.codigo_cargo = c.codigo";
			
			ResultSet rs = s.executeQuery(sql);
		
			while (rs.next()) { 
				Colaborador p= new Colaborador();
				Cargo c = new Cargo();
				
				p.setCodigo(Integer.parseInt(rs.getString(1)));
				
				p.setNome(rs.getString(2));	
				
				c.setNome(rs.getString(3));
				
				p.setCargo(c);
				
				p.setEmail(rs.getString(4));
				
				p.setObservacao(rs.getString(5));
				
				p.setAtivo(rs.getBoolean(6));
				
				lst.add(p);
				
			}
		
			return lst;
		
		}catch (Exception e) {
			throw e;
		}
        
	}

	public Colaborador getColaborador(){
		return vo;
	}
	
	public void setColaborador(Colaborador colaborador){
		this.vo = colaborador;
	}

	public Colaborador findByIdColaborador(int codigo) throws Exception{
		super.abrir();
		
		String sql = "SELECT C.codigo FROM table_colaborador C WHERE codigo=?";
		  
		PreparedStatement preparedStmt = getConn().prepareStatement(sql);
		preparedStmt.setInt(1, codigo);  
		  
		ResultSet rs =   preparedStmt.executeQuery();
		Colaborador colaborador = new Colaborador();
		
		while (rs.next()) { 
			colaborador.setCodigo(Integer.parseInt(rs.getString(1)) );	
		}
		
		rs.close();
		return colaborador;
	}
}
