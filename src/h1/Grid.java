package h1;

public class Grid {
	private Cell[][] gridArray;

	public Grid(Cell[] cells, int gridRows, int gridCols) {
		this.gridArray = new Cell[gridRows][gridCols];

		for (int i = 0; i < gridRows; i++) {
			for (int x = 0; x < gridCols; x++) {
				gridArray[i][x] = new Cell(i, x, false);
			}
		}
		for (Cell cell : cells) {
			int i = cell.getIndexRow();
			int x = cell.getIndexCol();

			if (i >= 0 && i < gridRows && x >= 0 && x < gridCols) {
				gridArray[i][x].setAlive(true);
			}
		}

		for (int i = 0; i < gridRows; i++) {
			for (int x = 0; x < gridCols; x++) {
				gridArray[i][x].countLivingNeighbors(gridArray);
			}
		}

	}

	public void computeNextGen() {
		for (int i = 0; i < gridArray.length; i++) {
			for (int x = 0; x < gridArray[0].length; x++) {
				gridArray[i][x].countLivingNeighbors(gridArray);
			}
		}
		for (int i = 0; i < gridArray.length; i++) {
			for (int x = 0; x < gridArray[0].length; x++) {
				gridArray[i][x].setAlive(gridArray[i][x].isAliveNextGen());
			}
		}

	}

	public void computeGeneration(int n) {
		for (int i = 0; i < n; i++) {
			computeNextGen();
		}
	}

	public Cell[][] getGridArray() {
		return gridArray;
	}

	public void setGridArray(Cell[][] gridArray) {
		this.gridArray = gridArray;
	}

}
