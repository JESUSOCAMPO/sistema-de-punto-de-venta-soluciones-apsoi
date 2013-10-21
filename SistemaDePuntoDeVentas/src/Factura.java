
public class Factura {

	
		private double codigoFactura;
		private String detalle;
		private float montoTotal;
		private float codigoArticulo;
		private String nombreArticulo;
		private double numeroDeComprabanteFiscal;

		public Factura() {
			codigoFactura = 0;
			detalle = null;
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

		public String getDetalle() {
			return detalle;
		}

		public void setDetalle(String detalle) {
			this.detalle = detalle;
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

		public void setNumeroDeComprabanteFiscal(
				double numeroDeComprabanteFiscal) {
			this.numeroDeComprabanteFiscal = numeroDeComprabanteFiscal;
		}
	}
	
