package arvores;

import java.util.ArrayList;
import java.util.List;
import Cidades.Cidades;
import java.util.Collections;

public class ABBRegistros {

	public class ARVORE {
		Cidades dado;
		ARVORE esq, dir;
	}

	public ARVORE root = null;

	public ARVORE inserir(ARVORE p, Cidades info) {
		if (p == null) {
			p = new ARVORE();
			p.dado = info;
			p.esq = null;
			p.dir = null;
		} else if (p.dado.getPorcVacinacao() > info.getPorcVacinacao())
			p.esq = inserir(p.esq, info);
		else
			p.dir = inserir(p.dir, info);
		return p;
	}
	
	public String printa(ARVORE p, String aux) {
		aux = "Nome: "+p.dado.getNome()+"\nPorcentagem de Vacinacao: "+p.dado.getPorcVacinacao()+"\nNúmero de Casos: "
				+p.dado.getNumCasos();
		
		return aux;
	}
	
	public void inOrdem(ARVORE p) {
		if (p!=null) {
			if (p.esq != null)
				inOrdem(p.esq);
			System.out.println(" "  + p.dado);
			if (p.dir != null)
				inOrdem(p.dir);
		}
	}

	public int contaNos(ARVORE p, int cont) {
		if (p != null) {
			cont++;
			cont = contaNos(p.esq, cont);
			cont = contaNos(p.dir, cont);
		}
		return cont;
	}

}
