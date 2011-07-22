package com.saharmassachi.ttt.java;

import java.util.Scanner;

public class HumanPlayer extends GamePlayer {

	public HumanPlayer(String name, String mark) {
		super(name, mark);
	}

	public HumanPlayer(String name) {
		super(name);
	}
	public void move(GameBoard b){
		System.out.println("Coordinates of where to move? (row, columm) where 0,0 = Top Right");
		Scanner sc = new Scanner(System.in);
		try{
			System.out.println("Row:");
			int one = sc.nextInt();
			System.out.println("Column:");
			int two = sc.nextInt();
			b.place(one, two, this);
		}
		catch(Exception e){
			System.out.println("sorry, what? try again.");
			move(b);
		}
		
	}

}
