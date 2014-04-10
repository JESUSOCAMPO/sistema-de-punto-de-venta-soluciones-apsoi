package clases;

public class NumComprobanteFiscal {
	
	private char serie;
	private String divisionDeNegocio;
	private String puntoDeEmision;
	private String areaDeImpresion;
	private String tipoCompFiscal;
	private int secuencial;
	
	public NumComprobanteFiscal(char serie, String divisionDeNegocio,
			String puntoDeEmision, String areaDeImpresion,
			String tipoCompFiscal, int secuencial) 
	{
		super();
		this.serie = serie;
		this.divisionDeNegocio = divisionDeNegocio;
		this.puntoDeEmision = puntoDeEmision;
		this.areaDeImpresion = areaDeImpresion;
		this.tipoCompFiscal = tipoCompFiscal;
		this.secuencial = secuencial;
	}

	public NumComprobanteFiscal() 
	{
		serie = '\u0000';
		divisionDeNegocio = null;
		puntoDeEmision = null;
		areaDeImpresion = null;
		tipoCompFiscal = null;
		secuencial = 0;
	}

	public char getSerie() {
		return serie;
	}

	public void setSerie(char serie) {
		this.serie = serie;
	}

	public String getDivisionDeNegocio() {
		return divisionDeNegocio;
	}

	public void setDivisionDeNegocio(String divisionDeNegocio) {
		this.divisionDeNegocio = divisionDeNegocio;
	}

	public String getPuntoDeEmision() {
		return puntoDeEmision;
	}

	public void setPuntoDeEmision(String puntoDeEmision) {
		this.puntoDeEmision = puntoDeEmision;
	}

	public String getAreaDeImpresion() {
		return areaDeImpresion;
	}

	public void setAreaDeImpresion(String areaDeImpresion) {
		this.areaDeImpresion = areaDeImpresion;
	}

	public String getTipoCompFiscal() {
		return tipoCompFiscal;
	}

	public void setTipoCompFiscal(String tipoCompFiscal) {
		this.tipoCompFiscal = tipoCompFiscal;
	}

	public int getSecuencial() {
		return secuencial;
	}

	public void setSecuencial(int secuencial) {
		this.secuencial = secuencial;
	}
	
	public void incrementaSecuencial ()
	{
		int inicioSecuencial = 000000;
		
		
	}

}
