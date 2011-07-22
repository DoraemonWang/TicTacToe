package com.saharmassachi.ttt.java;

import java.util.ArrayList;
import java.util.Random;

public class AIPlayer extends GamePlayer {

	public AIPlayer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public AIPlayer(String name, String mark){
		super(name, mark);
	}

	@Override
	public void move(GameBoard b) {
		int[] moves = winningMove(b);
		if( moves != null){
			b.place(moves[0], moves[1], this);
		}
		else{
			randomMove(b);
		}
	}

	//given a board, is there a move that could win the game?
	private int[] winningMove(GameBoard b){
		GameCell[][] cells = b.getBoardCopy();
		String[] empties  = findEmptyCells(cells);
		//for each empty cell: place it in the copied board. 
		for (String s:  empties){
			try{
				String[] moves = s.split("|");
			
			int one = Integer.parseInt(moves[1]);
			int two = Integer.parseInt(moves[3]);
			cells[one][two].claim(this);
			if (isWins(cells)){ 
				int[] intMoves = {one, two}; 
				return intMoves; 
			}
			else{
				cells[one][two] = new GameCell();

			}
			}
			catch(Exception e){
				//empties is not full so often you will be trying to split "". 
				//in that case do nothing that's fine.
			}

		}
		//if we got here with no winning move then there is none.
		//then see if it wins the game.
		return null;
	}

	private String[] findEmptyCells(GameCell[][] cells){
		//given a board-as-matrix, find the empty cells;
		//Each string represents a mvoe.
		String[] empties = new String[9];
		int place = 0; //the next open cell in empties.
		for (int i = 0; i <3; i++){
			for (int j = 0; j< 3; j++){
				if(cells[i][j].isEmpty()){
					empties[place] = i + "|" + j;
					place ++;
				}
			}	
		}
		return empties;
	}

	//given a board represented as a matrix, is there a winner?
	private boolean isWins(GameCell[][] board){
		int isWon = 0;
		for (int i = 0; i < 3; i++){
			isWon += checkEqual(board[0][i], board[1][i], board [2][i]);
			isWon += checkEqual(board[i][0], board[i][1], board [i][2]);
		}
		//that checks every row and column.

		//now the two diagonals.
		isWon += checkEqual(board[0][0], board[1][1], board[2][2]);
		isWon += checkEqual(board[2][0], board[1][1], board[0][2]);

		if (isWon > 0){return true;}
		return false;

	}


	//returns 1 if they are equal, 0 if not.
	private int checkEqual(GameCell a, GameCell b, GameCell c ){ //we could also use the ... keyword
		if ((a.getMark() == b.getMark()) && (b.getMark() == c.getMark() )&& (c.getMark() != "")){
			return 1;
		}
		return 0;
	}

	public void randomMove(GameBoard b){

		Random r = new Random();
		int one = r.nextInt(3);
		int two = r.nextInt(3);
		if(b.isEmpty(one, two)){
			b.place(one, two, this);
		}
		else {
			randomMove(b);
		}

	}

}
