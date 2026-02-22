package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Libro;
import modelo.Prestamo;
import modelo.Usuario;

public class GestorBiblioteca {

    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;

    public GestorBiblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        if (libro != null) {
            libros.add(libro);
        }
    }

    public void registrarUsuario(Usuario usuario) {
        if (usuario != null) {
            usuarios.add(usuario);
        }
    }

    public void prestarLibro(Libro libro, Usuario usuario) {
        if (libro != null && usuario != null) {
            if (libro.hayCopiasDisponibles() && usuario.puedePedirPrestamo()) {

                Prestamo nuevoPrestamo = new Prestamo(libro, usuario);
                prestamos.add(nuevoPrestamo);
                libro.prestar();
                usuario.agregarPrestamo(nuevoPrestamo);
                System.out.println("Prestamo realizado:" + libro.getTitulo());
            } else {
                System.out.println("No se puede realizar el prestamo.");
            }
        }
    }

    public void devolverLibro(Libro libro, Usuario usuario) {
        Prestamo prestamoEncontrado = null;
        for (Prestamo p : prestamos) {
            if (p.getLibro().equals(libro) && p.getUsuario().equals(usuario)) {
                prestamoEncontrado = p;
                break;
            }
        }
        if (prestamoEncontrado != null) {
            libro.devolver();
            usuario.devolverPrestamo(prestamoEncontrado);
            prestamos.remove(prestamoEncontrado);
            System.out.println("Libro devuelto: " + libro.getTitulo());
        } else {
            System.out.println("No se encontró el préstamo.");
        }
    }

    public void reservarLibro(Libro libro, Usuario usuario) {
        if (libro != null && usuario !=null) {
            if (!libro.hayCopiasDisponibles()) {
                System.out.println("Reserva confirmada: " + libro.getTitulo() + " para el usuario " + usuario.getNombre());
            } else {
                System.out.println("El  libro tiene copias disponibles, no es necesario reservar.");
            }
        }
    }

    public void mostrarResumenEstado() {
        System.out.println("\n========== ESTADO DE LA BIBLIOTECA ==========");
        System.out.println("Total de libros registrados: " + libros.size());
        System.out.println("Total de usuarios registrados: " + usuarios.size());
        System.out.println("Prestamos activos actualmente: " + prestamos.size());
        System.out.println("=============================================");
    }

    public void iniciarMenu(Consola consola) {
        int opcion;
        do { 
            consola.mostrarMensaje("\n---MENU BIBLIOTECA---");
            consola.mostrarMensaje("1. Prestar libro");
            consola.mostrarMensaje("2. Devolver libro");
            consola.mostrarMensaje("3. Reservar libro");
            consola.mostrarMensaje("4. Ver estado sistema");
            consola.mostrarMensaje("0. Salir");

            opcion = consola.leerEntero("Selecciona una opcion");

            switch (opcion) {
                case 1:
                    consola.mostrarMensaje("Ejecutando logaica de prestamo...");
                    break;
                case 2:
                    consola.mostrarMensaje("Ejecutando logica de devolucion...");
                    break;
                case 3:
                    consola.mostrarMensaje("Ejecutando logica de reserva...");
                    break;
                case 4:
                    mostrarResumenEstado();
                    break;
                case 0:
                    consola.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    consola.mostrarMensaje("Opcion no valida, intente de nuevo.");
            }
        } while (opcion != 0);
    }












    
}