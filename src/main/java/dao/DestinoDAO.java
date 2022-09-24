package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Destino;

public class DestinoDAO implements CRUD {

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
		
	public static void create(Destino destino) {
		sql = "INSERT INTO tb_destino VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, destino.getIdFuncionario());
			preparedStatement.setString(2, destino.getNome());
			preparedStatement.setString(3, destino.getCidade());
			preparedStatement.setString(4, destino.getEstado());
			preparedStatement.setDouble(5, destino.getPrecoDoPacote());
			preparedStatement.setBoolean(6, destino.isPromocao());
			preparedStatement.setDouble(7, destino.getDesconto());
			preparedStatement.setString(8, destino.getUrlFoto());
			
			
			preparedStatement.executeUpdate();
			
			System.out.println("--correct insert on database");
			
		} catch(SQLException e) {
			System.out.println("--incorrect insert on database. " + e.getMessage());

		}
	}
	
	public static void delete(int destinoId) {
		
		sql = "DELETE FROM tb_destino WHERE id_destino = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, destinoId);
			preparedStatement.executeUpdate();
			
			System.out.println("--correct delete on destino");
			
		} catch (SQLException e) {
			System.out.println("--incorrect delete on destino. " + e.getMessage());
			
		}
		
		
	}
	
	public static List<Destino> find(String pesquisa) {
		
		sql = String.format("SELECT * FROM tb_destino WHERE nome like '%s%%' OR cidade LIKE '%s%%'  OR estado LIKE '%s%%'", pesquisa, pesquisa);
		List<Destino> destinos = new ArrayList<Destino>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
				Destino destino = new Destino();
				destino.setIdDestino(resultSet.getInt("id_destino"));
				destino.setIdFuncionario(resultSet.getInt("id_funcionario"));
				destino.setNome(resultSet.getString("nome"));
				destino.setCidade(resultSet.getString("cidade"));
				destino.setEstado(resultSet.getString("estado"));
				destino.setPrecoDoPacote(resultSet.getDouble("preco_pacote"));
				destino.setPromocao(resultSet.getBoolean("promocao"));
				destino.setDesconto(resultSet.getDouble("desconto"));
				destino.setUrlFoto(resultSet.getString("url_foto"));
				
				destinos.add(destino);
			
			}
			
			System.out.println("--correct find destinos");
			return destinos;
			
		} catch (SQLException e) {
			System.out.println("--incorrect find destinos. " + e.getMessage());
			return null;
		}
		
	}
	
	public static Destino findByPk(int destinoId) {
		sql = String.format("SELECT * FROM tb_destino WHERE id_destino like %d ", destinoId);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Destino destino = new Destino();
			
			while (resultSet.next()) {
				
				destino.setIdDestino(resultSet.getInt("id_destino"));
				destino.setIdFuncionario(resultSet.getInt("id_funcionario"));
				destino.setNome(resultSet.getString("nome"));
				destino.setCidade(resultSet.getString("cidade"));
				destino.setEstado(resultSet.getString("estado"));
				destino.setPrecoDoPacote(resultSet.getDouble("preco_pacote"));
				destino.setPromocao(resultSet.getBoolean("promocao"));
				destino.setDesconto(resultSet.getDouble("desconto"));
				destino.setUrlFoto(resultSet.getString("url_foto"));				
			
			}
			
			System.out.println("--correct find by pk destino");
			return destino;
		
		} catch (SQLException e) {
			System.out.println("--incorrect find by pk destino. " + e.getMessage());
			return null;
		}
		
	}
	
	public static void update(Destino destino) {
		sql = "UPDATE tb_destino SET id_funcionario=?, nome=?, cidade=?, estado=?, preco_pacote=?, promocao=?, desconto=?, url_foto=? WHERE id_destino=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, destino.getIdFuncionario());
			preparedStatement.setString(2, destino.getNome());
			preparedStatement.setString(3, destino.getCidade());
			preparedStatement.setString(4, destino.getEstado());
			preparedStatement.setDouble(5, destino.getPrecoDoPacote());
			preparedStatement.setBoolean(6, destino.isPromocao());
			preparedStatement.setDouble(7, destino.getDesconto());
			preparedStatement.setString(8, destino.getUrlFoto());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--correct update on database");
			
		} catch(SQLException e) {
			System.out.println("--incorrect update on database. " + e.getMessage());

		}
	}
}

