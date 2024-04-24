package libros;

public class Libro {

    private int isbn;
    private String titulo;
    private String autor;
    private String imagenLink;
    private int cantDisponibleEnBiblioteca;
    private int cantDisponibleParaPrestar;

    public Libro(int isbn, String titulo, String autor, String imagenLink, int cantDisponibleEnBiblioteca, int cantDisponibleParaPrestar) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.imagenLink = imagenLink;
        this.cantDisponibleEnBiblioteca = cantDisponibleEnBiblioteca;
        this.cantDisponibleParaPrestar = cantDisponibleParaPrestar;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getImagenLink() {
        return imagenLink;
    }

    public int getCantDisponibleEnBiblioteca() {
        return cantDisponibleEnBiblioteca;
    }

    public int getCantDisponibleParaPrestar() {
        return cantDisponibleParaPrestar;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setImagenLink(String imagenLink) {
        this.imagenLink = imagenLink;
    }

    public void setCantDisponibleEnBiblioteca(int cantDisponibleEnBiblioteca) {
        this.cantDisponibleEnBiblioteca = cantDisponibleEnBiblioteca;
    }

    public void setCantDisponibleParaPrestar(int cantDisponibleParaPrestar) {
        this.cantDisponibleParaPrestar = cantDisponibleParaPrestar;
    }
}
