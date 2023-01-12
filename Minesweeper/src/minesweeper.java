import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.lang.Math;

public class minesweeper extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	private final double WIDTH = 800;
	private final double HEIGHT = 800;
	private final int ROWS = 8;
	private final int COLS = 8;
	private int bombsToBePlaced = 10;

	private NewButton board[][] = new NewButton[ROWS][COLS];
	Image baseTile = new Image("BaseTile.png");
	Image bomb = new Image("Bomb.PNG");
	
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Minesweeper");

		GridPane gridPane = new GridPane();
		Scene scene = new Scene(gridPane, WIDTH, HEIGHT);
		gridPane.setAlignment(Pos.TOP_CENTER);

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				
				ImageView baseTileView = new ImageView(baseTile);
				
				board[i][j] = new NewButton(i, j);
				board[i][j].setMinSize(WIDTH / COLS, HEIGHT / ROWS);
				board[i][j].setMaxSize(WIDTH / COLS, HEIGHT / ROWS);
				board[i][j].setPrefSize(WIDTH / COLS, HEIGHT / ROWS);
				board[i][j].setPrefSize(WIDTH / COLS, HEIGHT / ROWS);
				board[i][j].setGraphic(baseTileView);

			}
		}
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				gridPane.add(board[i][j], j, i + 1);
			}
		}

		while (bombsToBePlaced > 0) {
			int max = 8;
			int min = 0;
			int randRow = (int) ((Math.random() * (max - min)) + min);
			int randCol = (int) ((Math.random() * (max - min)) + min);
			System.out.println(randRow + " , " + randCol);
			if (board[randRow][randCol].isBomb() != true) {

				board[randRow][randCol].makeBomb();
				bombsToBePlaced -= 1;
			} else {

			}

		}
		
		 
		for(int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				
				ImageView bombView = new ImageView(bomb);
				if(board[i][j].isBomb()) {
					board[i][j].setGraphic(bombView);
				}
				
				
			}
			
		stage.setScene(scene);
		stage.show();
	}
}
}
