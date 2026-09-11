package vallegrande.edu.pe.misistema.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainView extends BorderPane {
    private Button btnInicio;
    private Button btnUsuarios;
    private Button btnProductos;
    private Button btnReportes;
    private Button btnConfiguracion;
    private Button btnCitas;

    public MainView(){
        setStyle("-fx-background-color: #0D1117;");
        crearMenu();
        mostrarInicio();
    }

    private void crearMenu(){
        VBox menu = new VBox(12);
        menu.setPadding(new Insets(25));
        menu.setPrefWidth(230);
        Label titulo = new Label("🖥️ MI SISTEMA");
        titulo.setStyle(
                "-fx-font-size: 20px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #E6EDF3;"
        );
        VBox tituloBox = new VBox(titulo);
        tituloBox.setPadding(new Insets(0, 0, 15, 0));

        btnInicio = crearBoton("🏠  Inicio");
        btnUsuarios = crearBoton("👤  Usuarios");
        btnProductos = crearBoton("📦  Productos");
        btnReportes = crearBoton("📊  Reportes");
        btnConfiguracion = crearBoton("⚙️  Configuración");
        btnCitas = crearBoton("📅  Citas");

        menu.getChildren().addAll(
                tituloBox,
                btnInicio,
                btnUsuarios,
                btnProductos,
                btnReportes,
                btnConfiguracion,
                btnCitas
        );
        menu.setStyle(
                "-fx-background-color: #161B22;" +
                        "-fx-border-color: #21262D;" +
                        "-fx-border-width: 0 1 0 0;"
        );
        setLeft(menu);
    }

    private Button crearBoton(String texto){
        Button boton = new Button(texto);
        boton.setPrefWidth(180);
        boton.setPrefHeight(42);
        boton.setAlignment(Pos.CENTER_LEFT);
        boton.setStyle(estiloBotonNormal());
        boton.setOnMouseEntered(e -> boton.setStyle(estiloBotonHover()));
        boton.setOnMouseExited(e -> boton.setStyle(estiloBotonNormal()));
        return boton;
    }

    private String estiloBotonNormal(){
        return "-fx-background-color: #1C2128;" +
                "-fx-text-fill: #C9D1D9;" +
                "-fx-font-size: 14px;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;" +
                "-fx-padding: 0 0 0 14;";
    }

    private String estiloBotonHover(){
        return "-fx-background-color: #6E40C9;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;" +
                "-fx-padding: 0 0 0 14;";
    }

    public void mostrarInicio(){
        VBox contenido = new VBox(10);
        contenido.setAlignment(Pos.CENTER);
        contenido.setStyle("-fx-background-color: #0D1117;");
        Label titulo = new Label("BIENVENIDO");
        titulo.setStyle("-fx-font-size: 30px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #E6EDF3;");
        Label texto = new Label("Panel principal de mi sistema");
        texto.setStyle("-fx-text-fill: #8B949E; -fx-font-size: 14px;");
        contenido.getChildren().addAll(titulo, texto);
        setCenter(contenido);
    }

    public void mostrarUsuarios(){
        VBox contenido = contenedorBase("USUARIOS");
        HBox tarjetas = new HBox(15);
        tarjetas.getChildren().addAll(
                crearTarjeta("Carlos Perez", "Administrador", "#3FB950"),
                crearTarjeta("Maria Lopez", "Vendedora", "#58A6FF"),
                crearTarjeta("Piero Ramos", "Supervisor", "#D29922")
        );
        contenido.getChildren().add(tarjetas);
        setCenter(contenido);
    }

    public void mostrarProductos(){
        VBox contenido = contenedorBase("PRODUCTOS");
        HBox tarjetas = new HBox(15);
        tarjetas.getChildren().addAll(
                crearTarjeta("Laptop Lenovo", "S/ 2500", "#58A6FF"),
                crearTarjeta("Mouse Logitech", "S/ 80", "#58A6FF"),
                crearTarjeta("Teclado Mecánico", "S/ 180", "#58A6FF")
        );
        contenido.getChildren().add(tarjetas);
        setCenter(contenido);
    }

    public void mostrarReportes(){
        VBox contenido = contenedorBase("REPORTES");
        HBox tarjetas = new HBox(15);
        tarjetas.getChildren().addAll(
                crearTarjeta("Reporte de Ventas", "Mes actual", "#F778BA"),
                crearTarjeta("Productos Registrados", "45 items", "#F778BA"),
                crearTarjeta("Usuarios Activos", "12 conectados", "#F778BA")
        );
        contenido.getChildren().add(tarjetas);
        setCenter(contenido);
    }

    public void mostrarConfiguracion(){
        VBox contenido = contenedorBase("CONFIGURACIÓN");
        HBox tarjetas = new HBox(15);
        tarjetas.getChildren().addAll(
                crearTarjeta("Perfil", "Editar datos de cuenta", "#D29922"),
                crearTarjeta("Seguridad", "Cambiar contraseña", "#D29922"),
                crearTarjeta("Notificaciones", "Activadas", "#D29922")
        );
        contenido.getChildren().add(tarjetas);
        setCenter(contenido);
    }

    public void mostrarCitas(){
        VBox contenido = contenedorBase("CITAS");
        HBox tarjetas = new HBox(15);
        tarjetas.getChildren().addAll(
                crearTarjeta("Cita con Cliente A", "10:00 am", "#3FB950"),
                crearTarjeta("Reunión de Ventas", "2:00 pm", "#3FB950"),
                crearTarjeta("Cita con Proveedor", "4:30 pm", "#3FB950")
        );
        contenido.getChildren().add(tarjetas);
        setCenter(contenido);
    }

    private VBox contenedorBase(String tituloTexto){
        VBox contenido = new VBox(20);
        contenido.setPadding(new Insets(30));
        contenido.setStyle("-fx-background-color: #0D1117;");
        Label titulo = new Label(tituloTexto);
        titulo.setStyle("-fx-font-size: 26px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #E6EDF3;");
        contenido.getChildren().add(titulo);
        return contenido;
    }

    private HBox crearTarjeta(String titulo, String detalle, String colorAcento){
        // Franja lateral recta (sin curvatura), separada del fondo redondeado
        javafx.scene.layout.Region franja = new javafx.scene.layout.Region();
        franja.setPrefWidth(4);
        franja.setMinWidth(4);
        franja.setStyle("-fx-background-color: " + colorAcento + ";");

        VBox textos = new VBox(6);
        textos.setPadding(new Insets(20, 20, 20, 16));
        textos.setPrefWidth(186);
        Label nombre = new Label(titulo);
        nombre.setStyle("-fx-font-size: 15px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #E6EDF3;");
        Label info = new Label(detalle);
        info.setStyle("-fx-text-fill: #8B949E; -fx-font-size: 13px;");
        textos.getChildren().addAll(nombre, info);

        HBox tarjeta = new HBox(franja, textos);
        tarjeta.setStyle(
                "-fx-background-color: #161B22;" +
                        "-fx-background-radius: 8;"
        );
        tarjeta.setPrefWidth(190);
        return tarjeta;
    }

    public Button getBtnInicio(){ return btnInicio; }
    public Button getBtnUsuarios(){ return btnUsuarios; }
    public Button getBtnProductos(){ return btnProductos; }
    public Button getBtnReportes(){ return btnReportes; }
    public Button getBtnConfiguracion(){ return btnConfiguracion; }
    public Button getBtnCitas(){ return btnCitas; }
}