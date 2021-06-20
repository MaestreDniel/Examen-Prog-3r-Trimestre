package inmobiliariadata;

import java.util.ArrayList;
import java.util.List;

public class Inmobiliaria {

    private static List<Inmueble> inmuebles = new ArrayList<>();
    private String nombre;
    private String CIF;

    public Inmobiliaria() {

    }

    public Inmobiliaria(String nombre, String CIF) {
        this.nombre = nombre;
        this.CIF = CIF;
    }

    public static List<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public static void setInmuebles(List<Inmueble> inmuebles) {
        Inmobiliaria.inmuebles = inmuebles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    @Override
    public String toString() {
        return "Inmobiliaria: {" +
                "inmuebles=" + inmuebles +
                ", nombre='" + nombre + '\'' +
                ", CIF='" + CIF + '\'' +
                '}';
    }

}
