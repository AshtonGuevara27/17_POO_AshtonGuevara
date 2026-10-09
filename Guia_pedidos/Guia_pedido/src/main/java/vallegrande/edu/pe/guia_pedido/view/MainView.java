package vallegrande.edu.pe.misistema.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import vallegrande.edu.pe.misistema.model.Pedido;

public class MainView extends VBox {

    private TextField txtCliente;
    private TextField txtProducto;
    private TextField txtCantidad;
    private ComboBox<String> cbEstado;

    private Button btnRegistrar;
    private Button btnActualizar;
    private Button btnEliminar;

    private TableView<Pedido> tablePedidos;
    private TableColumn<Pedido, Integer> colId;
    private TableColumn<Pedido, String> colCliente;
    private TableColumn<Pedido, String> colProducto;
    private TableColumn<Pedido, Integer> colCantidad;
    private TableColumn<Pedido, String> colEstado;

    public MainView() {
        setSpacing(20);
        setPadding(new Insets(25));
        // Fondo general gris ultra suave moderno
        setStyle("-fx-background-color: #f1f5f9;");

        // 1. Cabecera estilo Dashboard
        VBox headerBox = new VBox(4);
        Label lblTitulo = new Label("Sistema de Gestión de Pedidos");
        lblTitulo.setStyle("-fx-font-size: 20pt; -fx-font-weight: bold; -fx-text-fill: #0f172a; -fx-font-family: 'Segoe UI', Arial;");
        Label lblSubtitulo = new Label("Administra y haz seguimiento de tus órdenes en tiempo real.");
        lblSubtitulo.setStyle("-fx-font-size: 10pt; -fx-text-fill: #64748b; -fx-font-family: 'Segoe UI', Arial;");
        headerBox.getChildren().addAll(lblTitulo, lblSubtitulo);

        // 2. Panel del Formulario (Tarjeta Blanca Contenedora)
        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setPadding(new Insets(20));
        // Estilo de tarjeta con bordes redondeados y sombra sutil
        grid.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 10; -fx-border-radius: 10; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.05), 10, 0, 0, 4);");
        grid.setAlignment(Pos.CENTER_LEFT);

        // Estilos para Labels del formulario
        String labelStyle = "-fx-font-size: 10pt; -fx-font-weight: bold; -fx-text-fill: #475569; -fx-font-family: 'Segoe UI';";

        Label lblCliente = new Label("Cliente:");
        lblCliente.setStyle(labelStyle);
        txtCliente = new TextField();
        txtCliente.setPromptText("Ej. Juan Pérez");
        configurarInput(txtCliente);

        Label lblProducto = new Label("Producto:");
        lblProducto.setStyle(labelStyle);
        txtProducto = new TextField();
        txtProducto.setPromptText("Ej. Café Orgánico");
        configurarInput(txtProducto);

        Label lblCantidad = new Label("Cantidad:");
        lblCantidad.setStyle(labelStyle);
        txtCantidad = new TextField();
        txtCantidad.setPromptText("Ej. 10");
        configurarInput(txtCantidad);

        Label lblEstado = new Label("Estado:");
        lblEstado.setStyle(labelStyle);
        cbEstado = new ComboBox<>();
        cbEstado.getItems().addAll("Pendiente", "En proceso", "Entregado");
        cbEstado.getSelectionModel().selectFirst();
        cbEstado.setStyle("-fx-background-color: #ffffff; -fx-border-color: #cbd5e1; -fx-border-radius: 6; "
                + "-fx-background-radius: 6; -fx-padding: 3 8 3 8; -fx-font-size: 10pt;");
        cbEstado.setPrefWidth(180);

        // Distribución en el Grid
        grid.add(lblCliente, 0, 0);
        grid.add(txtCliente, 1, 0);
        grid.add(lblProducto, 2, 0);
        grid.add(txtProducto, 3, 0);

        grid.add(lblCantidad, 0, 1);
        grid.add(txtCantidad, 1, 1);
        grid.add(lblEstado, 2, 1);
        grid.add(cbEstado, 3, 1);

        // 3. Botones de Acción Estilizados con Efecto Hover
        btnRegistrar = new Button("Registrar Pedido");
        estilizarBoton(btnRegistrar, "#0284c7", "#0369a1"); // Azul Corporativo

        btnActualizar = new Button("Actualizar");
        estilizarBoton(btnActualizar, "#0d9488", "#0f766e"); // Verde Teal

        btnEliminar = new Button("Eliminar");
        estilizarBoton(btnEliminar, "#e11d48", "#be123c"); // Rojo Carmín

        HBox boxBotones = new HBox(12, btnRegistrar, btnActualizar, btnEliminar);
        boxBotones.setAlignment(Pos.CENTER_LEFT);

        // 4. Tabla de Datos Avanzada
        tablePedidos = new TableView<>();
        // Estilo moderno para la tabla, eliminando bordes internos toscos
        tablePedidos.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 8; -fx-border-radius: 8; "
                + "-fx-border-color: #e2e8f0; -fx-padding: 5;");

        colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colId.setPrefWidth(60);

        colCliente = new TableColumn<>("Cliente");
        colCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colCliente.setPrefWidth(200);

        colProducto = new TableColumn<>("Producto");
        colProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));
        colProducto.setPrefWidth(200);

        colCantidad = new TableColumn<>("Cantidad");
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        colCantidad.setPrefWidth(100);

        colEstado = new TableColumn<>("Estado");
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colEstado.setPrefWidth(140);

        tablePedidos.getColumns().addAll(colId, colCliente, colProducto, colCantidad, colEstado);
        tablePedidos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setVgrow(tablePedidos, Priority.ALWAYS); // Hace que la tabla se expanda hacia abajo de forma elástica

        // Agregar todos los elementos ordenados al contenedor VBox principal
        getChildren().addAll(headerBox, grid, boxBotones, tablePedidos);
    }

    // Método utilitario para que todos los campos de texto luzcan idénticos y limpios
    private void configurarInput(TextField input) {
        input.setStyle("-fx-background-color: #ffffff; -fx-border-color: #cbd5e1; -fx-border-radius: 6; "
                + "-fx-background-radius: 6; -fx-padding: 7 12 7 12; -fx-font-size: 10pt;");
        input.setPrefWidth(180);

        // Efecto visual: cambiar borde a azul cuando el usuario hace clic para escribir
        input.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                input.setStyle("-fx-background-color: #ffffff; -fx-border-color: #3b82f6; -fx-border-radius: 6; -fx-background-radius: 6; -fx-padding: 7 12 7 12; -fx-font-size: 10pt; -fx-effect: dropshadow(three-pass-box, rgba(59,130,246,0.15), 5, 0, 0, 0);");
            } else {
                input.setStyle("-fx-background-color: #ffffff; -fx-border-color: #cbd5e1; -fx-border-radius: 6; -fx-background-radius: 6; -fx-padding: 7 12 7 12; -fx-font-size: 10pt;");
            }
        });
    }

    // Método utilitario para aplicar colores, fuentes y animaciones hover a los botones
    private void estilizarBoton(Button boton, String colorHex, String colorHoverHex) {
        String estiloBase = "-fx-background-color: " + colorHex + "; -fx-text-fill: white; -fx-font-weight: bold; "
                + "-fx-font-size: 10pt; -fx-padding: 9 18 9 18; -fx-background-radius: 6; -fx-cursor: hand; -fx-font-family: 'Segoe UI';";
        String estiloHover = "-fx-background-color: " + colorHoverHex + "; -fx-text-fill: white; -fx-font-weight: bold; "
                + "-fx-font-size: 10pt; -fx-padding: 9 18 9 18; -fx-background-radius: 6; -fx-cursor: hand; -fx-font-family: 'Segoe UI';";

        boton.setStyle(estiloBase);

        // Detectar entrada y salida del puntero del mouse
        boton.setOnMouseEntered(e -> boton.setStyle(estiloHover));
        boton.setOnMouseExited(e -> boton.setStyle(estiloBase));
    }

    // Getters intactos para que tu MainController siga funcionando perfectamente
    public TextField getTxtCliente() { return txtCliente; }
    public TextField getTxtProducto() { return txtProducto; }
    public TextField getTxtCantidad() { return txtCantidad; }
    public ComboBox<String> getCbEstado() { return cbEstado; }
    public Button getBtnRegistrar() { return btnRegistrar; }
    public Button getBtnActualizar() { return btnActualizar; }
    public Button getBtnEliminar() { return btnEliminar; }
    public TableView<Pedido> getTablePedidos() { return tablePedidos; }
}
