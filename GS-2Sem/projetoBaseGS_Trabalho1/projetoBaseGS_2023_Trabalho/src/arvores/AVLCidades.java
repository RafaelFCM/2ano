package arvores;

import java.util.List;
import arvores.ABBRegistros;
import arvores.ABBRegistros.ARVORE;
import Cidades.Cidades;

public class AVLCidades {

	private class ARVORE {
		Cidades dado;
		ARVORE esq, dir;
		int hEsq, hDir;
	}

	public ARVORE root = null;

	public ARVORE inserirAVL(ARVORE p, Cidades info) {
		int comparacao=0;
		if (p != null) {
			comparacao = p.dado.getNome().compareToIgnoreCase(info.getNome());
		}
		if (p == null) {
			p = new ARVORE();
			p.dado = info;
			p.esq = null;
			p.dir = null;
			p.hDir = 0;
			p.hEsq = 0;
		} else if (comparacao > 0) {
			p.esq = inserirAVL(p.esq, info);
			if (p.esq.hDir > p.esq.hEsq)
				p.hEsq = p.esq.hDir + 1;
			else
				p.hEsq = p.esq.hEsq + 1;
		} else if (comparacao < 0){
			p.dir = inserirAVL(p.dir, info);
			if (p.dir.hDir > p.dir.hEsq)
				p.hDir = p.dir.hDir + 1;
			else
				p.hDir = p.dir.hEsq + 1;
		}
		p = balanceamento(p);
		return p;
	}

//	public void geraABB(ARVORE p, ABBRegistros abbRegistros) {
//		if (p != null) {
//			if (p.dado.getPorcVacinacao() < 80 && p.dado.getNumCasos() > 0) {
//				abbRegistros.inserir(abbRegistros.root, p.dado);
//			}
//			geraABB(p.esq, abbRegistros);
//			geraABB(p.dir, abbRegistros);
//		}
//	}
	
	public void geraArray(ARVORE p, List<Cidades> registros) {
		if (p != null) {
			if (p.dado.getPorcVacinacao() < 80 && p.dado.getNumCasos() > 0) {
				registros.add(p.dado);
			}
			geraArray(p.esq, registros);
			geraArray(p.dir, registros);
		}
	}
	
	public void gerenciaArray (ARVORE p, List<Cidades> registros) {
		int n = registros.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				
				if (registros.get(j).getPorcVacinacao() > registros.get(j+1).getPorcVacinacao()) {
					Cidades temp = registros.get(j);
					registros.set(j, registros.get(j + 1));
					registros.set(j + 1, temp);
				}
			}
		}
	}
	
	public ARVORE rotacaoDireita(ARVORE p) {
		ARVORE q, temp;
		q = p.esq;
		temp = q.dir;
		q.dir = p;
		p.esq = temp;
		return q;
	}

	public ARVORE rotacaoEsquerda(ARVORE p) {
		ARVORE q, temp;
		q = p.dir;
		temp = q.esq;
		q.esq = p;
		p.dir = temp;
		return q;
	}

	public ARVORE balanceamento(ARVORE p) {
		int FB = p.hDir - p.hEsq;
		if (FB > 1) {
			int fbFilhoDir = p.dir.hDir - p.dir.hEsq;
			if (fbFilhoDir >= 0)
				p = rotacaoEsquerda(p);
			else {
				p.dir = rotacaoDireita(p.dir);
				p = rotacaoEsquerda(p);
			}
		} else {
			if (FB < -1) {
				int fbFilhoEsq = p.esq.hDir - p.esq.hEsq;
				if (fbFilhoEsq <= 0)
					p = rotacaoDireita(p);
				else {
					p.esq = rotacaoEsquerda(p.esq);
					p = rotacaoDireita(p);
				}
			}
		}
		return p;
	}

}
