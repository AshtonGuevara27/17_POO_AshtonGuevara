package vallegrande.edu.pe.miperfil.controller;

import vallegrande.edu.pe.miperfil.model.Perfil;
import vallegrande.edu.pe.miperfil.view.PerfilView;

public class PerfilController {

    private PerfilView view;

    public PerfilController(PerfilView view) {
        this.view = view;
        inicializar();
    }

    private void inicializar() {
        view.getBtnMostrar().setOnAction(e -> {
            String nombre = view.getTxtNombre().getText();
            String carrera = view.getTxtCarrera().getText();
            String semestre = view.getTxtSemestre().getText();
            String cursoFavorito = view.getTxtCursoFavorito().getText();

            Perfil perfil = new Perfil(nombre, carrera, semestre, cursoFavorito);
            view.getLblResultado().setText(perfil.obtenerPresentacion());
        });
    }
}