package listas;

import static javax.swing.JOptionPane.showInputDialog;
import javax.swing.JOptionPane;

import entidades.Sensor;

public class ListaSensores {
	
	private class NO{
		Sensor dado;
		NO prox;
	}
	
	private NO lista = null;
	
	public void insere(Sensor elem) {
		
		NO novo = new NO();
		novo.dado = elem;
		
		if (lista==null) {
			novo.prox = null;
			lista = novo;
		}
		else {
			if (novo.dado.getUmidade() < lista.dado.getUmidade()) {
				novo.prox = lista;
				lista = novo;
			}
			else {
				NO aux = lista;
				boolean achou = false;
				while (aux.prox!=null && !achou) {
					if (aux.prox.dado.getUmidade() < novo.dado.getUmidade())
						aux = aux.prox;
					else
						achou = true;
				}
				novo.prox = aux.prox;
				aux.prox = novo;
			}
		}
	}
	public boolean remove() {
		String X = showInputDialog(null, "Digite a coordenada X do sensor:");
		String Y = showInputDialog(null, "Digite a coordenada Y do sensor:");
		boolean achou = false;
		if (lista != null) {
			if (lista.dado.getX().equals(X) && lista.dado.getY().equals(Y)) {
				achou = true;
				lista = lista.prox;
			}
			else {
				NO aux = lista;
				while (aux.prox!=null && !achou) {
					if (!(aux.prox.dado.getX().equals(X) && aux.prox.dado.getY().equals(Y)))
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
	public boolean remove(String X, String Y) {
		boolean achou = false;
		if (lista != null) {
			if (lista.dado.getX().equals(X) && lista.dado.getY().equals(Y)) {
				achou = true;
				lista = lista.prox;
			}
			else {
				NO aux = lista;
				while (aux.prox!=null && !achou) {
					if (!(aux.prox.dado.getX().equals(X) && aux.prox.dado.getY().equals(Y)))
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
	 
	
	public void apresenta() {
		NO aux = lista;
		String escreveDadosSensores = "\n *** LISTA DE SENSORES ***\n";
		JOptionPane.showMessageDialog(null, escreveDadosSensores);
		int contador = 0;
		while (aux!=null) {
			contador++;
			JOptionPane.showMessageDialog(null,"Dados do Sensor " +contador+ ":\n" + aux.dado);
			aux = aux.prox;
		}
	}
	
	public void apresenta(String X, String Y){
		NO aux = lista;
		boolean achou = false;
		while (aux!=null) {
			if (aux.dado.getX().equals(X) && aux.dado.getY().equals(Y)) {
				JOptionPane.showMessageDialog(null,aux.dado);
				achou = true;
				}
			aux = aux.prox;
		}
		if(!achou)			
			JOptionPane.showMessageDialog(null, "Sensor n�o encontrado!!!");
	}
	
	public Sensor[] getSensores(){
		Sensor listaSensores [] = new Sensor[contaNos()];
		NO aux = lista;
		int i = 0;
		while (aux!=null) {
			listaSensores[i] = aux.dado; 
			aux = aux.prox;
			i++;
		}
		return listaSensores;
	}
	
	public boolean achouSensor(Sensor sensor) {
		NO aux = lista;
		boolean achouSensor = false;
		while (aux!=null) {
			if (sensor.equals(aux.dado))
				achouSensor = true;
				aux = aux.prox;
		}
		return achouSensor;
	}
	
	
}
