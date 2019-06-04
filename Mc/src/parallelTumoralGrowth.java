import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class celula {//Propiedades de una celula
	static int semilla;
	double rs;//rand vivir Aleatorio
	double rm;//rand migrar *****
	double rp;//rand proliferar *****
	int ph;//señal prolif ******
	int viva;
	
	celula(int a){
		semilla=a;
		Random ale= new Random(a);
		rs=ale.nextDouble();
		rm=ale.nextDouble();
		rp=ale.nextDouble();
		viva=ale.nextInt(2);
		ph=0;
	}
	
	public celula(celula aux){//constructor copia
		rs=aux.rs;
		rm=aux.rm;
		rp=aux.rp;
		ph=aux.ph;
		viva=aux.viva;
		
	}
	public void vaciar(){
		rs=0;
		rm=0;
		rp=0;
		ph=0;
		viva=0;
		
	}
}

public class parallelTumoralGrowth implements Runnable {
	
	static int tam=700;
	private static int nucleos = Runtime.getRuntime().availableProcessors();
	static private long tVentana = tam / nucleos;;
	private int desde = 0, hasta = 0; // auxiliares usados para concurrencia
	
	static celula [][] tum= new celula[tam][tam];
	//static celula [][] auxcel = new celula[tam][tam];
	static double psu; //p vivir usuario   1=psu+pde;
	static double pde; //p morir ******
	static double pmi; //p migrar ***** 0<=pmi<=1;
	static double pp; //p proliferar ***** 0<=pp<=1;
	static double pqu; //p inactiva ***** 0<=pqu<=1;
	static int nph;//ph necesario proliferar *****    X
	
	
	
	parallelTumoralGrowth(int s){
		for(int i=0;i<tam;i++){
			for(int j=0;j<tam;j++){
				tum[i][j]=new celula(s);
			}
		}
		
	}
	
	parallelTumoralGrowth(int n, int m) {// Contructor concurr
		desde = n;
		hasta = m;
	}
	
	
	private int Nest(celula e,int i,int j){
		if(e.viva==0){return e.viva;}//si celula muerta no tiene sentido perder tiempo en comprobar nada
		if(e.rs<psu){
			if(e.rp<pp){//ini rrp<Pp
				e.ph=e.ph+1;
				if(e.ph<=nph){
					if(hacia(i,j)==0){return e.viva;}
					if(prolife(e)){
						int valor=hacia(i,j);
						switch(valor){
						case 0: {return e.viva;}
						case 1:{tum[(700+i-1)%700][j]= new celula(celula.semilla);tum[(700+i-1)%700][j].viva=1;break;}
						case 2:{tum[(700+i+1)%700][j]= new celula(celula.semilla);tum[(700+i+1)%700][j].viva=1;break;}
						case 3:{tum[i][(700+j-1)%700]= new celula(celula.semilla);tum[i][(700+j-1)%700].viva=1;break;}
						case 4:{tum[i][(700+j+1)%700]=new celula(celula.semilla);tum[i][(700+j+1)%700].viva=1;break;}
						}
						e.ph=0;
						return e.viva;
					}
				}
				if(e.rm<pmi){
					if(hacia(i,j)==0){return e.viva;}
					if(migra(e)){
						int valor=hacia(i,j);
						switch(valor){
						case 0: {return e.viva;}
						case 1:{tum[(700+i-1)%700][j]= new celula(tum[i][j]);tum[i][j].vaciar();break;}
						case 2:{tum[(700+i+1)%700][j]= new celula(tum[i][j]);tum[i][j].vaciar();break;}
						case 3:{tum[i][(700+j-1)%700]= new celula(tum[i][j]);tum[i][j].vaciar();break;}
						case 4:{tum[(700+i-1)%700][(700+j+1)%700]= new celula(tum[i][j]);tum[i][j].vaciar();break;}
						}
						return 0;
					}
				}
				return e.viva;
				}else{// fin rrrp<Pp
					if(e.rm<pmi){
						if(hacia(i,j)==0){return e.viva;}
						if(migra(e)){
							int valor=hacia(i,j);
							switch(valor){
							case 0: {return e.viva;}
							case 1:{tum[(700+i-1)%700][j]= new celula(tum[i][j]);tum[i][j].vaciar();break;}
							case 2:{tum[(700+i+1)%700][j]= new celula(tum[i][j]);tum[i][j].vaciar();break;}
							case 3:{tum[i][(700+j-1)%700]= new celula(tum[i][j]);tum[i][j].vaciar();break;}
							case 4:{tum[(700+i-1)%700][(700+j+1)%700]= new celula(tum[i][j]);tum[i][j].vaciar();break;}
							}
							return 0;
						}
					}return e.viva;}
			}else{return 0;}}
	
	private boolean prolife(celula e){
		if(e.ph==nph){return true;}else{return false;}
	}
	
	private int hacia(int i,int j){
		Random ale= new Random();
		double aux=ale.nextDouble();
		double p1=(1-tum[(700+i-1)%700][j].viva)/(4-tum[(700+i-1)%700][j].viva+tum[(700+i+1)%700][j].viva+tum[i][(700+j-1)%700].viva+
				tum[i][(700+j+1)%700].viva);
		double p2=(1-tum[(700+i+1)%700][j].viva)/(4-tum[(700+i-1)%700][j].viva+tum[(700+i+1)%700][j].viva+tum[i][(700+j-1)%700].viva+
				tum[i][(700+j+1)%700].viva);
		double p3=(1-tum[i][(700+j-1) %700].viva)/(4-tum[(700+i-1)%700][j].viva+tum[(700+i+1)%700][j].viva+tum[i][(700+j-1)%700].viva+
				tum[i][(700+j+1)%700].viva);
		double p4=(1-tum[i][(700+j+1)%700].viva)/(4-tum[(700+i-1)%700][j].viva+tum[(700+i+1)%700][j].viva+tum[i][(700+j-1)%700].viva+
				tum[i][(700+j+1)%700].viva);
		if(aux>0 && aux<=p1){return 1;}//derecha
		if(aux>p1 && aux<=(p1+p2)){return 2;}//izq
		if(aux>(p1+p2) && aux<=(p1+p2+p3)){return 3;}//abajo
		if(aux>(p1+p2+p3) && aux<=(p1+p2+p3+p4)){return 4;}//arriba
		return 0;//si celula ocupada,no hace nada
	}
	
	private boolean migra(celula e){
		if(e.ph<nph){return true;}else{return false;}
	}
	
	public void nextgen(){
		
		int i = 0;
		int f = (int) tVentana;

		ExecutorService ejecutor = Executors.newFixedThreadPool(nucleos);
		for (int ii = 1; ii <= nucleos; ii++) {
			ejecutor.execute(new parallelTumoralGrowth  (i, f));
			i = (int) (tVentana);
			f = (int) (f + tVentana);
		}

		ejecutor.shutdown();
		while (!ejecutor.isTerminated());
		
	}
	
	public void run(){
		for (int i = desde; i < hasta; i++)
			for (int j = 0; j < tam; j++)
				Nest(tum[i][j],i, j);
	}

}


