package aplicacao;

import java.util.Random;
import java.util.Scanner;
import entidades.Sensor;
import listas.ListaSensores;

public class Monitora {
	public static final double NITROGENIO_MIN = 20;
	public static final double NITROGENIO_MAX = 150;
	public static final double FOSFORO_MIN = 10;
	public static final double FOSFORO_MAX = 40;
	public static final double POTASSIO_MIN = 100;
	public static final double POTASSIO_MAX = 300;
	static ListaSensores ls = new ListaSensores();

	public static void main(String[] args) {
		Scanner le = new Scanner(System.in);
		Random gerador = new Random();

		String coordenadasSensores[] = {"47°55'44''W,21°00'34''S", "47°55'42''W,21°00'35''S", "47°55'39''W,21°00'37''S",
				"47°55'44''W,21°00'39''S", "47°55'40''W,21°00'40''S", "47°55'32''W,21°00'34''S", "47°55'28''W,21°00'34''S",
				"47°55'28''W,21°00'38''S", "47°55'33''W,21°00'39''S"};
		
		int n = coordenadasSensores.length;

		System.out.println(" Coordenadas Iniciais");
		for (int i = 0; i < n; i++) {
			System.out.println("Sensor " + i + ": " + coordenadasSensores[i]);
		}

		/*
		 * exemplo de geaï¿½ï¿½o de valores aleatorios para simular alteracao de medidas dos
		 * sensores
		 */
		System.out.println("\n Exemplo de valores de umidade");
		for (int i = 0; i < n; i++) {
			int u = gerador.nextInt(UMIDADE_MAX) + UMIDADE_MIN;
			System.out.println("Valor inteiro entre " + UMIDADE_MIN + " e " + UMIDADE_MAX + ": " + u);
		}
		System.out.println("\n Exemplo de valores de pH");
		for (int i = 0; i < n; i++) {
			float v = PH_MAX - (PH_MIN * ((float) gerador.nextInt(10) / 10));
			System.out.println("Valor real entre " + PH_MIN + " e " + PH_MAX + ": " + v);
		}
		apresenta();
		/*
		 * Esse trecho de programa pode ser usado para a implementacao de testes com
		 * coordenadas e valores de medidas em intervalos especificos
		 */

	}

	static void apresenta(){
		Scanner sc = new Scanner(System.in);
		System.out.println("X: ");
		double x = sc.nextDouble();
		System.out.println("Y: ");
		double y = sc.nextDouble();
		Sensor sensor = new Sensor(x,y,0,0);
		ls.apresenta(sensor);
	}

}