package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Articulo {
 
 			private static String codigoArticulo;
 			private double costoArticulo;
 			private double precioArticulo;
 			private static String descripcionArticulo;
 			
 			public Articulo()
 			{
 				codigoArticulo = null;
 				costoArticulo = 0;
 				precioArticulo = 0;
 				descripcionArticulo = null;
 			}
 
 	
 			public Articulo(String codigo, double costo, double precio, String descripcion)
 			{
 				codigoArticulo = codigo;
 				costoArticulo = costo;
 				precioArticulo = precio;
 				descripcionArticulo = descripcion;
 			}
 
 			public String getCodigoArticulo()
 			{
 				return codigoArticulo;
 			}
 	
 			public void setCodigoArticulo(String codigo) {
 				this.codigoArticulo = codigo;
 			}
 	
 			public double getCostoArticulo() {
 				return costoArticulo;
 			}
 	
 			public void setCostoArticulo(double costo) {
 				this.costoArticulo = costo;
 			}
 	
 			public double getPrecioArticulo() {
 				return precioArticulo;
 			}
 	
 			public void setPrecioArticulo(double precio) {
 				this.precioArticulo = precio;
 			}
 	
 			public String getDescripcionArticulo() {
 				return descripcionArticulo;
 			}
 	
 			public void setDescripcionArticulo(String descripcion) {
 				this.descripcionArticulo = descripcion;
 			}
 			
 			public void guardarDatosBD()
 			{
 				conexionBD conexion = new conexionBD();
				try {
					conexion.insertarDatos("tbarticulo", "'" + codigoArticulo + "','" + descripcionArticulo + "'," + costoArticulo + "," + precioArticulo);
					JOptionPane.showMessageDialog(null, "Datos guardados");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e);
				}
 			}
 			
 		   public void seleccionarDatos(String nombreTabla, String campos, String condicion) throws SQLException
 		   {
 			   Connection miConexion=(Connection) conexionBD.GetConnection();
 			   Statement statement=(Statement) miConexion.createStatement();
 			   ResultSet consulta = statement.executeQuery("select " + campos + " from " + nombreTabla + " where " + condicion +";");
 			   //statement.execute("select " + campos + " from " + nombreTabla + " where " + condicion +";");
 			   
 			   int columna1 = consulta.findColumn("codigoArticulo");
 			   int columna2 = consulta.findColumn("nombreArticulo");
 			   int columna3= consulta.findColumn("costoArticulo");
 			   int columna4 = consulta.findColumn("precioArticulo");

 			   boolean lleno = consulta.next();

 			   while (lleno){
 			   String id = consulta.getString(columna1);
 			   String descripcion = consulta.getString(columna2);
 			   Double costo = consulta.getDouble(columna3);
 			   Double precio = consulta.getDouble(columna4);
 			   
 			   lleno = consulta.next(); //se verifica si hay otro registro
 			   
 			   codigoArticulo = id;
 			   descripcionArticulo = descripcion;
 			   costoArticulo = costo;
 			   precioArticulo = precio;
 			  
 	          // JOptionPane.showMessageDialog(null, "codigo: " + id + " nombre: " + descripcion + " costo: " + costo);
 			  }
 	           statement.close();
 	           miConexion.close();
 		   }
 }