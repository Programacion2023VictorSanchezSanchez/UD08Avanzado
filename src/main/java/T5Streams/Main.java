package T5Streams;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();

        empleados.add(new Empleado("Juan", "García", 35000, LocalDate.of(2020, 3, 15), Departamento.INFORMATICA));

        empleados.add(new Empleado("María", "Martínez", 20000, LocalDate.of(2019, 8, 10), Departamento.CONTABILIDAD));

        empleados.add(new Empleado("Luis", "López", 28000, LocalDate.of(2022, 1, 20), Departamento.RRHH));

        empleados.add(new Empleado("Ana", "González", 37000, LocalDate.of(2023, 5, 5), Departamento.INFORMATICA));

        empleados.add(new Empleado("Carlos", "Rodríguez", 32000, LocalDate.of(2022, 12, 1), Departamento.CONTABILIDAD));


        // 2. Crea un stream que muestre por pantalla los empleados con sueldo mayor de 30000

        empleados.stream()
                .filter(empleado -> empleado.getSueldo() > 30000)
                .forEach(System.out::println);

        System.out.println(""); System.out.println("");

        // 3. Crea un stream que muestre por pantalla los empleados de Informática

        empleados.stream()
                .filter(empleado -> empleado.getDepartamento().equals(Departamento.INFORMATICA))
                .forEach(System.out::println);

        System.out.println(""); System.out.println("");

        // 4. Crea un stream que muestre por pantalla los empleados de Contabilidad con sueldo mayor de 30000 ordenado por sueldo. Utiliza peek para ver los resultados intermedios
        empleados.stream()
                .filter(empleado -> empleado.getSueldo() > 30000 && empleado.getDepartamento().equals(Departamento.CONTABILIDAD))
                .sorted(Comparator.comparing(Empleado::getSueldo))
                .forEach(System.out::println);

        System.out.println(""); System.out.println("");

        // 5. Crea un stream que devuelva una lista de String con los nombres del departamento de informática. Imprímela por pantalla.

        List<String> nombresInformatica5 = empleados.stream()
                .filter(empleado -> empleado.getDepartamento().equals(Departamento.INFORMATICA))
                .map(Empleado::getNombre)
                .collect(Collectors.toList());

        System.out.println(nombresInformatica5);

        System.out.println(""); System.out.println("");

        // 6. Crea un stream que devuelva un array de String con nombre+ sueldo, ordenada por sueldo. Imprimir por pantalla.
        String [] ejercicio6 = (String[]) empleados.stream()
                .sorted(Comparator.comparing(Empleado::getSueldo))
                .map(empleado -> empleado.getNombre() + " " + empleado.getSueldo())
                .toArray(String[]::new);

        System.out.println(Arrays.toString(ejercicio6));

        System.out.println(""); System.out.println("");

        // 7. Crea un stream que ordena por departamento y por apellido e imprime Departamento+apellido
        empleados.stream()
                .sorted(Comparator.comparing(Empleado::getDepartamento)
                .thenComparing(Empleado::getApellidos))
                .forEach(empleado -> System.out.println(empleado.getDepartamento() + " " + empleado.getApellidos()));

        System.out.println(""); System.out.println("");

        // 8. Crea un stream que imprime los empleados que entraron a la empresa el 2022

        empleados.stream()
                .filter(empleado -> empleado.getFechaEntrada().getYear() == 2022)
                .forEach(System.out::println);

        System.out.println(""); System.out.println("");

        // 9. Crea un stream que imprima la fecha de entrada de los empleados en formato local (12 abril 2023)

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");

        empleados.stream()
                .map(empleado -> empleado.getFechaEntrada().format(formatter))
                .forEach(fechaFormateada -> System.out.println("Fecha de entrada del empleado: " + fechaFormateada));

        System.out.println(""); System.out.println("");

        // 10. Crea un stream que imprima el empleado con sueldo máximo

        String empleadoSuledoMax = empleados.stream()
                .max(Comparator.comparing(Empleado::getSueldo))
                .toString();

        System.out.println(empleadoSuledoMax);

        System.out.println(""); System.out.println("");

        // 11. Crea un stream que nos diga el número total de empleados de Informática, imprime el resultado

        long numEmpleadosInformatica = empleados.stream()
                .filter(empleado -> empleado.getDepartamento() == Departamento.INFORMATICA)
                .count();

        System.out.println("Número total de empleados de Informática: " + numEmpleadosInformatica);

        System.out.println(""); System.out.println("");


    }
}
