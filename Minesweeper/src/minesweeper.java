import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class minesweeper extends Application {

	@Override
	public void start(Stage stage) throws Exception {
	stage.setTitle("Minesweeper 3");
	
	GridPane gridPane = new GridPane();
	
	
	Scene scene = new Scene(gridPane, 450 , 400);
	stage.setScene(scene);
	stage.show();
	
	
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
	
}
