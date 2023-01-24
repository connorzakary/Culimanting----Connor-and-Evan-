
import javafx.scene.control.Button;

public class NewButton extends Button {
	private int row;
	private int col;
	private boolean isBomb;
	private boolean isFlagged;
	private boolean isRevealed;

	/**
	 * Creates an object called a NewButton, one of the tiles on the grid
	 * 
	 * @param r the row the tile is in
	 * @param c the column the tile is in
	 */
	public NewButton(int r, int c) {
		super();
		row = r;
		col = c;
		isBomb = false;
		isFlagged = false;
		isRevealed = false;
	}

	/**
	 * Gets the row of a given button on a grid
	 * 
	 * @return the row of the given button
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Gets the column of a given button on a grid
	 * 
	 * @return the column of the given button
	 */
	public int getCol() {
		return col;
	}

	/**
	 * Tells if a given button is a bomb
	 * 
	 * @return if the button is a bomb
	 */
	public boolean isBomb() {
		return isBomb;
	}

	/**
	 * Tells if a given button is flagged
	 * 
	 * @return if the button is a flag
	 */
	public boolean isFlagged() {
		return isFlagged;
	}

	/**
	 * Tells if a given button has been clicked
	 * 
	 * @return if the button is revealed
	 */
	public boolean isRevealed() {
		return isRevealed;
	}

	/**
	 * Places a bomb on the grid
	 */
	public void makeBomb() {
		isBomb = true;
	}

	/**
	 * Removes a flag from a flagged tile
	 */
	public void removeFlag() {
		isFlagged = false;
	}

	/**
	 * Adds a flag to a tile on the grid
	 */
	public void makeFlagged() {
		isFlagged = true;
	}

	/**
	 * Changes a tile to indicate that it is revealed
	 */
	public void reveal() {
		isRevealed = true;
	}

}
