package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class conexionBD {
	
	private static Connection conexion=null;
	//conectar
				private void conectar()
				{
				try{
						// cargar el Driver
						Class.forName("com.mysql.jdbc.Driver");
						conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "root", "12345");
						//establecer la conexion
		
		
					}catch(SQLException ex)
					{
						JOptionPane.showMessageDialog(null, "No se logro la conexion", null, JOptionPane.ERROR_MESSAGE);
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, "No se logro la conexion", null, JOptionPane.ERROR_MESSAGE);
					}
				}
	
	   public static Connection GetConnection() 
	     {
	         try
	         {
	             Class.forName("com.mysql.jdbc.Driver");
	             String servidor = "jdbc:mysql://localhost/dbspvapsoi";
	             String usuarioDB="root";
	             String passwordDB="12345";
	             conexion= DriverManager.getConnection(servidor,usuarioDB,passwordDB);
	             //JOptionPane.showMessageDialog(null,"dhdhdgdg");
	         }
	         catch(Exception ex)
	         {
	             JOptionPane.showMessageDialog(null, ex, "Error en la Conexión con la Base de Datos ",1);
	             conexion=null;
	         }
	         return conexion;
	     }
	   
	    public void cerrar()
	    {
            try {
            	conexion.close();
                //JOptionPane.showMessageDialog(null,"cerro conexion");
            } catch (Exception e) {
            	JOptionPane.showMessageDialog(null,"Error: No es posible cerrar la conexión.");
            }
	    }
	    
	   // Metodo para insertar datos en la base de datos
	   public void insertarDatos(String nombreTabla, String datos) throws SQLException
	   {
		   Connection miConexion=(Connection) conexionBD.GetConnection();
		   Statement statement=(Statement) miConexion.createStatement();
		   
		   statement.execute("insert into " + nombreTabla + " values( " + datos + ");");
	          
           //JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
         
           statement.close();
           conexion.close();
           //PreparedStatement pra controlar las inyecciones a la base de datos
	   }
	    
	 //consultar
	   		 public ResultSet  consultar(String SQL)
	   	       {
	   			   conexionBD c = new conexionBD();	
	   			   c.GetConnection();	
	   			ResultSet rs = null;
	   				Statement sentencia = null;
	   				try{
	   					sentencia = conexion.createStatement();
	   					rs = sentencia.executeQuery(SQL);
	   	
	   				}catch(SQLException ex)
	   				{
	   					JOptionPane.showMessageDialog(null, "No se logro la conexion", null, JOptionPane.ERROR_MESSAGE);
	   				}
	   				catch(Exception ex)
	   				{
	   					JOptionPane.showMessageDialog(null, "No se logro la conexion", null, JOptionPane.ERROR_MESSAGE);
	   				}
	   
	   				return rs;
	   			}
}
