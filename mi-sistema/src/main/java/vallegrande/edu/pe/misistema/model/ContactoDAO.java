package vallegrande.edu.pe.misistema.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactoDAO {

    // Método SELECT para cargar la tabla
    public List<Contacto> listar() {
        List<Contacto> lista = new ArrayList<>();
        String sql = "SELECT * FROM contactos";

        try (Connection conn = Conexion.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Contacto c = new Contacto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getString("asunto"),
                        rs.getString("mensaje"),
                        rs.getString("estado")
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar contactos: " + e.getMessage());
        }
        return lista;
    }

    // Método INSERT para la Sesión 10
    public boolean insertar(Contacto c) {
        String sql = "INSERT INTO contactos (nombre, email, telefono, asunto, mensaje, estado) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getTelefono());
            stmt.setString(4, c.getAsunto());
            stmt.setString(5, c.getMensaje());
            stmt.setString(6, c.getEstado());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar contacto: " + e.getMessage());
            return false;
        }
    }
}