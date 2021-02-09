package williamjbf.com.github.algoritmos;

import java.util.Scanner;

public class Main {

	public static Scanner leitor = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int[] numeros = new int[7];
		for (int i=0; i< numeros.length;i++) {
			System.out.println("Digite um número: ");
			int numero = leitor.nextInt();
			numeros[i] = numero;
			
		}
		//buscaLinear(numeros);
		selectionSort(numeros);
		imprimirArray(numeros);
		buscaBinaria(numeros);
		leitor.close();
	}
	
	public static void buscaLinear(int[] numeros) {
		System.out.println("** BUSCAR LINEAR **");
		System.out.println("Digite o número a ser pesquisado: ");
		int alvo = leitor.nextInt();
		int resultado =-1;
		for (int i = 0; i <numeros.length;i++) {
			if (numeros[i]==alvo) {
				resultado = i;
				break;
			}
		}
		if(resultado <0) {
			System.out.println("Elemento não foi encontrado");
		}else {
			System.out.println(String.format("O número %d foi econtrado na posição %d", alvo,resultado));
		}
		
		System.out.print("Vetor desordenado: ");
		imprimirArray(numeros);
	}
	
	public static int[] selectionSort(int[] numeros) {
		System.out.println("** Selection Sort **");
		for(int i=0;i <numeros.length;i++) {
			int indiceDoMenor = i;
			for (int j = i+1; j<numeros.length;j++) {
				if(numeros[j]<numeros[indiceDoMenor]) {
					indiceDoMenor = j;
				}
			}
			int temp = numeros[indiceDoMenor];
			numeros[indiceDoMenor]=numeros[i];
			numeros[i]= temp;
		}
		return numeros;
	}
	
	public static void buscaBinaria(int[] numeros) {
		System.out.println("** Busca Biária **");
		numeros = selectionSort(numeros);
		int resultado = -1;
		int inicio = 0;
		int fim = numeros.length -1;
		int meio = 0;
		System.out.println("Digite o elemento a ser encontrado: ");
		int alvo = leitor.nextInt();
		while (inicio <= fim) {
			meio = (inicio + fim) /2;
			if(numeros[meio] < alvo) {
				inicio = meio+1;
			}else if (numeros[meio]> alvo) {
				fim = meio -1;				
			}else if (numeros[meio] == alvo){
				resultado = meio;
				break;
			}
		}
		if(resultado <0) {
			System.out.println("Elemento não foi encontrado");
		}else {
			System.out.println(String.format("O número %d foi econtrado na posição %d", alvo,resultado));
		}
	}
	
	public static void imprimirArray(int[] numeros) {
		
		for (int i =0; i<numeros.length;i++) {
			System.out.print(numeros[i] + " ");
		}
	}

}
