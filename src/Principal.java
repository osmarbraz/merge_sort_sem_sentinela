/*
 * Universidade Federal de Santa Catarina - UFSC
 * Departamento de Informática e Estatística - INE
 * Programa de Pós-Graduação em Ciências da Computação - PROPG
 * Disciplinas: Projeto e Análise de Algoritmos
 * Prof Alexandre Gonçalves da Silva 
 * Baseado nos slides 36 da aula do dia 18/01/2017 
 * Mergesort sem sentinela
 */
public class Principal {

    /**
     * Realiza a intercação sem sentinela
     * @param A
     * @param p
     * @param q
     * @param r 
     */
    public static void merge(int A[], int p, int q, int r) {
        int B[] = new int[r + 1];
        for (int i = p; i <= q; i++) {
            B[i] = A[i];
        }

        for (int j = q + 1; j <= r; j++) {
            B[r + q + 1 - j] = A[j];
        }
        int i = p;
        int j = r;
        for (int k = p; k <= r; k++) {
            if (B[i] <= B[j]) {
                A[k] = B[i];
                i = i + 1;
            } else {
                A[k] = B[j];
                j = j - 1;
            }
        }
    }

    /**
     * Mergesort sem sentinela
     * Complexidade no pior caso é Theta(n log n)
     * @param A
     * @param p
     * @param r 
     */
    public static void mergesort(int A[], int p, int r) {
        if (p < r) {                    //Theta(1)
            int q = (p + r) / 2;        //Theta(1)
            mergesort(A, p, q);         //T(n/2)
            mergesort(A, q + 1, r);     //T(n/2)
            merge(A, p, q, r);          //Theta(n)
        }
    }

    public static void main(String args[]) {
        //Vetor dos dados    
        int A[] = {50, 70, 60, 90, 10, 30, 20, 40};

        //Fim do vetor
        int n = A.length - 1;
        
        System.out.println(">>> MergeSort <<<");
        System.out.println("Original: ");
        for (int i = 0; i <= n; i++) {
            System.out.println((i + 1) + " - " + A[i]);
        }

        mergesort(A, 0, n);

        System.out.println("Depois: ");
        for (int i = 0; i <= n; i++) {
            System.out.println((i + 1) + " - " + A[i]);
        }

    }
}
