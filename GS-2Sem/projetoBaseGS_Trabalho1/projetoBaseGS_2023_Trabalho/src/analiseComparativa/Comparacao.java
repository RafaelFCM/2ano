

//TURMA: 2SIPF
//GRUPO:
//Gabrielly Fabricio Ramos - RM 95413
//Giovana Arruda Da Costa - RM 94584
//Rafael Fiel Cruz Miranda - RM 94654


package analiseComparativa;

import java.util.Random;
import arvores.ABBint;

public class Comparacao {
	public static void main(String[] args) {
		int index = 5000;
		int[] arrayInt = new int[index];
		Random gerador = new Random();
		for (int i = 0; i < index; i++) {
			arrayInt[i] = gerador.nextInt(100000);
		}
		ABBint abbInt = new ABBint();

		for (int info : arrayInt) {
			abbInt.inserir(info);
		}

		int[] cont = new int[2];

		System.out.println();
		System.out.println("===== VETOR ORDENADO PELO QUICKSORT ===== ");
		abbInt.quicksort(arrayInt, 0, arrayInt.length - 1, cont);
		for (int i = 0; i < 199; i++) {
			System.out.print(arrayInt[i]+" ");
		}

		int[] contadoresABBint = new int[1];

		int comparacoesQuicksort = cont[0];
		int trocasQuicksort = cont[1];
		int comparacoesABB = abbInt.totalComp();
		
		System.out.println();
		System.out.println();
		System.out.println("===== RESULTADOS NO VETOR =====");
		System.out.println("Comparações: " + comparacoesQuicksort);
		System.out.println("Trocas: " + trocasQuicksort);
		System.out.println();

		System.out.println("===== RESULTADOS NA ABB =====");
		System.out.println("Comparações: " + comparacoesABB);
	}

	
}
