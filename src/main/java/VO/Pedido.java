package VO;

public class Pedido {
	private int codigo;
	
	private Cliente cliente;
	
	private Colaborador colaborador;
	
	private Produto produto;

	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {

		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Colaborador getColaborador() {
		return colaborador;
	}
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}
