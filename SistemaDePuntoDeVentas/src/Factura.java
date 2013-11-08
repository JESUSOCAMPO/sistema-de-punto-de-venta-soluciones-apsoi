
public class Factura {

	
		private double codigoFactura;
		private String comentario;
		private float montoTotal;
		private float codigoArticulo;
		private String nombreArticulo;
		private double numeroDeComprabanteFiscal;

		public Factura() {
			codigoFactura = 0;
			comentario = null;
			montoTotal = 0;
			codigoArticulo = 0;
			nombreArticulo = null;
			numeroDeComprabanteFiscal = 0;			
		}
		

		public double getCodigoFactura() {
			return codigoFactura;
		}

		public void setCodigoFactura(double codigoFactura) {
			this.codigoFactura = codigoFactura;
		}

		public String getComentario() {
			return comentario;
		}

		public void setComentario(String comentario) {
			this.comentario = comentario;
		}

		public float getMontoTotal() {
			return montoTotal;
		}

		public void setMontoTotal(float montoTotal) {
			this.montoTotal = montoTotal;
		}

		public float getCodigoArticulo() {
			return codigoArticulo;
		}

		public void setCodigoArticulo(float codigoArticulo) {
			this.codigoArticulo = codigoArticulo;
		}

		public String getNombreArticulo() {
			return nombreArticulo;
		}

		public void setNombreArticulo(String nombreArticulo) {
			this.nombreArticulo = nombreArticulo;
		}

		public double getNumeroDeComprabanteFiscal() {
			return numeroDeComprabanteFiscal;
		}
		
		public double devuelta(double montoRecivido)
		{
			return montoRecivido - montoTotal;
		}
		
		public double importeDeArticulo(double cantidad, double precioArticulo)
		{
			return cantidad * precioArticulo;  // el valor de la variable precioArticulo tomara el valor que se le pase de la base de datos  
		}
		
		public void guardar()
		{
			
			conexionBD cone = new conexionBD();
			cone.conectar();
			
			//cone.insertarBD();// crear esta funcion en la class conexion
			
			//cone.cerrar(null);
		}
		
		
		
		public void setNumeroDeComprabanteFiscal(
				double numeroDeComprabanteFiscal) {
			this.numeroDeComprabanteFiscal = numeroDeComprabanteFiscal;
		}
	}
	
