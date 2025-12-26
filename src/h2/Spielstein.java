package h2;

public class Spielstein {
	private int currentRow;
	private int currentCol;
	private Spielbrett brett;

	public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
		this.currentRow = indexRow;
		this.currentCol = indexCol;
		this.brett = brett;
	}

	private boolean movesOut() {
		Feld b = brett.getBrett()[currentRow][currentCol];
		char d = b.getDirection();
		if (currentRow == 0 && d == 'U')
			return true;
		if (currentRow == brett.getDim() - 1 && d == 'D')
			return true;
		if (currentCol == 0 && d == 'L')
			return true;
		if (currentCol == brett.getDim() - 1 && d == 'R')
			return true;

		return false;
	}

	public void go(int n) {
		for (int i = 0; i < n; i++) {
			Feld x = brett.getBrett()[currentRow][currentCol];
			if (x.isBoese()) {
				continue;
			}
			if (movesOut()) {
				continue;
			}
			switch (x.getDirection()) {
			case 'U':
				currentRow--;
				break;
			case 'D':
				currentRow++;
				break;
			case 'L':
				currentCol--;
				break;
			case 'R':
				currentCol++;
				break;
			}
		}
	}

	public int getCurrentRow() {
		return currentRow;
	}

	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}

	public int getCurrentCol() {
		return currentCol;
	}

	public void setCurrentCol(int currentCol) {
		this.currentCol = currentCol;
	}

	public Spielbrett getBrett() {
		return brett;
	}

	public void setBrett(Spielbrett brett) {
		this.brett = brett;
	}

}
