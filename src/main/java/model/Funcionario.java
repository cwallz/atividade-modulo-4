package model;

public class Funcionario extends Usuario {

	private int idFuncionario;
	private String registroMatricula;
	private String perfil;
	
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getRegistroMatricula() {
		return registroMatricula;
	}
	public void setRegistroMatricula(String registroMatricula) {
		this.registroMatricula = registroMatricula;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	@Override
	public String toString() {
		return "Funcionario [idFuncionario=" + idFuncionario + ", registroMatricula=" + registroMatricula + ", perfil="
				+ perfil + "]";
	}
	
	
}
