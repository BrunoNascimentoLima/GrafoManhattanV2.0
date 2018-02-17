package edu.fatec.ferramentas;


import edu.fatec.grafo.Grafo;
//Classe que implementa os métodos da interface Grade
public class GradeImpl implements Grade{
   //Atributos
	private int n = 0, x = 0, y = 0;
    //Construtor nulo.
	public GradeImpl() {}
	
	@Override
	public GradeImpl[] criar_Grades(Grafo G) {

		int restoDiv, aux = 0, i;
		GradeImpl[] grid;

		if (G.V() % 2 == 0) {
			grid = new GradeImpl[G.V()];
			for (i = 0; i < G.V(); i++) 
				grid[i] = new GradeImpl();
		} else {
			grid = new GradeImpl[G.V() + 1];
			for (i = 0; i < G.V() + 1; i++) 
				grid[i] = new GradeImpl();
		}

		if (G.V() % 2 == 0) {
			restoDiv = 0;

		} else
			restoDiv = 1;

		for (i = 0; i < G.V(); i++) {
			if (restoDiv == 0) {
				grid[i].n = i;

				if ((i) < (G.V() / 2))
					grid[i].x = i + 1;
				else
					grid[i].x = (i) / (G.V() / 2) + (i % (G.V() / 2));

				if (i < (G.V() / 2))
					grid[i].y = 2;
				else
					grid[i].y = 1;
			} else {
				if ((G.V() / 2) == (i)) {
					aux = i - 1;
				}

				grid[i].n = i;

				if ((i) < ((G.V() + 1) / 2))
					grid[i].x = i + 1;
				else
					grid[i].x = (i) / ((G.V() + 1) / 2)
							+ (i % ((G.V() + 1) / 2));

				if (i < ((G.V() + 1) / 2))
					grid[i].y = 2;
				else
					grid[i].y = 1;
			}
		}

		if (restoDiv == 1) {
			if (aux < 0) {
				grid[i].n = aux + 1;
				grid[i].x = (i) / ((G.V() + 1) / 2) + (i % ((G.V() + 1) / 2));
			} else {
				grid[i].n = aux;
				grid[i].x = (i) / ((G.V() + 1) / 2) + (i % ((G.V() + 1) / 2));
			}

			grid[i].y = 1;
		}

		return grid;
	}

    	
	@Override
	public void calculaManhattan(GradeImpl[] grid, Grafo G,int P1,int P2) {
		int x1, x2, y1, y2, dm, i, aux;
		P1 = P1 - 1;
		x1 = grid[P1].x;
		y1 = grid[P1].y;

		P2 = P2 - 1;
		x2 = grid[P2].x;
		y2 = grid[P2].y;
        
		int destino = P2;
		//Fórmula para o cálculo manhattan
		dm = Math.abs(x2 - x1) + Math.abs(y2 - y1);
		
		System.out.printf("\n**DISTÂNCIA MANHATTAN**");
		System.out.printf("\nP  x  y\n");
		System.out.printf("---------\n");
		for (i = 0; i < dm; i++) {
			if (x1 < x2) {
				if (y1 < y2) {

					if (G.V() % 2 == 0)
						aux = G.V() / 2;
					else
						aux = (G.V() / 2) + (G.V() % 2);
					P1 = P1 - aux;
					x1 = grid[P1].x;
					y1 = grid[P1].y;
					System.out.printf("%d", grid[P1].n + 1);
					System.out.printf("  %d", grid[P1].x);
					System.out.printf("   %d\n", grid[P1].y);
				} else {
					if (y1 > y2) {
						if (G.V() % 2 == 0)
							aux = G.V() / 2;
						else
							aux = (G.V() / 2) + (G.V() % 2);
						P1 = P1 + aux;
						x1 = grid[P1].x;
						y1 = grid[P1].y;
						System.out.printf("%d", grid[P1].n + 1);
						System.out.printf("  %d", grid[P1].x);
						System.out.printf("   %d\n", grid[P1].y);
					} else {
						if (y1 == y2) {
							P1 = P1 + 1;
							x1 = grid[P1].x;
							y1 = grid[P1].y;
							System.out.printf("%d", grid[P1].n + 1);
							System.out.printf("  %d", grid[P1].x);
							System.out.printf("   %d\n", grid[P1].y);
						}
					}
				}
			} else {
				if (x1 > x2) {
					if (y1 < y2) {
						if (G.V() % 2 == 0)
							aux = G.V() / 2;
						else
							aux = (G.V() / 2) + (G.V() % 2);
						P1 = P1 - aux;
						x1 = grid[P1].x;
						y1 = grid[P1].y;
						System.out.printf("%d", grid[P1].n + 1);
						System.out.printf("  %d", grid[P1].x);
						System.out.printf("   %d\n", grid[P1].y);
					} else {
						if (y1 > y2) {
							if (G.V() % 2 == 0)
								aux = G.V() / 2;
							else
								aux = (G.V() / 2) + (G.V() % 2);
							P1 = P1 + aux;
							x1 = grid[P1].x;
							y1 = grid[P1].y;
							System.out.printf("%d", grid[P1].n + 1);
							System.out.printf("  %d", grid[P1].x);
							System.out.printf("   %d\n", grid[P1].y);
						} else {
							if (y1 == y2) {
								P1 = P1 - 1;
								x1 = grid[P1].x;
								y1 = grid[P1].y;
								System.out.printf("%d", grid[P1].n + 1);
								System.out.printf("  %d", grid[P1].x);
								System.out.printf("  %d\n", grid[P1].y);
							}
						}
					}
				} else {
					if (x1 == x2) {
						if (y1 < y2) {
							if (G.V() % 2 == 0)
								aux = G.V() / 2;
							else
								aux = (G.V() / 2) + (G.V() % 2);
							P1 = P1 - aux;
							x1 = grid[P1].x;
							y1 = grid[P1].y;
							System.out.printf("%d", grid[P1].n + 1);
							System.out.printf("  %d", grid[P1].x);
							System.out.printf("  %d\n", grid[P1].y);
						} else {
							if (y1 > y2) {

								if (G.V() % 2 == 0)
									aux = G.V() / 2;
								else
									aux = (G.V() / 2) + (G.V() % 2);
								P1 = P1 + aux;
								x1 = grid[P1].x;
								y1 = grid[P1].y;
								System.out.printf("%d", grid[P1].n + 1);
								System.out.printf("  %d", grid[P1].x);
								System.out.printf("  %d\n", grid[P1].y);
							}
						}
					}
				}
			}

		}

		System.out.printf("\nA distância Manhattan é de: %d", dm);
    }
	
	@Override
	public void mostraGrade(Grafo G,GradeImpl[] grid) {
	     int i , j;   
		     System.out.printf("\n** GRAFO **\n\n");
		     for(i = 0; i < G.V()/2 ; i++){
		           	  System.out.printf("%d " , grid[i].getN()+1);
		          }
		          System.out.printf("\n");
		          for(j = i; j < G.V() ; j++){
		        	  System.out.printf("%d " , grid[j].getN()+1);
		          }
		  }
	
	public int getN() {return n;}
	public int getX() {return x;}
	public int getY() {return y;}	
}
