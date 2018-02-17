package edu.fatec.ferramentas;

import edu.fatec.grafo.Grafo;
import edu.fatec.resources.Stack;// dependência de uma pilha para armazenamento do caminho

public class BuscaProfundidade {
	private String[] cor;    // cor[] mantém a informação sobre a cor de cada vértice.
    private int[] pai;          //pai[] mantém a informação do predecessor de cada vértice.
    private final int s;        //vértice de origem distinta 
    private int d[] ;        //d[]mantém o valor do tempo quando v’ foi visitado pela primeira vez.      
    private int F[] ;        //F[] mantém o valor do tempo quando v’ foi totalmente explorado. 
    private int tempo;
    
    public BuscaProfundidade(Grafo G, int s) {
    	this.s = s;
        pai = new int[G.V()];
    	cor = new String[G.V()];
    	 d  = new int[G.V()];
    	 F  = new int [G.V()];
    	tempo = 0;
    	for(int i = 0 ; i < G.V() ; i++)
    		cor[i]="BRANCO";
        VisitaDFS(G, s);
    }

    // busca em profundidade à partir de v
    private void VisitaDFS(Grafo G, int v) {
        cor[v] = "CINZA";
        tempo = tempo + 1;
        d[v] = tempo;
        for (int u : G.adje(v)) {
        	if (cor[u]=="BRANCO") {
            	 pai[u] = v;
            	VisitaDFS(G, u);
            }
        	cor[v]="PRETO";     	
        	F[v]= tempo + tempo + 1  ;	
        }
    }

    // Há filhos a serem explorados?
    public String cor(int v) {
        return cor[v];
    }

    public Iterable<Integer> filhos(int v) {
        if (this.cor(v)!="PRETO") return null;
        Stack<Integer> caminho = new Stack<Integer>();
        for (int i = v; i != s; i = pai[i])
            caminho.push(i);
        caminho.push(s);
        return caminho;
    }
    
    public void mostrarCaminhosDFS(Grafo G,int u){
    	System.out.printf("\n\n");
    	System.out.printf("**RÓTULO DE CAMINHOS COM BUSCA EM PROFUNDIDADE**\n");
    	for (int v = 0; v < G.V(); v++) {
            if (this.cor(v)=="PRETO") {
            	if(v==u){
            		 System.out.printf("SEU CAMINHO -> ");
            	}
                System.out.printf("%d para %d (%d / %d): ", s+1, v+1,d[v],F[v]-d[v]);
                for (int i : this.filhos(v)) {
                    if (i == s) System.out.print(i+1);
                    else        System.out.printf("-%d" , i+1);
                          
                }
                System.out.printf("\n");
            }

            else {
            	if(v==u){
           		 System.out.printf("SEU CAMINHO -> ");
           	}
            	System.out.printf("%d para %d:  não conectado\n", s+1, v+1);
            	
            }
    	
    	}
    	
    }
}

