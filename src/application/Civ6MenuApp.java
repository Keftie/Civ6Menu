package application;

import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Pair;

public class Civ6MenuApp extends Application {

	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	
	private List<Pair<String, Runnable>> menuData = Arrays.asList(
			new Pair<String, Runnable>("Single Player", () -> {}),
			new Pair<String, Runnable>("Multiplayer", () -> {}),
			new Pair<String, Runnable>("Game Options", () -> {}),
			new Pair<String, Runnable>("Additional Content", () -> {}),
			new Pair<String, Runnable>("Tutorial", () -> {}),
			new Pair<String, Runnable>("Benchmark", () -> {}),
			new Pair<String, Runnable>("Credits", () -> {}),
			new Pair<String, Runnable>("Exit to Desktop", Platform::exit)
	);
	
	private Pane root = new Pane();
	private VBox menuBox = new VBox(-5);
	private Line line;
	
	private Parent createContent() {
		addBackground();
		
		return root;
	}
	
	private void addBackground() {
		ImageView imageView = new ImageView(getClass().getResource("res/Civ6_bg.png").toExternalForm());
		imageView.setFitWidth(WIDTH);
		imageView.setFitHeight(HEIGHT);
		
		root.getChildren().add(imageView);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(createContent());
		primaryStage.setTitle("Civilization VI Menu");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
