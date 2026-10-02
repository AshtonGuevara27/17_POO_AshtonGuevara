package vallegrande.edu.pe.misistema.view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import vallegrande.edu.pe.misistema.model.Contacto;

public class MainView extends VBox {

    private TextField txtNombre = new TextField();
    private TextField txtEmail = new TextField();
    private TextField txtTelefono = new TextField();
    private TextField txtAsunto = new TextField();
    private TextArea txtMensaje = new TextArea();
    private Button btnRegistrar = new Button("Registrar Contacto");

    private TableView<Contacto> tablaContactos = new TableView<>();

    public MainView() {
        this.setSpacing(10);
        this.setPadding(new Insets(15));

        Label title = new Label("Registro de Contactos ADAM");
        title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("Nombre:"), 0, 0);
        grid.add(txtNombre, 1, 0);

        grid.add(new Label("Email:"), 2, 0);
        grid.add(txtEmail, 3, 0);

        grid.add(new Label("Teléfono:"), 0, 1);
        grid.add(txtTelefono, 1, 1);

        grid.add(new Label("Asunto:"), 2, 1);
        grid.add(txtAsunto, 3, 1);

        grid.add(new Label("Mensaje:"), 0, 2);
        txtMensaje.setPrefRowCount(2);
        grid.add(txtMensaje, 1, 2, 3, 1);

        btnRegistrar.setStyle("-fx-background-color: #2563eb; -fx-text-fill: white; -fx-font-weight: bold;");

        // Configuración de las columnas de la tabla
        TableColumn<Contacto, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colId.setPrefWidth(40);

        TableColumn<Contacto, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colNombre.setPrefWidth(120);

        TableColumn<Contacto, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colEmail.setPrefWidth(150);

        TableColumn<Contacto, String> colTelefono = new TableColumn<>("Teléfono");
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colTelefono.setPrefWidth(90);

        TableColumn<Contacto, String> colAsunto = new TableColumn<>("Asunto");
        colAsunto.setCellValueFactory(new PropertyValueFactory<>("asunto"));
        colAsunto.setPrefWidth(120);

        TableColumn<Contacto, String> colEstado = new TableColumn<>("Estado");
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colEstado.setPrefWidth(80);

        tablaContactos.getColumns().addAll(colId, colNombre, colEmail, colTelefono, colAsunto, colEstado);

        this.getChildren().addAll(title, grid, btnRegistrar, tablaContactos);
    }

    public void limpiarCampos() {
        txtNombre.clear();
        txtEmail.clear();
        txtTelefono.clear();
        txtAsunto.clear();
        txtMensaje.clear();
    }

    // Getters para el Controller
    public TextField getTxtNombre() { return txtNombre; }
    public TextField getTxtEmail() { return txtEmail; }
    public TextField getTxtTelefono() { return txtTelefono; }
    public TextField getTxtAsunto() { return txtAsunto; }
    public TextArea getTxtMensaje() { return txtMensaje; }
    public Button getBtnRegistrar() { return btnRegistrar; }
    public TableView<Contacto> getTablaContactos() { return tablaContactos; }
}