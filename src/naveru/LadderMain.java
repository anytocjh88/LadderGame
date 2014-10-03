package naveru;

import java.util.Random;

public class LadderMain {
	
	private int ladder[][];
	private int result;
	
	public LadderMain() {}

	public void makeLadder(int rowSize, int colSize) {
		initArrSize(rowSize, colSize);
		drawHorizontalLine(rowSize, colSize);
	}

	public void drawHorizontalLine(int rowSize, int colSize) {
		for (int i = 0; i < rowSize; i++) {
			makeRandomLine(colSize, i);
		}
	}

	public void makeRandomLine(int colSize, int i) {
		Random random = new Random();
		int lineCount = random.nextInt(colSize) + 1;
		
		for (int j = 0; j < lineCount; j++) {
			drawRandomLine(colSize, i, random);
		}
	}

	public void drawRandomLine(int colSize, int i, Random random) {
		int lineNum = random.nextInt(colSize);
		if (lineNum == colSize - 1) {
			return;
		}
		ladder[i][lineNum] = 1;
	}

	public void printLadderStatus(int rowIdx, int colIdx) {
		for (int i = 0; i < ladder.length; i++) {
			printLadderColumns(rowIdx, colIdx, i);
		}
		System.out.println();
	}

	public void printLadderColumns(int rowIdx, int colIdx, int i) {
		for (int j = 0; j < ladder[i].length; j++) {
			System.out.print(ladder[i][j]);
			printCurrentPosition(rowIdx, colIdx, i, j);
			System.out.print(" ");
		}
		System.out.println();
	}

	public void printCurrentPosition(int rowIdx, int colIdx, int i, int j) {
		if (i == rowIdx && j == colIdx) {
			System.out.print("*");
		}
	}

	public void initArrSize(int rowSize, int colSize) {
		if (isInvalidSize(rowSize, colSize)) {
			throw new RuntimeException();
		}
		ladder = new int[rowSize][colSize];
	}

	public boolean isInvalidSize(int rowSize, int colSize) {
		return rowSize < 0 || colSize < 0;
	}

	public int run(int rowSize, int colSize, int startNum) {
		try {
			makeLadder(rowSize, colSize);
			result =  startLadderGame(rowSize, colSize, startNum);
		} catch (RuntimeException e) {
			System.out.println("잘못된 입력 값입니다.");
		}
		
		return result;
	}

	public int startLadderGame(int rowSize, int colSize, int startNum) {
		if (isInvalidStartNum(colSize, startNum)) {
			throw new RuntimeException();
		}

		int rowIdx = 0;
		int colIdx = startNum - 1;

		
		while (rowIdx < rowSize) {
			printLadderStatus(rowIdx, colIdx);
			colIdx = moveLeftOrRight(rowIdx, colIdx);
			rowIdx++;
		}
		
		return colIdx + 1;
	}

	public boolean isInvalidStartNum(int colSize, int startNum) {
		return startNum <= 0 || startNum > colSize;
	}

	public int moveLeftOrRight(int rowIdx, int colIdx) {
		if (canIGoToRight(rowIdx, colIdx)) {
			colIdx = moveRight(rowIdx, colIdx);
			printLadderStatus(rowIdx, colIdx);
		} else if (canIGoToLeft(rowIdx, colIdx)) {
			colIdx = moveLeft(rowIdx, colIdx);
			printLadderStatus(rowIdx, colIdx);
		}
		
		
		return colIdx;
	}

	public int moveRight(int rowIdx, int colIdx) {
		while (canIGoToRight(rowIdx, colIdx)) {
			colIdx++;
		}
		return colIdx;
	}
	
	public int moveLeft(int rowIdx, int colIdx) {
		while (canIGoToLeft(rowIdx, colIdx)) {
			colIdx--;
		}
		return colIdx;
	}

	public boolean canIGoToLeft(int rowIdx, int colIdx) {
		if (colIdx - 1 < 0) {
			return false;
		}
		if (ladder[rowIdx][colIdx - 1] == 1) {
			return true;
		}
		return false;
	}

	public boolean canIGoToRight(int rowIdx, int colIdx) {
		if (ladder[rowIdx][colIdx] == 1) {
			return true;
		}
		return false;
	}

}
