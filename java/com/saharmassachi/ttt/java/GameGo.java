package com.saharmassachi.ttt.java;

public class GameGo {
	private static void print(String x){
		System.out.println(x);
	}
	
	
	public static void main(String[] args){
		System.out.println("hello");
		GameBoard gb = new GameBoard();
		print(gb.toString());
		
		RandomPlayer a = new RandomPlayer("mark");
		GamePlayer b = new HumanPlayer("bartholomew");
		
		boolean agoes = true;
		while(gb.getWinner() == null){
			
			if(agoes){
				a.move(gb);
			}
			else{
				b.move(gb);
			}
			GamePlayer aaaa = gb.getWinner();
			agoes = !agoes;
			print(gb.toString());
			
			
		}
		print("winner is: " + gb.getWinner().toString());
		
	}
}
