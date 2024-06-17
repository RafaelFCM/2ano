package aplicacao;

import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
import static java.lang.Math.floor;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import java.util.Random;

import entidades.Sensor;
import filas.FilaSensores;
import listas.ListaSensores;

public class Main {
	public static final double NITROGENIO_MIN = 15;
	public static final double NITROGENIO_MAX = 20 - NITROGENIO_MIN;
	public static final double FOSFORO_MIN = 5.7;
	public static final double FOSFORO_MAX = 6.5 - FOSFORO_MIN;
	public static final double POTASSIO_MIN = 120;
	public static final double POTASSIO_MAX = 150 - POTASSIO_MIN;
	public static final double PH_MIN = 5.5;
	public static final double PH_MAX = 7.5 - PH_MIN;
	public static final int UMIDADE_MIN = 60;
	public static final int UMIDADE_MAX = 80 - UMIDADE_MIN;
	public static Random gerador = new Random();
	public static ListaSensores listaSensores = new ListaSensores(); 
	public static FilaSensores filaSensores = new FilaSensores();
	public static FilaSensores auxFilaSensores = new FilaSensores();
	
	public static void main(String[] args) {
		String coordenadasSensoresInicial[] = { "47�55'44\"W,21�00'34\"S", "47�55'42\"W,21�00'35\"S", "47�55'39\"W,21�00'37\"S",
                "47�55'44\"W,21�00'39\"S", "47�55'40\"W,21�00'40\"S", "47�55'32\"W,21�00'34\"S", "47�55'28\"W,21�00'34\"S",
                "47�55'28\"W,21�00'38\"S", "47�55'33\"W,21�00'39\"S"};
		for(int i = 0; i<coordenadasSensoresInicial.length; i++) {
			String coordenadasX =  coordenadasSensoresInicial[i].substring(0,coordenadasSensoresInicial[i].indexOf(","));
			String coordenadasY =  coordenadasSensoresInicial[i].substring(coordenadasSensoresInicial[i].indexOf(",")+1);
			Sensor sensor = new Sensor(coordenadasX,coordenadasY);
			coletaValoresRandom(sensor);
			listaSensores.insere(sensor);
		}
		geraMenu();
	}
	private static void geraMenu() {
		String aux = "Bem vindo a AlimentAI !!!".toUpperCase();
		aux += """
				\n
				1.Ver sensores instalados no terreno
				2.Inserir novo Sensor
				3.Remover Sensor
				4.Exibir registros de sensores com parametros fora do intervalo adequado
				5.Pesquisar por um sensor especifico ja presente no terreno
				6.Visita do Agronomo
				7.Fechar o Programa
				
				""";
		int opcao;
		do {
			opcao= parseInt(showInputDialog(aux));
			switch(opcao) {
			case 1:
				listaSensores.apresenta();
				break;
			case 2:
				insereSensor();
				insereSensorNaFilaSensores();
				break;
			case 3:
				if(listaSensores.remove()) {
					showMessageDialog(null, "Sensor removido!!!");
				}else {
					showMessageDialog(null, "Sensor n�o encontrado!!!");
				}
				break;
			case 4:
				String escreveDadosSensores = "\n *** FILA DE SENSORES COM ALERTAS DE ERRO ***\n";
				showMessageDialog(null, escreveDadosSensores);
				int quant_Nos = filaSensores.contaNos(); 
				if(auxFilaSensores.contaNos()>0) {
					for(int i = 0; i<quant_Nos;i++) {
						Sensor elemRetirado = filaSensores.dequeue(); 
						showMessageDialog(null,"Dados do Sensor " + (i+1) + ":\n" + elemRetirado);
					}					
				}
				break;
			case 5:
				String x =showInputDialog("X:");
				String y = showInputDialog("Y:");	
				listaSensores.apresenta(x,y);
				break;
			case 6:
				for(int i = 0; i<auxFilaSensores.contaNos();i++) {
					auxFilaSensores.dequeue();
				}
				showMessageDialog(null,"Terreno pronto para visita do Agronomo");
				break;
			case 7:
				opcao = -1;
				showMessageDialog(null, "Saindo do programa...");
				break;
			default:
				opcao = 0;
				showMessageDialog(null, "N�mero digitado incorreto");
			}			
		}while(opcao<=6 && opcao>=0);
	}
	
	private static void insereSensor(){
		String X = showInputDialog(null, "Digite a coordenada X do sensor:");
		String Y = showInputDialog(null, "Digite a coordenada Y do sensor:");
		Sensor sensor = new Sensor(X,Y);
		coletaValores(sensor);
		if(!listaSensores.achouSensor(sensor)) {			
			listaSensores.insere(sensor);
			showMessageDialog(null, "Sensor adicionado!!!");
		}else{
			showMessageDialog(null, "Ja existe um sensor nessa coordenada!");
		}
	}
	private static void insereSensorNaFilaSensores() {
		Sensor arrayListaSensores[] = listaSensores.getSensores();
		boolean nitrogenio_Correto,fosforo_Correto,potassio_Correto,pH_Correto, umidade_Correta; 
		double nitrogenio_max = NITROGENIO_MAX + NITROGENIO_MIN;
		double fosforo_max = FOSFORO_MAX + FOSFORO_MIN;
		double potassio_max = POTASSIO_MAX + POTASSIO_MIN;
		double ph_max = PH_MAX + PH_MIN;
		int umidade_max = UMIDADE_MAX + UMIDADE_MIN;
		for(int i = 0; i<arrayListaSensores.length; i++ ) {
			int contadorDeErros = 0;
			nitrogenio_Correto = arrayListaSensores[i].getQuant_nitrogenio()>= NITROGENIO_MIN && arrayListaSensores[i].getQuant_nitrogenio()<= nitrogenio_max; 
			fosforo_Correto = arrayListaSensores[i].getQuant_fosforo()>= FOSFORO_MIN && arrayListaSensores[i].getQuant_fosforo()<= fosforo_max;
			potassio_Correto = arrayListaSensores[i].getQuant_potassio()>= POTASSIO_MIN && arrayListaSensores[i].getQuant_potassio()<= potassio_max;
			pH_Correto = arrayListaSensores[i].getpH()>= PH_MIN && arrayListaSensores[i].getpH()<= ph_max;
			umidade_Correta = arrayListaSensores[i].getUmidade()>= UMIDADE_MIN && arrayListaSensores[i].getUmidade()<= umidade_max;
			if(! nitrogenio_Correto) {
				contadorDeErros++;
			}
			if(! fosforo_Correto) {
				contadorDeErros++;
			}
			if(! potassio_Correto) {
				contadorDeErros++;
			}
			if(! pH_Correto) {
				contadorDeErros++;
			}
			if(! umidade_Correta) {
				contadorDeErros++;
			}
			if(contadorDeErros>1) {
				filaSensores.enqueue(arrayListaSensores[i]);		
				auxFilaSensores.enqueue(arrayListaSensores[i]);
			}
		}
	}
	
	public static void coletaValorNitrogenioRandom(Sensor sensor) {
		double u = floor(gerador.nextDouble(NITROGENIO_MAX)) + NITROGENIO_MIN;
		sensor.setQuant_nitrogenio(u);
	}
	public static void coletaValorFosforoRandom(Sensor sensor){
		double u = floor(gerador.nextDouble(FOSFORO_MAX)) + FOSFORO_MIN;
		sensor.setQuant_fosforo(u);
	}
	public static void coletaValorPotassioRandom(Sensor sensor){
		double u = floor(gerador.nextDouble(POTASSIO_MAX)) + POTASSIO_MIN;
		sensor.setQuant_potassio(u);
	}
	public static void coletaValorPHRandom(Sensor sensor){
		double u = floor(gerador.nextDouble(PH_MAX)) + PH_MIN;
		sensor.setpH(u);
	}
	public static void coletaValorUmidadeRandom(Sensor sensor){
		double u = floor(gerador.nextDouble(UMIDADE_MAX)) + UMIDADE_MIN;
		sensor.setUmidade(u);
	}
	
	public static void coletaValorNitrogenio(Sensor sensor) {
		double u = parseDouble(showInputDialog("Digite a Medida de Nitrogenio: "));
		sensor.setQuant_nitrogenio(u);
	}
	public static void coletaValorFosforo(Sensor sensor){
		double u = parseDouble(showInputDialog("Digite a Medida do Fosforo: "));
		sensor.setQuant_fosforo(u);
	}
	public static void coletaValorPotassio(Sensor sensor){
		double u = parseDouble(showInputDialog("Digite a Medida do Potassio: "));
		sensor.setQuant_potassio(u);
	}
	public static void coletaValorPH(Sensor sensor){
		double u = parseDouble(showInputDialog("Digite a Medida do PH: "));
		sensor.setpH(u);
	}
	public static void coletaValorUmidade(Sensor sensor){
		double u = parseDouble(showInputDialog("Digite a Medida de Umidade: "));
		sensor.setUmidade(u);
	}
	public static void coletaValores(Sensor sensor){
		coletaValorNitrogenio(sensor);
		coletaValorFosforo(sensor);
		coletaValorPotassio(sensor);
		coletaValorPH(sensor);
		coletaValorUmidade(sensor);
	}
	
	public static void coletaValoresRandom(Sensor sensor){
		coletaValorNitrogenioRandom(sensor);
		coletaValorFosforoRandom(sensor);
		coletaValorPotassioRandom(sensor);
		coletaValorPHRandom(sensor);
		coletaValorUmidadeRandom(sensor);
	}
	
}
