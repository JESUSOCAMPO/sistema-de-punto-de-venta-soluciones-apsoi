package clases;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Usuario {

		private String nombreUsuario;
		private String IDUsuario;
		private String claveUsuario;
		private String tipoUsuario;

		public Usuario() {
			nombreUsuario = null;
			IDUsuario = null;
			claveUsuario = null;
			tipoUsuario = null;
		}
		
		public Usuario(String nombre, String id, String clave, String tipo ) {
			nombreUsuario = nombre;
			IDUsuario = id;
			claveUsuario = clave;
			tipoUsuario = tipo;
		}

		public String getNombreUsuario() {
			return nombreUsuario;
		}

		public void setNombreUsuario(String nombre) {
			this.nombreUsuario = nombre;
		}

		public String getIDUsuario() {
			return IDUsuario;
		}

		public void setIDUsuario(String id) {
			IDUsuario = id;
		}

		public String getClaveUsuario() {
			return claveUsuario;
		}

		public void setClaveUsuario(String clave) {
			this.claveUsuario = clave;
		}

		public String getTipoUsuario() {
			return tipoUsuario;
		}

		public void setTipoUsuario(String tipo) {
			this.tipoUsuario = tipo;
		}
		
		public void guardarDatosBD()
			{
				conexionBD conexion = new conexionBD();
			/*try {
				conexion.insertarDatos("tbusuario", "null,'" + IDUsuario + "','" + descripcionArticulo + "'," + costoArticulo + "," + precioArticulo);
				JOptionPane.showMessageDialog(null, "Datos guardados");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e);
			}*/
			}
	}
