package com.saharmassachi.ttt.java;

import java.util.Random;

public class RandomPlayer extends GamePlayer {
	//this is the random movement ai
	public RandomPlayer(String name) {
		super(name);
	}
	public RandomPlayer(String name, String mark) {
		super(name, mark);
	}

	public void move(GameBoard b){
		
		Random r = new Random();
		int one = r.nextInt(3);
		int two = r.nextInt(3);
		if(b.isEmpty(one, two)){
			b.place(one, two, this);
		}
		else {
			move(b);
		}
		
	}
	
}
