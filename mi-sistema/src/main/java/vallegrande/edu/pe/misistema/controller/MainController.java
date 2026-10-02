package vallegrande.edu.pe.misistema.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import vallegrande.edu.pe.misistema.model.Contacto;
import vallegrande.edu.pe.misistema.model.ContactoDAO;
import vallegrande.edu.pe.misistema.view.MainView;

public class MainController {

    private MainView view;
    private ContactoDAO dao;

    public MainController(MainView view) {
        this.view = view;
        this.dao = new ContactoDAO();

        // Conectar botones y eventos
        this.view.getBtnRegistrar().setOnAction(e -> registrarContacto());

        // Cargar datos iniciales desde MySQL
        cargarDatos();
    }

    private void cargarDatos() {
        ObservableList<Contacto> lista = FXCollections.observableArrayList(dao.listar());
        view.getTablaContactos().setItems(lista);
    }

    private void registrarContacto() {
        String nombre = view.getTxtNombre().getText();
        String email = view.getTxtEmail().getText();
        String telefono = view.getTxtTelefono().getText();
        String asunto = view.getTxtAsunto().getText();
        String mensaje = view.getTxtMensaje().getText();

        if (nombre.isEmpty() || email.isEmpty() || mensaje.isEmpty()) {
            mostrarAlerta("Campos vacíos", "Por favor completa el nombre, email y mensaje.");
            return;
        }

        Contacto nuevo = new Contacto(nombre, email, telefono, asunto, mensaje);

        if (dao.insertar(nuevo)) {
            view.limpiarCampos();
            cargarDatos(); // Actualiza la tabla
        } else {
            mostrarAlerta("Error", "No se pudo guardar el contacto en la base de datos.");
        }
    }

    private void mostrarAlerta(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}