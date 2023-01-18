
import java.util.ArrayList;

import javafx.scene.control.Button;

public class NewButton extends Button {
	private int row;
	private int col;
	private boolean isBomb;
	private boolean isFlagged;
	private boolean isRevealed;  
	
	public NewButton(int r, int c) {
		super();
		row = r;
		col = c;
		isBomb = false;
		isFlagged = false;
		isRevealed = false;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}


	public boolean isBomb() {
		return isBomb;
	}
	public boolean isFlagged() {
		return isFlagged;
	}
	public boolean isRevealed() {
		return isRevealed;
	}
	
	public void makeBomb() {
		isBomb = true;
	}
	
	public void removeFlag() {
		isFlagged = false;
	}
	
	public void makeFlagged() {
		isFlagged = true;
	}
	public void reveal() {
		isRevealed = true;
	}
	@Override
	public String toString(){
		return "[" + String.valueOf(getRow()) + "," + String.valueOf(getCol())+"]";
	}
	
}
