

//TURMA: 2SIPF
//GRUPO:
//Gabrielly Fabricio Ramos - RM 95413
//Giovana Arruda Da Costa - RM 94584
//Rafael Fiel Cruz Miranda - RM 94654


package aplicacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Cidades.Cidades;
import arvores.ABBRegistros;
import arvores.AVLCidades;

public class Vacinacao {

	public static void main(String[] args) {
		Scanner le = new Scanner(System.in);

		String cidades[]   = {"Analandia","Araraquara","Dourado","Ibitinga","Matao","São Carlos","Tabatinga"};
		double vacinacao[]   = {72.5, 88.4, 71.9, 76, 78.8, 96.7,66};
		int nCasos[]  = {1, 0, 2, 0, 0, 1, 1};
			
		AVLCidades avlCidades = new AVLCidades();
		List<Cidades> registros = new ArrayList<>();
		ABBRegistros abbRegistros = new ABBRegistros();
		Cidades[] arrayCidades = new Cidades[7];
		Cidades[] arrayCidadesOrdenada = new Cidades[7];
		
		int cont=0;
		int opcao;
		String aux=null;
		
		do {
			System.out.println();
			System.out.println(" 1 - Inserir cidade");
			System.out.println(" 2 - Gerar vetor de cidades");
			System.out.println(" 3 – Ordenar vetor");
			System.out.println(" 4 - Gerar ABB a partir da AVL");
			System.out.println(" 5 - Encerrar o programa");
			while (true) {
				System.out.print("Sua opção: ");
	            try {
	            	opcao = le.nextInt();
	                break; 
	            } catch (InputMismatchException e) {
	                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
	                le.next(); 
	            }
	        }
			
			switch (opcao) {
				case 1:
					if (cont == 7) {
						System.out.println("Todas as cidades existentes foram inseridas");
						break;
					} else {
						for (int i=0; i<7; i++) {
							Cidades objCidades = new Cidades(cidades[i], vacinacao[i], nCasos[i]);
							avlCidades.root = avlCidades.inserirAVL(avlCidades.root, objCidades);
							cont++;
						}
					}
					break;
					
				case 2:
					avlCidades.geraArray(avlCidades.root, registros);
					System.out.println();
					for (int i=0; i < registros.size(); i++) {
						arrayCidades[i] = registros.get(i);
						if (arrayCidades[i] != null) {
							System.out.println("Cidade: "+arrayCidades[i].getNome()+"\nPorcentagem de Vacinacao: "+arrayCidades[i].getPorcVacinacao()+"\nNumero de Casos: "+arrayCidades[i].getNumCasos());
							System.out.println();
						}
					}
					break;
					
				case 3:
					avlCidades.gerenciaArray(avlCidades.root, registros);
					System.out.println();
					System.out.println("Registros em ordem crescente de porcentagem de vacinacao:");
					for (int i=0; i < registros.size(); i++) {
						arrayCidadesOrdenada[i] = registros.get(i);
						if (arrayCidades[i] != null) {
							System.out.println("Cidade: "+arrayCidadesOrdenada[i].getNome()+"\nPorcentagem de Vacinacao: "+arrayCidadesOrdenada[i].getPorcVacinacao()+"\nNumero de Casos: "+arrayCidadesOrdenada[i].getNumCasos());
							System.out.println();
						}
					}
					break;
					
				case 4:
					System.out.println();
					System.out.println("ABB:");
					for (Cidades cidade : registros) {
						abbRegistros.root = abbRegistros.inserir(abbRegistros.root, cidade);
					}
					for (int i=0; i<registros.size(); i++) {
						System.out.println(abbRegistros.printa(abbRegistros.root, aux));
					}
					break;
					
				case 5:
					break;
					
				default:
					System.out.println("Opção inválida");
			}
			
		} while (opcao != 5);
		
	}
		
}
