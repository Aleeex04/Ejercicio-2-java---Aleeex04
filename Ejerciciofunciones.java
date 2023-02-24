import java.util.Scanner;

public class Ejerciciofunciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Elige un ejercicio:");
            System.out.println("1. Calcular el factorial de un número entero positivo.");
            System.out.println("2. Calcular la potencia de un número entero.");
            System.out.println("3. Calcular la media aritmética de una lista de números.");
            System.out.println("4. Calcular el máximo común divisor de dos números enteros.");
            System.out.println("5. Calcular el número de combinaciones posibles de n elementos tomados de k en k.");
            System.out.println("6. Calcular el número de números primos que hay entre 2 y n.");
            System.out.println("7. Calcular el número de ocurrencias de un elemento en una lista.");
            System.out.println("8. Determinar si un número es palíndromo o no.");
            System.out.println("9. Salir.");
            System.out.print("Elija una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Has elegido calcular el factorial de un número entero positivo.");
                    System.out.println("Introduce un número: ");
                    long numeroentero = scanner.nextInt();
                    long factorial = factorial(numeroentero);
                    System.out.println("El factorial de " + numeroentero + " es: " + factorial);
                    break;
                case 2:
                    System.out.println("Has elegido calcular la potencia de un número entero.");
                    System.out.println("Introduce un numero entero: ");
                    int numero = scanner.nextInt();
                    System.out.println("Introduce la potencia: ");
                    int exponente = scanner.nextInt();
                    double potencia = potencia(numero, exponente);
                    System.out.println(numero + " elevado a " + exponente + " es: " + potencia);
                    break;
                case 3:
                    System.out.println("Has elegido calcular la media aritmética de una lista de números.");
                    System.out.println("Introduce los números separados por una coma: ");
                    String numeros = scanner.next();
                    double media = media_aritmetica(numeros);
                    System.out.println("La media aritmética de los numeros introducidos es: " + media);
                    break;
                case 4:
                    System.out.println("Has elegido calcular el máximo común divisor de dos números enteros.");
                    System.out.println("Introduce el primer número: ");
                    int num1 = scanner.nextInt();
                    System.out.println("Introduce el segundo número: ");
                    int num2 = scanner.nextInt();
                    int mcd = maximo_comun_divisor(num1, num2);
                    System.out.println("El máximo común divisor de " + num1 + " y " + num2 + " es: " + mcd);
                    break;

                case 5:
                    System.out.println("Introduce el número total de elementos: ");
                    int n = scanner.nextInt();
                    System.out.println("Introduce el número de elementos que se van a tomar: ");
                    int k = scanner.nextInt();
                    int combinaciones = combinaciones(n, k);
                    System.out.println("El número de combinaciones posibles es: " + combinaciones);
                    break;

                case 6:
                    System.out.println("Has elegido calcular el número de números primos que hay entre 2 y n.");
                    System.out.println("Introduce un número entero: ");
                    int num = scanner.nextInt();
                    int numPrimos = contarPrimos(num);
                    System.out.println("El número de números primos entre 2 y " + num + " es: " + numPrimos);
                    break;

                case 7:
                    System.out.println("Has elegido calcular el número de ocurrencias de un elemento en una lista.");
                    System.out.println("Introduce los números separados por coma: ");
                    String listaNumeros = scanner.next();
                    System.out.println("Ingresa el número que quieres buscar: ");
                    int numeroBuscado = scanner.nextInt();
                    int ocurrencias = calculo_ocurrencias(listaNumeros, numeroBuscado);
                    System.out.println("El número " + numeroBuscado + " aparece " + ocurrencias + " veces en la lista.");
                    break;
                case 8:
                    System.out.println("Has elegido determinar si un número es palíndromo o no.");
                    System.out.println("Ingrese un número entero positivo: ");
                    int numeropalindromo = scanner.nextInt();
                    boolean esPalindromo = esPalindromo(numeropalindromo);
                    if (esPalindromo) {
                        System.out.println("El número " + numeropalindromo + " es palíndromo.");
                    } else {
                        System.out.println("El número " + numeropalindromo + " no es palíndromo.");
                    }
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 9);

        scanner.close();
    }


public static long factorial(long numero) {
    if (numero == 0) {
        return 1;
    } else {
        return numero * factorial(numero-1);
    }
}

public static int potencia(int numero, int exponente) {
    int resultado = 1;
    for (int i = 0; i < exponente; i++) {
        resultado *= numero;
    }
    return resultado;
}

public static double media_aritmetica(String numeros) {
    String[] listaNumeros = numeros.split(",");
    int suma = 0;
    for (int i = 0; i < listaNumeros.length; i++) {
        suma += Integer.parseInt(listaNumeros[i]);
    }
    return (double) suma / listaNumeros.length;
}

public static int maximo_comun_divisor(int num1, int num2) {
    int divisorComun = 1;
    for (int i = 1; i <= num1 && i <= num2; i++) {
        if (num1 % i == 0 && num2 % i == 0) {
            divisorComun = i;
        }
    }
    return divisorComun;
}

public static int combinaciones(int n, int k) {
    if (k == 0 || k == n) {
        return 1;
    } else {
        return combinaciones(n-1, k-1) + combinaciones(n-1, k);
    }
} 

public static int contarPrimos(int num) {
    int contador = 0;
    boolean esPrimo;
    for (int i = 2; i <= num; i++) {
        esPrimo = true;
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                esPrimo = false;
                break;
            }
        }
        if (esPrimo) {
            contador++;
        }
    }
    return contador;
}

public static int calculo_ocurrencias(String listaNumeros, int numeroBuscado) {
    String[] lista = listaNumeros.split(",");
    int contador = 0;
    for (int i = 0; i < lista.length; i++) {
        if (Integer.parseInt(lista[i]) == numeroBuscado) {
        contador++;
        }
    }
    return contador;
 }

public static boolean Palindromo(int numero) {
    int numeroInvertido = 0;
    int numeroOriginal = numero;
    while (numero > 0) {
        int digito = numero % 10;
        numeroInvertido = numeroInvertido * 10 + digito;
        numero = numero / 10;
     }
    return numeroOriginal == numeroInvertido;
    }

public static boolean esPalindromo(int numero) {
    int numReverso = 0;
    int numOriginal = numero;
    
    while (numero != 0) {
        int digito = numero % 10;
        numReverso = numReverso * 10 + digito;
        numero /= 10;
    }
    return numOriginal == numReverso;
    }
}