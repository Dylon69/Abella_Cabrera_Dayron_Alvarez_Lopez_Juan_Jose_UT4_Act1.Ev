package Proyecto.modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {

    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaVencimiento;

    public Prestamo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = LocalDate.now();
        this.fechaVencimiento = fechaPrestamo.plusDays(30);
    }

    public boolean estaVencido() {
        return LocalDate.now().isAfter(fechaVencimiento);
    }

    public long duracionEnDias() {
        return ChronoUnit.DAYS.between(fechaPrestamo, LocalDate.now());
    }

    public Libro getLibro() { return libro; }
    public Usuario getUsuario() { return usuario; }

    @Override
    public String toString() {
        return "Prestamo{" +
                "libro=" + libro.getTitulo() +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaVencimiento=" + fechaVencimiento +
                '}';
    }
}