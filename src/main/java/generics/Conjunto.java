package generics;

import java.util.Arrays;

public class Conjunto <T>{
    private static final int TAM = 10;
    private T[] array;

    // Constructor base
    public Conjunto() {
        array = (T[]) new Object[TAM];
    }

    /**
     * Insertamos un elemento en el array
     * @param element a insertar
     * @return true o false en funcion de si se ha insertado o no
     */
    public boolean insert(T element) {
        boolean insertado = false;
        for (int i = 0; i < TAM; i++) {
            // Si encontramos un espacio vacío, insertamos, devolvemos true y dejamos de recorrer el array
            if (array[i] == null) {
                array[i] = element;
                insertado = true;
                i = TAM;
            }
        }
        return insertado;
    }

    /**
     * Eliminamos un elemento igual a element del array
     * @param element del cual buscaremos igualdad
     * @return true o false dependiendo de si elimino algo o no
     */
    public boolean delete(T element) {
        boolean eliminado = false;
        for (int i = 0; i < TAM; i++) {
            // Si eliminamos un elemento igual, devolvemos true y dejamos de recorrer el array
            if (array[i] != null && array[i].equals(element)) {
                array[i] = null;
                eliminado = true;
                i = TAM;
            }
        }
        return eliminado;
    }

    /**
     * Devolvemos el contenido de una posicion del array
     * @param pos posicion a devolver
     * @return contenido de la posicion o null
     */
    public T get(int pos) {
        T posContent;
        if (pos >= 0 && pos < TAM) {
            posContent = array[pos];
        } else {
            posContent = null;
        }
        return posContent;
    }

    /**
     * Devolvemos la posicion de un elemento del array (si se encuentra)
     * @param element a buscar en el array
     * @return posicion del elemento encontrado o -1 si no se encontro nada
     */
    public int find(T element) {
        int posFinded = -1;
        for (int i = 0; i < TAM; i++) {
            if (array[i] != null && array[i].equals(element)) {
                posFinded = i; // Se encontró el elemento en la posición i
                i = TAM;
            }
        }
        return posFinded;
    }

    /**
     * Metodo equals
     * @param obj del cual compararemos arrays
     * @return true o false dependiendo de si los arrays son exactamente iguales o no
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Conjunto<?> otroConjunto = (Conjunto<?>) obj;
        return Arrays.equals(array, otroConjunto.array);
    }

        public static void main(String[] args) {
            // Crear un conjunto de cadenas
            Conjunto<String> conjuntoCadenas = new Conjunto<>();

            // Insertar elementos
            conjuntoCadenas.insert("Hola");
            conjuntoCadenas.insert("Mundo");
            conjuntoCadenas.insert("Java");

            // Buscar un elemento
            System.out.println("Posición de 'Mundo': " + conjuntoCadenas.find("Mundo"));

            // Eliminar un elemento
            conjuntoCadenas.delete("Java");

            System.out.println("Elemento en la posicion 2: " + conjuntoCadenas.get(2));

            // Crear un conjunto de enteros
            Conjunto<Integer> conjuntoEnteros = new Conjunto<>();

            // Insertar elementos
            conjuntoEnteros.insert(10);
            conjuntoEnteros.insert(20);
            conjuntoEnteros.insert(30);

            // Buscar un elemento
            System.out.println("Posición de 20: " + conjuntoEnteros.find(20));

            // Eliminar un elemento
            conjuntoEnteros.delete(10);

            System.out.println("Elemento en la posicion 0: " + conjuntoEnteros.get(0));

            Conjunto<Integer> conjunto1 = new Conjunto<>();
            conjunto1.insert(1);
            conjunto1.insert(2);
            conjunto1.insert(3);

            Conjunto<Integer> conjunto2 = new Conjunto<>();
            conjunto2.insert(1);
            conjunto2.insert(2);
            conjunto2.insert(3);

            Conjunto<Integer> conjunto3 = new Conjunto<>();
            conjunto3.insert(1);
            conjunto3.insert(3);
            conjunto3.insert(2);

            System.out.println("Conjunto1 equals Conjunto2: " + conjunto1.equals(conjunto2));
            System.out.println("Conjunto1 equals Conjunto3: " + conjunto1.equals(conjunto3));

        }
        /* ¿Puedes insertar una cadena en un conjunto de enteros? Explica lo que sucede cuando lo intentas

            Dara error de compilación, los tipos genéricos están diseñados para proporcionar seguridad de tipos
            con lo cual cuando defines un "Conjunto<Integer>, especifícas que este conjunto solo puede contener objetos
            de tipo Integer.

            */
    }




