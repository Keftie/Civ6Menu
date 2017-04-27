package application;

import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
		addTitle();
		
		double lineX = WIDTH / 2 - 100;
		double lineY = HEIGHT / 3 + 50;
		
		addLine(lineX, lineY);
		
		return root;
	}
	
	private void addBackground() {
		ImageView imageView = new ImageView(getClass().getResource("res/Civ6_bg.png").toExternalForm());
		imageView.setFitWidth(WIDTH);
		imageView.setFitHeight(HEIGHT);
		
		root.getChildren().add(imageView);
	}
	
	private void addTitle() {
		Civ6Title title = new Civ6Title("CIVILIZATION VI");
		title.setTranslateX(WIDTH / 2 - title.getTitleWidth() / 2);
		title.setTranslateY(HEIGHT / 3);
		
		root.getChildren().add(title);
	}
	
	private void addLine(double x, double y) {
		line = new Line(x, y, x, y + 300);
		line.setStrokeWidth(3);
		line.setStroke(Color.color(1, 1, 1, 0.75));
		line.setEffect(new DropShadow(5, Color.BLACK));
		line.setScaleY(0);
		
		root.getChildren().add(line);
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
