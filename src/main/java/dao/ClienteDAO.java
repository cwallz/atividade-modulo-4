package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Cliente;

public class ClienteDAO implements CRUD {

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
		
	public static void create(Cliente cliente) {
		sql = "INSERT INTO tb_cliente VALUES (null, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getEmail());
			preparedStatement.setString(3, cliente.getSenha());
			preparedStatement.setString(4, cliente.getCpf());
			preparedStatement.setString(5, cliente.getDataDeNascimento());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--correct insert on database");
			
		} catch(SQLException e) {
			System.out.println("--incorrect insert on database. " + e.getMessage());

		}
	}
	
	public static void delete(int clienteId) {
		
		sql = "DELETE FROM tb_cliente WHERE id_cliente = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, clienteId);
			preparedStatement.executeUpdate();
			
			System.out.println("--correct delete on cliente");
			
		} catch (SQLException e) {
			System.out.println("--incorrect delete on cliente. " + e.getMessage());
			
		}
		
		
	}
	
	public static List<Cliente> find(String pesquisa) {
		
		sql = String.format("SELECT * FROM tb_cliente WHERE nome like '%%%s%%'", pesquisa, pesquisa);
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
				Cliente cliente = new Cliente();
				cliente.setIdCliente(resultSet.getInt("id_cliente"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setEmail(resultSet.getString("email"));
				cliente.setSenha(resultSet.getString("senha"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setDataDeNascimento(resultSet.getString("data_nascimento"));
				
				clientes.add(cliente);
			
			}
			
			System.out.println("--correct find clientes");
			return clientes;
			
		} catch (SQLException e) {
			System.out.println("--incorrect find clientes. " + e.getMessage());
			return null;
		}
		
	}
	
	public static Cliente findByPk(int clienteId) {
		sql = String.format("SELECT * FROM tb_cliente WHERE id_cliente like %d ", clienteId);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Cliente cliente = new Cliente();
			
			while (resultSet.next()) {
				
				cliente.setIdCliente(resultSet.getInt("id_cliente"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setEmail(resultSet.getString("email"));
				cliente.setSenha(resultSet.getString("senha"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setDataDeNascimento(resultSet.getString("data_nascimento"));
				
			
			}
			
			System.out.println("--correct find by pk cliente");
			return cliente;
		
		} catch (SQLException e) {
			System.out.println("--incorrect find by pk cliente. " + e.getMessage());
			return null;
		}
		
	}
	
	public static void update(Cliente cliente) {
		sql = "UPDATE tb_cliente SET nome=?, email=?, senha=?, cpf=?, data_nascimento=? WHERE id_cliente=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getEmail());
			preparedStatement.setString(3, cliente.getSenha());
			preparedStatement.setString(4, cliente.getCpf());
			preparedStatement.setString(5, cliente.getDataDeNascimento());
			preparedStatement.setInt(6, cliente.getIdCliente());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--correct update on database");
			
		} catch(SQLException e) {
			System.out.println("--incorrect update on database. " + e.getMessage());

		}
	}
}
