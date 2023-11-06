package bubblesort;

import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
    
    void bubbleSort(int[] vetor, int n){
        
        int countTrocas = 0;
        int countIteracoes = 0;
        int temp = 0;
        
        long comeco = System.nanoTime();
        
        for (int i=0; i< n; i++){
            for(int j=1; j < (n-i); j++){
                countIteracoes++;
                if(vetor[j-1] > vetor[j]){
                    //trocar os elementos
                    countTrocas++;
                    temp = vetor[j-1];
                    vetor[j-1] = vetor[j];
                    vetor[j] = temp;
                }
            }
        }
        
        long fim = System.nanoTime();
        
        double total = (double) (fim - comeco) / 1000000;
        System.out.println("tempo milisegundos = " + total);
        System.out.println("numero de trocas: " + countTrocas);
        System.out.println("numero de iteracoes: " + countIteracoes);
        
    }
    
    static int[] PopularVetor(int capacidade){
        Random rand = new Random();
        int[] vetor = new int[capacidade];
        
        for (int i = 0; i < capacidade; i++) {
            vetor[i] = rand.nextInt(999) + 1;
        }
        return vetor;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);        
        
        System.out.println("BubbleSort");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Qual sera a capacidade do vetor?");
        System.out.println("1: 50 numeros inteiros");
        System.out.println("2: 500 numeros inteiros");
        System.out.println("3: 1000  numeros inteiros");
        System.out.println("4: 5000 numeros inteiros");
        System.out.println("5: 10000 numeros inteiros");
        int tamanho_vetor = scan.nextInt();
        
        int[] vetor = null;
        int n = 0;
        
        switch (tamanho_vetor) {
            case 1:
                vetor = PopularVetor(50);
                n = 50;
                break;
            case 2:
                vetor = PopularVetor(500);
                n = 500;
                break;
            case 3:
                vetor = PopularVetor(1000);
                n = 1000;
                break;
            case 4:
                vetor = PopularVetor(5000);
                n = 5000;
                break;
            case 5:
                vetor = PopularVetor(10000);
                n = 10000;
                break;
            default:
                System.out.println("Opção inválida. Tente novamente");
                break;
        }
        
        BubbleSort ordenador = new BubbleSort();
        ordenador.bubbleSort(vetor, n);
        
    }
    
}
