package edu.pingpong.quickstart;

public class Espada {
    public String nombre;
    public Float longitud;

    public Espada(String nombre, Float longitud) {
        this.nombre = nombre;
        this.longitud = longitud;
    }

    public Espada() {
    }

    public String getNombre() {
        return nombre;
    }

    public Float getLongitud() {
        return longitud;
    }
}
