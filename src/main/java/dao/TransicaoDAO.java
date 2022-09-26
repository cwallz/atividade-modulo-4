package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Transicao;

public class TransicaoDAO implements CRUD {

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
		
	public static void create(Transicao transicao) {
		sql = "INSERT INTO tb_transicao VALUES (null, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, transicao.getIdCliente());
			preparedStatement.setInt(2, transicao.getIdDestino());
			preparedStatement.setInt(3, transicao.getQuantidadeDiarias());
			preparedStatement.setString(4, transicao.getDataViagem());
			preparedStatement.setBoolean(5, transicao.isOptanteSeguro());
			preparedStatement.setDouble(6, transicao.getTaxaSeguro());

			
			preparedStatement.executeUpdate();
			
			System.out.println("--correct insert on database");
			
		} catch(SQLException e) {
			System.out.println("--incorrect insert on database. " + e.getMessage());

		}
	}
	
	public static void delete(int transicaoId) {
		
		sql = "DELETE FROM tb_transicao WHERE id_transicao = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, transicaoId);
			preparedStatement.executeUpdate();
			
			System.out.println("--correct delete on transicao");
			
		} catch (SQLException e) {
			System.out.println("--incorrect delete on transicao. " + e.getMessage());
			
		}
		
		
	}
	
	public static List<Transicao> find(String pesquisa) {
		
		sql = String.format("SELECT * FROM tb_transicao WHERE id_transicao like '%%%s%%' ", pesquisa, pesquisa);
		List<Transicao> transicoes = new ArrayList<Transicao>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
				Transicao transicao = new Transicao();
				transicao.setIdTransicao(resultSet.getInt("id_transicao"));
				transicao.setIdCliente(resultSet.getInt("id_cliente"));
				transicao.setIdDestino(resultSet.getInt("id_destino"));
				transicao.setQuantidadeDiarias(resultSet.getInt("quantidade_diarias"));
				transicao.setDataViagem(resultSet.getString("data_viagem"));
				transicao.setOptanteSeguro(resultSet.getBoolean("optante_seguro"));
				transicao.setTaxaSeguro(resultSet.getDouble("taxa_seguro"));

				
				transicoes.add(transicao);
			
			}
			
			System.out.println("--correct find transicoes");
			return transicoes;
			
		} catch (SQLException e) {
			System.out.println("--incorrect find transicoes. " + e.getMessage());
			return null;
		}
		
	}
	
	public static Transicao findByPk(int transicaoId) {
		sql = String.format("SELECT * FROM tb_transicao WHERE id_transicao like %d ", transicaoId);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Transicao transicao = new Transicao();
			
			while (resultSet.next()) {
				
				transicao.setIdTransicao(resultSet.getInt("id_transicao"));
				transicao.setIdCliente(resultSet.getInt("id_cliente"));
				transicao.setIdDestino(resultSet.getInt("id_destino"));
				transicao.setQuantidadeDiarias(resultSet.getInt("quantidade_diarias"));
				transicao.setDataViagem(resultSet.getString("data_viagem"));
				transicao.setOptanteSeguro(resultSet.getBoolean("optante_seguro"));
				transicao.setTaxaSeguro(resultSet.getDouble("taxa_seguro"));
				
			
			}
			
			System.out.println("--correct find by pk transicao");
			return transicao;
		
		} catch (SQLException e) {
			System.out.println("--incorrect find by pk transicao. " + e.getMessage());
			return null;
		}
		
	}
	
	public static void update(Transicao transicao) {
		sql = "UPDATE tb_transicao SET id_cliente=?, id_destino=?, quantidade_diarias=?, data_viagem=?, optante_seguro=?, taxa_seguro=? WHERE id_transicao=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, transicao.getIdCliente());
			preparedStatement.setInt(2, transicao.getIdDestino());
			preparedStatement.setInt(3, transicao.getQuantidadeDiarias());
			preparedStatement.setString(4, transicao.getDataViagem());
			preparedStatement.setBoolean(5, transicao.isOptanteSeguro());
			preparedStatement.setDouble(6, transicao.getTaxaSeguro());
			preparedStatement.setInt(7, transicao.getIdTransicao());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--correct update on database");
			
		} catch(SQLException e) {
			System.out.println("--incorrect update on database. " + e.getMessage());

		}
	}
}
