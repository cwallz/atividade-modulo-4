package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Funcionario;

public class FuncionarioDAO {

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
		
	public static void create(Funcionario funcionario) {
		sql = "INSERT INTO tb_funcionario VALUES (null, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, funcionario.getNome());
			preparedStatement.setString(2, funcionario.getEmail());
			preparedStatement.setString(3, funcionario.getSenha());
			preparedStatement.setInt(4, Integer.parseInt(funcionario.getRegistroMatricula()));
			preparedStatement.setString(5, funcionario.getPerfil());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--correct insert on database");
			
		} catch(SQLException e) {
			System.out.println("--incorrect insert on database. " + e.getMessage());

		}
	}
	
	public static void delete(int funcionarioId) {
		
		sql = "DELETE FROM tb_funcionario WHERE id_funcionario = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, funcionarioId);
			preparedStatement.executeUpdate();
			
			System.out.println("--correct delete on funcionario");
			
		} catch (SQLException e) {
			System.out.println("--incorrect delete on funcionario. " + e.getMessage());
			
		}
		
		
	}
	
	public static List<Funcionario> find(String pesquisa) {
		
		sql = String.format("SELECT * FROM tb_funcionario WHERE nome like '%%%s%%' ", pesquisa);
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
				Funcionario funcionario = new Funcionario();
				funcionario.setIdFuncionario(resultSet.getInt("id_funcionario"));
				funcionario.setNome(resultSet.getString("nome"));
				funcionario.setEmail(resultSet.getString("email"));
				funcionario.setSenha(resultSet.getString("senha"));
				funcionario.setRegistroMatricula(resultSet.getString("registro_matricula"));
				funcionario.setPerfil(resultSet.getString("perfil"));
				
				funcionarios.add(funcionario);
			}
			
			System.out.println("--correct find funcionarios");
			return funcionarios;
			
		} catch (SQLException e) {
			System.out.println("--incorrect find funcionarios. " + e.getMessage());
			return null;
		}
		
	}
	
	public static Funcionario findByPk(int funcionarioId) {
		sql = String.format("SELECT * FROM tb_funcionario WHERE id_funcionario like %d ", funcionarioId);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Funcionario funcionario = new Funcionario();
			
			while (resultSet.next()) {
				
				funcionario.setIdFuncionario(resultSet.getInt("id_funcionario"));
				funcionario.setNome(resultSet.getString("nome"));
				funcionario.setEmail(resultSet.getString("email"));
				funcionario.setSenha(resultSet.getString("senha"));
				funcionario.setRegistroMatricula(resultSet.getString("registro_matricula"));
				funcionario.setPerfil(resultSet.getString("perfil"));
				
			
			}
			
			System.out.println("--correct find by pk funcionario");
			return funcionario;
		
		} catch (SQLException e) {
			System.out.println("--incorrect find by pk funcionario. " + e.getMessage());
			return null;
		}
		
	}
	
	public static void update(Funcionario funcionario) {
		sql = "UPDATE tb_funcionario SET nome=?, email=?, senha=?, registro_matricula=?, perfil=? WHERE id_funcionario=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, funcionario.getNome());
			preparedStatement.setString(2, funcionario.getEmail());
			preparedStatement.setString(3, funcionario.getSenha());

			String matricula = funcionario.getRegistroMatricula();
			if (matricula == "") {
				preparedStatement.setString(4, null);
			} else {
				preparedStatement.setInt(4, Integer.parseInt(matricula));
			}
			
			preparedStatement.setString(5, funcionario.getPerfil());
			preparedStatement.setInt(6, funcionario.getIdFuncionario());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--correct update on database");
			
		} catch(SQLException e) {
			System.out.println("--incorrect update on database. " + e.getMessage());

		}
	}
}
