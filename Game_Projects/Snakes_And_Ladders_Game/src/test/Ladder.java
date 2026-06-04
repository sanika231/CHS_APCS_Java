package test;

import engine.Actor;

public class Ladder extends Actor{
	private int startRow; 
	private int startCol; 
	private int endRow;
	private int endCol;
	int x;
	
	public Ladder(int srow, int scol, int erow, int ecol, int num) {
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
    
    public boolean playerOnLadder(int row, int col) {
        if(row==endRow && col==endCol) {
        	return true;
        }
        return false;
    }
    
    public int getLadder() {
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
