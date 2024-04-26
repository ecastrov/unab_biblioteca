package biblioteca;

import java.time.Duration;
import java.time.LocalDate;

public class Devolucion {

    private Prestamo prestamo;
    private LocalDate fechaDevuelto;
    private int      multa;

    public Devolucion(Prestamo prestamo, LocalDate fechaDevuelto) {
        this.prestamo = prestamo;
        this.fechaDevuelto = fechaDevuelto;
    }

    public long calcularMulta(){
        long diferenciaDias = Duration.between(prestamo.getFechaDevolucion(), fechaDevuelto).toDays();
        return diferenciaDias * Long.valueOf(1000);
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public LocalDate getFechaDevuelto() {
        return fechaDevuelto;
    }

    public void setFechaDevuelto(LocalDate fechaDevuelto) {
        this.fechaDevuelto = fechaDevuelto;
    }

    public int getMulta() {
        return multa;
    }

    public void setMulta(int multa) {
        this.multa = multa;
    }
}
