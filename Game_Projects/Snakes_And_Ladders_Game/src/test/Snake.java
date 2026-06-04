package test;

import engine.Actor;

public class Snake extends Actor{
	private int startRow; 
	private int startCol; 
	private int endRow;
	private int endCol;
	int x;
	
	public Snake(int srow, int scol, int erow, int ecol, int num) {
        startRow=srow;
        startCol=scol;
        endRow=erow;
        endCol=ecol;
        x = num;
        
    }
	
	public int getStartRow() {
        return startRow;
    }

    public int getStartCol() {
        return startCol;
    }

    public int getEndRow() {
        return endRow;
    }

    public int getEndCol() {
        return endCol;
    }
    
    public boolean playerOnSnake(int row, int col) {
        if(row==startRow && col==startCol) {
        	return true;
        }
        return false;
    }
    
    public int getSnake() {
    	return x;
    }
    
    public int getLength() {
    	return Math.abs(startRow-endRow);
    }

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
}
