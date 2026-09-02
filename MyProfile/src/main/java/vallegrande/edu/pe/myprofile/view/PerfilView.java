package vallegrande.edu.pe.miperfil.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PerfilView extends VBox {

    private TextField txtNombre;
    private TextField txtCarrera;
    private TextField txtSemestre;
    private TextField txtCursoFavorito;
    private Button btnMostrar;
    private Label lblResultado;

    public PerfilView() {
        Label titulo = new Label("MI PERFIL");
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        titulo.setStyle("-fx-text-fill: white;");

        txtNombre = crearCampo("Nombre completo");
        txtCarrera = crearCampo("Carrera profesional");
        txtSemestre = crearCampo("Semestre académico");
        txtCursoFavorito = crearCampo("Curso favorito");

        btnMostrar = new Button("Mostrar Perfil");
        btnMostrar.setStyle(
                "-fx-background-color: #3b82f6;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 8 20 8 20;" +
                        "-fx-background-radius: 6;"
        );

        lblResultado = new Label();
        lblResultado.setWrapText(true);
        lblResultado.setStyle(
                "-fx-text-fill: #d1d5db;" +
                        "-fx-background-color: #1f2937;" +
                        "-fx-padding: 12;" +
                        "-fx-background-radius: 6;"
        );

        this.setSpacing(12);
        this.setPadding(new Insets(25));
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: #111827;");
        this.getChildren().addAll(titulo, txtNombre, txtCarrera, txtSemestre, txtCursoFavorito, btnMostrar, lblResultado);
    }

    private TextField crearCampo(String placeholder) {
        TextField campo = new TextField();
        campo.setPromptText(placeholder);
        campo.setStyle(
                "-fx-background-color: #1f2937;" +
                        "-fx-text-fill: white;" +
                        "-fx-prompt-text-fill: #9ca3af;" +
                        "-fx-padding: 8;" +
                        "-fx-background-radius: 6;" +
                        "-fx-border-color: #374151;" +
                        "-fx-border-radius: 6;"
        );
        return campo;
    }

    public VBox getContenedor() {
        return this;
    }

    public TextField getTxtNombre() {
        return txtNombre;
    }

    public TextField getTxtCarrera() {
        return txtCarrera;
    }

    public TextField getTxtSemestre() {
        return txtSemestre;
    }

    public TextField getTxtCursoFavorito() {
        return txtCursoFavorito;
    }

    public Button getBtnMostrar() {
        return btnMostrar;
    }

    public Label getLblResultado() {
        return lblResultado;
    }
}