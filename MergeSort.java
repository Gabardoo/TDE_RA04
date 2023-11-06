package bubblesort;

import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    
    static int countTrocas = 0;
    static int countIteracoes = 0;
    
    void mergeSort(int[] vetor, int[] sub, int inicio, int fim){
        countIteracoes++;
        
        if (inicio < fim){
            int meio = (inicio + fim) / 2;
            mergeSort(vetor, sub, inicio, meio);
            mergeSort(vetor, sub, meio+1, fim);
            juntar(vetor, sub, inicio, meio, fim);
            
        }
    }
    
    void juntar(int[] vetor, int[] sub, int inicio, int meio, int fim){
        for(int i = inicio; i <= fim; i++){
            sub[i] = vetor[i];
        }
        int ini = inicio;
        int j = meio+1;
        
        for(int i = inicio; i <= fim; i++){
            if(ini > meio){
                vetor[i] = sub[j++];
            }else if(j > fim){
                vetor[i] = sub[ini++];
            }else if (sub[ini] < sub[j]){
                vetor[i] = sub[ini++];
            }else{
                vetor[i] = sub[j++];
            } 
            countTrocas++;
        }
       
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
        int[] subVetor = null;
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
        
        subVetor = new int[n];
        
        long comeco = System.nanoTime();
        
        MergeSort merge = new MergeSort();
        merge.mergeSort(vetor, subVetor, 0, n-1);
        
        long fim = System.nanoTime();
        double total = (double) (fim - comeco) / 1000000;
        System.out.println("tempo em milisegundos = " + total);
        System.out.println("numero de trocas: " + countTrocas);
        System.out.println("numero de iteracoes: " + countIteracoes);
    }
    
}
