package com.saharmassachi.ttt.java;

public class GameCell {

	private String mark = " ";
	private GamePlayer player;
	boolean claimed;
	
	public GameCell (){
		claimed = false;
	}
	
	//when a player claims a cell, call this function
	public void claim(GamePlayer P){
		mark = P.getMark();
		player = P;
		claimed = true;
	}
	
	//a mark is typically an X or a O.
	public String getMark(){
		return mark;
	}
	
	public GamePlayer getPlayer(){
		return player;
	}
	
	public boolean isEmpty(){
		return !claimed;
	}
}
