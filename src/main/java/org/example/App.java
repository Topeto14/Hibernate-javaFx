package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entities.CategoriaJuego;
import org.example.entities.Juego;
import org.example.entities.PlataformaJuego;
import org.example.repository.RepositorioJuego;

import java.io.IOException;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Opción 2: utilizando plantillas FXML (Recomendable)
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960, 690);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() throws Exception {
        System.out.println("init() method: " + Thread.currentThread().getName());
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop() method: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Juego Mario = new Juego ("Super Mario", 1, PlataformaJuego.OTHER, CategoriaJuego.PVP);
        Juego Mario2 = new Juego ("Super Mario 2", 2, PlataformaJuego.OTHER, CategoriaJuego.PVP);
        Juego Mario3 = new Juego ("Super Mario 3", 3, PlataformaJuego.OTHER, CategoriaJuego.PVP);
        Juego CounterStrike = new Juego ("Counter Strike", 4, PlataformaJuego.STEAM, CategoriaJuego.PVP);
        Juego Fortnite = new Juego ("Fortnite", 5, PlataformaJuego.STEAM, CategoriaJuego.PVP);
        Juego Minecraft = new Juego ("Minecraft", 6, PlataformaJuego.STEAM, CategoriaJuego.PVP);
        Juego CallOfDuty = new Juego ("Call of Duty", 7, PlataformaJuego.PLAYSTATION, CategoriaJuego.PVP);
        Juego Dota2 = new Juego ("Dota 2", 8, PlataformaJuego.PLAYSTATION, CategoriaJuego.PVP);
        Juego LeagueOfLegends = new Juego ("League of Legends", 9, PlataformaJuego.OTHER, CategoriaJuego.PVP);
        Juego Fifa = new Juego ("FIFA", 10, PlataformaJuego.OTHER, CategoriaJuego.PVP);
        RepositorioJuego repo = new RepositorioJuego();
        repo.save(Mario);
        repo.save(Mario2);
        repo.save(Mario3);
        repo.save(CounterStrike);
        repo.save(Fortnite);
        repo.save(Minecraft);
        repo.save(CallOfDuty);
        repo.save(Dota2);
        repo.save(LeagueOfLegends);
        repo.closeSession();
        launch();

    }
}