package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cliente extends Persona {
	
	private String codigoCliente;
	
		public Cliente()
		{
			super();
			codigoCliente = null;
		}
	
		public void setCodigoCliente(String codigoCliente)
		{
			this.codigoCliente = codigoCliente;		
		}
		
		public String getCodigoCliente()
		{
			return codigoCliente;
		}
	
	   public boolean seleccionarDatos(String nombreTabla, String campos, String condicion) throws SQLException
	   {
		   String clienteNombre = "";
		   String clienteDireccion = "";
		   String clienteTelefono = "";
		   
		   Connection miConexion=(Connection) conexionBD.GetConnection();
		   Statement statement=(Statement) miConexion.createStatement();
		   ResultSet consulta = statement.executeQuery("select " + campos + " from " + nombreTabla + " where " + condicion +";");
		   //statement.execute("select " + campos + " from " + nombreTabla + " where " + condicion +";");
		   
		   int columna1 = consulta.findColumn("Nombre");
		   int columna2 = consulta.findColumn("Direccion");
		   int columna3= consulta.findColumn("Telefono");

		   boolean lleno = consulta.next();
		   if(!lleno)
			   return false;
		   else		   
			   while (lleno)
			   {
				   clienteNombre = consulta.getString(columna1);
				   clienteDireccion = consulta.getString(columna2);
				   clienteTelefono = consulta.getString(columna3);
		   
				   lleno = consulta.next(); //se verifica si hay otro registro
			   }
		   nombre = clienteNombre;
		   direccion = clienteDireccion;
		   telefono = clienteTelefono;
		  
           statement.close();
           miConexion.close();
           
           return true;
	   }
}
