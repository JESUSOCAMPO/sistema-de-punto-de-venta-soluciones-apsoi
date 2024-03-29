package clases;

public class Empleado extends Persona{

		private float sueldo;
		private int codigo;
		private String cargo;
		private float impuestos;
		private float seguro;
		private float AFP;
        
		///Cosntructor Empleado
		
		public Empleado(float SueldoEmpleado,int CodigoEmpleado, String CargoEmpleado,
				float ImpuestoEmpleado,float SeguroPersona,float AfpEmpleado,String NombrePersona,
				String ApellidoPersona,String CedulaPersona,char SexoPersona,
				String DirecionPersona,String TelefonoPersona) {
			
			super(NombrePersona,ApellidoPersona,CedulaPersona,SexoPersona,DirecionPersona,TelefonoPersona);
			sueldo = SueldoEmpleado;
			impuestos = CodigoEmpleado ;
			seguro = SeguroPersona;
			AFP = AfpEmpleado;
			cargo = CargoEmpleado;
			codigo = CodigoEmpleado;
		}

		public Empleado() {
			super();
			sueldo = 0;
			impuestos = 0;
			seguro = 0;
			AFP = 0;
			cargo = null;
			codigo = 0;	
			
			
		}

		public float getSueldo() {
			return sueldo;
		}

		public void setSueldo(float sueldo) {
			this.sueldo = sueldo;
		}

		public float getImpuestos() {
			return impuestos;
		}

		public void setImpuestos(float impuestos) {
			this.impuestos = impuestos;
		}

		public float getSeguro() {
			return seguro;
		}

		public void setSeguro(float seguro) {
			this.seguro = seguro;
		}

		public float getAFP() {
			return AFP;
		}

		public void setAFP(float aFP) {
			AFP = aFP;
		}
		
		public int getCodigo()
		{
			return codigo;
		}
		
		public void setCodigo(int codigo)
		{
			this.codigo = codigo;
		}
		
		public String getCargo()
		{
			return cargo;
		}
		
		public void setCargo(String cargo)
		{
			this.cargo = cargo;
		}
		
		public float getSuedoNeto()
		{
			float sueldoNeto;
			sueldoNeto = impuestos - seguro - AFP;
			return sueldoNeto;
		}
}
