package vallegrande.edu.pe.misistema.model;

public class Contacto {
    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private String asunto;
    private String mensaje;
    private String estado;

    // Constructor 1: Para cuando LEEMOS de la BD (incluye ID)
    public Contacto(int id, String nombre, String email, String telefono, String asunto, String mensaje, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.estado = estado;
    }

    // Constructor 2: Para cuando REGISTRAMOS un nuevo contacto (sin ID)
    public Contacto(String nombre, String email, String telefono, String asunto, String mensaje) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.estado = "pendiente";
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    public String getAsunto() { return asunto; }
    public String getMensaje() { return mensaje; }
    public String getEstado() { return estado; }
}