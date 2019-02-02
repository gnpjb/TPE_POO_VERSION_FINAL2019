package game.frontend;

import game.backend.CandyGame;
import game.backend.level.Level1;
import game.backend.level.Level2;
import game.backend.level.Level3;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Optional;

public class AppMenu extends MenuBar {

    public AppMenu() {
        Menu file = new Menu("Archivo");
        MenuItem exitMenuItem = new MenuItem("Salir");
        exitMenuItem.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Salir");
            alert.setHeaderText("Salir de la aplicación");
            alert.setContentText("¿Está seguro que desea salir de la aplicación?");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent()) {
                if (result.get() == ButtonType.OK) {
                    Platform.exit();
                }
            }
        });
        file.getItems().add(exitMenuItem);
        Menu help = new Menu("Ayuda");
        MenuItem aboutMenuItem = new MenuItem("Acerca De");
        aboutMenuItem.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Acerca De");
            alert.setHeaderText("Candy TPE");
            alert.setContentText("Cátedra POO 2018.\n" +
                    "Implementación Original: Laura Zabaleta (POO 2013).");
            alert.showAndWait();
        });
        help.getItems().add(aboutMenuItem);

        Menu level = new Menu("Nivel");
        MenuItem level1=new MenuItem("Nivel 1");
        level1.setOnAction(event->{
            Stage stage= (Stage) this.getScene().getWindow();
            CandyGame game = new CandyGame(Level1.class);
            CandyFrame frame = new CandyFrame(game);
            Scene scene = new Scene(frame);
            stage.setScene(scene);
        });
        MenuItem level2=new MenuItem("Nivel 2");
        level2.setOnAction(event->{
            Stage stage= (Stage) this.getScene().getWindow();
            CandyGame game = new CandyGame(Level2.class);
            CandyFrame frame = new CandyFrame(game);
            Scene scene = new Scene(frame);
            stage.setScene(scene);
        });
        MenuItem level3=new MenuItem("Nivel 3");
        level3.setOnAction(event->{
            Stage stage= (Stage) this.getScene().getWindow();
            CandyGame game = new CandyGame(Level3.class);
            CandyFrame frame = new CandyFrame(game);
            Scene scene = new Scene(frame);
            stage.setScene(scene);
        });
        level.getItems().addAll(level1,level2,level3);


        getMenus().addAll(file, help,level);
    }

}
