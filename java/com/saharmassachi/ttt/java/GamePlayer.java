package com.saharmassachi.ttt.java;

public abstract class GamePlayer {
	String mark;
	String name;
	public GamePlayer(String name, String mark){
		this.name = name;
		this.mark = mark;
	}
	
	public GamePlayer(String name){
		this.name = name;
		this.mark = name.substring(0, 1);
	}
	
	public String getMark(){
		return mark;
	}
	
	public String toString(){
		return name;
	}
	
	public abstract void move(GameBoard b);
}
