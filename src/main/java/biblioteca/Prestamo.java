package biblioteca;

import libros.Libro;
import usuarios.Usuario;

import java.time.LocalDateTime;
import java.util.Date;

public class Prestamo {

    private Usuario       usuarioPrestamo;
    private Libro         libroPrestado;
    private Date          fechaPrestamo;
    private int           cantDiasPrestados;
    private LocalDateTime fechaDevolucion;

    public Prestamo(Usuario usuarioPrestamo, Libro libroPrestado, Date fechaPrestamo, int cantDiasPrestados, LocalDateTime fechaDevolucion) {
        this.usuarioPrestamo   = usuarioPrestamo;
        this.libroPrestado     = libroPrestado;
        this.fechaPrestamo     = fechaPrestamo;
        this.cantDiasPrestados = cantDiasPrestados;
        this.fechaDevolucion   = fechaDevolucion;
    }

    public Usuario getUsuarioPrestamo() {
        return usuarioPrestamo;
    }

    public void setUsuarioPrestamo(Usuario usuarioPrestamo) {
        this.usuarioPrestamo = usuarioPrestamo;
    }

    public Libro getLibroPrestado() {
        return libroPrestado;
    }

    public void setLibroPrestado(Libro libroPrestado) {
        this.libroPrestado = libroPrestado;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public int getCantDiasPrestados() {
        return cantDiasPrestados;
    }

    public void setCantDiasPrestados(int cantDiasPrestados) {
        this.cantDiasPrestados = cantDiasPrestados;
    }

    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "biblioteca.Prestamo{" +
                "usuarioPrestamo=" + usuarioPrestamo +
                ", fechaPrestamo=" + fechaPrestamo +
                ", cantDiasPrestados=" + cantDiasPrestados +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }
}
