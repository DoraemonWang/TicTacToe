package com.saharmassachi.ttt.java;

import java.util.Arrays;

//This object represents the tic tac toe board
//It also contains the method to check to see if anyone has won.
//With other helper methods
public class GameBoard {
	GameCell[][] board; //0,0 is topleft. 0,2 is top right
	GamePlayer playerOne;
	GamePlayer playerTwo;
	GamePlayer current;
	boolean endgame = false;
	public GameBoard(GamePlayer a, GamePlayer b){
		board = new GameCell[3][3];
		initBoard();
		playerOne = a;
		playerTwo = b;
		current = playerOne;
	}

	public GameBoard(GamePlayer a, GamePlayer b, GameCell[][] board){
		playerOne = a;
		playerTwo = b;
		current = playerOne;
		this.board = board;
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
	
	
	public boolean isFull(){
		return !(isEmptyCells(board));
	}
	
	private boolean isEmptyCells(GameCell[][] cells){
		//given a board-as-matrix, find the empty cells;
		//Each string represents a mvoe.
		for (int i = 0; i <3; i++){
			for (int j = 0; j< 3; j++){
				if(cells[i][j].isEmpty()){
					return true;
				}
			}	
		}
		endgame = true;
		return false;
	}
	
	
	//returns 1 if they all are equal, 0 otherwise
	private GamePlayer checkEqual(GameCell a, GameCell b, GameCell c ){ //we could also use the ... keyword
		if (a.getMark() == b.getMark() && b.getMark() == c.getMark()){
			return a.getPlayer();
		}
		return null;
	}
	
	public GameCell[][] getBoardCopy(){
		GameCell[][] newboard = new GameCell[3][3];
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j ++){
				newboard[i][j] = board[i][j].copyOf();
		}
		}
		return newboard;
	}
	
	
	public boolean isEmpty(int a, int b){
		if(board[a][b].isEmpty()){
			return true;
		}
		return false;
	}
	
	//how players move.
	public void place(int a, int b, GamePlayer P){
		if (P.equals(current)){ //this prevents cheating.
			board[a][b].claim(P);
			iterPlayer();
		}
	}
	
	public GamePlayer nextPlayer(){
		//returns the player whose turn it is to play. 
		return current;
	}
	
	//switch the current player (aka the one whose move it is) 
	private void iterPlayer(){
		if (current.equals(playerOne)){
			current = playerTwo;
			return;
		}
		current = playerOne;
	}
	
	public GamePlayer[] getPlayers(){
		GamePlayer[] toreturn = {playerOne, playerTwo};
		return toreturn;
	}
	
	public void endGame(){
		current = null;
		endgame = true;
	}
	
	public boolean isEnded(){
		if(endgame == true) return true;
		if(getWinner() != null) endgame = true;
		return endgame;
	}
}
