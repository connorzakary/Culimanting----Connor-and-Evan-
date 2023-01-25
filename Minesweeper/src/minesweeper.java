import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.lang.Math;

/**
 * The graphics and some of the logic for Minesweeper
 * 
 * @author C. Zakary & E.Apostolidis
 *
 */
public class minesweeper extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	private final double WIDTH = 800;
	private final double HEIGHT = 800;
	private final int ROWS = 8;
	private final int COLS = 8;
	private int bombsToBePlaced = 10;
	private boolean isGameOn = true;

	// Import all the images

	private NewButton board[][] = new NewButton[ROWS][COLS];
	Image baseTile = new Image("BaseTile.png");
	Image bomb = new Image("Bomb.PNG");
	Image one = new Image("1.png");
	Image two = new Image("2.png");
	Image three = new Image("3.png");
	Image four = new Image("4.png");
	Image five = new Image("5.png");
	Image six = new Image("6.png");
	Image seven = new Image("7.png");
	Image eight = new Image("8.png");
	Image checkedTile = new Image("bigGreyTile.png");
	Image flag = new Image("Flag.png");
	Image incorrectFlag = new Image("incorrectFlag.png");

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Minesweeper!");
		StackPane sp = new StackPane();

		Font titleFont = new Font("Arial", 40);

		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.TOP_CENTER);
		sp.getChildren().addAll(gridPane);

		Scene scene = new Scene(sp, WIDTH, HEIGHT);

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				// Creating the board and populating it with tiles
				ImageView baseTileView = new ImageView(baseTile);

				board[i][j] = new NewButton(i, j);
				board[i][j].setMinSize(WIDTH / COLS, HEIGHT / ROWS);
				board[i][j].setMaxSize(WIDTH / COLS, HEIGHT / ROWS);
				board[i][j].setPrefSize(WIDTH / COLS, HEIGHT / ROWS);
				board[i][j].setPrefSize(WIDTH / COLS, HEIGHT / ROWS);
				board[i][j].setGraphic(baseTileView);

			}
		}
		// Adding all the tiles to a gridpane
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				gridPane.add(board[i][j], j, i);

			}
		}
		// Placing bombs on the grid randomly
		while (bombsToBePlaced > 0) {
			int max = 8;
			int min = 0;
			int randRow = (int) ((Math.random() * (max - min)) + min);
			int randCol = (int) ((Math.random() * (max - min)) + min);

			if (board[randRow][randCol].isBomb() != true) {

				board[randRow][randCol].makeBomb();
				bombsToBePlaced -= 1;
			} else {

			}

		}
		// Adding functionality to the tiles, when clicked reveals what the tile holds.
		// Ends game if tile is bomb.
		ArrayList<NewButton> flaggedTiles = new ArrayList<>();
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {

				ImageView bombView = new ImageView(bomb);
				ImageView oneView = new ImageView(one);
				ImageView twoView = new ImageView(two);
				ImageView threeView = new ImageView(three);
				ImageView fourView = new ImageView(four);
				ImageView fiveView = new ImageView(five);
				ImageView sixView = new ImageView(six);
				ImageView sevenView = new ImageView(seven);
				ImageView eightView = new ImageView(eight);
				ImageView baseTileView = new ImageView(baseTile);
				ImageView checkedTileView = new ImageView(checkedTile);
				ImageView flagView = new ImageView(flag);

				int count = countNeighbours(getNeighbours(board[j][i]));

				board[i][j].setGraphic(baseTileView);

				board[i][j].setOnMouseClicked(e -> {
					// Adding flags to tiles when you right click them
					if (e.getButton() == MouseButton.SECONDARY) {
						if (((NewButton) e.getSource()).isFlagged() && isGameOn == true) {
							((NewButton) e.getSource()).removeFlag();
							((NewButton) e.getSource()).setGraphic(baseTileView);
							flaggedTiles.remove(e.getSource());

						} else if (((NewButton) e.getSource()).isRevealed() == false && isGameOn == true) {

							((NewButton) e.getSource()).setGraphic(flagView);
							((NewButton) e.getSource()).makeFlagged();
							flaggedTiles.add((NewButton) e.getSource());
						}
					}
					// Revealing tiles when they are left clicked
					if (e.getButton() == MouseButton.PRIMARY) {

						if (((NewButton) e.getSource()).isBomb() && ((NewButton) e.getSource()).isFlagged() == false
								&& isGameOn == true) {
							((NewButton) e.getSource()).setGraphic(bombView);
							((NewButton) e.getSource()).reveal();
							isGameOn = false;

						}
						if (count == 1 && !((NewButton) e.getSource()).isBomb() && isGameOn == true
								&& ((NewButton) e.getSource()).isFlagged() == false) {
							((NewButton) e.getSource()).setGraphic(oneView);
							((NewButton) e.getSource()).reveal();

						}
						if (count == 2 && !((NewButton) e.getSource()).isBomb() && isGameOn == true
								&& ((NewButton) e.getSource()).isFlagged() == false) {
							((NewButton) e.getSource()).setGraphic(twoView);
							((NewButton) e.getSource()).reveal();
						}
						if (count == 3 && !((NewButton) e.getSource()).isBomb() && isGameOn == true
								&& ((NewButton) e.getSource()).isFlagged() == false) {
							((NewButton) e.getSource()).setGraphic(threeView);
							((NewButton) e.getSource()).reveal();
						}
						if (count == 4 && !((NewButton) e.getSource()).isBomb() && isGameOn == true
								&& ((NewButton) e.getSource()).isFlagged() == false) {
							((NewButton) e.getSource()).setGraphic(fourView);
							((NewButton) e.getSource()).reveal();
						}
						if (count == 5 && !((NewButton) e.getSource()).isBomb() && isGameOn == true
								&& ((NewButton) e.getSource()).isFlagged() == false) {
							((NewButton) e.getSource()).setGraphic(fiveView);
							((NewButton) e.getSource()).reveal();
						}
						if (count == 6 && !((NewButton) e.getSource()).isBomb() && isGameOn == true
								&& ((NewButton) e.getSource()).isFlagged() == false) {
							((NewButton) e.getSource()).setGraphic(sixView);
							((NewButton) e.getSource()).reveal();
						}
						if (count == 7 && !((NewButton) e.getSource()).isBomb() && isGameOn == true
								&& ((NewButton) e.getSource()).isFlagged() == false) {
							((NewButton) e.getSource()).setGraphic(sevenView);
							((NewButton) e.getSource()).reveal();
						}
						if (count == 8 && !((NewButton) e.getSource()).isBomb() && isGameOn == true
								&& ((NewButton) e.getSource()).isFlagged() == false) {
							((NewButton) e.getSource()).setGraphic(eightView);
							((NewButton) e.getSource()).reveal();
						}
						if (count == 0 && !((NewButton) e.getSource()).isBomb() && isGameOn == true
								&& ((NewButton) e.getSource()).isFlagged() == false) {
							((NewButton) e.getSource()).setGraphic(checkedTileView);
							((NewButton) e.getSource()).reveal();
						}

					}
					// Ending game, shows which flags were correct and shows game over screen. Also
					// stops button functionality
					if (isGameOn == false) {
						for (int k = 0; k < flaggedTiles.size(); k++) {
							ImageView falseFlagView = new ImageView(incorrectFlag);
							if (checkFlag(flaggedTiles.get(k)) == false) {
								flaggedTiles.get(k).setGraphic(falseFlagView);
							}
						}
						Label gameOverLose = new Label("Game Over!");

						gameOverLose.setFont(titleFont);
						sp.getChildren().add(gameOverLose);

					}

				});

			}

		}

		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Gets the coordinates of the 8 surrounding tiles of a given tile
	 * 
	 * @param button the given tile
	 * @return an ArrayList of the coordinates of the surrounding tiles
	 */
	private ArrayList<NewButton> getNeighbours(NewButton button) {
		ArrayList<NewButton> neighbours = new ArrayList<>();

		int[] points = new int[] { -1, -1, -1, 0, -1, 1, 0, -1, 0, 1, 1, -1, 1, 0, 1, 1 };

		for (int i = 0; i < points.length; i++) {
			int dx = points[i];
			int dy = points[++i];

			int newX = button.getCol() + dx;
			int newY = button.getRow() + dy;

			if (newX >= 0 && newX <= 7 && newY >= 0 && newY <= 7) {
				neighbours.add(board[newX][newY]);

			}
		}
		return neighbours;

	}

	/**
	 * Counts how many of the surrounding neighbours are bombs
	 * 
	 * @param neighbours An ArrayList of the 8 surrounding tiles coordinates
	 * @return the number of bombs surrounding a the tile
	 */
	private int countNeighbours(ArrayList<NewButton> neighbours) {
		int count = 0;
		for (int i = 0; i < neighbours.size(); i++) {
			if (neighbours.get(i).isBomb()) {
				count += 1;
			}

		}
		return count;
	}

	/**
	 * Checks if a given tile is flagged, if so, checks if it is correctly flagged
	 * 
	 * @param button The tile to be checked for flagging accuracy
	 * @return if the tile is correctly flagged or not
	 */
	private boolean checkFlag(NewButton button) {
		boolean isCorrect = false;
		if (button.isBomb() == true && button.isFlagged() == true) {
			isCorrect = true;
		}
		return isCorrect;
	}

}
