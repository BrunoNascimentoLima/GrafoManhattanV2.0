package edu.fatec.ferramentas;

import edu.fatec.grafo.Grafo;

public interface Grade {
	
	// Método que cria grades a partir do número de vértices do Grafo
	public GradeImpl[] criar_Grades(Grafo G);
	
	/* Método que calcula a distância manhattan e mostra o rótulo dos vértices
	 * percorridos. 
	 */
	public void calculaManhattan(GradeImpl[] grid, Grafo G,int P1,int P2);	
	public void mostraGrade(Grafo G,GradeImpl[] grid);
}
