package model;

public class Transicao {

	private int idTransicao;
	private int idCliente;
	private int idDestino;
	private int quantidadeDiarias;
	private String dataViagem;
	private boolean optanteSeguro;
	private double taxaSeguro;
	
	public int getIdTransicao() {
		return idTransicao;
	}
	public void setIdTransicao(int idTransicao) {
		this.idTransicao = idTransicao;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdDestino() {
		return idDestino;
	}
	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}
	public int getQuantidadeDiarias() {
		return quantidadeDiarias;
	}
	public void setQuantidadeDiarias(int quantidadeDiarias) {
		this.quantidadeDiarias = quantidadeDiarias;
	}
	public String getDataViagem() {
		return dataViagem;
	}
	public void setDataViagem(String dataViagem) {
		this.dataViagem = dataViagem;
	}
	public boolean isOptanteSeguro() {
		return optanteSeguro;
	}
	public void setOptanteSeguro(boolean optanteSeguro) {
		this.optanteSeguro = optanteSeguro;
	}
	public double getTaxaSeguro() {
		return taxaSeguro;
	}
	public void setTaxaSeguro(double taxaSeguro) {
		this.taxaSeguro = taxaSeguro;
	}
	@Override
	public String toString() {
		return "Transicao [idTransicao=" + idTransicao + ", idCliente=" + idCliente + ", idDestino=" + idDestino
				+ ", quantidadeDiarias=" + quantidadeDiarias + ", dataViagem=" + dataViagem + ", optanteSeguro="
				+ optanteSeguro + ", taxaSeguro=" + taxaSeguro + "]";
	}
	
}
