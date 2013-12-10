package clases;

public class Factura {

	
		private String codigoFactura;
		private String comentarioFactura;
		private double montoTotalFactura;
		private String codigoArticuloFactura;
		private String nombreArticuloFactura;
		private double numeroDeComprabanteFiscalFactura;

		public Factura(String codigo, String comentario, double montoTotal, String codigoArticulo, String nombreArticulo, double ncf ) {
			codigoFactura = codigo;
			comentarioFactura = comentario;
			montoTotalFactura = montoTotal;
			codigoArticuloFactura = codigoArticulo;
			nombreArticuloFactura = nombreArticulo;
			numeroDeComprabanteFiscalFactura = ncf;			
		}
		
		public Factura(){
			codigoFactura = null;
			comentarioFactura = null;
			montoTotalFactura = 0;
			codigoArticuloFactura = null;
			nombreArticuloFactura = null;
			numeroDeComprabanteFiscalFactura = 0;
		}

		public String getCodigoFactura() {
			return codigoFactura;
		}

		public void setCodigoFactura(String codigo) {
			this.codigoFactura = codigo;
		}

		public String getComentarioFactura() {
			return comentarioFactura;
		}

		public void setComentarioFactura(String comentario) {
			this.comentarioFactura = comentario;
		}

		public double getMontoTotalFactura() {
			return montoTotalFactura;
		}

		public void setMontoTotalFactura(double montoTotal) {
			this.montoTotalFactura = montoTotal;
		}

		public String getCodigoArticuloFactura() {
			return codigoArticuloFactura;
		}

		public void setCodigoArticuloFactura(String codigoArticulo) {
			this.codigoArticuloFactura = codigoArticulo;
		}

		public String getNombreArticuloFactura() {
			return nombreArticuloFactura;
		}

		public void setNombreArticulo(String nombreArticulo) {
			this.nombreArticuloFactura = nombreArticulo;
		}

		public double getNumeroDeComprabanteFiscal() {
			return numeroDeComprabanteFiscalFactura;
		}
		
		public double devuelta(double montoRecivido)
		{
			return montoRecivido - montoTotalFactura;
		}
		
		public double importeDeArticulo(double cantidad, double precioArticulo)
		{
			return cantidad * precioArticulo;    
		}
		
		public void guardar()
		{
			
			conexionBD cone = new conexionBD();
			cone.GetConnection();
			
			//cone.insertarBD();// crear esta funcion en la class conexion
			
			//cone.cerrar(null);
		}
		
		
		
		public void setNumeroDeComprabanteFiscal(
				double numeroDeComprabanteFiscal) {
			this.numeroDeComprabanteFiscalFactura = numeroDeComprabanteFiscal;
		}
	}
	
