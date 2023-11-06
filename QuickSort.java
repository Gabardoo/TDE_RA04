package bubblesort;

import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    
    static int countTrocas = 0;
    static int countIteracoes = 0;
    
    static void quicksort(int[] vetor, int esquerda, int direita){
        
        if (esquerda < direita){
            int p = particao(vetor, esquerda, direita);
            quicksort(vetor, esquerda, p);
            quicksort(vetor, p + 1, direita);
        }

        
    }
    
    static int particao(int[] vetor, int esquerda, int direita){
        
        int meio = (int) (esquerda + direita) / 2;
        int pivo = vetor[meio];
        int i = esquerda - 1;
        int j = direita + 1;
        while(true){
            countIteracoes++;
            do{
                i++;
            }while(vetor[i] < pivo);
            do{
                j--;
            }while(vetor[j] > pivo);
            if (i >= j){
                return j;
            }
            int aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
            countTrocas++;
        }
    }
    
    static int[] popularVetor(int capacidade) {
        Random rand = new Random();
        int[] vetor = new int[capacidade];
        
        for (int i = 0; i < capacidade; i++) {
            vetor[i] = rand.nextInt(999) + 1;
        }
        return vetor;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("QuickSort");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Qual sera a capacidade do vetor?");
        System.out.println("1: 50 numeros inteiros");
        System.out.println("2: 500 numeros inteiros");
        System.out.println("3: 1000 numeros inteiros");
        System.out.println("4: 5000 numeros inteiros");
        System.out.println("5: 10000 numeros inteiros");
        int tamanho_vetor = scan.nextInt();
        
        int[] vetor = null;
        int n = 0;
        
        switch (tamanho_vetor) {
            case 1:
                vetor = popularVetor(50);
                n = 50;
                break;
            case 2:
                vetor = popularVetor(500);
                n = 500;
                break;
            case 3:
                vetor = popularVetor(1000);
                n = 1000;
                break;
            case 4:
                vetor = popularVetor(5000);
                n = 5000;
                break;
            case 5:
                vetor = popularVetor(10000);
                n = 10000;
                break;
            default:
                System.out.println("Opção inválida. Tente novamente");
                break;
        }
        
        long comeco = System.nanoTime();
        
        quicksort(vetor, 0, n - 1);
        
        long fim = System.nanoTime();
        double total = (double) (fim - comeco) / 1000000;
        System.out.println("tempo milisegundos = " + total);
        System.out.println("numero de trocas: " + countTrocas);
        System.out.println("numero de iteracoes: " + countIteracoes);
        

    }
}
