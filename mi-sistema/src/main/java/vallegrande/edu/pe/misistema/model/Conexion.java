package vallegrande.edu.pe.misistema.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Si tu puerto MySQL es el estándar 3306
    private static final String URL = "jdbc:mysql://localhost:3306/adam_db";

    // Pon aquí exactamente el usuario y la contraseña con la que abres MySQL Workbench
    private static final String USER = "root";
    private static final String PASSWORD = "root"; // Si no usas contraseña, déjalo como ""

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}