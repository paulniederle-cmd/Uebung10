package h1;

public class Cell {
	private int indexRow;
	private int indexCol;
	private boolean alive;
	private int numLivingNeighbors;
	private boolean isAliveNextGen;

	public Cell(int indexRow, int indexCol, boolean alive) {
		setIndexRow(indexRow);
		setIndexCol(indexCol);
		setAlive(alive);
	}

	public Cell(int indexRow, int indexCol) {
		setIndexRow(indexRow);
		setIndexCol(indexCol);
		setAlive(false);
	}

	public void countLivingNeighbors(Cell[][] gridArray) {
		int count = 0;

		for (int i = indexRow - 1; i <= indexRow + 1; i++) {
			for (int x = indexCol - 1; x <= indexCol + 1; x++) {

				if (i == indexRow && x == indexCol) {
					continue;
				}

				if (i >= 0 && i < gridArray.length && x >= 0 && x < gridArray[0].length) {

					if (gridArray[i][x].isAlive()) {
						count++;
					}
				}
			}
		}

		this.numLivingNeighbors = count;
		decideNextStatus();
	}

	private void decideNextStatus() {
        if (alive) {
            isAliveNextGen = (numLivingNeighbors == 2 || numLivingNeighbors == 3);
        } else {
            isAliveNextGen = (numLivingNeighbors == 3);
        }
    }

	public int getIndexRow() {
		return indexRow;
	}

	public void setIndexRow(int indexRow) {
		this.indexRow = indexRow;
	}

	public int getIndexCol() {
		return indexCol;
	}

	public void setIndexCol(int indexCol) {
		this.indexCol = indexCol;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getNumLivingNeighbors() {
		return numLivingNeighbors;
	}

	public void setNumLivingNeighbors(int numLivingNeighbors) {
		this.numLivingNeighbors = numLivingNeighbors;
	}

	public boolean isAliveNextGen() {
		return isAliveNextGen;
	}

	public void setAliveNextGen(boolean isAliveNextGen) {
		this.isAliveNextGen = isAliveNextGen;
	}

}
