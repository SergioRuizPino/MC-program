import java.util.Random;
//import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * @author:Sergio Ruiz Pino
 * @version: 1.0
 */
public class Life implements Runnable {
	static int tam;
	private static int nucleos = Runtime.getRuntime().availableProcessors();
	private long tVentana;
	private int desde = 0, hasta = 0; // auxiliares usados para concurrencia
	static int[][] LIFE;
	static int[][] LIFEAUX;
	static int vivas = 0, muertas = 0;

	Life(int n) {
		tam = n;
		LIFE = new int[n][n];
		tVentana = n / nucleos;
		LIFEAUX = new int[n][n];
		Random r1 = new Random(System.currentTimeMillis());
		for (int i = 0; i < LIFE.length; i++) {
			for (int j = 0; j < LIFE[i].length; j++) {
				LIFE[i][j] = r1.nextInt(2);// 2 PARA QUE ESTEN 0 y 1;
				if (LIFE[i][j] == 1) {
					vivas++;
				} else {
					muertas++;
				}
			}
		}
		// estados();
	}

	Life(int n, int m) {// Contructor concurr
		desde = n;
		hasta = m;
	}// usado para crear tareas de forma concurrente cuidado causa excepciones
		// si se usa mal

	public void run() {
		for (int i = desde; i < hasta; i++)
			for (int j = 0; j < LIFE[i].length; j++)
				LIFEAUX[i][j] = nuevoEst(i, j);
	}

	public void nextgen()// calcula la siguiente generacion de LIFE
	{
		int i = 0;
		int f = (int) tVentana;

		ExecutorService ejecutor = Executors.newFixedThreadPool(nucleos);
		for (int ii = 1; ii <= nucleos; ii++) {
			ejecutor.execute(new Life(i, f));
			i = (int) (tVentana);
			f = (int) (f + tVentana);
		}

		ejecutor.shutdown();
		while (!ejecutor.isTerminated());

		// LLAMAR A ESTADOS ACTUALIZA VIDA DESPUES DE EXECUTOR ACABE
		LIFE = LIFEAUX.clone();
		estados();
	}

	private void estados() {
		int contV = 0;
		int contM = 0;
		for (int i = 0; i < LIFE.length; i++)
			for (int j = 0; j < LIFE[i].length; j++)
				if (LIFE[i][j] == 1)
					contV++;
				else
					contM++;

		vivas = contV;
		muertas = contM;
	}

	public static int viva() {
		return vivas;
	}

	public static int muerta() {
		return muertas;
	}

	private int nuevoEst(int pos, int pos2) {// Función calcula sucesores los
												// hilos la llamaran haciendo el
												// trabajo mas sencillo y
												// abstracto
		int cont = 0;
		int newEst = LIFE[pos][pos2];
		for (int i = pos - 1; i <= pos + 1; i++) {// 1 y -1 vencidad automata
													// LIFE es 1
			for (int j = pos2 - 1; j <= pos2 + 1; j++) {
				if (i < 0) {
					int aux = LIFE.length + i;
					if (j < 0) {
						int aux2 = LIFE[aux].length + j;
						if (LIFE[aux][aux2] == 1) {
							cont++;
						}
					} else {// else 2º if
						if (j >= LIFE[aux].length) {
							int aux2 = j % LIFE[aux].length;
							if (LIFE[aux][aux2] == 1) {
								cont++;
							}
						} else {
							if (LIFE[aux][j] == 1) {
								cont++;
							}
						}
					} // Fin condiciones i>0{j<0 y j>0

				} else {// else 1º if
					if (i >= LIFE.length) {
						int aux = i % LIFE.length;
						if (j < 0) {
							int aux2 = LIFE[aux].length + j;
							if (LIFE[aux][aux2] == 1) {
								cont++;
							}
						} else {
							if (j >= LIFE[aux].length) {
								int aux2 = j % LIFE[aux].length;
								if (LIFE[aux][aux2] == 1) {
									cont++;
								}
							} else {
								if (LIFE[aux][j] == 1) {
									cont++;
								}
							}
						}
					} else {
						if (j < 0) {
							int aux2 = LIFE[i].length + j;
							if (LIFE[i][aux2] == 1) {
								cont++;
							}
						} else {
							if (j >= LIFE[i].length) {
								int aux2 = j % LIFE[i].length;
								if (LIFE[i][aux2] == 1) {
									cont++;
								}
							} else {
								if (LIFE[i][j] == 1) {
									cont++;
								}
							}

						}

					}
				}
			} // 2º FOR
		} // 1º FOR
		if (LIFE[pos][pos2] == 1) {
			cont--;
		} // Antes hemos recorrido un cuadrado 3x3 vecinas y celula a generar si
			// cg==1 la hemos sumado,debemos borrarla
		if (cont < 2) {
			newEst = 0;
		}
		if (3 < cont) {
			newEst = 0;
		}
		if (cont == 3 && LIFE[pos][pos2] == 0) {
			newEst = 1;
		}
		if ((cont == 2 || cont == 3) && LIFE[pos][pos2] == 1) {
			newEst = 1;
		}
		return newEst;
	}// Fin funcion

}// fin clase
