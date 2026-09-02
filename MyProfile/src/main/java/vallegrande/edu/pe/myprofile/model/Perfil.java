package vallegrande.edu.pe.miperfil.model;

public class Perfil {
    private String nombre;
    private String carrera;
    private String semestre;
    private String cursoFavorito;

    public Perfil(String nombre, String carrera, String semestre, String cursoFavorito) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.semestre = semestre;
        this.cursoFavorito = cursoFavorito;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getCursoFavorito() {
        return cursoFavorito;
    }

    public String obtenerPresentacion() {
        return "Hola, soy " + nombre + ", estudio " + carrera + ", estoy en el semestre " + semestre
                + " y mi curso favorito es " + cursoFavorito + ".";
    }
}