package T6ExpresionesRegulares;

public class Persona {
    private String nombre;
    private String dni;
    private String telefono;
    private String direccion;

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + this.nombre + '\'' +
                ", dni='" + this.dni + '\'' +
                ", telefono=" + this.telefono +
                ", direccion='" + this.direccion + '\'' +
                '}';
    }

    public Persona(String nombre, String dni, String telefono, String direccion) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
