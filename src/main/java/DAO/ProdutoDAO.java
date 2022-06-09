package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import VO.Cargo;
import VO.Categoria;
import VO.Colaborador;
import VO.Produto;

public class ProdutoDAO extends BaseDAO{
	private Produto vo;
	
	public ProdutoDAO(){}
	
	public ProdutoDAO(Produto produto){
		this.vo = produto;
	}
	
	public void save(Produto produto) throws Exception{
		try {
			  abrir();		
		      String query = " insert into table_produto (nome, codigo_categoria, valor, quantidade, observacao, ativo)"
		    		  + " values (?, ?, ?, ?, ?, ?)";
		      PreparedStatement preparedStmt = getConn().prepareStatement(query);
		      preparedStmt.setString (1, produto.getNome()); 
		      preparedStmt.setInt(2,produto.getCategoria().getCodigo());
		      preparedStmt.setDouble(3, produto.getPreco());
		      preparedStmt.setInt(4, produto.getQuantidade());
		      preparedStmt.setString(5, produto.getDescricao());
		      preparedStmt.setBoolean(6, produto.getAtivo());
		      preparedStmt.execute();
		      fechar();
		}catch (Exception e) {
			throw e;
		}
	}
	
	public void delete(Produto produto) throws Exception{
		try {
			  abrir();
		      String query = " delete from table_produto where codigo=?";
		      PreparedStatement preparedStmt = getConn().prepareStatement(query);
		      preparedStmt.setInt(1, produto.getCodigo());    
		      preparedStmt.execute();
		      preparedStmt.close();
		      fechar();
		      }catch (Exception e) {
			
		      }
	}
	
	public void editar(Produto produto) throws Exception{
		try {
			  abrir();	
		      
			  String query = " update table_produto set nome=?, codigo_categoria=?, valor=?, quantidade=?, observacao=?, ativo=? where codigo=?";
		      
		      PreparedStatement preparedStmt = getConn().prepareStatement(query);
		      
		      preparedStmt.setString (1, produto.getNome()); 
		      
		      preparedStmt.setInt(2, produto.getCategoria().getCodigo());
		      
		      preparedStmt.setDouble(3,produto.getPreco());
		      
		      preparedStmt.setInt(4, produto.getQuantidade());
		      
		      preparedStmt.setString(5, produto.getDescricao());
		      
		      preparedStmt.setBoolean(6, produto.getAtivo());
		      
		      preparedStmt.setInt(7, produto.getCodigo());
		      
		      preparedStmt.execute();
		      
		      fechar();
			}catch (Exception e) {
				throw e;
			}
	}
	
	public Produto load(int codigo) throws Exception{
		try {
			super.abrir();
			
			String sql = "SELECT codigo, nome, codigo_categoria, valor, quantidade, observacao, ativo FROM table_produto where codigo=?";
			  
			PreparedStatement preparedStmt = getConn().prepareStatement(sql);
			preparedStmt.setInt(1, codigo);  
			  
			ResultSet rs =   preparedStmt.executeQuery();
			Produto p= new Produto();
			Categoria categoria = new Categoria();
			
			while (rs.next()) { 
				
				p.setCodigo(Integer.parseInt(rs.getString(1)));
				
				p.setNome(rs.getString(2));	
				
				categoria.setCodigo(rs.getInt(3));
				
				p.setCategoria(categoria);
				
				p.setPreco(rs.getDouble(4));
				
				p.setQuantidade(rs.getInt(5));
				
				p.setDescricao(rs.getString(6));
				
				p.setAtivo(rs.getBoolean(7));
				
				
			}
			
			rs.close();
			return p;
			
			}catch (Exception e) {
				throw e;
			}
	}
	
	public ArrayList<Produto> getProdutos() throws Exception{
		try {
			abrir();
			
			ArrayList <Produto> lst = new ArrayList();
			
			Statement s = getConn().createStatement(); 
			
			String sql = "SELECT p.codigo, p.nome, c.nome, p.observacao, p.valor, p.quantidade, p.ativo FROM table_produto p INNER JOIN  table_categoria c WHERE p.codigo_categoria = c.codigo;";
			
			ResultSet rs = s.executeQuery(sql);
		
			while (rs.next()) { 
				Produto p= new Produto();
				Categoria categoria = new Categoria();
				
				p.setCodigo(Integer.parseInt(rs.getString(1)));
				
				p.setNome(rs.getString(2));	
				
				categoria.setNome(rs.getString(3));
				
				p.setCategoria(categoria);
				
				p.setDescricao(rs.getString(4));
				
				p.setPreco(rs.getDouble(5));
				
				p.setQuantidade(rs.getInt(6));
				
				p.setAtivo(rs.getBoolean(7));
				
				lst.add(p);
				
			}
		
			return lst;
		
		}catch (Exception e) {
			throw e;
		}
	}

	public void setProduto(Produto produto){
		this.vo = produto;
	}
	
	public Produto getProduto(){
		return vo;
	}
}
