import biblioteca.Biblioteca;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        System.out.println("Administracion Biblioteca UNAB");

        Biblioteca biblioteca = new Biblioteca();
        String run, nombre, genero, carrera, carreraEnCurso, profesion;


        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Ingresar usuario Estudiante");
            System.out.println("2. Ingresar usuario Docente");
            System.out.println("3. Ingresar libro");
            System.out.println("4. Prestar libro");
            System.out.println("5. Devolver libro");
            System.out.println("6. ver  libro");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ingresarUsuarioEstudiante();
                    System.out.println(" ---Ingresar Usuario---\n");
                    System.out.print("Ingrese el RUN del usuario: ");
                    String rutUsu = scanner.next();
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsu = scanner.next();
                    System.out.print("Ingrese el género del usuario (M/F): ");
                    String generoUsu = scanner.next();
                    System.out.print("Ingrese la carrera del usuario: ");
                    String carreraUsu = scanner.next();
                    System.out.print("Ingrese la carrera en curso (Solo para estudiantes): ");
                    String carreraEnCursoUsu = scanner.next();
                    int prestamoISBNUsu=0;
                    //crearUsuario(String run, String nombre, String genero, String carrera, int prestamoISBN, String carreraEnCurso)
                    biblioteca.crearUsuario(rutUsu, nombreUsu, generoUsu, carreraUsu,prestamoISBNUsu, carreraEnCursoUsu);

                    break;

                case 2:
                    ingresarUsuarioDocente();

                    break;
                case 3:
                    ingresarLibro();
                    System.out.print(" ---Ingresar Libro ---\n\n");
                    System.out.print("Ingrese el ISBN del libro \n");
                    int isbn = scanner.nextInt();
                    System.out.print("Ingrese el titulo del libro \n");
                    String titulo =  scanner.next();
                    System.out.print("Ingrese el autor del libro \n");
                    String autor =  scanner.next();
                    System.out.print("Ingrese el link con la imagen \n");
                    String imagen =  scanner.next();
                    System.out.print("Ingrese cantidad disponible \n");
                    int cantidadDisponible = scanner.nextInt();
                    System.out.print("Ingrese cantidad para prestar\n");
                    int cantidadPrestamo = scanner.nextInt();
                    //int isbn, String titulo, String autor, String imagenLink, int cantDisponibleEnBiblioteca, int cantDisponibleParaPrestar
                    biblioteca.crearLibro(isbn, titulo, autor, imagen, cantidadDisponible, cantidadPrestamo);

                    break;
                case 4:
                    prestarLibro();

                    System.out.print(" ---PRESTAMO---\n\n");
                    System.out.print("Ingrese el ISBN del libro \n");
                    int isbnPrestamo = scanner.nextInt();
                    System.out.print("Ingrese el RUN del usuario: ");
                    String rutPrestamo = scanner.next();
                    System.out.print("Ingrese  cantidad dias de prestamo: ");
                    int cantidadDiasPrestamo = scanner.nextInt();
                    //public String prestarLibro(Integer isbn, Usuario usuario, int cantDiasPrestados)
                    biblioteca.prestarLibro(isbnPrestamo, biblioteca.getUsuario(rutPrestamo), cantidadDiasPrestamo);




                    break;
                case 5:
                    devolverLibro();
                    System.out.print(" ---DEVOLVER LIBRO---\n\n");
                    System.out.print("Ingrese el ISBN del libro \n");
                    int isbnDevolucion = scanner.nextInt();
                    System.out.print("Ingrese el RUN del usuario: ");
                    String rutDevolucion = scanner.next();
                    //System.out.print("Ingrese  cantidad dias de prestamo: ");
                    //int cantidadDiasPrestamo = scanner.nextInt();
                    //public String prestarLibro(Integer isbn, Usuario usuario, int cantDiasPrestados)
                    biblioteca.devolverLibro(isbnDevolucion, rutDevolucion);


                    break;
                case 6:
                    listarLibro();
                    System.out.print(" ---el  Libro creado es  ---\n\n");

                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    public static void ingresarUsuarioDocente() {
        // Lógica para ingresar un usuario
        System.out.println("Ingresando usuario...");
    }
    public static void ingresarUsuarioEstudiante() {
        // Lógica para ingresar un usuario
        System.out.println("Ingresando usuario...");
    }
    public static void ingresarLibro() {
        // Lógica para ingresar un libro
        System.out.println("Ingresando libro...");
    }

    public static void prestarLibro() {
        // Lógica para prestar un libro
        System.out.println("Prestando libro...");
    }

    public static void devolverLibro() {
        // Lógica para devolver un libro
        System.out.println("Devolviendo libro...");
    }
    public static void listarLibro() {
        // Lógica para listar un libro
        System.out.println("libro creado");
    }
}

