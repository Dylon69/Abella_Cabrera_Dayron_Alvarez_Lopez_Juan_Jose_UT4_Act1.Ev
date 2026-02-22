import modelo.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestorBiblioteca {

    private List<Libro> libros;

    public GestorBiblioteca() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public List<Libro> buscarPorTitulo(String titulo) {
        return libros.stream()
                .filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
                .collect(Collectors.toList());
    }

    public Libro buscarPorISBN(String isbn) {
        return libros.stream()
                .filter(l -> l.getIsbn().equalsIgnoreCase(isbn))
                .findFirst()
                .orElse(null);
    }

    public List<Libro> buscarPorGenero(Genero genero) {
        return libros.stream()
                .filter(l -> l.getGenero() == genero)
                .collect(Collectors.toList());
    }
}