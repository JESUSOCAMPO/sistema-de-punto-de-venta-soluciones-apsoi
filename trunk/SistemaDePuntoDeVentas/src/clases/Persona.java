package clases;

public abstract class Persona {
	
		protected String nombre;
		protected  String apellido;
		protected  String cedula;
		protected  char sexo;
		protected  String direccion;
		protected  String telefono;
           //Constructor de la clase Persona
		public Persona(String NombrePersona,String ApellidoPersona,String CedulaPersona,char SexoPersona,
				String DirecionPersona,String TelefonoPersona) {
			 nombre = NombrePersona;
			 apellido = ApellidoPersona;
			 cedula = CedulaPersona;
			 sexo = SexoPersona;
			 direccion = DirecionPersona;
			 telefono = TelefonoPersona;
		}
		//Fin del costructor Persona
		
		public Persona() {
			 nombre = null;
			 apellido = null;
			 cedula = null;
			 sexo = '\n';
			 direccion = null;
			 telefono = null;
		}
		
		

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getCedula() {
			return cedula;
		}

		public void setCedula(String cedula) {
			this.cedula = cedula;
		}

		public char getSexo() {
			return sexo;
		}

		public void setSexo(char sexo) {
			this.sexo = sexo;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		
		public String getNombreCompleto()
		{
			return nombre + " " + apellido;
		}
	}
