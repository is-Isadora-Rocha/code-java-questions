package jobRotationSP;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner numUsuario = new Scanner(System.in);
        System.out.println("#-Sequência de Fibonacci-#\nInforme um número: ");

        int numero = numUsuario.nextInt();
        int qntd_Termos = 10, n1 = 0, n2 =1;

        if (verificaNumero(numero)) {
            System.out.println("O numero "+numero+" pertece à sequência de Fibonacci");
        } else {
            System.out.println("O numero "+numero+" não pertece à sequência de Fibonacci");
        }

        for (int i = 2; i < qntd_Termos; i++){
            int n3 = n1 + n2;
            System.out.print(" "+ n3);
            n1 = n2;
            n2 = n3;
        }
    }

    public static boolean verificaNumero(int n){
        int n1 = 0, n2 = 1, n3;
        while (n2 < n) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n2 == n;
    }
}
