package model;

public class Cliente extends Usuario {
	
	private int idCliente;
	private String cpf;
	private String dataDeNascimento;
	
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", cpf=" + cpf + ", dataDeNascimento=" + dataDeNascimento + "]";
	}
	

}
