package edu.fatec.ferramentas;

import edu.fatec.grafo.Grafo;
import edu.fatec.resources.Queue;//Fila FIFO para gerenciar a lista de v�rtices de cor cinza.
import edu.fatec.resources.Stack;// Depend�ncia de uma pilha para armazenamento do caminho

public class BuscaAmplitude {
	private static final int INFINITO = Integer.MAX_VALUE;
    private String[] cor;  //cor[v'] mant�m a informa��o sobre a cor de cada v�rtice.
    private int[] pai;     //pai[v�] mant�m a informa��o do predecessor de cada v�rtice.
    private int[] d;      //d[v�] mant�m o valor da dist�ncia entre o v�rtice inicial e v�
    private final int s;  //v�rtice de origem distinta
    
    public BuscaAmplitude(Grafo G, int s) {
        this.s=s;
    	cor = new String[G.V()];
        d = new int[G.V()];
        pai = new int[G.V()];
        for(int i = 0 ; i < G.V() ; i++)
    		cor[i]="BRANCO";
        BFS(G, s); 	
    }
    
    // busca em largura � partir de s
    private void BFS(Grafo G, int s) {
        Queue<Integer> Q = new Queue<Integer>();
        for (int v = 0; v < G.V(); v++) 
        	d[v] = INFINITO;
        d[s] = 0;
        cor[s] = "CINZA";
        Q.enqueue(s);

        while (!Q.isEmpty()) {
            int v = Q.dequeue();
            for (int w : G.adje(v)) {
                if (cor[w]=="BRANCO") {
                    d[w] = d[v] + 1;
                    pai[w] = v;
                    cor[w] = "PRETO";
                    Q.enqueue(w);
                }
            }
        }
    }
  

    public Iterable<Integer> filhos(int v) {
        if (this.cor(v)!="PRETO") return null;
        Stack<Integer> caminho = new Stack<Integer>();
        int i;
        for (i = v; d[i] != 0; i = pai[i])
            caminho.push(i);
        caminho.push(i);
        return caminho;
    }
    
    public void mostrarCaminhosBFS(Grafo G,int u){
    	 System.out.printf("\n\n");
    	 System.out.printf("**R�TULO DE CAMINHOS COM BUSCA EM LARGURA**\n");
    	for (int v = 0; v < G.V(); v++) {
            if (this.cor(v)=="PRETO") {
            	if(v==u){
           		 System.out.printf("SEU CAMINHO -> ");
           	}
                System.out.printf("%d para %d (%d):  ", s+1, v+1, this.d(v));
                for (int i : this.filhos(v)) {
                    if (i == s) System.out.printf("%d",i+1);
                    else        System.out.printf("-%d" , i+1);
                }
                System.out.println();
            }

            else {
            	if(v==u){
              		 System.out.printf("SEU CAMINHO -> ");
              	}
                System.out.printf("%d para %d (-):  n�o conectado\n", s+1, v+1);
            }

        }
    }
    
    public String cor(int v) {return cor[v];}
    public int d(int v) {return d[v];}
  

}
