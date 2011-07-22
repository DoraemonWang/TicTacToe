package com.saharmassachi.ttt.java;

import java.util.ArrayList;

public class MoveNode {
	private ArrayList<MoveNode> children;
	//these aren't moves. These are states of the board.
	int wins = 0;
	int lost = 0;
	int tie = 0; 
	int moveacross;
	int movedown;
	GameBoard board;
	MoveNode parent;
	//^^ these are for non-leaf nodes that tally up the wins/losses/ties of their children.
	
	public MoveNode(GameBoard b){
		children = new ArrayList<MoveNode>();
		board = b;
		//this should only be used for the root node.
	}
	
	//takes in a gameboard representing the state of the game if you make move m1,m2
	public MoveNode(GameBoard b, int m1, int m2, MoveNode parent){
		children = new ArrayList<MoveNode>();
		board = b;
		movedown = m1;
		moveacross = m2;
		this.parent = parent;
	};
	
	public void addChild(MoveNode n){
		children.add(n);
	}
	
	public boolean isLeaf(){
		if(children.isEmpty()) return true;
		return false;
	}
	public ArrayList<MoveNode> getChildren(){
		return children;
	}
	
	public GameBoard getBoard(){
		return board;
	}
	
	public void tellParent(){
		if (parent == null){
			return;
		}
		else{
			parent.wins += wins;
			parent.lost += lost;
			parent.tie += tie;
			parent.tellParent();
		}
	}

}
