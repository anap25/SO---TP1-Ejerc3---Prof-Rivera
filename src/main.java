import java.util.Scanner;

public class main {

	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese cantidad de procesos: ");
		int n = scan.nextInt();
		double llegada, tiempo,porcentaje;
		proceso[] procesos = new proceso[n];
		
		//INGRESO DE DATOS, ORDENADOS POR TIEMPO DE LLEGADA
		System.out.println("Ingrese el porcentaje de E/S promedio. : ");
		porcentaje = scan.nextDouble();

		for (int i = 0 ; i<n ; i++) {
			System.out.println("Ingrese tiempo de llegada del P"+(i+1)+": ");
			llegada = scan.nextDouble();
			
			System.out.println("Ingrese tiempo requerido de CPU del P"+(i+1)+": ");
			tiempo = scan.nextDouble();
			
			int j=0;
			while (j < i && llegada>=procesos[j].getLlegada()) {
				j++;
			}
			if (j<i) {
				for (int k=i; k>=j; k--) {
					procesos[k]= procesos[k-1];
				}
			}
			procesos[j]= new proceso(i+1,llegada,tiempo,porcentaje);
		}
		
		scan.close();
		// FIN INGRESO 
		
		//muestra procesos ingresados
		
		System.out.println("--------- INICIO ---------");
		System.out.println("Proc\tllega\ttCPU\t%E/S\tSale");
		for(int i = 0; i<n; i++) {
			System.out.println(procesos[i]);
		}
		
		
		int band= 0;
		double osciosa, ocupada, momento, momento2;
		int cantListos;
		proceso[] listos= new proceso[n];
		
		momento = procesos[0].getLlegada();
		momento2 = 1000000000;
		
		while(band <2) {
			
			cantListos = 0;
			
			
			// Carga de la lista listos o se busca un momnento2 mejor
		
			for (int i=0; i<n; i++) {
				if(procesos[i].getLlegada()<=momento && procesos[i].getTCPU()>0) {
					listos[cantListos] = procesos[i];
					cantListos++;
				}else {
					if(procesos[i].getLlegada()<momento2 && (procesos[i].getLlegada() - momento)>0) {
						momento2= procesos[i].getLlegada();
					}
				}
			}
			
			// si la lista de procesos listos no está vacía, calculo la prob de CPU ocupada
			// y calculo la proporción que le toca a cada proceso
			
			if(cantListos!=0) {
				osciosa = Math.pow(porcentaje/100, cantListos);
				ocupada = 1 - osciosa;
				double auxCpuProc = ocupada/cantListos;
				
	
				// Si uno de los procesos termina antes, cambia el momento 2 y se guarda el indice
				//en auxindex para luego actualizar ese campo y no tener a errores de redondeo
				
				int auxindex = -1;
				
				// se calcula el momento2 real
				for(int i= 0; i<cantListos; i++) {
					if(momento2-momento > listos[i].getTCPU()/auxCpuProc) {
						momento2 = momento+listos[i].getTCPU()/auxCpuProc;
						auxindex=i;
						
					}
				}

				
				// Actualiza los tiempos de CPU de cada proceso en listos
				for(int i= 0; i<cantListos; i++) {
					if (auxindex == i) {
						listos[auxindex].setTCPU(0);
						listos[auxindex].setSalida(momento2);
					}else {
						double aux = listos[i].getTCPU()-(momento2-momento)*auxCpuProc;
						if(Math.abs(aux) < 0.00001) {
							listos[i].setTCPU(0);
							listos[i].setSalida(momento2);
						}else {
							listos[i].setTCPU(aux);
						}
					}
				}
				
				momento = momento2;
				momento2= 1000000000;
				band= 0;
				
			}else {
				band++;
				momento= momento2;
				momento2=1000000000;
			}
		}

		System.out.println("");
		
		System.out.println("---------- FINAL ----------");
		
		System.out.println("Proc\tllega\ttCPU\t%E/S\tSale");
		
		for(int i = 0; i<n; i++) {
			System.out.println(procesos[i]);
		}
	}
	


}
