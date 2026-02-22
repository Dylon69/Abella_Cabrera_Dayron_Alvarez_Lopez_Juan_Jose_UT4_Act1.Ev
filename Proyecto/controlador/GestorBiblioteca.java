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
}