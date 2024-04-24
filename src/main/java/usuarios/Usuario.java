package usuarios;

public abstract class Usuario {

    private String run;
    private String nombre;
    private String genero;
    private String carrera;
    private int prestamoISBN;

    public Usuario(String run, String nombre, String genero, String carrera, int prestamoISBN) {
        this.run = run;
        this.nombre = nombre;
        this.genero = genero;
        this.carrera = carrera;
        this.prestamoISBN = prestamoISBN;
    }

    public String getRun() {
        return run.toUpperCase();
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getPrestamoISBN() {
        return prestamoISBN;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setPrestamoISBN(int prestamoISBN) {
        this.prestamoISBN = prestamoISBN;
    }

}
