package com.saharmassachi.ttt.java;

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
		GameCell[][] cells = b.getBoardCopy();
	}

	//given a board, is there a move that could win the game?
	private int[] winningMove(GameBoard b){
		
		
	}
	
}
