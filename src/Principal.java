/*
 * Universidade Federal de Santa Catarina - UFSC
 * Departamento de Informática e Estatística - INE
 * Programa de Pós-Graduação em Ciências da Computação - PROPG
 * Disciplina: Projeto e Análise de Algoritmos
 * Prof Alexandre Gonçalves da Silva 
 *
 * Baseado nos slides 36 da aula do dia 18/08/2017 
 *
 * Mergesort sem sentinela
 *
 * Atenção:
 * Vetor em java inicia em 0, os algoritmos consideram início em 1.
 * A subtração de -1 ocorre somente no local de acesso ao vetor ou matriz 
 * para manter a compatibilidade entre os algoritmos.
 *
 */
public class Principal {

    /**
     * O piso (= floor) de um número real x é o resultado do arredondamento de x
     * para baixo. 
     * 
     * Em outras palavras, o piso de x é o único número inteiro i
     * tal que i<=x<i+1. Ex. O piso de 3.9 é 3.
     *
     * Em java pode ser utilizando Math.floor(double)
     *
     * @param x Número real a ser calculado o piso.
     * @return um valor inteiro com o piso de x.
     */
    public static int piso(double x) {
        //Pego a parte inteira de x
        int parteInteira = (int) x;
        //Pego a parte fracionária de x
        double parteFracionaria = x - parteInteira;
        //Retorno x subtraindo a parte fracionária 
        return (int) (x - parteFracionaria);
    }    
    
    /**
     * Realiza a intercação sem sentinela.
     * 
     * Consumo de tempo Theta(n)
     *
     * @param A Vetor a ser ordenado
     * @param p Inicio do vetor
     * @param q Pivo do vetor
     * @param r Fim do vetor
     */
    public static void merge(int A[], int p, int q, int r) {
        int B[] = new int[r + 1];         
        for (int i = p; i <= q; i++) {
            B[i-1] = A[i-1];
        }
        for (int j = q + 1; j <= r; j++) {
            B[r + (q + 1) - j - 1] = A[j-1];
        }
        int i = p;
        int j = r;
        for (int k = p; k <= r; k++) {
            if (B[i-1] <= B[j-1]) {
                A[k-1] = B[i-1];
                i = i + 1;
            } else {
                A[k-1] = B[j-1];
                j = j - 1;
            }
        }
    }

    /**
     * Mergesort sem sentinela.
     * 
     * Algoritmos de ordenação podem ser ou não in-place ou estáveis.
     * Um método de ordenação é estável se elementos iguais ocorrem no 
     * vetor ordenado na mesma ordem em que são passados na entrada.
     * O mergesort é estável. 
     * 
     * Complexidade no pior caso é Theta(n log n)
     *
     * @param A Vetor a ser ordenado
     * @param p Inicio do vetor
     * @param r Fim do vetor
     */
    public static void mergesort(int A[], int p, int r) {
        if (p < r) {                            //Theta(1)
            int q = piso((p + r) / 2);          //Theta(1)
            mergesort(A, p, q);                 //T(teto(n/2))
            mergesort(A, q + 1, r);             //T(piso(n/2))
            merge(A, p, q, r);                  //Theta(n)
        }
    }

    public static void main(String args[]) {
        
        //Vetor dos dados    
        int A[] = {50, 70, 60, 90, 10, 30, 20, 40};
        //Quantidade de elementos       
        int r = A.length;
        //Início do vetor
        int p = 1;
        
        System.out.println(">>> MergeSort sem sentinela <<<");
        System.out.println("Original: ");
        for (int i = 0; i < r; i++) {
            System.out.println((i + 1) + " - " + A[i]);
        }

        mergesort(A, p, r);

        System.out.println("Depois: ");
        for (int i = 0; i < r; i++) {
            System.out.println((i + 1) + " - " + A[i]);
        }
    }
}