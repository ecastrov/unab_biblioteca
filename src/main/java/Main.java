import biblioteca.Biblioteca;

public class Main {
    public static void main(String[] args){
        System.out.println("Administracion biblioteca.Biblioteca UNAB");

        Biblioteca biblioteca = new Biblioteca();
        String run, nombre, genero, carrera, carreraEnCurso, profesion;

        run = "18698757-0";
        System.out.println("Existe el usuario con RUN " + run + "?: " + biblioteca.existeUsuario(run));
        System.out.println("Es valido el RUN " + run + "?: " + biblioteca.esValidoRUN(run));

        nombre = "Eliseo Castro";
        genero = "M";
        carrera = "Ingenieria en Computacion e Informatica";
        carreraEnCurso = "Ingenieria en Computacion e Informatica";
        System.out.println(biblioteca.crearUsuario(run, nombre, genero, carrera, 0, carreraEnCurso));

        System.out.println("Existe el usuario con RUN " + run + "?: " + biblioteca.existeUsuario(run));
        System.out.println("Usuario RUN " + run + ": " + biblioteca.getUsuarios().get(run));


        nombre = "Claudio Moreno";
        genero = "M";
        carrera = "Ingenieria en Computacion e Informatica";
        carreraEnCurso = "Ingenieria en Computacion e Informatica";
        System.out.println(biblioteca.crearUsuario(run, nombre, genero, carrera, 0, carreraEnCurso));
        System.out.println("Usuario RUN " + run + ": " + biblioteca.getUsuarios().get(run));

    }
}
