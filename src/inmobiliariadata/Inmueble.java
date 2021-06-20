package inmobiliariadata;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Inmueble {

    private double m2;
    private double precio;
    private String poblacion;
    private int identificador;

    public Inmueble() {

    }

    public Inmueble(double m2, double precio, String poblacion, int identificador) {
        this.m2 = m2;
        this.precio = precio;
        this.poblacion = poblacion;
        this.identificador = identificador;
    }

    public double getM2() {
        return m2;
    }

    public void setM2(double m2) {
        this.m2 = m2;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        int precinit = 0;
        while (precinit < 1) {
            if (precio <= 0) {
                System.out.println("No se puede poner un precio menor o igual a cero.");
                System.out.print("Asigna un precio al inmueble: ");
                Scanner prec = new Scanner(System.in);
                this.precio = prec.nextInt();
                precio = this.precio;
            } else {
                precinit += 1;
            }
        }

        this.precio = precio;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return "\nInmueble: {" +
                "m2=" + m2 +
                ", precio=" + precio +
                ", poblacion='" + poblacion + '\'' +
                ", identificador=" + identificador +
                '}';
    }

    public abstract Inmueble solicitarDatos();

    public static void buscarVivienda(int habitaciones) {

        Vivienda vivienda = null;
        for (int i = 0; i < Inmobiliaria.getInmuebles().size(); i++) {

            Inmueble inmueble = Inmobiliaria.getInmuebles().get(i);
            if (inmueble instanceof Vivienda) {
                vivienda = (Vivienda) inmueble;
                if (habitaciones == vivienda.getNumhabitaciones()) {
                    System.out.println("Coincidencias: " + vivienda);
                    // Mostrará todas las viviendas con el mismo número de habitaciones que solicitaba el usuario
                }
            } else {
                i = i;
            }
        }
    }
    public static void buscarTerreno(String calific) {
        Terreno terreno = null;
        for (int i = 0; i < Inmobiliaria.getInmuebles().size(); i++) {

            Inmueble inmueble = Inmobiliaria.getInmuebles().get(i);
            if (inmueble instanceof Terreno) {
                terreno = (Terreno) inmueble;
                if (calific.equals(terreno.getTipocalificacion())) {
                    System.out.println("Coincidencias: " + terreno);
                    break; // Para mostrar solo el primero que coincide
                }
            } else {
                i = i;
            }
        }
    }

}
