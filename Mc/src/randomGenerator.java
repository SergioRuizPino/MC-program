/*
 * @author = Sergio Ruiz Pino
 * @version 1.0
 *
 */

import java.util.Scanner;


public class randomGenerator {
	public static void main(String [] args){
		int opcion,valgen;
		Scanner tec = new Scanner(System.in);
		System.out.println("Introduce una opcion valida");
		System.out.println("1)Generador y=(5x) mod 2^5");
		System.out.println("2)Generador y=(7x) mod 2^5");
		System.out.println("3)Generador y=(3x) mod 31");
		System.out.println("4)Generador y=(7^5 * x) mod (2^31 - 1)");
		System.out.println("5)Generador combinado");
		System.out.println("6)Generador de Fishman y Moore");
		System.out.println("7)Generador RANDU");
		System.out.println("8)Salir");
		opcion = tec.nextInt();
		switch(opcion){
		case 1:	System.out.println("El numero de valores a generar");valgen = tec.nextInt();generador1(valgen);break;
		case 2: System.out.println("El numero de valores a generar");valgen = tec.nextInt();generador2(valgen);break;
		case 3: System.out.println("El numero de valores a generar");valgen = tec.nextInt();generador3(valgen);break;
		case 4: System.out.println("El numero de valores a generar");valgen = tec.nextInt();generador4(valgen);break;
		case 5: System.out.println("El numero de valores a generar");valgen = tec.nextInt();generador5(valgen);break;
		case 6: System.out.println("El numero de valores a generar");valgen = tec.nextInt();generador6(valgen);break;
		case 7: System.out.println("El numero de valores a generar");valgen = tec.nextInt();generador7(valgen);break;
		case 8: break;
		default:System.out.println("Opcion Invalida");
		}
		tec.close();
	}
	
	public static void generador1(int valgen){
		int ale=1;
		System.out.println("semilla inicial : "+ale);
		for(int generado=1;generado<=valgen;generado++){
			ale=(5*ale)%32;
			double normalizado=(double)ale/32;
			System.out.println(normalizado);
		}
	}
	public static void generador2(int valgen){
		int ale=1;
		System.out.println("semilla inicial : "+ale);
		for(int generado=1;generado<=valgen;generado++){
			ale=(7*ale)%32;
			double normalizado=(double)ale/32;
			System.out.println(normalizado);
		}
	}
	
	public static void generador3(int valgen){
		int ale=1;
		System.out.println("semilla inicial : "+ale);
		for(int generado=1;generado<=valgen;generado++){
			ale=(3*ale)%31;
			double normalizado=(double)ale/31;
			System.out.println(normalizado);
		}
	}
	public static void generador4(int valgen){
		long ale= 1l;
		long siecin = 16807l; //16807=7 elevado a 5,
		long t= 2147483647l; //2147483647 = 2 elevado a 31 - 1
		System.out.println("semilla inicial : "+ale);
		for(int generado=1;generado<=valgen;generado++){
			ale=(ale*siecin)%t; 
			double normalizado=(double)ale/t;
			System.out.println(normalizado);
		}
	}
	
	public static void generador5(int valgen){
		int ale=1,aux=1,aux2=1,aux3=1;
		System.out.println("semilla inicial : "+ale);
		for(int generado=1;generado<=valgen;generado++){
			aux=(157*aux)%32363;
			aux2=(146*aux2)%31727;
			aux3=(142*aux3)%31657;
			ale=(aux-aux2+aux3)%32362;
			double normalizado=(double)ale/32362;
			System.out.println(normalizado);
		}
	}
	
	public static void generador6(int valgen){
		long ale= 1l;
		int siecin = 48271;
		long t= 2147483647l; //2147483647 = 2 elevado a 31 - 1
		System.out.println("semilla inicial : "+ale);
		for(int generado=1;generado<=valgen;generado++){
			ale=(ale*siecin)%t; 
			double normalizado=(double)ale/t;
			System.out.println(normalizado);
		}

		}
	
	public static void generador7(int valgen){
		long ale=1l;
		int siecin =65539;
		long t= 2147483648l; //2147483648 = 2 elevado a 31
		System.out.println("semilla inicial : "+ale);
		for(int generado=1;generado<=valgen;generado++){
			ale=(ale*siecin)%t; 
			double normalizado=(double)ale/t;
			System.out.println(normalizado);
		}
	}
	
	}

