package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import VO.Categoria;
import VO.Cliente;
import VO.Colaborador;
import VO.Pedido;
import VO.Produto;

public class PedidoDAO extends BaseDAO{

	private Pedido vo;
	
	public PedidoDAO(){}
	
	public PedidoDAO(Pedido pedido){
		this.vo = pedido;
	}

	public void save(Pedido pedido) throws Exception{
		try {
			  abrir();		
		      String query = " insert into table_pedido (codigo_cliente, codigo_colaborador, codigo_produto)"
		    		  + " values (?, ?, ?)";
		      PreparedStatement preparedStmt = getConn().prepareStatement(query);
		      preparedStmt.setInt(1, pedido.getCliente().getCodigo());
		      preparedStmt.setInt(2, pedido.getColaborador().getCodigo());
		      preparedStmt.setInt(3, pedido.getProduto().getCodigo());
		      preparedStmt.execute();
		      fechar();
		}catch (Exception e) {
			throw e;
		}
	}
	
	public void editar(Pedido pedido) throws Exception{
		try {
			  abrir();	
		      
			  String query = " update table_pedido set codigo_cliente=?, codigo_colaborador=?, codigo_produto=? where codigo=?";
		      
		      PreparedStatement preparedStmt = getConn().prepareStatement(query);     
		      
		      preparedStmt.setInt(1, pedido.getCliente().getCodigo());
		      
		      preparedStmt.setInt(2, pedido.getColaborador().getCodigo());
		      
		      preparedStmt.setInt(3, pedido.getProduto().getCodigo());
		      
		      preparedStmt.setInt(4, pedido.getCodigo());
		      
		      preparedStmt.execute();
		      
		      fechar();
			}catch (Exception e) {
				throw e;
			}
	}
	
	public void delete(Pedido pedido) throws Exception{
		try {
			  abrir();
		      String query = " delete from table_pedido where codigo=?";
		      PreparedStatement preparedStmt = getConn().prepareStatement(query);
		      preparedStmt.setInt(1, pedido.getCodigo());    
		      preparedStmt.execute();
		      preparedStmt.close();
		      fechar();
		      }catch (Exception e) {
			
		      }
	}
	
	public Pedido load(int codigo) throws Exception{
		try {
			super.abrir();
			
			String sql = "SELECT codigo, codigo_cliente, codigo_colaborador, codigo_produto FROM table_pedido where codigo=?";
			  
			PreparedStatement preparedStmt = getConn().prepareStatement(sql);
			preparedStmt.setInt(1, codigo);  
			  
			ResultSet rs =   preparedStmt.executeQuery();
			Pedido p= new Pedido();
			Produto produto = new Produto();
			Colaborador colaborador = new Colaborador();
			Cliente cliente = new Cliente();
			
			while (rs.next()) { 
				
				p.setCodigo(Integer.parseInt(rs.getString(1)));
				
				
				cliente.setCodigo(Integer.parseInt(rs.getString(2)));	
				
				p.setCliente(cliente);
				
				
				colaborador.setCodigo(rs.getInt(3));
				
				p.setColaborador(colaborador);
				
				
				produto.setCodigo(rs.getInt(4));
				
				p.setProduto(produto);

				
			}
			
			rs.close();
			return p;
			
			}catch (Exception e) {
				throw e;
			}
	}
	
	public ArrayList<Pedido> getAllPedidos() throws Exception{
		try {
			abrir();
			
			ArrayList <Pedido> lst = new ArrayList();
			
			Statement s = getConn().createStatement(); 
			
			String sql = "SELECT p.codigo, c.nome, d.nome, t.nome FROM table_pedido p "
					+ " INNER JOIN table_cliente c ON p.codigo_cliente = c.codigo" + 
					" INNER JOIN table_colaborador d ON p.codigo_colaborador = d.codigo" + 
					" INNER JOIN  table_produto t ON p.codigo_produto = t.codigo";
			
			ResultSet rs = s.executeQuery(sql);
		
			while (rs.next()) { 
			
				Pedido p= new Pedido();
				
				Produto produto = new Produto();
				
				Colaborador colaborador = new Colaborador();
				
				Cliente cliente = new Cliente();
				
				p.setCodigo(Integer.parseInt(rs.getString(1)));
				
				cliente.setNome(rs.getString(2));	
				
				p.setCliente(cliente);
				
				colaborador.setNome(rs.getString(3));
				
				p.setColaborador(colaborador);
				
				produto.setNome(rs.getString(4));
				
				p.setProduto(produto);
				
				lst.add(p);
				
			}
		
			return lst;
		
		}catch (Exception e) {
			throw e;
		}
	}

	public void setPedido(Pedido pedido){
		this.vo = pedido;
	}
	
	public Pedido getPedido(){
		return vo;
	}

}
