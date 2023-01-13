
import java.util.ArrayList;

import javafx.scene.control.Button;

public class NewButton extends Button {
	private int row;
	private int col;
	private boolean isBomb;

	public NewButton(int r, int c) {
		super();
		row = r;
		col = c;
		isBomb = false;
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

	public void makeBomb() {
		isBomb = true;
	}
	@Override
	public String toString(){
		return "[" + String.valueOf(getRow()) + "," + String.valueOf(getCol())+"]";
	}
	
}
