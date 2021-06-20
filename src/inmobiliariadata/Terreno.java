package inmobiliariadata;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Terreno extends Inmueble {

    private String tipocalificacion;

    public Terreno() {

    }

    public Terreno(double m2, double precio, String poblacion, int identificador) {
        super(m2, precio, poblacion, identificador);
    }

    public String getTipocalificacion() {
        return tipocalificacion;
    }

    public void setTipocalificacion(String tipocalificacion) {
        int calificado = 0;
        ArrayList<String> calificacionposible = new ArrayList<>();
        calificacionposible.add("rustico");
        calificacionposible.add("urbano");
        calificacionposible.add("urbanizable");
        while (calificado < 1) {
            for (int i = 0; i < calificacionposible.size(); i++) {
                if (tipocalificacion.equals("rustico") || tipocalificacion.equals("urbano") || (tipocalificacion.equals("urbanizable"))) {
                    this.tipocalificacion = tipocalificacion;
                    calificado += 1;
                    break;
                } else {
                    System.out.println("No es un tipo de calificación correcto, vuelve a intentarlo.");
                    System.out.println("Los tipos disponibles son: 'rustico', 'urbano', 'urbanizable'.");
                    Scanner scannombre = new Scanner(System.in);
                    tipocalificacion = scannombre.nextLine();
                }
            }
        }
        this.tipocalificacion = tipocalificacion;
    }

    @Override
    public String toString() {
        return "\nTerreno: {" +
                "tipocalificacion='" + tipocalificacion + '\'' +
                '}';
    }

    @Override
    public Terreno solicitarDatos() {
        Terreno terreno = null;
        try {
            terreno = new Terreno();
            System.out.print("Escribe los metros cuadrados: ");
            Scanner datos = new Scanner(System.in);
            double met = datos.nextDouble();
            terreno.setM2(met);

            System.out.print("Escribe el precio: ");
            double prec = datos.nextDouble();
            terreno.setPrecio(prec);

            Scanner datos2 = new Scanner(System.in);
            System.out.print("Escribe la población: ");
            String pob = datos2.nextLine();
            terreno.setPoblacion(pob);

            System.out.print("Escribe el identificador: ");
            int id = datos.nextInt();
            terreno.setIdentificador(id);

            Scanner datos3 = new Scanner(System.in);
            System.out.print("Escribe la calificación (rustico o urbano o urbanizable): ");
            String calif = datos3.nextLine();
            terreno.setTipocalificacion(calif);

            Inmobiliaria.getInmuebles().add(terreno);
            System.out.println("El terreno se ha añadido (no se muestran los datos de la superclase): " + terreno);
            return terreno;
        } catch (Exception e) {
            System.out.println("Error al introducir datos. ¡Asegúrate de introducirlos bien!");
        }
        return terreno;
    }

    public static Terreno añadirTerreno() {
        Terreno terreno = new Terreno();
        terreno.solicitarDatos();
        return terreno;
    }
}


