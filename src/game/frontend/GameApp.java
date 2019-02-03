package game.frontend;

import game.backend.CandyGame;
import game.backend.Grid;
import game.backend.element.Candy;
import game.backend.level.Level1;
import game.backend.level.Level2;
import game.backend.level.Level3;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		//crea un vbox
		VBox vbox = new VBox();

		//crea 3 botones(uno para cada level)
		Button level1=new Button("Level 1");
		Button level2=new Button("Level 2");
		Button level3=new Button("Level 3");


		//setea la accion que sucede al tocar
		level1.setOnAction(e->{
			//borra los contenidos del vbox
			//esto es para evitar excepciones por el menubar
			vbox.getChildren().clear();
			//crea un nuevo juego, candyfram y scene con
			//el level correcto y lo setea en el primarystage
			CandyGame game = new CandyGame(Level1.class);
			CandyFrame frame = new CandyFrame(game);
			Scene scene = new Scene(frame);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		});

		level2.setOnAction(e->{
			vbox.getChildren().clear();
			CandyGame game = new CandyGame(Level2.class);
			CandyFrame frame = new CandyFrame(game);
			Scene scene = new Scene(frame);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		});

		level3.setOnAction(e->{
			vbox.getChildren().clear();
			CandyGame game = new CandyGame(Level3.class);
			CandyFrame frame = new CandyFrame(game);
			Scene scene = new Scene(frame);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		});

		//aplica css style a todos los botones
		Group buttonGroup = new Group(level1,level2,level3);
		for(Node n: buttonGroup.getChildren()){
			n.setStyle("-fx-background-color:Yellow;-fx-border-radius:2px;" +
					"-fx-font-size:40px;");
		}

		//setea el color de fondo a rosa
		vbox.setBackground(new Background(new BackgroundFill(Color.PINK,null,null)));
		//alinea por el centro
		vbox.setAlignment(Pos.TOP_CENTER);
		//setea el tamaño minino a algo aproximado a lo que sera el nivel
		vbox.setMinSize(Grid.SIZE* CandyFrame.CELL_SIZE,Grid.SIZE* CandyFrame.CELL_SIZE);
		//setea el espacio entre los elementos
		vbox.setSpacing(70);
		//agrega el appemenu y luego los botones
		vbox.getChildren().add(new AppMenu());
		vbox.getChildren().addAll(buttonGroup.getChildren());
		//setea el scene y lo muestra
		Scene scene = new Scene(vbox);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
