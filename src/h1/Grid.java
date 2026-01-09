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
	    int rows = gridArray.length;
	    int cols = gridArray[0].length;

	    boolean[][] nextState = new boolean[rows][cols];

	    for (int r = 0; r < rows; r++) {
	        for (int c = 0; c < cols; c++) {
	            nextState[r][c] = gridArray[r][c].isAliveNextGen();
	        }
	    }

	    for (int r = 0; r < rows; r++) {
	        for (int c = 0; c < cols; c++) {
	            gridArray[r][c].setAlive(nextState[r][c]);
	        }
	    }

	    for (int r = 0; r < rows; r++) {
	        for (int c = 0; c < cols; c++) {
	            gridArray[r][c].countLivingNeighbors(gridArray);
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
