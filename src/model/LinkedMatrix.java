package model;

public class LinkedMatrix {
	
	private int col;
	private int row;
	private int mirrors;
	
	
	private Node firstNode;		
	

	private void createMatrix() {
        firstNode = new Node(0, 0);
        createRow(0, 0, firstNode);
    }

    private void createRow(int i, int j, Node firstRow) {
        createColumn(i, j+1, firstRow);
        if(i+1<row) {
            Node downFirstRow = new Node(i+1, j);
            downFirstRow.setUpNode(firstRow);
            firstRow.setDownNode(downFirstRow);
            createRow(i+1, j, downFirstRow);
        }
    }

    private void createColumn(int i, int j, Node preNode) {
        if(j<col) {
            Node current = new Node(i, j);
            current.setPreNode(preNode);
            preNode.setNextNode(current);
            createColumn(i, j+1, current);
        }
    }
      
    
   
    
    public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getMirrors() {
		return mirrors;
	}

	public void setMirrors(int mirrors) {
		this.mirrors = mirrors;
	}

	


}
