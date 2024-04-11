package T5Streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();

        empleados.add(new Empleado("Juan", "García", 35000, LocalDate.of(2020, 3, 15), Departamento.INFORMATICA));

        empleados.add(new Empleado("María", "Martínez", 20000, LocalDate.of(2019, 8, 10), Departamento.CONTABILIDAD));

        empleados.add(new Empleado("Luis", "López", 28000, LocalDate.of(2022, 1, 20), Departamento.RRHH));

        empleados.add(new Empleado("Ana", "González", 37000, LocalDate.of(2023, 5, 5), Departamento.INFORMATICA));

        empleados.add(new Empleado("Carlos", "Rodríguez", 32000, LocalDate.of(2022, 12, 1), Departamento.CONTABILIDAD));


        // 2. Crea un stream que muestre por pantalla los empleados con sueldo mayor de 30000

        empleados.stream().filter(empleado -> empleado.getSueldo() > 30000).forEach(System.out::println);

        // 3. Crea un stream que muestre por pantalla los empleados de Informática

        empleados.stream().filter(empleado -> empleado.getDepartamento().equals(Departamento.INFORMATICA)).forEach(System.out::println);

        // 4. Crea un stream que muestre por pantalla los empleados de Contabilidad con sueldo mayor de 30000 ordenado por sueldo. Utiliza peek para ver los resultados intermedios
        empleados.stream().filter(empleado -> empleado.getSueldo() > 30000 && empleado.getDepartamento().equals(Departamento.CONTABILIDAD)).sorted(Comparator.comparing(Empleado::getSueldo)).forEach(System.out::println);

    }
}
