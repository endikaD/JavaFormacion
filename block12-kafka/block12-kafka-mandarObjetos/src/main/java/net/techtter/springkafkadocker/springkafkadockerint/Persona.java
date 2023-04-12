package net.techtter.springkafkadocker.springkafkadockerint;

public class Persona {
    private String nombre;
    private String pueblo;
    private Integer edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPueblo() {
        return pueblo;
    }

    public void setPueblo(String pueblo) {
        this.pueblo = pueblo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Persona() {
    }

    public Persona(String nombre, String pueblo, Integer edad) {
        this.nombre = nombre;
        this.pueblo = pueblo;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", pueblo='" + pueblo + '\'' +
                ", edad=" + edad +
                '}';
    }
}
