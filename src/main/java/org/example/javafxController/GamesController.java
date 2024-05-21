package org.example.javafxController;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.entities.Juego;
import org.example.repository.RepositorioJuego;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GamesController implements Initializable { /* Para inicializar la estructura de la ventana */
    @FXML
    private TableView<Juego> juegoTabla;

    @FXML
    public TableColumn<Juego, Long> juegoId;

    @FXML
    public TableColumn<Juego, String> juegoNombre;

    @FXML
    public TableColumn<Juego, Integer> juegoPegi;

    @FXML
    private TableColumn<Juego, String> juegoPlataforma;

    @FXML
    private TableColumn<Juego, String> juegoCategoria;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { /* Inicializa la estructura de la ventana */
        juegoId.setCellValueFactory(new PropertyValueFactory<>("id")); /* Crea la columna de id */
        juegoNombre.setCellValueFactory(new PropertyValueFactory<>("nombre")); /* Crea la columna de nombre */
        juegoPegi.setCellValueFactory(new PropertyValueFactory<>("pegi")); /* Crea la columna de pegi */
        juegoPlataforma.setCellValueFactory(new PropertyValueFactory<>("plataforma")); /* Crea la columna de plataforma */
        juegoCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria")); /* Crea la columna de categoria */

        RepositorioJuego repo = new RepositorioJuego();                                 /* Crea el repositorio */
        List<Juego> juegos = repo.findAll();                                 /* Obtiene todos los juegos del repositorio */
        juegoTabla.setItems(FXCollections.observableArrayList(juegos));     /* Carga el listado de juegos en la tabla */
    }
}
