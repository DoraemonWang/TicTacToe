package com.saharmassachi.ttt.java;

//This object represents the tic tac toe board
//It also contains the method to check to see if anyone has won.
//With other helper methods
public class GameBoard {
	GameCell[][] board; //0,0 is topleft. 0,2 is top right
	public GameBoard(){
		board = new GameCell[3][3];
		initBoard();
	}

	public void initBoard(){
		for (GameCell[] g : board){
			for (int i = 0; i < 3; i ++){
				g[i] = new GameCell();
			}
		}
		
	}
	public String toString(){
		String out ="";
		for (GameCell[] a : board){
			for (GameCell c : a){
				out += "|" + c.getMark() + "|";
			}
			out += "\n";
			out += "----------------";
			out += "\n";
		}
		return out;
	}

	public GamePlayer getWinner(){
		GamePlayer winner;
		for (int i = 0; i < 3; i++){
			winner = checkEqual(board[0][i], board[1][i], board [2][i]);
			if (winner != null) return winner;
			winner = checkEqual(board[i][0], board[i][1], board [i][2]);
			if (winner != null) return winner;
		}
		//that checks every row and column.
		
		//now the two diagonals.
		winner = checkEqual(board[0][0], board[1][1], board[2][2]);
		if (winner != null) return winner;
		winner = checkEqual(board[2][0], board[1][1], board[0][2]);
		
		return winner;
		
	}
	
	
	
	//returns 1 if they all are equal, 0 otherwise
	private GamePlayer checkEqual(GameCell a, GameCell b, GameCell c ){ //we could also use the ... keyword
		if (a.getMark() == b.getMark() && b.getMark() == c.getMark()){
			return a.getPlayer();
		}
		return null;
	}
	
	public GameCell[][] getBoardCopy(){
		return board.clone();
	}
	
	
	public boolean isEmpty(int a, int b){
		if(board[a][b].isEmpty()){
			return true;
		}
		return false;
	}
	
	public void place(int a, int b, GamePlayer P){
		board[a][b].claim(P);
	}
	
}
