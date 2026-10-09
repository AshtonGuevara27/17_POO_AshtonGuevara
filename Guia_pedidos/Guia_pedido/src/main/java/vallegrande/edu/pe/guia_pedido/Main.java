package vallegrande.edu.pe.misistema;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vallegrande.edu.pe.misistema.controller.MainController;
import vallegrande.edu.pe.misistema.view.MainView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        MainView view = new MainView();
        MainController controller = new MainController(view);

        // Se mantiene el tamaño ideal de 900x600 que definiste
        Scene scene = new Scene(view, 900, 600);

        // Evita que la interfaz se rompa o colapse si arrastran la ventana para hacerla muy chica
        primaryStage.setMinWidth(850);
        primaryStage.setMinHeight(550);

        primaryStage.setTitle("Sistema de Gestión de Pedidos - Valle Grande");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
