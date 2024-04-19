package T6ExpresionesRegulares;

import javafx.css.Match;

import java.util.ArrayList;
import java.util.List;
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

        String regex7 = "(192\\.168\\.1\\.\\d{1,3}) - - \\[(\\d{1,2}/[a-zA-Z]{3}/\\d{4})";
        String log = "192.168.1.10 - - [11/Apr/2024:12:00:00] \"GET /pagina1 HTTP/1.1\" 200 1234";
        Pattern pattern7 = Pattern.compile(regex7);
        Matcher matcher7 = pattern7.matcher(log);

        while(matcher7.find()){
            System.out.println(matcher7.group(1) + " " +  matcher7.group(2));

        }


        System.out.println(" "); System.out.println(" ");

        // 8. A partir del siguiente texto, que contiene puntos de una gráfica extrae el contenido dentro de las llaves {}, crea una lista con los puntos e imprímelos.

        String puntos = "{0,2}, {1,5}, {20,3}, {300,4}";
        String regex8 = "\\{(\\d+),(\\d+)}";
        Pattern pattern8 = Pattern.compile(regex8);
        Matcher matcher8 = pattern8.matcher(puntos);

        List<Punto> listaPuntos = new ArrayList<Punto>();
        Punto punto;
        while(matcher8.find()){
            try{
                int x = Integer.parseInt(matcher8.group(1));
                int y = Integer.parseInt(matcher8.group(2));
                punto = new Punto(x,y);
                listaPuntos.add(punto);
            }catch (NumberFormatException e){
                System.out.println("Error en el formato del fichero");
            }
        }
        listaPuntos.forEach(System.out::println);

        System.out.println(" "); System.out.println(" ");


        // 9. Dado el siguiente string Crea una clase persona con los campos anteriores, Extrae la información del string anterior y crea una lista con las personas del string, imprímela.

        String personas = "Nombre:Juan,DNI:12345678A,Teléfono:123456789,Dirección:Calle 123\n" +
                "Nombre:María,DNI:87654321B,Teléfono:987654321,Dirección:Avenida XYZ\n" +
                "Nombre:Carlos,DNI:98765432C,Teléfono:987654321,Dirección:Calle 456";

        String regex9 = "Nombre:([a-zA-Záéíóúñ]+),DNI:(\\d{8}[A-HJ-NP-TV-Z]),Teléfono:(\\d{9}),Dirección:(.+)";
        Pattern pattern9 = Pattern.compile(regex9);
        Matcher matcher9 = pattern9.matcher(personas);

        List<Persona> listaPersonas = new ArrayList<Persona>();


        while(matcher9.find()){
            Persona persona = new Persona(matcher9.group(1), matcher9.group(2), matcher9.group(3), matcher9.group(4));
            listaPersonas.add(persona);
        }
        listaPersonas.forEach(System.out::println);




    }
}
