package inmobiliariadata;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Nombre y apellidos: Daniel Maestre Hermoso
 * Fecha: 07/06/2021
 * Curso: 1º DAW
 * Módulo: Programación
 * Examen práctico del 3r trimestre
 *
 */

public class GestionInmobiliaria {

    private static ArrayList<Inmobiliaria> listaInmobiliaria = new ArrayList<>();

    public static ArrayList<Inmobiliaria> getListaInmobiliaria() {
        return listaInmobiliaria;
    }

    public static void setListaInmobiliaria(ArrayList<Inmobiliaria> listaInmobiliaria) {
        GestionInmobiliaria.listaInmobiliaria = listaInmobiliaria;
    }

    public static void main(String[] args) {
        iniciarInmobiliaria(listaInmobiliaria);
        Inmobiliaria inmobiliariaActiva = elegirInmobiliaria();
        int asignada = 0;
        while (asignada < 1) {
            if (inmobiliariaActiva != null) {
                menuPrincipalInmobiliaria(inmobiliariaActiva);
                asignada += 1;
            } else { // Hasta que no se introduzca un cif existente, habrá que volver a intentarlo
                System.out.println("Vuelve a intentarlo. Sugerencia: Inmo0");
                inmobiliariaActiva = elegirInmobiliaria();
            }
        }


    }

    public static Inmobiliaria elegirInmobiliaria() {
        Inmobiliaria inmobiliaria = null;
        System.out.print("Introduce el cif de la inmobiliaria (sugerencia Inmo0): ");
        Scanner ciff = new Scanner(System.in);
        String cif = ciff.nextLine();

        for (int i = 0; i < getListaInmobiliaria().size(); i++) {
            if (cif.equals(getListaInmobiliaria().get(i).getCIF())){
                inmobiliaria = getListaInmobiliaria().get(i);
            } else if (!cif.equals(getListaInmobiliaria().get(i).getCIF())){
                i = i;
            } else {
                System.out.println("No se encontró la inmobiliaria");
            }
        }
        return inmobiliaria;
        //return getListaInmobiliaria().get(1);
    }

    public static void menuPrincipalInmobiliaria(Inmobiliaria inmobiliariaActiva) {
        Scanner menu = new Scanner(System.in);
        boolean salir = false;
        int opcion = 0; //Guardaremos la opción del usuario
        while(!salir) {
            System.out.println("1. Opcion 1 - Añadir terreno");
            System.out.println("2. Opcion 2 - Añadir vivienda");
            System.out.println("3. Opcion 3 - Buscar vivienda");
            System.out.println("4. Opcion 4 - Buscar terreno");
            System.out.println("5. Opcion 5 - Salir");
            System.out.print("Escribe una de las opciones: ");
            opcion = menu.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Añade un terreno: ");
                    Terreno.añadirTerreno();
                    break;
                case 2:
                    System.out.println("Añade una vivienda: ");
                    Vivienda.añadirVivienda();
                    break;
                case 3:
                    System.out.println("Busca una vivienda: ");
                    System.out.print("Introduce la cantidad de habitaciones que quieres: ");
                    Scanner habquery = new Scanner(System.in);
                    int habitaciones = habquery.nextInt();
                    Inmueble.buscarVivienda(habitaciones);
                    break;
                case 4:
                    System.out.println("Busca un terreno: ");
                    System.out.println("Introduce el tipo de calificación de terreno que te interesa (puede ser rustico o urbano o urbanizable): ");
                    System.out.println("Sugerencia: por defecto se añaden los rústicos, prueba a poner 'rustico'. Si no, añade otro manualmente");
                    Scanner terrquery = new Scanner(System.in);
                    String calific = terrquery.nextLine();
                    Inmueble.buscarTerreno(calific);
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Las opciones disponibles son de 1 a 5. " + "Vuelve a intentarlo");
            }
        }
    }

    public static void iniciarInmobiliaria(ArrayList<Inmobiliaria> listaInmobiliaria) {
        Inmobiliaria inmoTemp;
        Terreno terrenoTemp;
        Vivienda viviendaTemp;

        for (int i = 0; i < 3; i++) {
            inmoTemp = new Inmobiliaria();
            inmoTemp.setCIF("Inmo0");
            inmoTemp.setNombre("nombreInmo");
            for (int j = 0; j < 3; j++) {
                terrenoTemp = new Terreno();
                terrenoTemp.setIdentificador(i + j);
                terrenoTemp.setM2(j * 80);
                terrenoTemp.setPoblacion("poblac" + j);
                terrenoTemp.setPrecio(30000 * (i + 1));
                terrenoTemp.setTipocalificacion("rustico");
                Inmobiliaria.getInmuebles().add(terrenoTemp);

                viviendaTemp = new Vivienda();
                viviendaTemp.setIdentificador(i + j);
                viviendaTemp.setM2(j * 80);
                viviendaTemp.setPoblacion("poblac" + j);
                viviendaTemp.setPrecio(30000 * (i + 1));
                viviendaTemp.setDescripcion("descripcion vivienda " + i);
                viviendaTemp.setNumhabitaciones(i + j + 1);

                Inmobiliaria.getInmuebles().add(viviendaTemp);

            }
            listaInmobiliaria.add(inmoTemp);
        }

    }

}
