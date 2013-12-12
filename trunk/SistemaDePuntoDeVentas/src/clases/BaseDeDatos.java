package clases;
import java.sql.*;

import javax.swing.JOptionPane;

public class BaseDeDatos {

	private Connection conexion = null;
	
	private void conectar() throws ClassNotFoundException
	{
		try{
		Class.forName("com.mysql.jdbc.Driver");
		conexion = DriverManager.getConnection("jdbc:mysql://localhost/dbspvapsoi", "root", "27031988");
		}
		catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null, "No se conecto");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "No se conecto nada");
		}
	}
	
	public ResultSet consultar(String SQL) throws ClassNotFoundException
	{
		this.conectar();
		ResultSet rs = null;
		Statement sentencia = null;
		try{
			sentencia = conexion.createStatement();
			rs = sentencia.executeQuery(SQL);
		}
		catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null, "No se conecto");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "No se conecto nada");
		}
		
		return rs;
	}
	
}
