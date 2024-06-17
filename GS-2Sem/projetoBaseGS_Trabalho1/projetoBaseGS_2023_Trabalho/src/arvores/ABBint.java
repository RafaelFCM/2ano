package arvores;

public class ABBint {
    
	private class ARVORE {
        int dado;
        ARVORE esq, dir;
        int comp;

        public ARVORE(int dado) {
            this.dado = dado;
            this.esq = null;
            this.dir = null;
            this.comp = 0;
        }
    }

    private ARVORE raiz;
    public static int totalComp; 


    public void inserir(int info) {
        this.raiz = inserirRec(this.raiz, info);
    }

    private ARVORE inserirRec(ARVORE p, int info) {
        if (p == null) {
            return new ARVORE(info);
        }

        this.totalComp++;
        if (info < p.dado) {
            p.esq = inserirRec(p.esq, info);
        } else if (info > p.dado) {
            p.dir = inserirRec(p.dir, info);
        }

        return p;
    }

    public int totalComp() {
    	return totalComp;
    }
    
    public static void quicksort(int[] vetor, int li, int ls, int[] cont) {
        if (li < ls) {
            int j = particiona(vetor, li, ls, cont);
            quicksort(vetor, li, j - 1, cont);
            quicksort(vetor, j + 1, ls, cont);
        }
    }

    private static int particiona(int[] x, int li, int ls, int[] cont) {

int abaixo,acima;
		int pivo,temp;
		pivo=x[ls];
		acima=ls;
		abaixo=li;
		while(abaixo<acima)
		{
			while(x[abaixo]<pivo && abaixo<ls) {
				abaixo++;
				cont[0]++;
			}
			while (x[acima]>=pivo && acima > abaixo) {
				acima--;
				cont[0]++;
			}
			if (abaixo<acima){
				temp=x[abaixo];
				x[abaixo]=x[acima];
				x[acima]=temp;
				cont[1]++; 
			}
		}
		x[ls]=x[acima];
		x[acima]=pivo;
		return acima;
    }
}
