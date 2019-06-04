
import java.awt.Toolkit;

public class ca1DSimulator extends Thread implements ca1DSim{
	static int band=0;
	Object lock = new Object();
	static int ancho = (int)(Toolkit.getDefaultToolkit().getScreenSize().width); 
	static int[] automata =new int[ancho-ancho/3];//automata mismo tamaño que el canvas
	static int[] automataaux = new int[ancho-ancho/3];//se usara con vector automata para generarel paso de estado a otro sin alterar
	int regl1 [];
	int regl2 [];
	static int k;//conjunto de estados del automata
	int r;//rango de vencidad
	static int[] regla;//valores que tomaran las proximas generaciones el automata
	static int auxR;
	boolean conBarrer;//barrera
	public ca1DSimulator(){}
	public ca1DSimulator(int est,int ve,boolean barre) {
		k=est;
		r=ve;
		auxR=(2*ve +1)*(est-1)+1;
		//regl1=new int[auxR];
		regla= new int[auxR];
		conBarrer=barre;
		
	}
	public  void nextGen(){
		Thread hili = new Thread(this);
		Thread hili2 = new Thread(this);
		hili.start();
		hili2.start();
		try{
			hili.join();
			hili2.join();
		band=0;
		for(int i= 0;i<automata.length;i++){
			automata[i]=automataaux[i];
			automataaux[i]=0;
			}}catch(Exception e){}	
	}
	
	public void caComputation(int nGen){
	}
	
	
	public static void crearreglak(int r){
		int i=0;
		if(r<(k-1)){
			regla[0]=r;
		}else{
			while(r>=k){
				regla[i]=r%k;
				r=r/k;
				i++;
				if(i==regla.length){i=0;}
			}
			regla[i]=r;
	}}
	
	
	public  void run(){
		synchronized(lock){
			band=band+1;
		}
		if(band==1){
		if(conBarrer){//if barrera ciclica
			for(int i=0;i<automata.length/2;i++){//inicio 1 for
				for( int j =i-r;j<=i+r;j++){//inicio 2 for
					if(j>=automata.length){ // 1 if
				automataaux[i] = automataaux[i] + automata[j%automata.length];
			}else{// y fin 1 if cmienzo else
					if(j<0){//comienzo 2 if
						int aux=automata.length+j;
						automataaux[i] = automataaux[i]*k + automata[aux];
					}else{
						automataaux[i] = automataaux[i] + automata[j];
					}//normal
				}//fin else
				}//bucle for 2
				int aux=automataaux[i];
				automataaux[i]=regla[aux];
			}//fin 1 for
			
		}else{//sin if y comienzo sin barrera ciclica
			for(int i=0;i<automata.length/2;i++){//inicio 1 for
				for( int j =i-r;j<=i+r;j++){//inicio 2 for
					if(j>=automata.length){ // 1 if
				automataaux[i] = automataaux[i];
			}else{// y fin 1 if cmienzo else
					if(j<0){//comienzo 2 if
						automataaux[i] = automataaux[i];
					}else{
						automataaux[i] = automataaux[i] + automata[j];
					}//normal
				}//fin else
				}//bucle for 2
				int aux=automataaux[i];
				automataaux[i]=regla[aux];
				
			}	
		}
		
	}else{
		
		if(conBarrer){//if barrera ciclica
			for(int i=automata.length/2;i<automata.length;i++){//inicio 1 for
				for( int j =i-r;j<=i+r;j++){//inicio 2 for
					if(j>=automata.length){ // 1 if
				automataaux[i] = automataaux[i] + automata[j%automata.length];
			}else{// y fin 1 if cmienzo else
					if(j<0){//comienzo 2 if
						int aux=automata.length+j;
						automataaux[i] = automataaux[i] + automata[aux];
					}else{
						automataaux[i] = automataaux[i] + automata[j];
					}
				}//fin else
				}//bucle for 2
				int aux=automataaux[i];
				automataaux[i]=regla[aux];
			}//fin 1 for
			
		}else{//sin if y comienzo sin barrera ciclica
			for(int i=automata.length/2;i<automata.length;i++){//inicio 1 for
				for( int j =i-r;j<=i+r;j++){//inicio 2 for
					if(j>=automata.length){ // 1 if
				automataaux[i] = automataaux[i];
			}else{// y fin 1 if cmienzo else
					if(j<0){//comienzo 2 if
						automataaux[i] = automataaux[i];
					}else{
						automataaux[i] = automataaux[i] + automata[j];
					}
				}//fin else
				}//bucle for 2
				int aux=automataaux[i];
				automataaux[i]=regla[aux];
				
			}	
		}	
	}}
		

public  void inicial(int ob){
	long t=1L;
	switch(ob){
	case 1:{
	 for(int i=0;i<automata.length;i++){
			t=(t*5)%32;
			double kk=(double)t/32;
			kk=kk*k;
			automata[i]=(int)kk;}
	 break;}
	
	case 2:{
		 for(int i=0;i<automata.length;i++){
				t=(t*7)%32;
				double kk=(double)t/32;
				kk=kk*k;
				automata[i]=(int)kk;}
		 break;}
	
	case 3:{
		 for(int i=0;i<automata.length;i++){
				t=(t*3)%31;
				double kk=(double)t/31;
				kk=kk*k;
				automata[i]=(int)kk;}
		 break;}
	
	case 4:{
		long siecin = 16807; //16807=7 elevado a 5,
		long x= 2147483647l; //2147483647 = 2 elevado a 31 - 1
		 for(int i=0;i<automata.length;i++){
				t=(t*siecin)%x;
				double kk=(double)t/x;
				kk=kk*k;
				automata[i]=(int)kk;}
		 break;}
	
	case 5:{
		int aux=1,aux2=1,aux3=1;
		for(int i=0;i<automata.length;i++){
			aux=(157*aux)%32363;
			aux2=(146*aux2)%31727;
			aux3=(142*aux3)%31657;
			t=(aux-aux2+aux3)%32362;
			if(t<0){t=t*(-1);}
			double kk=(double)t/32362;
			kk=kk*k;
			automata[i]=(int)kk;}
		 break;}
		
	case 6:{
		long siecin = 48271; //16807=7 elevado a 5,
		long x= 2147483647l; //2147483647 = 2 elevado a 31 - 1
		 for(int i=0;i<automata.length;i++){
				t=(t*siecin)%x;
				double kk=(double)t/x;
				kk=kk*k;
				automata[i]=(int)kk;}
		 break;}
	
	case 7:{
		long siecin = 65539; //16807=7 elevado a 5,
		long x= 2147483648l; //2147483647 = 2 elevado a 31 
		 for(int i=0;i<automata.length;i++){
				t=(t*siecin)%x;
				double kk=(double)t/x;
				kk=kk*k;
				automata[i]=(int)kk;}
		 break;}
	default:break;}
	t=1;
}

public int vivas(){
	int vivas=0;
	for(int i =0;i<automata.length;i++){
		if(automata[i]!=0){vivas=vivas+1;}
	}
	return vivas;
	
}

public int muerta(){
	int muertas=0;
	for(int i =0;i<automata.length;i++){
		if(automata[i]==0){muertas=muertas+1;}
	}
	return muertas;
}
}





