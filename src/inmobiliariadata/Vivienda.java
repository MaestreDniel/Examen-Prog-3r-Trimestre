package inmobiliariadata;

import java.util.Scanner;

public class Vivienda extends Inmueble {

    private int numhabitaciones;
    private String descripcion;

    public Vivienda() {

    }

    /*public Vivienda(double m2, double precio, String poblacion, int identificador) {
        super(m2, precio, poblacion, identificador);
    }

    public Vivienda(int numhabitaciones, String descripcion) {
        this.numhabitaciones = numhabitaciones;
        this.descripcion = descripcion;
    }

    public Vivienda(double m2, double precio, String poblacion, int identificador, int numhabitaciones, String descripcion) {
        super(m2, precio, poblacion, identificador);
        this.numhabitaciones = numhabitaciones;
        this.descripcion = descripcion;
    }*/

    public int getNumhabitaciones() {
        return numhabitaciones;
    }

    public void setNumhabitaciones(int numhabitaciones) {
        int confirmada = 0;
        // Control del número de habitaciones
        while (confirmada < 1) {
            if (numhabitaciones < 1) {
                System.out.print("No puede ser inferior a 0. Vuelve a intentarlo: ¿Cuántas habitaciones quieres?: ");
                Scanner copiassc = new Scanner(System.in);
                this.numhabitaciones = copiassc.nextInt();
                numhabitaciones = this.numhabitaciones;
            } else {
                confirmada += 1;
            }
        }
        this.numhabitaciones = numhabitaciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "\nVivienda: {" +
                "numhabitaciones=" + numhabitaciones +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public Vivienda solicitarDatos() {
        Vivienda vivienda = null;
        try {
            vivienda = new Vivienda();
            System.out.print("Escribe los metros cuadrados: ");
            Scanner datos = new Scanner(System.in);
            double met = datos.nextDouble();
            vivienda.setM2(met);

            System.out.print("Escribe el precio: ");
            double prec = datos.nextDouble();
            vivienda.setPrecio(prec);

            Scanner datos2 = new Scanner(System.in);
            System.out.print("Escribe la población: ");
            String pob = datos2.nextLine();
            vivienda.setPoblacion(pob);

            System.out.print("Escribe el identificador: ");
            int id = datos.nextInt();
            vivienda.setIdentificador(id);

            Scanner datos3 = new Scanner(System.in);
            System.out.print("Escribe el numero de habitaciones: ");
            int numhab = datos3.nextInt();
            vivienda.setNumhabitaciones(numhab);

            Scanner datos4 = new Scanner(System.in);
            System.out.print("Escribe una pequeña descripción: ");
            String desc = datos4.nextLine();
            vivienda.setDescripcion(desc);

            Inmobiliaria.getInmuebles().add(vivienda);
            System.out.println("La vivienda se ha añadido (no se muestran los datos de la superclase): " + vivienda);
            return vivienda;

        } catch (Exception e) {
            System.out.println("Error al introducir datos. ¡Asegúrate de introducirlos bien!");
        }
        return vivienda;
    }
    public static Vivienda añadirVivienda() {
        Vivienda vivienda = new Vivienda();
        vivienda.solicitarDatos();
        return vivienda;
    }
}

