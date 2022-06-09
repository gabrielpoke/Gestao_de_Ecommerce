package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import VO.Cargo;
import VO.Categoria;

public class CargoDAO extends BaseDAO {
	
	private Cargo vo;
	
	public CargoDAO(Cargo vo) {
		this.vo = vo;
	}
	
	public CargoDAO(){}
	
	
	public Cargo getCargo(){
		return vo;
	}
	
	public void save(Cargo c) throws Exception{
		try {
			abrir();
			String query = " insert into table_cargo (nome, observacao, ativo)"
		    		  + " values (?, ?, ?)";
			
		      PreparedStatement preparedStmt = getConn().prepareStatement(query);
		      preparedStmt.setString (1, c.getNome());  
		      preparedStmt.setString(2, c.getObservacao());
		      preparedStmt.setBoolean(3, c.getAtivo());
		      preparedStmt.execute();
		      fechar();
		}catch (Exception e) {
			throw e;
		}
	}
	
	public void editar(Cargo c) throws Exception{
		try {
			  abrir();	
		      String query = " update table_cargo set nome=?, observacao=?, ativo=? where codigo=?";
		      PreparedStatement preparedStmt = getConn().prepareStatement(query);
		      preparedStmt.setString (1, c.getNome());  
		      preparedStmt.setString(2,c.getObservacao());
		      preparedStmt.setBoolean(3, c.getAtivo());
		      preparedStmt.setInt(4, c.getCodigo()); 
		      preparedStmt.execute();
		      fechar();
			}catch (Exception e) {
				throw e;
			}
	}
	
	public void delete(Cargo c) throws Exception{
		try {
			  abrir();
		      String query = " delete from table_cargo where codigo=?";
		      PreparedStatement preparedStmt = getConn().prepareStatement(query);
		      preparedStmt.setInt(1, c.getCodigo());    
		      preparedStmt.execute();
		      preparedStmt.close();
		      fechar();
		      }catch (Exception e) {
			}
	}
	
	public Cargo load(int codigo) throws Exception{
		try{
			super.abrir();
			
			String sql = "SELECT codigo,nome,observacao,ativo FROM table_cargo where codigo=?";
			  
			PreparedStatement preparedStmt = getConn().prepareStatement(sql);
			preparedStmt.setInt(1, codigo);  
			  
			ResultSet rs =   preparedStmt.executeQuery();
			Cargo p= new Cargo();
			while (rs.next()) { 
				
				p.setCodigo(Integer.parseInt(rs.getString(1)) );
				
				p.setNome(rs.getString(2));	
				
				p.setObservacao(rs.getString(3));
				
				p.setAtivo(rs.getBoolean(4));
				
			}
			
			rs.close();
			return p;
			
			}catch (Exception e) {
				throw e;
			}
	}
	
	public void setCargo(Cargo cargo){
		this.vo = cargo;
	}
	
	public ArrayList<Cargo> getCargos() throws Exception{
		try {
			abrir();
			
			ArrayList <Cargo> lst = new ArrayList();
			
			Statement s = getConn().createStatement(); 
			
			String sql = "SELECT codigo,nome,observacao,ativo FROM table_cargo";
			
			ResultSet rs = s.executeQuery(sql);
		
			while (rs.next()) { 
				Cargo p= new Cargo();
				
				p.setCodigo(rs.getInt(1));
				
				p.setNome(rs.getString(2));	
				
				p.setObservacao(rs.getString(3));
				
				p.setAtivo(rs.getBoolean(4));
				
				lst.add(p);
				
			}
		
			return lst;
		
		}catch (Exception e) {
			throw e;
		}

	}
}
