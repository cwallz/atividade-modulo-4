package model;

public class Destino {

	private int idDestino;
	private int idFuncionario;
	private String nome;
	private String cidade;
	private String estado;
	private double precoDoPacote;
	private boolean promocao;
	private double desconto;
	private String urlFoto;
	
	public int getIdDestino() {
		return idDestino;
	}
	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public double getPrecoDoPacote() {
		return precoDoPacote;
	}
	public void setPrecoDoPacote(double precoDoPacote) {
		this.precoDoPacote = precoDoPacote;
	}
	public boolean isPromocao() {
		return promocao;
	}
	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	public String getUrlFoto() {
		return urlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	@Override
	public String toString() {
		return "Destino [idDestino=" + idDestino + ", idFuncionario=" + idFuncionario + ", nome=" + nome + ", cidade="
				+ cidade + ", estado=" + estado + ", precoDoPacote=" + precoDoPacote + ", promocao=" + promocao
				+ ", desconto=" + desconto + ", urlFoto=" + urlFoto + "]";
	}
		
}
