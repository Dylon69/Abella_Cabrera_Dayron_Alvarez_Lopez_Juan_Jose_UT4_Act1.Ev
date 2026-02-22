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
}