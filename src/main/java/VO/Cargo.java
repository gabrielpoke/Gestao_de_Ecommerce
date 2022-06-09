package VO;

public class Cargo {
	private int codigo;
	
	private String nome;
	
	private String observacao;
	
	private boolean ativo;

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {

		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
