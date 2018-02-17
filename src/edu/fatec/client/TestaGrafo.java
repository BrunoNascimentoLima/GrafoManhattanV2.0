package edu.fatec.client;

import java.util.Scanner;
//dependências
import edu.fatec.ferramentas.BuscaAmplitude;
import edu.fatec.ferramentas.BuscaProfundidade;
import edu.fatec.ferramentas.Grade;
import edu.fatec.ferramentas.GradeImpl;
import edu.fatec.grafo.Grafo;

//Classe de teste
public class TestaGrafo {
	/*
	 * Lista 1 Inteligência Artificial Exercício 10
	 * 
	 * Aline Soares da Silva    RA: 101681079 
	 * Bruno Nascimento Lima    RA: 101682067
	 * Eduardo Petricioni Nunes RA: 101682017 
	 * João Henrique            RA: 101682068
	 * 
	 * -Projeto feito,compilado,executado e testado no FrameWork Eclipse juno
	 * IDE.Necessita da versão de bibliotecas javaSE-1.7 para funcionar corretamente.
	 * 
	 * Referências e Links: Algoritmos Teoria e Pratica Cormen, Leiserson 2nd
	 * português Brasil,Capítulo 22.
	 * http://www.ime.usp.br/~pf/grafos-exercicios/texto/ETG.pdf
	 * http://algs4.cs.princeton.edu/41undirected/Graph.java.html
	 * http://algs4.cs.princeton.edu/41undirected/
	 * http://www.horstmann.com/gridworld/javadoc/
	 * http://horstmann.com/gridworld/
	 */

	// Método cliente que consome os serviços dos objetos.
	public static void main(String[] args) {
		Grafo G;
		int V, E, inicial, destino, resp, aux;
		Scanner s = new Scanner(System.in);
		System.out.printf("'Programação orientada a objetos");
		System.out.printf(" é uma péssima ideia, que só poderia ter nascido ");
		System.out.printf("na Califórnia.' \n");
		System.out.printf("-Edsger Dijkstra. \n");
		do {
			System.out.printf("\nForneça número de vértices:");
			V = s.nextInt();
		} while ((V < 4) || (V > 10));// mínimo 4 e máximo 10 vértices.
		System.out.printf("\nForneça número de arestas:");
		E = s.nextInt();
		G = new Grafo(V);// instanciando G com V vértices.
		G.adiciona_aresta(E);// adicionando E arestas ao Grafo.
		Grade grid = new GradeImpl();// instanciando uma GradeImpl.
		GradeImpl[] grids = grid.criar_Grades(G); // Criando um array de GradeImpl.
		G.mostrarMatriz();// mostrando matriz de adjacências.
		do {
			grid.mostraGrade(G, grids);
			G.mostrarGrafo();// mostrando G atual.
			do {
				System.out.printf("\nForneça o vértice INICIAL: ");
				inicial = s.nextInt();
			} while ((inicial < 0)||(inicial > G.V()));
			do {
				System.out.printf("\nForneça o vértice FINAL: ");
				destino = s.nextInt();
			} while ((destino < 0)||(destino > G.V()));
			System.out.printf("\nEscolha um algoritmo para busca: ");
			System.out.printf("\n1- BFS. ");
			System.out.printf("\n2- DFS.\n ");
			aux = s.nextInt();
			if (aux == 1) {
				grid.calculaManhattan(grids, G, inicial, destino);// calculando manhattan
				BuscaAmplitude busca = new BuscaAmplitude(G, inicial - 1);// instanciando BFS
				busca.mostrarCaminhosBFS(G, destino - 1);// chamada do método de busca
			} else if (aux == 2) {
				grid.calculaManhattan(grids, G, inicial, destino);// calculando manhattan
				BuscaProfundidade busca = new BuscaProfundidade(G, inicial - 1); // instanciando DFS
				busca.mostrarCaminhosDFS(G, destino - 1);// chamada do método de busca
			}
			System.out.printf("\nDeseja fazer uma nova busca? ");
			System.out.printf("\n1- sim. ");
			System.out.printf("\n0- encerrar.\n ");
			resp = s.nextInt();
		} while (resp != 0);
	}
}