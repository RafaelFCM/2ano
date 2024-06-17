package listas;

import entidades.Sensor;

public class ListaSensores {
	
	private class NO{
		Sensor dado;
		NO prox;
	}
	
	private NO lista = null;
	
	public void insere(Sensor elem) {
		//etapa 1 alocar novo no
		NO novo = new NO();
		novo.dado = elem;
		//etapa 2: achar posicao para insercao
		if (lista==null) {
			novo.prox = null;
			lista = novo;
		}
		else {
			if (novo.dado.getpH() < lista.dado.getpH()) {
				novo.prox = lista;
				lista = novo;
			}
			else {
				NO aux = lista;
				boolean achou = false;
				while (aux.prox!=null && !achou) {
					if (aux.prox.dado.getpH() < novo.dado.getpH())
						aux = aux.prox;
					else
						achou = true;
				}
				novo.prox = aux.prox;
				aux.prox = novo;
			}
		}
	}
	public boolean remove(Sensor valor) {
		boolean achou = false;
		if (lista != null) {
			if (lista.dado == valor) {
				achou = true;
				lista = lista.prox;
			}
			else {
				NO aux = lista;
				while (aux.prox!=null && !achou) {
					if (aux.prox.dado != valor)
						aux = aux.prox;
					else {
						achou = true;
						aux.prox = aux.prox.prox;
					}
				}
			}
		}
		return achou;
	}
	
	public int contaNos() {
		int cont = 0;
		NO aux = lista;
		while (aux!=null) {
			cont++;
			aux = aux.prox;
		}
		return cont;
	}
	
	public void apresentaMaiores(Sensor valor) {
		NO aux = lista;
		System.out.print("\t ***Valores da lista maiores do que "+ valor +":");
		while (aux!=null) {
			if (aux.dado.getpH() > valor.getpH())
				System.out.print("\t"+ aux.dado);
			aux = aux.prox;
		}
		System.out.println();
	}
	
	public void apresenta() {
		NO aux = lista;
		System.out.println("\n **** LISTA DE SENSORES***");
		while (aux!=null) {
			System.out.println("\t"+ aux.dado);
			aux = aux.prox;
		}	
	}
	
	public void apresenta(Sensor elem){
		NO aux = lista;
		while (aux!=null) {
			if (aux.dado.getX() == elem.getX() && aux.dado.getY() == elem.getY())
				System.out.print("\t"+ aux.dado);
			aux = aux.prox;
		}
		if(aux == null)
			System.out.println("Sensor nao encontrado!!!");
	}
	
}
