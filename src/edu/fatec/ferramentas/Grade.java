package edu.fatec.ferramentas;

import edu.fatec.grafo.Grafo;

public interface Grade {
	
	// M�todo que cria grades a partir do n�mero de v�rtices do Grafo
	public GradeImpl[] criar_Grades(Grafo G);
	
	/* M�todo que calcula a dist�ncia manhattan e mostra o r�tulo dos v�rtices
	 * percorridos. 
	 */
	public void calculaManhattan(GradeImpl[] grid, Grafo G,int P1,int P2);	
	public void mostraGrade(Grafo G,GradeImpl[] grid);
}
