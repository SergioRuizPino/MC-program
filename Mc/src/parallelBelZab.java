import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class parallelBelZab implements Runnable {
	
	static float [][][] a;
	static float [][][] b;
	static float [][][] c;
	private static int nucleos = Runtime.getRuntime().availableProcessors();
	private static long tVentana;
	private int desde = 0, hasta = 0; // auxiliares usados para concurrencia
	static int p = 0;
	static int q = 1;
	static int width = 500;  //TAMAÑO CANVAS
	static int height = 500;
	static float alfa;  //USUARIO
	static float beta;  //USUARIO 
	static float gamma; //USUARIO
	
	parallelBelZab()
	{
		a = new float [width][height][2];
		b = new float [width][height][2];
		c = new float [width][height][2];
		tVentana = width / nucleos;
		for (int x = 0; x < width ; x ++) {
			for (int y = 0; y < height ; y ++) {
				Random ale = new Random(System.currentTimeMillis());
				a[x][y][p] = ale.nextFloat();
				b[x][y][p] = ale.nextFloat();
				c[x][y][p] = ale.nextFloat();
												}
											}		
	}
	
	parallelBelZab(int n, int m) {// Contructor concurr
		desde = n;
		hasta = m;
	}
	
	
	static void  compute()
	{
		int i = 0;
		int f = (int) tVentana;
		ExecutorService ejecutor = Executors.newFixedThreadPool(nucleos);
		for (int ii = 1; ii <= nucleos; ii++) {
			ejecutor.execute(new parallelBelZab(i, f));
			i = (int) (tVentana);
			f = (int) (f + tVentana);
		}

		ejecutor.shutdown();
		while (!ejecutor.isTerminated());

		if(p==0){p = 1; q = 0;}else {p = 0; q = 1;}
	}
	
	static float constrain(float b)
	{
		if(b<=0){return  0.0f;}else{
		if(b>=1){return  1.0f;}else{return b;}}
		
		
	}
	
	public void run(){
		for (int x = desde; x < hasta ; x++)
		{
			for (int y = 0; y < height ; y++)
			{
				float c_a = 0;
				float c_b = 0;
				float c_c = 0;
				for (int i = x-1; i <= x+1; i++){
					for (int j = y - 1; j <= y +1; j++) {
						c_a += a[(i+ width)%width][(j+height)%height][p];
						c_b += b[(i+ width)%width][(j+height)%height][p];
						c_c += c[(i+ width)%width][(j+height)%height][p];
														}
												}
				c_a /= 9.0;
				c_b /= 9.0;
				c_c /= 9.0;
				a[x][y][q] = constrain(c_a+c_a*(alfa*c_b-gamma*c_c));
				b[x][y][q] = constrain(c_b+c_b*(beta*c_c-alfa*c_a));
				c[x][y][q] = constrain(c_c+c_c*(gamma*c_a-beta*c_b));
			}
		}
		
	}

}
