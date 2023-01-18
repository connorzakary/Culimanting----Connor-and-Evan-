import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
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
	private int bombsToBePlaced = 16;
	private boolean isGameOn = true;

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

				// List the coordinates of neighbours when clicked TEST
				board[i][j].setOnAction(e -> {

					System.out.println(countNeighbours(getNeighbours((NewButton) e.getSource())));
					System.out.println(((NewButton) e.getSource()).isBomb());
				});
			}
		}
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				gridPane.add(board[i][j], j, i);

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

				System.out.println(i + " , " + j + " count = " + count);

				board[i][j].setGraphic(baseTileView);

				board[i][j].setOnMouseClicked(e -> {
					if (e.getButton() == MouseButton.SECONDARY) {
						if (((NewButton) e.getSource()).isFlagged()) {
							((NewButton) e.getSource()).removeFlag();
							((NewButton) e.getSource()).setGraphic(baseTileView);
						} else if(((NewButton) e.getSource()).isRevealed()== false){

							((NewButton) e.getSource()).setGraphic(flagView);
							((NewButton) e.getSource()).makeFlagged();
						}
					}
					if (e.getButton() == MouseButton.PRIMARY) {
						System.out.println(((NewButton) e.getSource()).getCol() + "," + ((NewButton) e.getSource()).getRow());
						System.out.println(countNeighbours(getNeighbours((NewButton) e.getSource())));
						System.out.println(((NewButton) e.getSource()).isFlagged());

						if (((NewButton) e.getSource()).isBomb() && isGameOn == true
								&& ((NewButton) e.getSource()).isFlagged() == false) {
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
				});

			}

		}

		stage.setScene(scene);
		stage.show();
	}

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

	private int countNeighbours(ArrayList<NewButton> neighbours) {
		int count = 0;
		for (int i = 0; i < neighbours.size(); i++) {
			if (neighbours.get(i).isBomb()) {
				count += 1;
			}

		}
		return count;
	}

}
