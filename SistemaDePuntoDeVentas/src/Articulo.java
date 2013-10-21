
public class Articulo {

		private float codigoArticulo;
		private float costo;
		private float precio;
		private String descripcion;


		public Articulo()
		{
			codigoArticulo = 0;
			costo = 0;
			precio = 0;
			descripcion = null;
		}
		
		public float getCodigoArticulo()
		{
			return codigoArticulo;
		}
		
		public void setCodigoArticulo(float codigoArticulo) {
			this.codigoArticulo = codigoArticulo;
		}

		public float getCosto() {
			return costo;
		}

		public void setCosto(float costo) {
			this.costo = costo;
		}

		public float getPrecio() {
			return precio;
		}

		public void setPrecio(float precio) {
			this.precio = precio;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
	}
