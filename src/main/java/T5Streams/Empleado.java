package T5Streams;

import java.time.LocalDate;

public class Empleado implements Comparable{
    private String nombre;
    private String apellidos;
    private double sueldo;
    private LocalDate fechaEntrada;
    private Departamento departamento;

    public Empleado(String nombre, String apellidos, double sueldo, LocalDate fechaEntrada, Departamento departamento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sueldo = sueldo;
        this.fechaEntrada = fechaEntrada;
        this.departamento = departamento;
    }

    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public double getSueldo() {
        return this.sueldo;
    }
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public LocalDate getFechaEntrada() {
        return this.fechaEntrada;
    }
    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Departamento getDepartamento() {
        return this.departamento;
    }
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + this.nombre + '\'' +
                ", apellidos='" + this.apellidos + '\'' +
                ", sueldo=" + this.sueldo +
                ", fechaEntrada=" + this.fechaEntrada +
                ", departamento=" + this.departamento +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        return this.apellidos.compareTo(((Empleado)o).apellidos);
    }
}
