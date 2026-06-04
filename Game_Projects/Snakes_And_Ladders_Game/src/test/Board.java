package test;


public class Board {
	int[][] board = new int[10][10];
	int snakes;
	int ladders;
	int [][] pos;
	int [][] lad;
	int count = 0;
	
	public Board() {
		snakes = 5;
		ladders = 5;
		pos = new int[2][5];
		lad = new int[2][5];
		setUpBoard();
		show();

	}
	
	public Board(int s, int l) {
		snakes = s;
		ladders = l;
		pos = new int[2][s];
		lad = new int[2][s];
		setUpBoard();
		show();

	}
	
	public void setUpBoard() {
		int x = 100;
		for(int i = 0; i < board.length; i++) {
			if(i % 2 == 0) {
				for(int j = 0; j < board[i].length; j++) {
					board[i][j] = x;
					x--;
				}
			} else {
				for(int j = board[i].length - 1; j >= 0; j--) {
					board[i][j] = x;
					x--;
				}
			}
			
		}
        if(snakes == 3) {
        	//pos has the end row
    		board[0][1] = 0;
    		pos[0][0] = 6;
    		pos[1][0] = 1;
    		board[3][5] = 0;
    		pos[0][1] = 5;
    		pos[1][1] = 5;
    		board[3][8] = 0;
    		pos[0][2] = 6;
    		pos[1][2] = 8;
    		
    		//lad has the end row
    		board[7][6] = -1;
    		lad[0][0] = 3;
    		lad[1][0] = 6;
    		board[8][2] = -1;
    		lad[0][1] = 4;
    		lad[1][1] = 2;
    		board[9][8] = -1;
    		lad[0][2] = 8;
    		lad[1][2] = 8;
    		
        }
        
        if(snakes == 5) {
    		board[0][1] = 0;
    		pos[0][0] = 6;
    		pos[1][0] = 1;
    		board[0][6] = 0;
    		pos[0][1] = 2;
    		pos[1][1] = 6;
    		board[3][5] = 0;
    		pos[0][2] = 5;
    		pos[1][2] = 5;
    		board[3][8] = 0;
    		pos[0][3] = 6;
    		pos[1][3] = 8;
    		board[5][3] = 0;
    		pos[0][4] = 8;
    		pos[1][4] = 3;
    		
    		
    		//lad has the end row
    		board[7][6] = -1;
    		lad[0][0] = 3;
    		lad[1][0] = 6;
    		board[8][2] = -1;
    		lad[0][1] = 4;
    		lad[1][1] = 2;
    		board[9][8] = -1;
    		lad[0][2] = 8;
    		lad[1][2] = 8;
        }
        
        if(snakes == 7) {
        	board[0][1] = 0;
    		pos[0][0] = 6;
    		pos[1][0] = 1;
    		board[0][6] = 0;
    		pos[0][1] = 2;
    		pos[1][1] = 6;
    		board[2][2] = 0;
    		pos[0][2] = 4;
    		pos[1][2] = 2;
    		board[3][5] = 0;
    		pos[0][3] = 5;
    		pos[1][3] = 5;
    		board[3][8] = 0;
    		pos[0][4] = 6;
    		pos[1][4] = 8;
    		board[5][3] = 0;
    		pos[0][5] = 8;
    		pos[1][5] = 3;
    		board[6][7] = 0;
    		pos[0][6] = 9;
    		pos[1][6] = 7;
    		
    		
    		//lad has the end row
    		board[7][6] = -1;
    		lad[0][0] = 3;
    		lad[1][0] = 6;
    		board[8][2] = -1;
    		lad[0][1] = 4;
    		lad[1][1] = 2;
    		board[9][8] = -1;
    		lad[0][2] = 8;
    		lad[1][2] = 8;
        }

	}
	
	public void show() {
		System.out.print("    ");
		for(int i = 0; i < board.length; i++) {
			System.out.print(i + "  ");
		}
		System.out.println();
		System.out.println();
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]  + " ");
				
			}
			System.out.println();
		}
	}
	
	public int getWidth() {
		return board.length;
	}
	
	public int getHeight() {
		return board[0].length;
	}
	
	public int getValue(int i, int j) {
		return board[i][j];
	}
	
	public boolean isMatch(int row, int col) {
		for(int j = 0; j < pos[0].length; j++) {
			if(pos[0][j] == row) {
				if(pos[1][j] == col) {
					return true;
				}
			}
		}
		return false;
	}
	
	public int getEndRowSnake(int num) {
		return pos[0][num];
	}
	
	public int getEndColSnake(int num) {
		return pos[1][num];
	}
	
	public int getEndRowLadder(int num) {
		return lad[0][num];
	}
	
	public int getEndColLadder(int num) {
		return lad[1][num];
	}
}
