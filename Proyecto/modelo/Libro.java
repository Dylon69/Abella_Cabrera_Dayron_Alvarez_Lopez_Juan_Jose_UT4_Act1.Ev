package Proyecto.modelo;

public class Libro {

    private String isbn;
    private String titulo;
    private String autor;
    private int añoPublicacion;
    private String editorial;
    private Genero genero;
    private int copiasTotales;
    private int copiasDisponibles;
    private EstadoLibro estado;

    public Libro(String isbn, String titulo, String autor, int añoPublicacion, String editorial, Genero genero, int copiasTotales) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.editorial = editorial;
        this.genero = genero;
        this.copiasTotales = copiasTotales;
        this.copiasDisponibles = copiasTotales;
        this.estado = EstadoLibro.DISPONIBLE;
    }

    public boolean hayCopiasDisponibles() {
        return copiasDisponibles > 0;
    }

    public void prestar() {
        if (copiasDisponibles > 0) {
            copiasDisponibles--;
            if (copiasDisponibles == 0) {
                estado = EstadoLibro.PRESTADO;
            }
        }
    }

    public void devolver() {
        if (copiasDisponibles < copiasTotales) {
            copiasDisponibles++;
            estado = EstadoLibro.DISPONIBLE;
        }
    }

    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public Genero getGenero() { return genero; }
    public EstadoLibro getEstado() { return estado; }

    @Override
    public String toString() {
        return "Libro{" +
                "ISBN='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero=" + genero +
                ", disponibles=" + copiasDisponibles +
                '}';
    }
}
