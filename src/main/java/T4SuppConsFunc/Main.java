package T4SuppConsFunc;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // 1. Crea un predicado para comprobar si un número de entrada es mayor a 100.
        Predicate<Integer> mayorQue100 = num -> num > 100;
        int num1 = 50;
        if(mayorQue100.test(num1)){
            System.out.println(num1 + " es mayor que 100");
        } else {
            System.out.println(num1 + " no es mayor que 100");
        }

        // 2. Crea predicados para comprobar si un número está entre 100 y 300.
        Predicate<Integer> entre100y300 = num -> num >= 100 && num <= 300;
        int num2 = 150;

        if(entre100y300.test(num2)){
            System.out.println(num2 + " esta entre 100 y 300");
        } else {
            System.out.println(num2 + " no esta entre 100 y 300");
        }
        // 3. Crea predicados para comprobar si un número es mayor a 100 o es menor que 50.
        Predicate<Integer> mayorQue100OMenorQue50 = num -> num > 100 || num < 50;

        int num3 = 100;

        if(mayorQue100OMenorQue50.test(num3)){
            System.out.println(num3 + " es o mayor que 100 o menor que 50");
        } else {
            System.out.println(num3 + " no es ni mayor que 100 ni menor que 50");
        }

        // 4. Crea un predicado para comprobar que un número no sea igual a 100.
        Predicate<Integer> noEsIgual100 = num -> num != 100;

        int num4 = 99;

        if(noEsIgual100.test(num4)){
            System.out.println(num4 + " no es igual a 100");
        } else {
            System.out.println(num4 + " es igual a 100");
        }

        // 5. Crea un predicado para comprobar que dos String son iguales.
        BiPredicate<String, String> sonIguales = (str1, str2) -> str1.equals(str2);

        String strTest1 = "hola";
        String strTest2 = "hola!";

        if(sonIguales.test(strTest1, strTest2)){
            System.out.println(strTest1 + " y " + strTest2 + " son iguales");
        } else {
            System.out.println(strTest1 + " y " + strTest2 + " no son iguales");
        }

        // 6. Crea una lista con 10 enteros. Crea dos predicados para saber si algún número de la lista está entre 25 y 30. Imprime el resultado
        Predicate<List<Integer>> entre25y30=(lista)->{
          boolean es25o30 = false;
          for(int n : lista){
              if(n >= 25 && n <= 30){
                  es25o30 = true;
              }
          }
          return es25o30;
        };

        List<Integer> numeros = Arrays.asList(10, 15, 20, 25, 30, 35, 40, 45, 50, 55);

        if(entre25y30.test(numeros)){
            System.out.println("Hay un número entre 25 y 30");
        } else {
            System.out.println("No hay ningún número entre 25 y 30");
        }

        // 7. Crea una lista con 6 cadenas de texto. Crea predicados para saber si alguna cadena de texto empieza por A o si alguna tiene longitud 5

        Predicate<List<String>> empiezaPorA = (lista) ->{
            boolean porA = false;
            for(String s : lista){
                if(s.startsWith("A")){
                    porA = true;
                }
            }
            return porA;
        };

        Predicate<List<String>> longitud5 = (lista)->{
            boolean tieneLongitud5 = false;
            for(String s : lista){
                if(s.length() == 5){
                    tieneLongitud5 = true;
                }
            }
            return tieneLongitud5;
        };

        List<String> cadenas = Arrays.asList("Manzana", "Banana", "Cereza", "Kiwi", "Uva", "Pera");

        if(empiezaPorA.test(cadenas) || longitud5.test(cadenas)){
            System.out.println("Tiene algún elemento de longitud 5 o que empiece por A");
        } else {
            System.out.println("No tiene algún elemento de longitud 5 o que empiece por A");
        }

        // 8. Crea un predicado para encontrar elementos en la lista anterior que no empiecen por P.
        Predicate<List<String>> noEmpiezaPorP = (lista) ->{
            boolean porP = false;
            for(String s : lista){
                if(s.startsWith("P")){
                    System.out.println(s);
                    porP = true;
                }
            }
            return porP;
        };

        noEmpiezaPorP.test(cadenas);

    }

}
