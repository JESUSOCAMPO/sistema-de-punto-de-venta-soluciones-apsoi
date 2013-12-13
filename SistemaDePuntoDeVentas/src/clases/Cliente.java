package clases;

public class Cliente extends Persona {
	
	private String codigoCliente;
	public Cliente()
	{
		super();
		codigoCliente = null;
	}

	public void setCodigoCliente(String codigoCliente)
	{
		this.codigoCliente = codigoCliente;		
	}
	
	public String getCodigoCliente()
	{
		return codigoCliente;
	}
	}
