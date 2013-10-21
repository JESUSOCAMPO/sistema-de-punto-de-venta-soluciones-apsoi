
public class Usuario {

		private String nombre;
		private String IDUsuario;
		private String clave;
		private String tipoUsuario;

		public Usuario() {
			nombre = null;
			IDUsuario = null;
			clave = null;
			tipoUsuario = null;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getIDUsuario() {
			return IDUsuario;
		}

		public void setIDUsuario(String iDUsuario) {
			IDUsuario = iDUsuario;
		}

		public String getClave() {
			return clave;
		}

		public void setClave(String clave) {
			this.clave = clave;
		}

		public String getTipoUsuario() {
			return tipoUsuario;
		}

		public void setTipoUsuario(String tipoUsuario) {
			this.tipoUsuario = tipoUsuario;
		}
	}
