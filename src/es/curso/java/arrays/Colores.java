package es.curso.java.arrays;

import java.util.Scanner;

public class Colores {
	public static void main(String[] arg)
	{
		Scanner scan;
		scan = new Scanner(System.in);
		int nColores;
		String colores[];
		
		do {
		System.out.println("\nCuantos colores va a introducir: [1 a 10]");
		nColores=scan.nextInt();
		} while (nColores<1 && nColores>10);
		
		colores = new String[nColores];
		
		for (int i=0;i<nColores;i++)
		{
			System.out.printf("Nombre del color %d: ",i+1);
			colores[i]=scan.next();
		}
		
		System.out.println("Los colores introducidos son:\n");
		
		for (int i=0;i<nColores;i++)
		{
			System.out.printf("\nColor %d: %s",i+1,colores[i]);
		}
		
		System.out.println("\n\nLos colores que contienen \"o\" y empiezan por \"a\" son: ");
		
		for (int i=0;i<nColores;i++)
		{
			if (colores[i].toLowerCase().contains("o") && colores[i].toLowerCase().charAt(0)=='a')
			System.out.printf("\nColor %d: %s",i+1,colores[i]);
		}
		
		scan.close();
	}

}
