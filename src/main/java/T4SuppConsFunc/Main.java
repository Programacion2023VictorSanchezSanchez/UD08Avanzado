package T4SuppConsFunc;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
            boolean porP = true;
            for(String s : lista){
                if(!s.startsWith("P")){
                    System.out.println(s);
                    porP = false;
                }
            }
            return porP;
        };

        noEmpiezaPorP.test(cadenas);


       // 9. Crea una lambda basada en Supplier que devuelva el String “Me gusta Java”. Imprime el resultado.
        Supplier<String> meGusta = () -> "Me gusta Java";

        System.out.println(meGusta.get());

        // 10. Crea una lista con 5 Strings con nombres de Ciudad. Crea una lambda basada en Supplier que devuelve aleatoriamente un nombre de la lista anterior.

        List<String> ciudades5 = Arrays.asList("Tokio", "Nueva York", "Londres", "París", "Roma");

        Random random = new Random();

        Supplier<String> ciudadAleatoria = () -> ciudades5.get(random.nextInt(ciudades5.size()));

        System.out.println("Me voy de viaje a ... " + ciudadAleatoria.get());
        System.out.println("Me voy de viaje a ... " + ciudadAleatoria.get());

        // 11. Crea una lambda basada en Supplier que devuelva un String con la fecha actual. Busca información de cómo obtener la fecha y su formato.
        Supplier<String> fechaActual = () ->{
            LocalDateTime fecha = LocalDateTime.now();
            return fecha.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        };

        System.out.println("Fecha y hora actual " + fechaActual.get());

        // 12. Crea una lambda basada en Supplier que devuelva String con el día de la semana actual.
        Supplier<String> diaSemana = () -> {
            DayOfWeek diaSemanaActual = LocalDate.now().getDayOfWeek();
            return diaSemanaActual.toString();
        };

        System.out.println("El dia de la semana actual es: " + diaSemana.get());

        // 13. Con la lista del ejercicio 10, llama al método foreach y pasale una lambda que muestre por pantalla todas la ciudades en mayúsculas.

        ciudades5.forEach(ciudad -> System.out.println(ciudad.toUpperCase()));

        // 14. Crea una función que devuelva la longitud de una cadena. Imprime la longitud de la cadena “Programación” utilizando la función
        Function<String, Integer> longitudCadena = (cadena) -> cadena.length();

        String cadena = "Programación";

        System.out.println("Longitud de la cadena '" + cadena + "': " + longitudCadena.apply(cadena));

        // 15. Crea una función que devuelva la potencia de dos de un número dado. Imprime la del número 4.
        Function<Integer, Integer> potenciaDeDos = (numero) -> numero * numero;

        System.out.println(potenciaDeDos.apply(4));

        // 16. Crea una función que reciba un double y devuelva un string mostrando: “Resultado: numero”.

        Function<Double, String> resultadoString = (numero) -> "Resultado: " + numero;

        System.out.println(resultadoString.apply(3.14));

        // 17.

        // a. Muestra la lista por pantalla.
        ciudades5.forEach(s-> System.out.println(s));

        // b. Muestra el Map por pantalla utilizando foreach.

        Function<String, Integer> f17 = s -> s.length();

        HashMap<String, Integer> map = convertirListaEnMap(ciudades5, f17);







    }

    /**
     * Metodo para el ejercicio 17
     * @param lista que pasamos al metodo
     * @param funcionValor function que pasamos al metodo
     * @return map con strings y sus longitudes
     */
    public static HashMap<String, Integer> convertirListaEnMap(List<String> lista, Function<String, Integer> funcionValor){
        HashMap<String, Integer> map = new HashMap<>();
        lista.forEach(s -> map.put(s, funcionValor.apply(s)));

        return map;
    }

}
