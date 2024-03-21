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
