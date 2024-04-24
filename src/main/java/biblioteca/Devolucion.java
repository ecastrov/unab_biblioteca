package biblioteca;

import usuarios.Usuario;

import java.time.LocalDateTime;
import java.util.Date;

public class Devolucion {

    private Prestamo prestamo;
    private LocalDateTime fechaDevuelto;
    private int multa;

    public Devolucion(Prestamo prestamo, LocalDateTime fechaDevuelto) {
        this.prestamo = prestamo;
        this.fechaDevuelto = fechaDevuelto;
    }



    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public LocalDateTime getFechaDevuelto() {
        return fechaDevuelto;
    }

    public void setFechaDevuelto(LocalDateTime fechaDevuelto) {
        this.fechaDevuelto = fechaDevuelto;
    }

    public int getMulta() {
        return multa;
    }

    public void setMulta(int multa) {
        this.multa = multa;
    }
}
