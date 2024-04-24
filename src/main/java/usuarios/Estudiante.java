package usuarios;

public class Estudiante extends Usuario {

    private String carreraEnCurso;

    public Estudiante(String run, String nombre, String genero, String carrera, int prestamoISBN, String carreraEnCurso) {
        super(run, nombre, genero, carrera, prestamoISBN);
        this.carreraEnCurso = carreraEnCurso;
    }

    public String getCarreraEnCurso() {
        return carreraEnCurso;
    }

    public void setCarreraEnCurso(String carreraEnCurso) {
        this.carreraEnCurso = carreraEnCurso;
    }
}
