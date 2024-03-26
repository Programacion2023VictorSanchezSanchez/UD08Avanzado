# UD08Avanzado
### Ejercicio 2
con mystery(0) mostrará del 0 al 6, con mystery(100) mostrará 100 solo

### Ejercicio 3
generá un bucle infinito y acaba dando error porque nunca para de mostrar números, siempre se cumple la condición

### Ejercicio 4
x es el número que se va a sumar e y es la cantidad de veces que se va a sumar ese número entre si(o una multiplicación)

va reduciendo y en 1 cada vez que suma 1 vez el número hasta que y es igual a 0 y sale de la recursividad

fun(3, 4) daría 12 // 3x4 = 12

### Ejercicio 5
public static int exponente(int x, int e) {

    // Caso base: si e es igual a 0, el resultado es 1.
    
    if (e == 0) {
    
        return 1;
        
    }
    
    // Caso recursivo: x^e = x * x^(e-1)
    
    return x * exponente(x, e - 1);
    
}

### Ejercicio 6
public static int exponente(int x, int e) {

    int resultado = 1;
    
    // Si el exponente es 0, retornamos 1.
    
    if (e == 0) {
    
        return resultado;
        
    }

    // Si el exponente es mayor que 0, realizamos la multiplicación iterativa.
    
    for (int i = 0; i < e; i++) {
    
        resultado *= x;
    }

    return resultado;
    
}


## Lambda 

### Ejercicio 1
Dependerá de si tiene uno o más de un método abstracto dentro de la interfaz, si tiene solo 1 podemos usar lambda.

Si, podemos usar lambda para mapear metodos concretos de List ya que List como tal no podemos mapearla al no ser una interfaz funcional.

### Ejercicio 2
Si, porque es una interfaz funcional, solo tiene el método call().

### Ejercicio 3
Comparator al tener 2 métodos no es una interfaz funcional, no podría aplicarse un lambda.

### Ejercicio 4
Runnable runnable = () -> {

            String texto = "Vamos a crear un array";
            
            String[] partes = texto.split(" ");
            
            for (String parte : partes) {
            
                System.out.println(parte);
                
            }
            
        };

        // Ejecutar el código de la expresión lambda
        
        runnable.run();


### Ejercicio 5
a) OperacionUnitariaEntera operacion = x -> x + x;

b) OperacionBinariaDecimal operacion = valor -> valor*valor;

c) Predicate operacion = x -> x * > 100;

d) OperacionBinariaEntera operacion = (x, y) -> x * y;

e) Saludable sal = () -> System.out.println("hola mundo");

### Ejercicio 6
a) boolean test(Integer valor);

b) Integer apply(Integer valor);

c) void accept(Integer valor);

d) Integer apply(Integer valor1, Integer valor2);

e) boolean test(Integer valor);

### Ejercicio 7
 Function<String, String> funcionLambda = (texto) -> {
 
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < texto.length(); i++) {
            
                if(i % 2 == 0){
                
                sb.append(texto.charAt(i));
                
                }
                
            }
            
            return sb.toString();
            
        };

### Ejercicio 8
        // Texto de entrada
        
        String texto = "1234567890";

        // Aplicar la función al texto de entrada
        
        String resultado = funcionLambda.apply(texto);

        System.out.println("Resultado después de aplicar la función: " + resultado);

### Ejercicio 9
// Metodo para ejecutar la funcion

public static String paresEjecuta(Function<String, String> funcion) {

        String texto = "1234567890";
        
        return funcion.apply(texto);
        
    }

// Llamada en el main

String resultado = paresEjecuta(funcionLambda);

System.out.println("Resultado después de ejecutar la función: " + resultado);

### Ejercicio 10
// Lista de ciudades

List<String> ciudades = Arrays.asList("elche", "alicante", "elda", "petrer", "aspe", "crevillente", "alcoy", "ibi", "benidorm", "matola");
        
// Ordenar la lista de ciudades

Collections.sort(ciudades, (ciudad1, ciudad2) -> ciudad1.compareToIgnoreCase(ciudad2));
        
// Imprimir los elementos de la lista ordenados y con la primera letra en mayúsculas
        
ciudades.forEach(ciudad -> System.out.println(ciudad.substring(0, 1).toUpperCase() + ciudad.substring(1)));

