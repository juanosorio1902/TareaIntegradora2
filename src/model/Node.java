package model;

public class Node {
	
	private int row;
	private int col;
	private boolean lMirror;
	private boolean rMirror;
	private boolean visMirror;
	private Node upNode;
	private Node downNode;
	private Node preNode;
	private Node nextNode;
	private String temp;
	
	
	public Node(int r, int c) {
		row = r;
		col = c;
		lMirror = false;
		rMirror = false;
		visMirror = false;
		temp = "";
		
	}


	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getCol() {
		return col;
	}


	public void setCol(int col) {
		this.col = col;
	}


	public boolean getlMirror() {
		return lMirror;
	}


	public void setlMirror(boolean lMirror) {
		this.lMirror = lMirror;
	}


	public boolean getrMirror() {
		return rMirror;
	}


	public void setrMirror(boolean rMirror) {
		this.rMirror = rMirror;
	}


	public boolean getVisMirror() {
		return visMirror;
	}


	public void setVisMirror(boolean visMirror) {
		this.visMirror = visMirror;
	}
	public Node getUpNode() {
		return upNode;
	}

	public void setUpNode(Node upNode) {
		this.upNode = upNode;
	}

	public Node getDownNode() {
		return downNode;
	}

	public void setDownNode(Node downNode) {
		this.downNode = downNode;
	}

	public Node getPreNode() {
		return preNode;
	}

	public void setPreNode(Node preNode) {
		this.preNode = preNode;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	public String toString() {
		if(!temp.equals("")) {
			String aux = "["+temp+"]";
			temp = "";
			return aux;
		}
		else if(visMirror) {
			if(lMirror) {
				return "[\\]";
				
			}
			else {
				return "[/]";		
				
			}
		
		}
		else {
			return "[ ]";
		}
	}


	public void setTemp(String temp) {
		this.temp = temp;
	}

	

}
