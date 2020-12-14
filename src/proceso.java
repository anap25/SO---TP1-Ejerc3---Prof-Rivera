
public class proceso {
	private int id;
	private double llegada;
	private double tCPU;
	private double porcES;
	private double salida;
	
	public proceso(int id, double llegada,double tCPU, double ES) {
		this.id = id;
		this.llegada = llegada;
		this.tCPU = tCPU;
		this.porcES = ES;
		this.salida = -10;
	}
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getLlegada() {
		return llegada;
	}
	
	public void setLlegada(double llegada) {
		this.llegada = llegada;
	}
	
	public double getTCPU() {
		return tCPU;
	}
	
	public void setTCPU(double tCPU) {
		this.tCPU = tCPU;
	}
		
	public double getPorcES() {
		return porcES;
	}

	public void setPorcES(double porcES) {
		this.porcES = porcES;
	}

	public double getSalida() {
		return salida;
	}
	
	public void setSalida(double salida) {
		this.salida = salida;
	}
	
	/* public String  toString() {
		return "P"+this.id+ "\t"+this.llegada+ "\t"+Math.round(this.tCPU*100d)/100d+"\t"+this.porcES+"\t"+Math.round(this.salida*100d)/100d;
	} */
	
	public String  toString() {
		return "P"+this.id+ "\t"+this.llegada+ "\t"+this.tCPU+"\t"+this.porcES+"\t"+this.salida;
	}
}
