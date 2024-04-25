package biblioteca;

import libros.Libro;
import usuarios.Docente;
import usuarios.Estudiante;
import usuarios.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Biblioteca {

    private HashMap<String, Usuario> usuarios;
    private HashMap<Integer, Libro> libros;
    private HashMap<String, Prestamo> prestamos;

    public Biblioteca() {
        this.usuarios = new HashMap<String, Usuario>();
        this.libros = new HashMap<Integer, Libro>();
    }


   //public String prestarLibro(){
   public String prestarLibro(Integer isbn, Usuario usuario, int cantDiasPrestados){
        if(!existeLibro(isbn))
            return "El libro no existe";
        if(!estaDisponible(isbn))
            return "El libro no esta disponible";
        if(!existeUsuario(usuario.getRun()))
            return "El run no existe";
        if(!estaHabilitadoParaPrestamos(usuario.getRun()))
            return "El run no esta habilitado para prestamos";

        if(usuario instanceof Docente)
            if(cantDiasPrestados > 20)
                return "Supera el plazo maximo para Docentes de 20 dias";

        if(usuario instanceof Estudiante)
            if(cantDiasPrestados > 10)
                return "Supera el plazo maximo para Estudiantes de 10 dias";

        Date fechaPrestamo = new Date();
        LocalDate d1 = LocalDate.parse(fechaPrestamo.toString(), DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDateTime fechaDevolucion = LocalDateTime.from(fechaPrestamo.toInstant()).plusDays(cantDiasPrestados);

        usuarios.get(usuario.getRun()).setPrestamoISBN(isbn);
        libros.get(isbn).setCantDisponibleParaPrestar(libros.get(isbn).getCantDisponibleParaPrestar() - 1);
        prestamos.put(usuario.getRun().toUpperCase(), new Prestamo(usuario, libros.get(isbn), fechaPrestamo, cantDiasPrestados, fechaDevolucion));

        return "OK";
    }

    public String devolverLibro(Integer isbn, Usuario usuario ){
        if(!existeLibro(isbn))
            return "El libro no existe";
        if(!estaDisponible(isbn))
            return "El libro no esta disponible";
        if(!existeUsuario(usuario.getRun()))
            return "El run no existe";
        if(!estaHabilitadoParaPrestamos(usuario.getRun()))
            return "El run no esta habilitado para prestamos";

        if(usuario.getPrestamoISBN() ==isbn)
            return "el usuario tiene el libro";



        if(usuario.getPrestamoISBN() ==isbn) {
            return "OK";
        }
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();
        // Calcular la cantidad de días de retraso en la devolución
        long diasRetraso = ChronoUnit.DAYS.between(fechaDevolucion, fechaActual);


        if (diasRetraso > 0) {
            // Calcular el monto de la multa
            int multa = (int) (diasRetraso * 1000); // $1.000 por día de retraso

        }
        usuarios.get(usuario.getRun()).setPrestamoISBN(0);
        libros.get(isbn).setCantDisponibleParaPrestar(libros.get(isbn).getCantDisponibleParaPrestar() + 1);
        return multa;
    }

    public boolean estaHabilitadoParaPrestamos(String run){
        return usuarios.get(run.toUpperCase()).getPrestamoISBN() == 0;
    }


    public String crearLibro(int isbn, String titulo,String autor, String imagen, int cantidadDisponible, int cantidadPrestamo){
        String validacionLibro = validarLibro(isbn);
        if( validacionLibro == "OK"){
            libros.put(isbn, new Libro(isbn, titulo, autor, imagen, cantidadDisponible, cantidadPrestamo));
            return "Libro creado correctamente";
        }
        else
            return validacionLibro;
    }

    private String validarLibro(int isbn){
        if(existeLibro(isbn))
            return "El libro "+ isbn +" ya existe";
        if(!estaEnBiblioteca(isbn))
            return "El libro " + isbn + " no es esta en biblioteca";
        if(!estaDisponible(isbn))
            return "El libro " + isbn + " no es esta disponible";
        return "OK";
    }

    public boolean existeLibro(int isbn){
        return libros.get(isbn) != null;
    }

    //public boolean estaEnBiblioteca(int isbn){
     //   return libros.get(isbn).getCantDisponibleEnBiblioteca() > 0;
    //}

    public boolean estaEnBiblioteca(int isbn){
        Libro libro = libros.get(isbn);
        return libro != null && libro.getCantDisponibleEnBiblioteca() > 0;
    }


    public boolean estaDisponible(int isbn){
        return (libros.get(isbn).getCantDisponibleParaPrestar() > 0 && libros.get(isbn).getCantDisponibleParaPrestar() <= libros.get(isbn).getCantDisponibleEnBiblioteca());
    }

    public String eliminarLibro(int isbn){
        if(!existeLibro(isbn))
            return "No se ha podido eliminar el libro debido a que el isbn " + isbn + " no existe";
        libros.remove(isbn);
        return "Libro eliminado correctamente";
    }

    /**
     * Metodo sobrecargado para crear un usuario estudiante
     * */
    public String crearUsuario(String run, String nombre, String genero, String carrera, int prestamoISBN, String carreraEnCurso){
        String validacionUsuario = validarUsuario(run, genero);
        if( validacionUsuario == "OK"){
            usuarios.put(run.toUpperCase(), new Estudiante(run.toUpperCase(), nombre, genero, carrera, prestamoISBN, carreraEnCurso));
            return "Usuario registrado correctamente";
        }
        else
            return validacionUsuario;
    }

    /**
     * Metodo sobrecargado para crear un usuario docente
     * */
    public String crearUsuario(String run, String nombre, String genero, String carrera, int prestamoISBN, List<String> grados){
        String validacionUsuario = validarUsuario(run, genero);
        if( validacionUsuario == "OK"){
            usuarios.put(run.toUpperCase(), new Docente(run, nombre, genero, carrera, prestamoISBN, grados));
            return "Usuario registrado correctamente";
        }
        else
            return validacionUsuario;
    }

    private String validarUsuario(String run, String genero){
        String runUpper = run.toUpperCase();
        if(existeUsuario(runUpper))
            return "No se ha podido crear el usuario debido a que el run " + run + " ya se encuentra registrado";
        if(!esValidoRUN(runUpper))
            return "No se ha podido crear el usuario debido a que el run " + run + " no es valido";
        if(!esValidoGenero(genero))
            return "No se ha podido crear el usuario debido a que el genero " + genero + " no es valido";
        return "OK";
    }

    public String eliminarUsuario(String run){
        String runUpper = run.toUpperCase();
        if(existeUsuario(runUpper))
            return "No se ha podido eliminar el usuario debido a que el run " + run + " no existe";
        usuarios.remove(runUpper);
        return "Usuario eliminado correctamente";
    }

    public boolean existeUsuario(String run){
        return usuarios.get(run.toUpperCase()) != null;
    }

    public Usuario getUsuario(String run) {
        return usuarios.get(run.toUpperCase());
    }
    public boolean esValidoRUN(String run){
        boolean validacion = false;
        try {
            run = run.toUpperCase().replace(".", "").replace("-", "");
            int rutAux = Integer.parseInt(run.substring(0, run.length() - 1));
            char dv = run.charAt(run.length() - 1);
            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }
        } catch (Exception e) {
            System.out.println("Excepcion: " + e.getMessage());
        } finally {
          return validacion;
        }
    }

    public boolean esValidoGenero(String genero){
        boolean validacion = false;
        try {
            if(genero.equals("F") || genero.equals("M"))
                validacion = true;
        } catch (Exception e) {
            System.out.println("Excepcion: " + e.getMessage());
        } finally {
            return validacion;
        }
    }

    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }

}
