package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String id;
    private String nombre;
    private List<Prestamo> prestamosActivos;
    private List<Prestamo> historialPrestamos;
    private LocalDate bloqueadoHasta;

    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.prestamosActivos = new ArrayList<>();
        this.historialPrestamos = new ArrayList<>();
        this.bloqueadoHasta = null;
    }

    public boolean puedePedirPrestamo() {
        if (prestamosActivos.size() >= 3) {
            return false;
        }

        if (bloqueadoHasta != null && LocalDate.now().isBefore(bloqueadoHasta)) {
            return false;
        }

        return true;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamosActivos.add(prestamo);
    }

    public void devolverPrestamo(Prestamo prestamo) {
        prestamosActivos.remove(prestamo);
        historialPrestamos.add(prestamo);

        // Si lo tuvo 30 días → bloqueo 7 días
        if (prestamo.duracionEnDias() >= 30) {
            bloqueadoHasta = LocalDate.now().plusDays(7);
        }
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public List<Prestamo> getPrestamosActivos() { return prestamosActivos; }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", prestamosActivos=" + prestamosActivos.size() +
                '}';
    }
}
