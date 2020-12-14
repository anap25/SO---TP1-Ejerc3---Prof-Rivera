public class planifica {
	private proceso[] procesos;
	private double porcentaje;
	private int n;
	
	public planifica (double por, int n, proceso[] proces) {
		this.porcentaje = por;
		this.n = n;
		this.procesos = proces;
	}
	
	
	public proceso[] getProcesos() {
		return procesos;
	}
	
	public void setProcesos(proceso[] procesos) {
		this.procesos = procesos;
	}
	
	public double getPorcentaje() {
		return porcentaje;
	}
	
	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	public int getN() {
		return n;
	}
	
	public void setN(int n) {
		this.n = n;
	}
	
}
