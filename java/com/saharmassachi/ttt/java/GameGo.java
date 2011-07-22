package com.saharmassachi.ttt.java;

public class GameGo {
	private static void print(String x){
		System.out.println(x);
	}
	
	
	public static void main(String[] args){
		System.out.println("hello");
		
		GamePlayer a = new RandomPlayer("abraham");
		GamePlayer b = new AIbetterPlayer("benjamin");
		GameBoard gb = new GameBoard(a, b);
		print(gb.toString());
		
		
		while((gb.getWinner() == null) && !gb.isFull()){
			GamePlayer player = gb.nextPlayer();
			//the board itself knows which player is next.
			player.move(gb);
			print(gb.toString());
		}
		
		GamePlayer winner = gb.getWinner();
		if(winner  != null){
			print("winner is: " + gb.getWinner().toString());	
		}
		else{
			print("tie");
		}
		
		
		
	}
}
