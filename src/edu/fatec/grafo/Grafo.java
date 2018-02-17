package edu.fatec.grafo;

import java.util.LinkedList;
import java.util.Scanner;

//Classe G=(V,E) não-orientado.Tempo esperado de execução é proporcional à O(|V|E|)
public class Grafo {
	//Atributos
	private final int V;// Número de vértices,sendo uma constante.
	private int E;// Número de arestas
	private int adj[][];// Matriz de adjacências
	private LinkedList<Integer>[] adje;// Lista de adjacências
	// Construtor que inicializa o Grafo com V vértices
	public Grafo(int V) {   
		if (V < 0) throw new IllegalArgumentException("Número de vértices não pode ser negativo");
        this.V = V;
        this.E = 0;
        adj = new int[V][V];
        adje = (LinkedList<Integer>[]) new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adje[v] = new LinkedList<Integer>();
        }
                
    }
     /* Método que adiciona E(v-w) arestas ao Grafo.
      * Tempo esperado de execução é proporcional a O(V + E).
      */     
	 public void adiciona_aresta(int E) {
		if (E < 0) throw new IllegalArgumentException("Número de arestas não pode ser negativo");
		 int v=0,w=0,cont=0;
		 int u=0;
		 Scanner s = new Scanner(System.in);
	     
		 while(cont < E){ 
		       System.out.printf("\n%d ARESTA:",cont+1);
		       do{
		    	  System.out.printf("\nForneça o valor da coordenada X: ");
		          v=s.nextInt();
		       }while(v > this.V);
		      
		       do{
		           System.out.printf("Forneça o valor da coordenada Y: ");
		           w=s.nextInt();
		       } while(w > this.V);
		      
		      do{
		          System.out.printf("\nForneça o valor de peso da aresta[%d,%d]: " , v , w);
		          System.out.printf("\n*Sendo 1 para Aresta horizontal ou vertical\n");
		          System.out.printf("*Sendo 2(RAIZ de 2) para Aresta diagonal\n");
		          u=s.nextInt();
		       }while(u > 2);
		       
		    
		       if (v != w && this.adj[v - 1][w - 1] == 0) {
		          this.adj[v - 1][w - 1] = u;
		          this.adj[w - 1][v - 1] = u; 
		          adicionaArestaLista(v-1, w-1);
		          this.E++;
		       }
		       
		       cont = cont + 1;
		    }
	    }
	
	public void mostrarGrafo(){
		int v, w;
		 System.out.printf("\n\n");
		   for (v = 0; v < this.V; v++){
		      System.out.printf( "%2d:", v+1);
		      for (w = 0; w < this.V; w++)
		         if (this.adj[v][w] > 0 )
		            System.out.printf( " %2d", w+1);
		      System.out.printf( "\n");
		   }
	}
	
	     /* Método que mostra matriz de adjacências.
	      * Tempo esperado de execução é proporcional a O(V x V).
          * Matriz simétrica. 	
	      */     
     public	void mostrarMatriz(){
		   int i , j; 
		   System.out.printf( "\n\n** MATRIZ DE ADJACÊNCIAS**\n");
		    for(i = 0; i < this.V ; i++){
		          System.out.printf("    %d" , i + 1);        
		    }
		    System.out.printf("\n   --------------------------------------------------");
		    System.out.printf("\n");
		    
		     for(i = 0; i < this.V ; i++){
		    	 System.out.printf("%d|" , i + 1);
		           for(j = 0; j < this.V ; j++)
		        	   System.out.printf("    %d" , this.adj[i][j]);
		           System.out.printf("\n");
		     }
		}

     private void adicionaArestaLista(int v, int w) {
         if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
         if (w < 0 || w >= V) throw new IndexOutOfBoundsException();
         adje[v].add(w);
         adje[w].add(v);
     }
     
    public int V(){return V;}
	public int E(){return E;}
	public int[][] getAdj(){return adj;}
	public Iterable<Integer> adje(int v) {
	        if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
	        return adje[v];
	    }


}
