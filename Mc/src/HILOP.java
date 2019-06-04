/* 
 * author:Sergio Ruiz Pino
 * version:1.1
 */

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.lang.Math;
import javax.swing.*;

//Primera Pestaña

@SuppressWarnings("serial")
class pintar_distA extends Canvas {// CLASE USADA PARA DIBUJAR LAS GENERACIONES
									// ALEATORIAS CORREGIRLA
	int ancho = (int) (Toolkit.getDefaultToolkit().getScreenSize().width);
	int alto = (int) (Toolkit.getDefaultToolkit().getScreenSize().height);
	int pent = 0, valgen;// auxiliares para los generadores
	double ale = 1;

	public void paint(Graphics g) {// METODO PARA DIBUJAR EN EL CANVAS
		switch (pent) {
		case 1: {
			g.setColor(Color.yellow);
			for (int generado = 1; generado <= valgen; generado++)
			{
				double auxx = ale;
				ale = (5 * ale) % 32;
				double nor = ale / 32;
				int x = (int) ((ancho - ancho / 3) * (auxx / 32));
				int y = (int) ((alto - 150) * nor);
				g.drawRect(x, y, 1, 1);
			}
			ale = 1;
			break;
		}

		case 2: {
			g.setColor(Color.yellow);
			for (int generado = 1; generado <= valgen; generado++) {
				double auxx = ale;
				ale = (7 * ale) % 32;
				double nor = ale / 32;
				int x = (int) ((ancho - ancho / 3) * (auxx / 32));
				int y = (int) ((alto - 150) * nor);
				g.drawRect(x, y, 1, 1);
			}
			ale = 1;
			break;
		}
		case 3: {
			g.setColor(Color.yellow);
			for (int generado = 0; generado <= valgen; generado++) {
				double auxx = ale;
				ale = (3 * ale) % 31;
				double nor = ale / 31;
				int x = (int) ((ancho - ancho / 3) * (auxx / 31));
				int y = (int) ((alto - 150) * nor);
				g.drawRect(x, y, 1, 1);
			}
			ale = 1;
			break;
		}

		case 4: {
			g.setColor(Color.yellow);
			int siecin = 16807; // 16807=7 elevado a 5,
			long t = 2147483647l; // 2147483647 = 2 elevado a 31 - 1
			for (int generado = 1; generado <= valgen; generado++) {
				double auxx = ale;
				ale = (ale * siecin) % t;
				double nor = (double) ale / t;
				int x = (int) ((ancho - ancho / 3) * (auxx / t));
				int y = (int) ((alto - 150) * nor);
				g.drawRect(x, y, 1, 1);
			}
			ale = 1;
			break;
		}

		case 5: {
			int aux = 1, aux2 = 1, aux3 = 1;
			g.setColor(Color.yellow);
			for (int generado = 1; generado <= valgen; generado++) {
				double auxx = ale;
				aux = (157 * aux) % 32363;
				aux2 = (146 * aux2) % 31727;
				aux3 = (142 * aux3) % 31657;
				ale = (aux - aux2 + aux3) % 32362;
				double nor = ale / 32362;
				int x = (int) ((ancho - ancho / 3) * (auxx / 32362));
				int y = (int) ((alto - 150) * nor);
				g.drawRect(x, y, 1, 1);
			}
			ale = 1;
			break;
		}

		case 6: {
			g.setColor(Color.yellow);
			int siecin = 48271; // 16807=7 elevado a 5,
			long t = 2147483647l; // 2147483647 = 2 elevado a 31 - 1
			for (int generado = 1; generado <= valgen; generado++) {
				double auxx = ale;
				ale = (ale * siecin) % t;
				double nor = (double) ale / t;
				int x = (int) ((ancho - ancho / 3) * (auxx / t));
				int y = (int) ((alto - 150) * nor);
				g.drawRect(x, y, 1, 1);
			}
			ale = 1;
			break;
		}

		case 7: {
			g.setColor(Color.yellow);
			int siecin = 65539; // 16807=7 elevado a 5,
			long t = 2147483648l; // 2147483647 = 2 elevado a 31
			for (int generado = 1; generado <= valgen; generado++) {
				double auxx = ale;
				ale = (ale * siecin) % t;
				double nor = (double) ale / t;
				int x = (int) ((ancho - ancho / 3) * (auxx / t));
				int y = (int) ((alto - 150) * nor);
				g.drawRect(x, y, 1, 1);
			}
			ale = 1;
			break;
		}

		}
	}

	public void generador1(int valgen) {
		pent = 1;
		this.valgen = valgen;
	}

	public void generador2(int valgen) {
		pent = 2;
		this.valgen = valgen;
	}

	public void generador3(int valgen) {
		pent = 3;
		this.valgen = valgen;
	}

	public void generador4(int valgen) {
		pent = 4;
		this.valgen = valgen;
	}

	public void generador5(int valgen) {
		pent = 5;
		this.valgen = valgen;
	}

	public void generador6(int valgen) {
		pent = 6;
		this.valgen = valgen;
	}

	public void generador7(int valgen) {
		pent = 7;
		this.valgen = valgen;
	}
}

class distribucionAle {// CLASE PARA CREAR LA VENTANA DE LAS GENERECIONES
						// ALETORIAS
	int ancho = (int) (Toolkit.getDefaultToolkit().getScreenSize().width);
	int alto = (int) (Toolkit.getDefaultToolkit().getScreenSize().height);
	JFrame dist = new JFrame("Generadores Aleatorios");

	distribucionAle() throws ParseException {
		dist.setResizable(false);
		dist.setSize(ancho - 150, alto - 150);
		dist.setVisible(true);
		pintar_distA dibujo = new pintar_distA();
		dist.setLayout(null);
		dibujo.setBackground(Color.BLACK);
		dibujo.setBounds(22, 22, ancho - ancho / 3, alto - 250);
		dist.add(dibujo);
		JComboBox<String> cajadis = new JComboBox<String>();
		cajadis.setBounds(ancho - 420, alto - 650, 250, 25);
		dist.add(cajadis);
		dist.setLocationRelativeTo(null);
		cajadis.addItem("Generador y=(5x) mod 2^5");
		cajadis.addItem("Generador y=(7x) mod 2^5");
		cajadis.addItem("Generador y=(3x) mod 31");
		cajadis.addItem("Generador y=(7^5 * x) mod (2^31 - 1)");
		cajadis.addItem("Generador combinado");
		cajadis.addItem("Generador de Fishman y Moore");
		cajadis.addItem("Generador RANDU");
		JFormattedTextField generador = new JFormattedTextField();
		generador.setBounds(ancho - 270, alto - 475, 100, 20);
		dist.add(generador);
		JLabel et6 = new JLabel("GENERACIONES :");
		et6.setBounds(ancho - 370, alto - 475, 100, 20);
		dist.add(et6);
		JLabel et5 = new JLabel("SELECCIONE UN GENERADOR");
		et5.setFont(new Font("Tahoma", Font.ITALIC, 18));
		et5.setBounds(ancho - 420, alto - 700, 250, 25);
		dist.add(et5);
		JButton dibujando = new JButton("DIBUJAR");
		dibujando.setBounds(ancho - 370, alto - 575, 100, 25);
		dist.add(dibujando);
		// Eventos y acciones
		generador.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int longitud = 0;
				char caracter = e.getKeyChar();
				longitud = longitud + 1;
				if ((caracter < '0') || (caracter > '9')) {
					e.consume();
				} // CONTROLA VALOR DE ENTRADA 0 A 9
				if (generador.getText().length() == 5) {
					e.consume();
				}
			}// CONTROLA QUE LONGITUD <=5 PARA EVITAR DESBORDAMIENTO
		});
		cajadis.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arge) {
				dibujo.pent = 0;
				;// CUANDO REPINTEMOS NO SE MEZCLEN GENERACIONES
				dibujo.repaint();
			}
		});
		dibujando.addActionListener(new ActionListener() {// CONTROL DEL BOTON
															// DE DIBUJO
			public void actionPerformed(ActionEvent e) {
				Graphics g = dibujo.getGraphics();
				String cn = generador.getText();
				int valor = Integer.parseInt(cn);
				String objeto = (String) cajadis.getSelectedItem();// EXTRAEMOS
																	// DEL
																	// JCOMBOBOX
																	// EL
																	// ELEMENTO
																	// MARCADO
				if ("Generador y=(5x) mod 2^5" == objeto) {// SEGUN SEA EL
															// ELEMENTO,SE
															// PINTARA UNA
															// GENERACION
															// DIFERENTE
					dibujo.generador1(valor);
					dibujo.paint(g);
				}
				if ("Generador y=(7x) mod 2^5" == objeto) {
					dibujo.generador2(valor);
					dibujo.paint(g);
				}
				if ("Generador y=(3x) mod 31" == objeto) {
					dibujo.generador3(valor);
					dibujo.paint(g);
				}
				if ("Generador y=(7^5 * x) mod (2^31 - 1)" == objeto) {
					dibujo.generador4(valor);
					dibujo.paint(g);
				}
				if ("Generador combinado" == objeto) {
					dibujo.generador5(valor);
					dibujo.paint(g);
				}
				if ("Generador de Fishman y Moore" == objeto) {
					dibujo.generador6(valor);
					dibujo.paint(g);
				}
				if ("Generador RANDU" == objeto) {
					dibujo.generador7(valor);
					dibujo.paint(g);
				}
			}
		});
	}

};

@SuppressWarnings("serial")
class pintarAuto extends Canvas {// Clase pintar automata
	int gen = 0;
	int y = 1;
	ca1DSimulator automata;

	public void paint(Graphics g) {
		//BufferedImage imagen = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		for (int i = 1; i <= gen; i++) {
			for (int j = 0; j < ca1DSimulator.automata.length; j++) {
				switch (ca1DSimulator.automata[j]) {
				case 0: {
					g.setColor(Color.black);
					g.drawRect(j, y, 1, 1);
					break;
				}
				case 1: {
					g.setColor(Color.cyan);
					g.drawRect(j, y, 1, 1);
					break;
				}
				case 2: {
					g.setColor(Color.green);
					g.drawRect(j, y, 1, 1);
					break;
				}
				case 3: {
					g.setColor(Color.orange);
					g.drawRect(j, y, 1, 1);
					break;
				}
				case 4: {
					g.setColor(Color.yellow);
					g.drawRect(j, y, 1, 1);
					break;
				}
				case 5: {
					g.setColor(Color.pink);
					g.drawRect(j, i, y, 1);
					break;
				}
				case 6: {
					g.setColor(Color.BLUE);
					g.drawRect(j, i, y, 1);
					break;
				}
				case 7: {
					g.setColor(Color.GRAY);
					g.drawRect(j, i, y, 1);
					break;
				}
				case 8: {
					g.setColor(Color.MAGENTA);
					g.drawRect(j, i, y, 1);
					break;
				}
				case 9: {
					g.setColor(Color.WHITE);
					g.drawRect(j, i, y, 1);
					break;
				}
				case 10: {
					g.setColor(Color.RED);
					g.drawRect(j, i, y, 1);
					break;
				}
				case 11: {
					g.setColor(Color.DARK_GRAY);
					g.drawRect(j, i, y, 1);
					break;
				}
				case 12: {
					g.setColor(Color.LIGHT_GRAY);
					g.drawRect(j, i, y, 1);
					break;
				}
				}

			}
			automata.nextGen();
			y = y + 1;
			if (y == this.getHeight()) {
				y = 1;
				g.clearRect(0, 0, this.getWidth(), this.getHeight());

			}
		}
		y = 1;
	}
}

@SuppressWarnings("serial")
class pintarGraf extends Canvas {
	int gen;
	ca1DSimulator graficas;

	public void paint(Graphics g) {
		for (int i = 0; i < gen; i++) {
			int v = graficas.vivas();
			int m = graficas.muerta();
			graficas.nextGen();
			g.setColor(Color.green);
			g.drawString("vivas", 100, 100);
			int v2 = graficas.vivas();
			int m2 = graficas.muerta();
			g.drawLine(i, v, i + 1, v2);
			g.setColor(Color.yellow);
			g.drawString("muertas", 100, 125);
			g.drawLine(i, m, i + 1, m2);
		}
	}
}

@SuppressWarnings("serial")
class pintarHam extends Canvas {
	private int ancho = (int) (Toolkit.getDefaultToolkit().getScreenSize().width);
	int gen;
	int coody, coodya;
	static ca1DSimulator graficas;
	int[] antiguo = new int[ancho - ancho / 3];
	int auxd = 0;

	pintarHam(ca1DSimulator auto) {
		graficas = auto;
	}

	public void paint(Graphics g) {
		g.setColor(Color.green);
		g.drawString("x:TIEMPO", 25, 25);
		g.drawString("Y:DISTANCIA HAMMING", 25, 40);
		g.setColor(Color.green);
		for (int i = 0; i <= gen; i++) {
			antiguo = ca1DSimulator.automata.clone();
			coody = auxd;
			graficas.nextGen();
			auxd = 0;
			for (int j = 0; j < ca1DSimulator.automata.length; j++) 
				if (ca1DSimulator.automata[j] != antiguo[j]) 
					auxd = auxd + 1;

			coodya = auxd;
			g.drawLine(i, 900 - coody, i + 1, 900 - coodya);
		}
	}
}

@SuppressWarnings("serial")
class pintarEntro extends Canvas {
	int gen, valor;
	double entro, entroa;
	static ca1DSimulator graficas;
	static double[] prob;

	public pintarEntro(ca1DSimulator aux, int aux2) {
		graficas = aux;
		prob = new double[aux2];
		valor = aux2;
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawString("ENTROPIA", 25, 25);
		for (int i = 1; i <= gen; i++) {
			entro = entroa;
			for (int j = 0; j < ca1DSimulator.automata.length; j++) {
				switch (ca1DSimulator.automata[j]) {
				case 0: {
					prob[0]++;
					break;
				}
				case 1: {
					prob[1]++;
					break;
				}
				case 2: {
					prob[2]++;
					break;
				}
				case 3: {
					prob[3]++;
					break;
				}
				case 4: {
					prob[4]++;
					break;
				}
				case 5: {
					prob[5]++;
					break;
				}
				case 6: {
					prob[6]++;
					break;
				}
				case 7: {
					prob[7]++;
					break;
				}
				case 8: {
					prob[8]++;
					break;
				}
				case 9: {
					prob[9]++;
					break;
				}
				case 10: {
					prob[10]++;
					break;
				}
				case 11: {
					prob[11]++;
					break;
				}
				case 12: {
					prob[12]++;
					break;
				}
				}
			}
			entroa = 0;
			for (int j = 0; j < prob.length; j++) {
				if (prob[j] != 0) {
					entroa = ((prob[j] / ca1DSimulator.automata.length)
							* ((Math.log(prob[j] / ca1DSimulator.automata.length)) / (Math.log(valor)))) + entroa;
				}
				prob[j] = 0;
			}
			entroa = (-1) * entroa;
			g.drawLine(i, (int) (900 - (this.getWidth() * entro)), i + 1, (int) (900 - this.getWidth() * entroa));
			graficas.nextGen();
		}
	}
}

@SuppressWarnings("serial")
class Pestaña1 extends JPanel {
	pintarAuto dibujo = new pintarAuto();
	int ancho = (int) (Toolkit.getDefaultToolkit().getScreenSize().width);
	int alto = (int) (Toolkit.getDefaultToolkit().getScreenSize().height);

	Pestaña1() {
		this.setLayout(null);
		JButton EntropiT = new JButton("Entropia.T");
		JButton boton = new JButton("Cuadro de");
		JButton boton2 = new JButton("Acerca de");
		JButton dibujando = new JButton("Dibujar");
		JButton DistaH = new JButton("D.Hamming");
		JButton DistaHM = new JButton("D.H.media");
		JButton Entropia = new JButton("Entropia");
		JButton EntropiaM = new JButton("Entropia.M");
		JButton graficas = new JButton("Grafica.P");
		JButton encrip = new JButton("Encriptar");
		JRadioButton opcionD3 = new JRadioButton("Frontera ciclica");
		JRadioButton opcionD = new JRadioButton("Frontera nula");
		ButtonGroup bg = new ButtonGroup();
		bg.add(opcionD3);
		bg.add(opcionD);
		opcionD3.setSelected(true);
		JLabel et1 = new JLabel("Vecindad :");
		JLabel et2 = new JLabel("Estados del automata :");
		JLabel et3 = new JLabel("Regla:");
		JLabel et5 = new JLabel("SELECCIONE UN GENERADOR");
		JLabel et6 = new JLabel("GENERACIONES :");
		JLabel et4 = new JLabel("Frontera");
		JLabel et7 = new JLabel("Resultados");
		JLabel et8 = new JLabel("Celula");
		et7.setBounds(ancho - 160, alto - 370, 100, 25);
		et4.setFont(new Font("Tahoma", Font.ITALIC, 18));
		et4.setBounds(ancho - 380, alto - 510, 100, 25);
		et5.setToolTipText("Con el cual se generarán valores para ser mostrados graficamente en la parte izquierda");
		dibujando.setToolTipText(
				"Click para dibuja  el numero de puntos que aparece en generaciones usando el generador seleccionado");
		JSpinner variablex = new JSpinner();
		variablex.setModel(new SpinnerNumberModel(2, 2, 13, 1));
		JSpinner variabley = new JSpinner();
		variabley.setModel(new SpinnerNumberModel(1, 1, 6, 1));
		JSpinner regla = new JSpinner();
		regla.setBounds(ancho - 270, alto - 430, 100, 20);
		regla.setModel(new SpinnerNumberModel(0, 0, 2000000000, 1));
		JSpinner ET = new JSpinner();
		ET.setModel(new SpinnerNumberModel(0, 0, ancho - ancho / 3 - 1, 1));
		ET.setBounds(ancho - 330, alto - 220, 50, 20);
		JFormattedTextField generador = new JFormattedTextField();
		JFormattedTextField resultado = new JFormattedTextField();
		resultado.setBounds(ancho - 160, alto - 345, 100, 25);
		resultado.setBackground(Color.WHITE);
		resultado.setEditable(false);
		generador.setBounds(ancho - 270, alto - 400, 100, 20);
		JComboBox<String> cajadis = new JComboBox<String>();
		cajadis.setBounds(ancho - 380, alto - 740, 250, 25);
		et8.setBounds(ancho - 380, alto - 220, 75, 20);
		et6.setBounds(ancho - 380, alto - 400, 100, 20);
		et3.setBounds(ancho - 330, alto - 430, 100, 20);
		et1.setBounds(ancho - 220, alto - 580, 100, 20);
		et2.setBounds(ancho - 380, alto - 580, 150, 20);
		et5.setFont(new Font("Tahoma", Font.ITALIC, 18));
		et5.setBounds(ancho - 380, alto - 770, 400, 20);
		EntropiT.setBounds(ancho - 380, alto - 255, 100, 25);
		boton.setBounds(ancho - 270, alto - 255, 100, 25);
		boton2.setBounds(ancho - 160, alto - 255, 100, 25);
		opcionD.setBounds(ancho - 220, alto - 480, 100, 25);
		variablex.setBounds(ancho - 380, alto - 550, 100, 20);
		variabley.setBounds(ancho - 220, alto - 550, 100, 20);
		dibujando.setBounds(ancho - 140, alto - 400, 100, 25);
		encrip.setBounds(ancho - 140, alto - 440, 100, 25);
		DistaH.setBounds(ancho - 270, alto - 300, 100, 25);
		DistaHM.setBounds(ancho - 380, alto - 300, 100, 25);
		Entropia.setBounds(ancho - 160, alto - 300, 100, 25);
		EntropiaM.setBounds(ancho - 380, alto - 345, 100, 25);
		graficas.setBounds(ancho - 270, alto - 345, 100, 25);
		opcionD3.setBounds(ancho - 380, alto - 480, 150, 25);
		variablex.setEditor(new JSpinner.DefaultEditor(variablex));
		variabley.setEditor(new JSpinner.DefaultEditor(variabley));
		this.add(et1);
		this.add(et2);
		this.add(et3);
		this.add(et4);
		this.add(et5);
		this.add(et6);
		this.add(et7);
		this.add(et8);
		this.add(boton);
		this.add(boton2);
		this.add(opcionD);
		this.add(opcionD3);
		this.add(generador);
		this.add(ET);
		this.add(variabley);
		this.add(dibujando);
		this.add(cajadis);
		this.add(regla);
		this.add(DistaH);
		this.add(DistaHM);
		this.add(Entropia);
		this.add(EntropiaM);
		this.add(resultado);
		this.add(graficas);
		this.add(EntropiT);
		this.add(variablex);
		this.add(encrip);
		this.setVisible(true);
		// CONFIGURACIÓN DE LOS EVENTOS SOBRE BOTONES Y BARRA MENU
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame cuadro = new JFrame("CUADRO DE");
				cuadro.setSize(600, 400);
				cuadro.setVisible(true);
				cuadro.setLocationRelativeTo(null);
			}
		});

		DistaH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valor = (Integer) variablex.getValue();
				int valor2 = (Integer) variabley.getValue();
				int valor3 = (Integer) regla.getValue();
				boolean front = opcionD3.isSelected();
				ca1DSimulator aux = new ca1DSimulator(valor, valor2, front);
				ca1DSimulator.crearreglak(valor3);
				String cn = generador.getText();
				int valor4 = Integer.parseInt(cn);
				String objeto = (String) cajadis.getSelectedItem();// EXTRAEMOS
																	// DEL
																	// JCOMBOBOX
																	// EL
																	// ELEMENTO
																	// MARCADO
				if ("Generador y=(5x) mod 2^5" == objeto)aux.inicial(1);
				if ("Generador y=(7x) mod 2^5" == objeto) {
					aux.inicial(2);
				}
				if ("Generador y=(3x) mod 31" == objeto) {
					aux.inicial(3);
				}
				if ("Generador y=(7^5 * x) mod (2^31 - 1)" == objeto) {
					aux.inicial(4);
				}
				if ("Generador combinado" == objeto) {
					aux.inicial(5);
				}
				if ("Generador de Fishman y Moore" == objeto) {
					aux.inicial(6);
				}
				if ("Generador RANDU" == objeto) {
					aux.inicial(7);
				}
				JFrame graf = new JFrame("DISTANCIA DE HAMMING");
				graf.setSize(ancho - ancho / 3, alto - 50);
				pintarHam grafica = new pintarHam(aux);
				grafica.setBackground(Color.BLACK);
				graf.add(grafica);
				grafica.gen = valor4;
				graf.setVisible(true);
				Graphics g = grafica.getGraphics();
				grafica.paint(g);
			}
		});

		EntropiT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int j = (Integer) ET.getValue();
				int valor = (Integer) variablex.getValue();
				int valor2 = (Integer) variabley.getValue();
				int valor3 = (Integer) regla.getValue();
				boolean front;
				if (opcionD3.isSelected()) {
					front = true;
				} else {
					front = false;
				}
				ca1DSimulator aux = new ca1DSimulator(valor, valor2, front);
				ca1DSimulator.crearreglak(valor3);
				String cn = generador.getText();
				int valor4 = Integer.parseInt(cn);
				double[] prob = new double[valor];
				double entropi = 0;
				String objeto = (String) cajadis.getSelectedItem();// EXTRAEMOS
																	// DEL
																	// JCOMBOBOX
																	// EL
																	// ELEMENTO
																	// MARCADO
				if ("Generador y=(5x) mod 2^5" == objeto) {
					aux.inicial(1);
				}
				if ("Generador y=(7x) mod 2^5" == objeto) {
					aux.inicial(2);
				}
				if ("Generador y=(3x) mod 31" == objeto) {
					aux.inicial(3);
				}
				if ("Generador y=(7^5 * x) mod (2^31 - 1)" == objeto) {
					aux.inicial(4);
				}
				if ("Generador combinado" == objeto) {
					aux.inicial(5);
				}
				if ("Generador de Fishman y Moore" == objeto) {
					aux.inicial(6);
				}
				if ("Generador RANDU" == objeto) {
					aux.inicial(7);
				}
				for (int i = 1; i <= valor4; i++) {
					++prob[ca1DSimulator.automata[j]];
					aux.nextGen();
				}
				

				for (int i = 0; i < prob.length; i++) {
					if (prob[i] != 0) {
						entropi = (prob[i] / valor4) * ((Math.log(prob[i] / valor4)) / (Math.log(valor))) + entropi;
						prob[i] = 0;
					}
				}
				entropi = (-1) * entropi;
				resultado.setValue(entropi);

			}
		});

		DistaHM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] antiguo = new int[ancho - ancho / 3];
				int valor = (Integer) variablex.getValue();
				int valor2 = (Integer) variabley.getValue();
				int valor3 = (Integer) regla.getValue();
				String cn = generador.getText();
				int valor4 = Integer.parseInt(cn);
				int hamiM = 0;
				boolean front;
				if (opcionD3.isSelected()) {
					front = true;
				} else {
					front = false;
				}
				ca1DSimulator aux = new ca1DSimulator(valor, valor2, front);
				ca1DSimulator.crearreglak(valor3);
				String objeto = (String) cajadis.getSelectedItem();// EXTRAEMOS
																	// DEL
																	// JCOMBOBOX
																	// EL
																	// ELEMENTO
																	// MARCADO
				if ("Generador y=(5x) mod 2^5" == objeto) {
					aux.inicial(1);
				}
				if ("Generador y=(7x) mod 2^5" == objeto) {
					aux.inicial(2);
				}
				if ("Generador y=(3x) mod 31" == objeto) {
					aux.inicial(3);
				}
				if ("Generador y=(7^5 * x) mod (2^31 - 1)" == objeto) {
					aux.inicial(4);
				}
				if ("Generador combinado" == objeto) {
					aux.inicial(5);
				}
				if ("Generador de Fishman y Moore" == objeto) {
					aux.inicial(6);
				}
				if ("Generador RANDU" == objeto) {
					aux.inicial(7);
				}
				for (int i = 1; i <= valor4; i++) {
					antiguo = ca1DSimulator.automata.clone();
					aux.nextGen();
					for (int j = 0; j < ca1DSimulator.automata.length; j++) {
						if (ca1DSimulator.automata[j] != antiguo[j]) {
							hamiM = hamiM + 1;
						}
					}

				}
				if (valor4 == 0) {
					valor4 = valor4 + 1;
				}
				hamiM = hamiM / valor4;
				resultado.setValue(hamiM);
			}
		});

		Entropia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valor = (Integer) variablex.getValue();
				int valor2 = (Integer) variabley.getValue();
				int valor3 = (Integer) regla.getValue();
				boolean front;
				if (opcionD3.isSelected()) {
					front = true;
				} else {
					front = false;
				}
				ca1DSimulator aux = new ca1DSimulator(valor, valor2, front);
				ca1DSimulator.crearreglak(valor3);
				String cn = generador.getText();
				int valor4 = Integer.parseInt(cn);
				String objeto = (String) cajadis.getSelectedItem();// EXTRAEMOS
																	// DEL
																	// JCOMBOBOX
																	// EL
																	// ELEMENTO
																	// MARCADO
				if ("Generador y=(5x) mod 2^5" == objeto) {
					aux.inicial(1);
				}
				if ("Generador y=(7x) mod 2^5" == objeto) {
					aux.inicial(2);
				}
				if ("Generador y=(3x) mod 31" == objeto) {
					aux.inicial(3);
				}
				if ("Generador y=(7^5 * x) mod (2^31 - 1)" == objeto) {
					aux.inicial(4);
				}
				if ("Generador combinado" == objeto) {
					aux.inicial(5);
				}
				if ("Generador de Fishman y Moore" == objeto) {
					aux.inicial(6);
				}
				if ("Generador RANDU" == objeto) {
					aux.inicial(7);
				}
				JFrame graf = new JFrame("Entropia");
				graf.setSize(ancho - ancho / 3, alto - 50);
				pintarEntro grafica = new pintarEntro(aux, valor);
				grafica.setBackground(Color.BLACK);
				graf.add(grafica);
				grafica.gen = valor4;
				graf.setVisible(true);
				Graphics g = grafica.getGraphics();
				grafica.paint(g);

			}
		});

		EntropiaM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valor = (Integer) variablex.getValue();
				int valor2 = (Integer) variabley.getValue();
				int valor3 = (Integer) regla.getValue();
				String cn = generador.getText();
				int valor4 = Integer.parseInt(cn);
				double entropi = 0;
				double entropiM = 0;
				double[] prob = new double[valor];
				boolean front;
				if (opcionD3.isSelected()) {
					front = true;
				} else {
					front = false;
				}
				ca1DSimulator aux = new ca1DSimulator(valor, valor2, front);
				ca1DSimulator.crearreglak(valor3);
				String objeto = (String) cajadis.getSelectedItem();// EXTRAEMOS
																	// DEL
																	// JCOMBOBOX
																	// EL
																	// ELEMENTO
																	// MARCADO
				if ("Generador y=(5x) mod 2^5" == objeto) {
					aux.inicial(1);
				}
				if ("Generador y=(7x) mod 2^5" == objeto) {
					aux.inicial(2);
				}
				if ("Generador y=(3x) mod 31" == objeto) {
					aux.inicial(3);
				}
				if ("Generador y=(7^5 * x) mod (2^31 - 1)" == objeto) {
					aux.inicial(4);
				}
				if ("Generador combinado" == objeto) {
					aux.inicial(5);
				}
				if ("Generador de Fishman y Moore" == objeto) {
					aux.inicial(6);
				}
				if ("Generador RANDU" == objeto) {
					aux.inicial(7);
				}
				for (int i = 1; i <= valor4; i++) {
					for (int j = 0; j < ca1DSimulator.automata.length; j++) {
						switch (ca1DSimulator.automata[j]) {
						case 0: {
							prob[0]++;
							break;
						}
						case 1: {
							prob[1]++;
							break;
						}
						case 2: {
							prob[2]++;
							break;
						}
						case 3: {
							prob[3]++;
							break;
						}
						case 4: {
							prob[4]++;
							break;
						}
						case 5: {
							prob[5]++;
							break;
						}
						case 6: {
							prob[6]++;
							break;
						}
						case 7: {
							prob[7]++;
							break;
						}
						case 8: {
							prob[8]++;
							break;
						}
						case 9: {
							prob[9]++;
							break;
						}
						case 10: {
							prob[10]++;
							break;
						}
						case 11: {
							prob[11]++;
							break;
						}
						case 12: {
							prob[12]++;
							break;
						}
						}
					}

					for (int j = 0; j < prob.length; j++) {
						if (prob[j] != 0) {
							entropi = (prob[j] / ca1DSimulator.automata.length)
									* ((Math.log(prob[j] / ca1DSimulator.automata.length)) / (Math.log(valor)))
									+ entropi;
						}
						prob[j] = 0;
					}
					entropi = (-1) * entropi;
					entropiM = entropiM + entropi;
					entropi = 0;
					aux.nextGen();
				}
				entropiM = entropiM / valor4;
				resultado.setValue(entropiM);
			}

		});
		// ENCRIPTACION INICIO
		encrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame op = new JFrame("opciones");
				op.setVisible(true);
				op.setSize(400, 200);
				op.setLayout(null);
				JButton texto = new JButton("Cifrar texto");
				JButton archivo = new JButton("Cifrar txt");
				JFormattedTextField key = new JFormattedTextField();
				JLabel t = new JLabel("KEY");
				key.setBounds(150, 25, 50, 25);
				t.setBounds(100, 25, 50, 25);
				op.setLocationRelativeTo(null);
				op.setResizable(false);
				archivo.setBounds(50, 100, 100, 25);
				texto.setBounds(250, 100, 100, 25);
				op.add(texto);
				op.add(archivo);
				op.add(key);
				op.add(t);
				key.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent e) {
						char caracter = e.getKeyChar();
						if ((caracter < '0') || (caracter > '9')) {
							e.consume();
						} // CONTROLA VALOR DE ENTRADA 0 A 9
						if (key.getText().length() == 3) {
							e.consume();
						}
					}// CONTROLA QUE LONGITUD <=3
				});

				archivo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser txt = new JFileChooser();
						txt.showOpenDialog(op);
						File TXT = txt.getSelectedFile();
						// File fichero = new File
						// (TXT.getAbsolutePath(),"Encriptado.txt");
						// if(fichero.createNewFile()){System.out.println("SE ha
						// creaod el archivo");}}catch(Exception e3){}
						ca1DSimulator cifrador = new ca1DSimulator(2, 1, true);
						ca1DSimulator.crearreglak(10);
						cifrador.inicial(7);
						String k = key.getText();
						int keyy = Integer.parseInt(k);
						try {
							// fichero.createNewFile();
							Scanner s = new Scanner(TXT);
							int[] xor = new int[8];
							BufferedWriter bw = new BufferedWriter(new FileWriter(TXT, true));
							while (s.hasNextLine()) {
								String linea = s.nextLine();
								char cad[] = linea.toCharArray();
								int eau = 0;
								for (int ii = 0; ii < cad.length; ii++) {
									for (int i = 0; i < xor.length; i++) {
										xor[i] = ca1DSimulator.automata[keyy];
										cifrador.nextGen();
									}
									for (int i = 0; i < xor.length; i++) {
										eau = (int) (xor[i] * Math.pow(2, i));
									}

									cad[ii] = (char) (cad[ii] ^ eau);
									// bw.write(cad[ii]);
								}
								String aux = cad.toString();
								bw.write(aux);
								bw.newLine();
								// System.out.println(linea);
							}
							bw.close();
							s.close();
						} catch (Exception e2) {
						}
					}
				});

				texto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ca1DSimulator cifrador = new ca1DSimulator(2, 1, true);
						ca1DSimulator.crearreglak(10);
						cifrador.inicial(6);
						String k = key.getText();
						int keyy = Integer.parseInt(k);
						op.setVisible(false);
						JFrame plano = new JFrame("Texto");
						plano.setSize(400, 200);
						plano.setResizable(false);
						JFrame cifr = new JFrame("Cifrado");
						cifr.setResizable(false);
						cifr.setSize(400, 200);
						cifr.setLocation(400, 0);
						JTextArea eplano = new JTextArea();
						JTextArea ecifr = new JTextArea();
						ecifr.setEditable(false);
						plano.add(eplano);
						plano.setVisible(true);
						cifr.add(ecifr);
						cifr.setVisible(true);
						int[] xor = new int[8];
						eplano.addKeyListener(new KeyAdapter() {
							public void keyTyped(KeyEvent e) {
								int eau = 0;
								char caracter = e.getKeyChar();
								for (int i = 0; i < xor.length; i++) {
									xor[i] = ca1DSimulator.automata[keyy];
									cifrador.nextGen();
								}
								for (int i = 0; i < xor.length; i++) {
									eau = (int) (xor[i] * Math.pow(2, i));
								}

								caracter = (char) (caracter ^ eau);
								ecifr.append(Character.toString(caracter));
							}
						});

					}
				});

			}
		});

		// ENCRIPTACION FINAL

		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pintarGraf grafi = new pintarGraf();
				JFrame acerca = new JFrame("ACERCA DE");
				acerca.setSize(600, 400);
				acerca.setVisible(true);
				acerca.setLocationRelativeTo(null);
				Graphics g = grafi.getGraphics();
				int valor = (Integer) variablex.getValue();
				int valor2 = (Integer) variabley.getValue();
				int valor3 = (Integer) regla.getValue();
				boolean front;
				if (opcionD3.isSelected()) {
					front = true;
				} else {
					front = false;
				}
				ca1DSimulator aux = new ca1DSimulator(valor, valor2, front);
				grafi.graficas = aux;
				ca1DSimulator.crearreglak(valor3);
				String cn = generador.getText();
				int valor4 = Integer.parseInt(cn);
				String objeto = (String) cajadis.getSelectedItem();
				if ("Generador y=(5x) mod 2^5" == objeto) {
					grafi.gen = valor4;
					grafi.graficas.inicial(1);
					grafi.paint(g);
				}
				if ("Generador y=(7x) mod 2^5" == objeto) {
					dibujo.gen = valor4;
					dibujo.automata.inicial(2);
					dibujo.paint(g);
				}
				if ("Generador y=(3x) mod 31" == objeto) {
					dibujo.gen = valor4;
					dibujo.automata.inicial(3);
					dibujo.paint(g);
				}
				if ("Generador y=(7^5 * x) mod (2^31 - 1)" == objeto) {
					dibujo.gen = valor4;
					dibujo.automata.inicial(4);
					dibujo.paint(g);
				}
				if ("Generador combinado" == objeto) {
					dibujo.gen = valor4;
					dibujo.automata.inicial(5);
					dibujo.paint(g);
				}
				if ("Generador de Fishman y Moore" == objeto) {
					dibujo.gen = valor4;
					dibujo.automata.inicial(6);
					dibujo.paint(g);
				}
				if ("Generador RANDU" == objeto) {
					dibujo.gen = valor4;
					dibujo.automata.inicial(7);
					dibujo.paint(g);
				}

			}
		});

		// INTRODUCCION DE CANVAS
		dibujo.setBackground(Color.BLACK);
		dibujo.setBounds(22, 22, ancho - ancho / 3, alto - 150);
		this.add(dibujo);
		this.setVisible(true);

		// CONFIGURACION DE JCOMBOBOX
		cajadis.addItem("Generador y=(5x) mod 2^5");
		cajadis.addItem("Generador y=(7x) mod 2^5");
		cajadis.addItem("Generador y=(3x) mod 31");
		cajadis.addItem("Generador y=(7^5 * x) mod (2^31 - 1)");
		cajadis.addItem("Generador combinado");
		cajadis.addItem("Generador de Fishman y Moore");
		cajadis.addItem("Generador RANDU");
		cajadis.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arge) {
				// Graphics g = dibujo.getGraphics();
				dibujo.gen = 0;// CUANDO REPINTEMOS NO SE MEZCLEN GENERACIONES
				dibujo.repaint();
			}
		});

		// EVENTO DEL CAMPO DE TEXTO GENERADOR, SOLO ACEPTARA VALORES NUMERICOS
		// Y ADMITIRA UN VALOR DE 0 A 99999
		generador.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int longitud = 0;
				char caracter = e.getKeyChar();
				longitud = longitud + 1;
				if ((caracter < '0') || (caracter > '9')) {
					e.consume();
				} // CONTROLA VALOR DE ENTRADA 0 A 9
				if (generador.getText().length() == 5) {
					e.consume();
				}
			}// CONTROLA QUE LONGITUD <=5 PARA EVITAR DESBORDAMIENTO
		});
		// BOTON DIBUJAR

		dibujando.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g = dibujo.getGraphics();
				g.clearRect(0, 0, dibujo.getWidth(), dibujo.getHeight());
				int valor = (Integer) variablex.getValue();
				int valor2 = (Integer) variabley.getValue();
				int valor3 = (Integer) regla.getValue();
				boolean front;
				if (opcionD3.isSelected()) {
					front = true;
				} else {
					front = false;
				}
				ca1DSimulator aux = new ca1DSimulator(valor, valor2, front);
				dibujo.automata = aux;
				ca1DSimulator.crearreglak(valor3);
				String cn = generador.getText();
				pintarGraf grafica = new pintarGraf();
				JFrame ventanagrafico = new JFrame("Grafica poblacion");
				grafica.graficas = aux;
				ventanagrafico.add(grafica);
				int valor4 = Integer.parseInt(cn);
				grafica.gen = valor4;
				grafica.setBackground(Color.BLACK);
				ventanagrafico.setSize(1000, 850);
				String objeto = (String) cajadis.getSelectedItem();// EXTRAEMOS
																	// DEL
																	// JCOMBOBOX
																	// EL
																	// ELEMENTO
																	// MARCADO
				if ("Generador y=(5x) mod 2^5" == objeto) {// SEGUN SEA EL
															// ELEMENTO,SE
															// PINTARA UNA
															// GENERACION
															// DIFERENTE
					dibujo.gen = valor4;
					dibujo.automata.inicial(1);
					dibujo.paint(g);
				}
				if ("Generador y=(7x) mod 2^5" == objeto) {
					dibujo.gen = valor4;
					dibujo.automata.inicial(2);
					dibujo.paint(g);
				}
				if ("Generador y=(3x) mod 31" == objeto) {
					dibujo.gen = valor4;
					dibujo.automata.inicial(3);
					dibujo.paint(g);
				}
				if ("Generador y=(7^5 * x) mod (2^31 - 1)" == objeto) {
					dibujo.gen = valor4;
					dibujo.automata.inicial(4);
					dibujo.paint(g);
				}
				if ("Generador combinado" == objeto) {
					dibujo.gen = valor4;
					dibujo.automata.inicial(5);
					dibujo.paint(g);
				}
				if ("Generador de Fishman y Moore" == objeto) {
					dibujo.gen = valor4;
					dibujo.automata.inicial(6);
					dibujo.paint(g);
				}
				if ("Generador RANDU" == objeto) {
					dibujo.gen = valor4;
					dibujo.automata.inicial(7);
					dibujo.paint(g);
				}
			}
		});
	}
}
// Fin Primera pestaña

// ini Segundo pestaña

@SuppressWarnings("serial")
class PintarPLi extends Canvas {
	public int gen = 0;
	public static Life poblacion;

	public void paint(Graphics g) {
		if (gen <= 0) {
		} else {
			for (int i = 1; i <= gen; i++) {
				int v = Life.viva();
				int m = Life.muerta();
				double aux1 = (double) v / (Life.tam * Life.tam);// NORMALIZAR I
				double aux2 = (double) m / (Life.tam * Life.tam);
				;// NORMALIZAR J
				v = (int) (aux1 * this.getWidth());
				m = (int) (aux2 * this.getHeight());
				poblacion.nextgen();
				g.setColor(Color.green);
				g.drawString("vivas", 50, 50);
				int v2 = Life.viva();
				int m2 = Life.muerta();
				aux1 = (double) v2 / (Life.tam * Life.tam);
				;// NORMALIZAR I
				aux2 = (double) m2 / (Life.tam * Life.tam);
				;// NORMALIZAR J
				v2 = (int) (aux1 * this.getWidth());
				m2 = (int) (aux2 * this.getHeight());
				g.drawLine(i, this.getWidth() - v, i + 1, this.getWidth() - v2);
				g.setColor(Color.yellow);
				g.drawString("muertas", 50, 75);
				g.drawLine(i, this.getWidth() - m, i + 1, this.getWidth() - m2);
			}
		}

	}
}

@SuppressWarnings("serial")
class PintarL extends Canvas {
	static Life actual;
	int flag = 0;// Evita excepcion

	public void paint(Graphics g) {
		BufferedImage imagen = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		if (flag == 0) {
		} else {
			for (int i = 0; i < Life.LIFE.length; i++) {
				for (int j = 0; j < Life.LIFE[i].length; j++) {
					if (Life.LIFE[i][j] == 1) {
						double aux1 = (double) i / Life.tam;// NORMALIZAR I
						double aux2 = (double) j / Life.tam;// NORMALIZAR J
						int coodx = (int) (aux1 * this.getWidth());
						int coody = (int) (aux2 * this.getHeight());
						imagen.setRGB(coodx, coody, Color.white.getRGB());
					} // 2for
				}
			} // 1for
			g.drawImage(imagen, 0, 0, this);
		}
	}
}

@SuppressWarnings("serial")
class PLIFE extends JPanel {
	int ancho = (int) (Toolkit.getDefaultToolkit().getScreenSize().width);
	int alto = (int) (Toolkit.getDefaultToolkit().getScreenSize().height);
	static PintarL dibujo = new PintarL();
	private static JLabel vivitas = new JLabel();
	private static JSpinner gene = new JSpinner();
	private static JSpinner dimen = new JSpinner();
	private static JLabel rip = new JLabel();
	private static JButton dibujar = new JButton("DIBUJAR");
	private static JButton pobla = new JButton("Grafica.P");
	private static PintarPLi pintaP = new PintarPLi();

	PLIFE() {
		dimen.setModel(new SpinnerNumberModel(200, 200, 800, 1));
		dimen.setBounds(ancho - 380, alto - 500, 100, 25);
		gene.setModel(new SpinnerNumberModel(1, 1, 5000, 1));
		gene.setBounds(ancho - 200, alto - 500, 100, 25);
		JLabel et3 = new JLabel("Generaciones");
		et3.setBounds(ancho - 200, alto - 520, 100, 25);
		JLabel et4 = new JLabel("Vivas");
		et4.setBounds(ancho - 300, alto - 300, 100, 25);
		JLabel et5 = new JLabel("Muertas");
		et5.setBounds(ancho - 300, alto - 250, 100, 25);
		vivitas.setBounds(ancho - 250, alto - 300, 100, 25);
		rip.setBounds(ancho - 250, alto - 250, 100, 25);
		this.setLayout(null);
		dibujo.setBackground(Color.BLACK);
		dibujo.setBounds(22, 22, ancho - ancho / 3, alto - 150);
		JLabel et1 = new JLabel("Tamaño");
		et1.setBounds(ancho - 380, alto - 520, 100, 25);
		JLabel et2 = new JLabel("LIFE");
		et2.setBounds(ancho - 380, alto - 750, 100, 25);
		et2.setFont(new Font("Tahoma", Font.ITALIC, 18));
		dibujar.setBounds(ancho - 380, alto - 400, 100, 25);
		pobla.setBounds(ancho - 200, alto - 400, 100, 25);
		this.add(et2);
		this.add(et1);
		this.add(dibujo);
		this.add(gene);
		this.add(dimen);
		this.add(dibujar);
		this.add(pobla);
		this.add(et3);
		this.add(et4);
		this.add(et5);
		this.add(rip);
		this.add(vivitas);
		dibujar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dibujar.setEnabled(false);
				ExecutorService ejecutor = Executors.newSingleThreadExecutor();
				ejecutor.execute(PLIFE::botton);
				ejecutor.shutdown();
			}
		});
		pobla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pobla.setEnabled(false);
				JFrame ventanaa = new JFrame("Poblaciones");
				ventanaa.setSize(700, 600);
				ventanaa.setResizable(false);
				int tam = (Integer) dimen.getValue();
				int genn = (Integer) gene.getValue();
				pintaP.gen = genn;
				PintarPLi.poblacion = new Life(tam);
				pintaP.setBackground(Color.BLACK);
				ventanaa.add(pintaP);
				ventanaa.setVisible(true);
				Graphics g = pintaP.getGraphics();
				pintaP.paint(g);
				pobla.setEnabled(true);
			}
		});
	}

	public static void botton() {
		int tam = (Integer) dimen.getValue();
		int gen = (Integer) gene.getValue();
		PintarL.actual = new Life(tam);
		Graphics g = dibujo.getGraphics();
		dibujo.flag = 1;// indica que puede pintar
		try {
			for (int i = 0; i <= gen; i++) {
				vivitas.setText(Integer.toString(Life.viva()));
				rip.setText(Integer.toString(Life.muerta()));
				dibujo.paint(g);
				PintarL.actual.nextgen();
				if (i == gen) {
					Thread.interrupted();
					dibujar.setEnabled(true);
				}
				Thread.sleep(50);
			}
		} catch (Exception e4) {
		}
	}
}

class dibBelZha extends Canvas{
	static parallelBelZab reaccion;
	int flag = 0;// Evita exception
	public void paint(Graphics g) {
		BufferedImage imagen = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		if (flag == 0) {
		} else {
			for (int i = 0; i < this.getWidth(); i++) {
				for (int j = 0; j < this.getHeight(); j++) {
						Color actual= new Color(parallelBelZab.a[i][j][parallelBelZab.q]%255,parallelBelZab.b[i][j][parallelBelZab.q]%255,parallelBelZab.c[i][j][parallelBelZab.q]%255);
						imagen.setRGB(i, j, actual.getRGB());
					} // 2for
				}
			g.drawImage(imagen, 0, 0, this);
			}
		}
	}

class PesBelZha extends JPanel {
	int ancho = (int) (Toolkit.getDefaultToolkit().getScreenSize().width);
	int alto = (int) (Toolkit.getDefaultToolkit().getScreenSize().height);
	private static JSpinner alpha = new JSpinner();
	private static JSpinner beta = new JSpinner();
	private static JSpinner gamma = new JSpinner();
	private static dibBelZha dreac=new dibBelZha();
	private static JButton pintar= new JButton("Reacción");
	private static JButton parar= new JButton("Parar");
	private static JLabel ap=new JLabel("ALPHA");
	private static JLabel be=new JLabel("BETA");
	private static JLabel ga=new JLabel("GAMMA");
	private static ExecutorService ejecutor;
	private static boolean salida=false;
	PesBelZha(){
		this.setLayout(null);
		alpha.setModel(new SpinnerNumberModel(0.0f, 0.0f, 100.0f, 0.1f));
		alpha.setBounds(25,alto/2-200,50,25);
		ap.setBounds(25,alto/2-225,50,25);
		beta.setModel(new SpinnerNumberModel(0.0f, 0.0f, 100.0f, 0.1f));
		beta.setBounds(25,alto/2-150,50,25);
		be.setBounds(25,alto/2-175,50,25);
		gamma.setModel(new SpinnerNumberModel(0.0f, 0.0f, 100.0f, 0.1f));
		gamma.setBounds(25,alto/2-100,50,25);
		ga.setBounds(25,alto/2-125,50,25);
		dreac.setBackground(Color.black);
		dreac.setBounds(450, 100, 500, 500);
		pintar.setBounds(20,alto/2,100,25);
		parar.setBounds(60,alto/2+75,100,25);
		this.add(dreac);
		this.add(ap);
		this.add(be);
		this.add(ga);
		this.add(pintar);
		this.add(alpha);
		this.add(beta);
		this.add(gamma);
		this.add(parar);
		pintar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double a=(Double) alpha.getValue();
				Double b=(Double) beta.getValue();
				Double c=(Double) gamma.getValue();
				parallelBelZab.alfa=a.floatValue();
				parallelBelZab.beta=b.floatValue();
				parallelBelZab.gamma=c.floatValue();
				pintar.setEnabled(false);
				salida=false;
				ejecutor = Executors.newSingleThreadExecutor();
				ejecutor.execute(PesBelZha::pintado);
				ejecutor.shutdown();
				
			}
		});
		
		parar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salida=true;
				ExecutorService ejecutor2 = Executors.newSingleThreadExecutor();
				ejecutor2.execute(PesBelZha::parar);
				ejecutor2.shutdown();
				pintar.setEnabled(true);
				
			}
		});
	}
	
	static void  pintado(){
		dibBelZha.reaccion=  new  parallelBelZab();
		dreac.flag=1;
		for(;;){
			if(salida){break;}
			dreac.paint(dreac.getGraphics());
			parallelBelZab.compute();
	}
		}
	static void parar(){
		ejecutor.shutdown();
		pintar.setEnabled(true);
	}

}


class Pintumor extends Canvas{
	static parallelTumoralGrowth actual;
	int flag = 0;// Evita excepcion
	Pintumor(int s){
		actual = new parallelTumoralGrowth(s);
	}
		
	public void paint(Graphics g) {
		BufferedImage imagen = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		if (flag == 0) {
		} else {
			for (int i = 0; i < parallelTumoralGrowth.tam; i++) {
				for (int j = 0; j < parallelTumoralGrowth.tam; j++) {
					if (parallelTumoralGrowth.tum[i][j].viva == 1) {
						imagen.setRGB(i, j, Color.white.getRGB());
					} // 2for
				}
			} // 1for
			g.drawImage(imagen, 0, 0, this);
		}
	}
	
}
class Pestumor extends JPanel{
	int ancho = (int) (Toolkit.getDefaultToolkit().getScreenSize().width);
	int alto = (int) (Toolkit.getDefaultToolkit().getScreenSize().height);
	private static JSpinner PV = new JSpinner();
	private static JSpinner PM = new JSpinner();
	private static JSpinner semilla = new JSpinner();
	private static JSpinner PP = new JSpinner();
	private static JSpinner PHN = new JSpinner();
	private static JLabel et1=new JLabel("P.VIVIR");
	private static JLabel et2=new JLabel("P.MIGRAR");
	private static JLabel et3=new JLabel("P.PROLIFERAR");
	private static JLabel et4= new JLabel("SEMILLA");
	private static JLabel et5= new JLabel("PHN");
	private static JButton pintar = new JButton("GENERAR");
	private static JButton parar = new JButton("PARAR");
	private static ExecutorService ejecutor;
	private static boolean salida=false;

	
	private static Pintumor dibujo=new Pintumor(0);

	Pestumor(){
		this.setLayout(null);
		PV.setModel(new SpinnerNumberModel(0.0, 0.0, 1, 0.01));
		PV.setBounds(25,alto/2-200,50,25);
		et1.setBounds(25,alto/2-225,100,25);
		PM.setModel(new SpinnerNumberModel(0.0, 0.0, 1, 0.01));
		PM.setBounds(25,alto/2-140,50,25);
		et2.setBounds(25,alto/2-165,100,25);
		PP.setModel(new SpinnerNumberModel(0.0, 0.0, 1, 0.01));
		PP.setBounds(25,alto/2-80,50,25);
		et3.setBounds(25,alto/2-105,100,25);
		semilla.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		semilla.setBounds(25,alto/2-20,50,25);
		et4.setBounds(25,alto/2-50,100,25);
		PHN.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		PHN.setBounds(25,alto/2+35,50,25);
		et5.setBounds(25,alto/2+10,100,25);
		dibujo.setBackground(Color.black);
		dibujo.setBounds(ancho-720, 20, 700, 700);
		pintar.setBounds(25,alto/2+125,100,25);
		parar.setBounds(150,alto/2+125,100,25);
		this.add(PV);
		this.add(PM);
		this.add(PP);
		this.add(PHN);
		this.add(semilla);
		this.add(et1);
		this.add(et2);
		this.add(et3);
		this.add(et4);
		this.add(et5);
		this.add(dibujo);
		this.add(pintar);
		this.add(parar);
		
		pintar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dibujo.actual= new parallelTumoralGrowth((Integer)semilla.getValue());
				dibujo.actual.psu =(Double) PV.getValue();
				dibujo.actual.pde=1-dibujo.actual.psu;
				dibujo.actual.pmi=(Double) PM.getValue();
				dibujo.actual.pp=(Double) PP.getValue();
				dibujo.actual.nph=(Integer) PHN.getValue();
				
				pintar.setEnabled(false);
				salida=false;
				ejecutor = Executors.newSingleThreadExecutor();
				ejecutor.execute(Pestumor::pintado);
				ejecutor.shutdown();
				
			}
		});
		
		parar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				salida=true;
				ExecutorService ejecutor2 = Executors.newSingleThreadExecutor();
				ejecutor2.execute(Pestumor::parar);
				ejecutor2.shutdown();
				pintar.setEnabled(true);
				
			}
		});
	}
	
	static void  pintado(){
		dibujo.flag=1;
		for(;;){
			if(salida){break;}
			dibujo.paint(dibujo.getGraphics());
			Pintumor.actual.nextgen();
	}
		}
	static void parar(){
		ejecutor.shutdown();
		pintar.setEnabled(true);
		dibujo.flag=0;
	}
		
	
	}

class PinMandelbrot extends Canvas{
	
	  private final int MAX_ITER = 10000;
	  private double zx, zy, cX, cY, tmp;
	  int flag =0;
	
	  
	  public void paint(Graphics g) {
		  BufferedImage  Imagen = new BufferedImage(getWidth(), getHeight(),BufferedImage.TYPE_INT_RGB);
		 if(flag==0){}else{
			 
			 for (int y = 0; y < getHeight(); y++) {
			     for (int x = 0; x < getWidth(); x++) {
			     	     zx = zy = 0;
			     	     cX = (x - 800)/150 ;
			     	     cY = (y - 600)/150;
			     	     int iter = MAX_ITER;
			     	     while (zx * zx + zy * zy < 4 && iter > 0) {
			     	     	     tmp = zx * zx - zy * zy + cX;
			     	     	     zy = 2.0 * zx * zy + cY;
			     	     	     zx = tmp;
			     	     	     iter--;
			     	     }
			     	     Imagen.setRGB(x, y, iter | (iter << 8));
			     }
			     }
			// g.drawImage(Imagen, 0, 0, this);
			   }
	  }}

class PMandelbot extends JPanel{
	 PinMandelbrot obj;
	PMandelbot(){
		this.setLayout(null);
		obj=new PinMandelbrot();
		obj.setBackground(Color.GRAY);
		obj.setBounds(260, 25, 800, 600);
		this.add(obj);
		Graphics g = obj.getGraphics();
		obj.flag=1;
		obj.paint(g);
	}
	
}


class VentanaP {// VENTANA PRINCIPAL
	public VentanaP(String s) {
		JTabbedPane pestañas = new JTabbedPane();
		// CONFIGURACIÓN BARRA DE LA INTERFAZ Y SUS ELEMENTOS
		JFrame ventanaP = new JFrame(s);
		Pestaña1 ventana = new Pestaña1();
		PLIFE lifee = new PLIFE();
		PesBelZha bel = new PesBelZha();
		Pestumor tum = new Pestumor();
		PMandelbot mal = new PMandelbot();
		pestañas.add(ventana, "AUTOMATA 1D ENCRIP");
		pestañas.add(lifee, "LIFE");
		pestañas.add(bel, "Belusov-Zhabotinsky");
		pestañas.add(tum,"Crecimiento Tumoral");
		pestañas.add(mal, "Mandelrot");
		ventanaP.add(pestañas);
		ventanaP.setExtendedState(JFrame.MAXIMIZED_BOTH);
		JMenuBar menuBar = new JMenuBar();
		ventanaP.setJMenuBar(menuBar);
		JMenu aMenu = new JMenu("1ª Opcion");
		JMenu bMenu = new JMenu("2ª Opcion");
		JMenu cMenu = new JMenu("3ª Opcion");
		JMenu subAMenu = new JMenu("1 A");
		JMenu subMenuB = new JMenu("1 B");
		JMenu subMenuC = new JMenu("1 C");
		JMenuItem p2 = new JMenuItem("Generador Aleatorio");
		JMenuItem p3 = new JMenuItem("Item 1B");
		JMenuItem p4 = new JMenuItem("Item 1C");
		JMenuItem p5 = new JMenuItem("subItem 1A");
		JMenuItem p6 = new JMenuItem("subItem 1B");
		JMenuItem p7 = new JMenuItem("subItem 1C");
		aMenu.add(p2);
		menuBar.add(aMenu);
		menuBar.add(bMenu);
		menuBar.add(cMenu);
		cMenu.add(subMenuC);
		bMenu.add(subMenuB);
		aMenu.add(subAMenu);
		bMenu.add(p3);
		cMenu.add(p4);
		subAMenu.add(p5);
		subMenuB.add(p6);
		subMenuC.add(p7);
		ventana.setLayout(null);
		ventanaP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaP.setVisible(true);
	}
};

public class HILOP {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		VentanaP n = new VentanaP("VENTANA PRINCIPAL");// VENTANA PRINCIPALL DEL
														// PROGRAMA
	}
};