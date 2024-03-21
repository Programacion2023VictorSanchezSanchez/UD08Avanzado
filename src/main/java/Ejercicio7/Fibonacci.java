package Ejercicio7;

public class Fibonacci {
    public static void main(String[] args) {
        int numero = 10; // Cambia este valor al número hasta el cual deseas calcular la secuencia Fibonacci
        System.out.println("Secuencia de Fibonacci hasta el número " + numero + ":");
        for (int i = 0; i <= numero; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    public static int fibonacci(int n) {
        int fibonacciResultado;
        // Caso base: si n es 0, el resultado es 0
        if (n == 0) {
            fibonacciResultado = 0;
        }
        // Caso base: si n es 1 o 2, el resultado es 1
        if (n == 1 || n == 2) {
            fibonacciResultado = 1;
        }
        // Caso recursivo: fibonacci(n) = fibonacci(n-1) + fibonacci(n-2)
        fibonacciResultado = fibonacci(n - 1) + fibonacci(n - 2);

        return fibonacciResultado;
    }
}
