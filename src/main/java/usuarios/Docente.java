package usuarios;

import java.util.List;

public class Docente extends Usuario {

    private List<String> grados;

    public Docente(String run, String nombre, String genero, String carrera, int prestamoISBN, List<String> grados) {
        super(run, nombre, genero, carrera, prestamoISBN);
        this.grados = grados;
    }


    public List<String> getGrados() {
        return grados;
    }


    public void setGrados(List<String> grados) {
        this.grados = grados;
    }
}
