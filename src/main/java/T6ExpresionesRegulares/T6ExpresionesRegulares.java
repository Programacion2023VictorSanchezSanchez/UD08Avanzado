package T6ExpresionesRegulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T6ExpresionesRegulares {
    public static void main(String[] args) {

        // 1. Escribe una expresión regular que haga match tanto con el texto “He ido al cine.”, como con “He ido al supermercado.”. Verifica tu repuesta con el método de la clase String matches.

        String regex1 = "He ido al cine\\.|He ido al supermercado\\.";
        System.out.println("He ido al supermercado.".matches(regex1));

        System.out.println(" "); System.out.println(" ");

        // 2.A partir del ejercicio anterior, usa el método de la clase Matcher matches para verificar las coincidencias (match) en vez de String.matches.

        Pattern pattern2 = Pattern.compile(regex1);
        Matcher matcher2 = pattern2.matcher("He ido al supermercado.");
        System.out.println(matcher2.matches());

        System.out.println(" "); System.out.println(" ");

        // 3. Reemplaza todos los “+$...+” por una barra baja (_) en la siguiente cadena. Imprime el resultado.

        String regex3 = "\\+\\$+\\+";
        System.out.println("Ciclo+$+formativo+$$+Desarrollo+$$$$+de+$$+aplicaciones+$+multiplataforma.".replaceAll(regex3, "_"));

        System.out.println(" "); System.out.println(" ");

        // 4. Escribe una expresión regular que coincida con el siguiente. Usa String.matches para verificar que funciona. “aaabcccccccdddefffg”. Puede haber:

        String regex4 = "\\ba*bc+d{3}e\\w*\\b";
        System.out.println("aaabcccccccdddefffg".matches(regex4));
        System.out.println("sssdd aaabcccccccdddefffg ffffccc aaabcccccccdddefffg".matches(regex4));
        Pattern pattern4 = Pattern.compile(regex4);
        Matcher matcher4 = pattern4.matcher("sssdd aaabcccccccdddefffg ffffccc aaabcccccccdddefffg ");
        System.out.println(matcher4.matches());

        int cont = 0;
        while(matcher4.find()){
            cont++;
        }
        System.out.println("Apariciones: " + cont);

        System.out.println(" "); System.out.println(" ");

        // 5. Escribe una expresión regular que coincida con un texto que tiene el siguiente formato.

        String regex5 = "[a-z]+\\.\\d+";
        System.out.println("abcdge.1234".matches(regex5));

        System.out.println(" "); System.out.println(" ");

        // 6. Modifica la expresión regular del ejercicio anterior y utiliza grupos. Ahora queremos imprimir todos los números que aparecen en un String que contiene múltiples ocurrencias del patrón del ejercicio anterior.

        String regex6 = "[a-z]+\\.(\\d+)";
        Pattern pattern6 = Pattern.compile(regex6);
        Matcher matcher6 = pattern6.matcher("abcde.1234jd.6tjuk.000");
        while(matcher6.find()){
            System.out.println(matcher6.group(1));
        }


        System.out.println(" "); System.out.println(" ");

        // 7. Nos han pedido encontrar en el Log de un servidor Web las ips que han accedido de la red 192.168.1.0. Crea una expresión regular que encuentre las ips de esta red (recuerda que la red va de 192.168.1.1 a la 192.168.1.254) y la fecha de acceso.

        String regex7 = "192\\.168\\.1\\.\\d{1,3} - - \\[\\d{1,2}/[a-zA-Z]{3}/\\d{4}";



        System.out.println(" "); System.out.println(" ");
    }
}
