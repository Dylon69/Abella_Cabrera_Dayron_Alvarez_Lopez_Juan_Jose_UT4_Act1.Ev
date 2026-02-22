import controlador.Consola;
import controlador.GestorBiblioteca;
import modelo.Genero;
import modelo.Libro;
import modelo.Usuario;

public class Main {
    public static void main(String[] args) {
        GestorBiblioteca gestor = new GestorBiblioteca();
        Consola consola = new Consola();

        Libro libro1 = new Libro("1", "El Quijote", "Miguel de Cervantes", 1605, "Anaya", Genero.NOVELA, 3);
        Usuario usuario1 = new Usuario("101", "Juan Jose");

        gestor.agregarLibro(libro1);
        gestor.registrarUsuario(usuario1);

        gestor.iniciarMenu(consola);
    }
}