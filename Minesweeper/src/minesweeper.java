import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class minesweeper extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	private final double WIDTH = 800;
	private final double HEIGHT = 800;
	private final int ROWS = 8;
	private final int COLS = 8;
	
	private NewButton board[][] = new NewButton[ROWS][COLS];
	
	
	@Override
	public void start(Stage stage) throws Exception {
	stage.setTitle("Minesweeper");
	
	GridPane gridPane = new GridPane();
	Scene scene = new Scene(gridPane, WIDTH , HEIGHT);
	gridPane.setAlignment(Pos.TOP_CENTER);
	Image bomb = new Image("0.png");
	ImageView bombView  = new ImageView(bomb);
	
	for (int i = 0; i < ROWS; i++) {
		for (int j = 0; j < COLS; j++) {
		board[i][j] = new NewButton(i,j);
		board[i][j].setMinSize(WIDTH/COLS, HEIGHT/ROWS);
		board[i][j].setMaxSize(WIDTH/COLS, HEIGHT/ROWS);
		board[i][j].setPrefSize(WIDTH/COLS, HEIGHT/ROWS);
		board[i][j].setPrefSize(WIDTH/COLS, HEIGHT/ROWS);
		board[i][j].setGraphic(bombView);
	
		
		}
	}
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				gridPane.add(board[i][j], j, i+1);
			}
		}
		stage.setScene(scene);
		stage.show();
		
	
	
	
}
	}
