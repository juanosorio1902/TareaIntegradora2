package model;

import java.util.Random;

public class LinkedMatrix {
	
	private int col;
	private int row;
	private int mirrors;
	private int hidden;
	private String nickname;
	private int shoots;
	private int fails;
	
	
	
	public int getShoots() {
		return shoots;
	}

	public int getFails() {
		return fails;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getHidden() {
		return hidden;
	}

	private Node firstNode;		
	
	public LinkedMatrix(int m, int n, int mirrors) {
		row = m;
		col = n;
		this.mirrors = mirrors;
		hidden = mirrors;
		createMatrix();
		generateRowMirrors(firstNode,this.mirrors);
		
	}

	private void createMatrix() {
        firstNode = new Node(0, 0);
        createRow(0, 0, firstNode);
    }

    private void createRow(int i, int j, Node firstRow) {
    	
        createColumn(i, j+1, firstRow, firstRow.getUpNode());
        if(i+1<row) {
            Node downFirstRow = new Node(i+1, j);
            downFirstRow.setUpNode(firstRow);
            firstRow.setDownNode(downFirstRow);
            createRow(i+1, j, downFirstRow);
        }
    }

    private void createColumn(int i, int j, Node preNode, Node preRow) {
    	
        if(j<col) {
        	Node current = new Node(i, j);
            current.setPreNode(preNode);
            preNode.setNextNode(current);
            
            if(preRow!=null) {
            	preRow = preRow.getNextNode();
            	current.setUpNode(preRow);
            	preRow.setDownNode(current);            	
            	
            }
            createColumn(i,j+1,current,preRow);
            
        }        
        
    }
    public String toString() {
    	String msg;
    	msg = toStringRow(firstNode);
    	return msg;
    	
    }
    private String toStringRow(Node firstRow) {
    	String msg = "";
    	if(firstRow!=null) {
    		msg = toStringCol(firstRow)+"\n";
    		msg += toStringRow(firstRow.getDownNode());
    	}
    	return msg;
    }
    private String toStringCol(Node current) {
    	String msg = "";
    	if(current!=null) {
    		msg = current.toString();
    		msg += toStringCol(current.getNextNode());
    	}
    	return msg;
    }
       
    private int generateRowMirrors(Node current, int n) {
    	if(n>0) {    		
    		n = generateColMirrors(current,n);
    		current = current.getDownNode();
    		if(current!=null) {
    			n = generateRowMirrors(current,n);
    			
    		}
    		else {
    			if(n>0) {
    				current = firstNode;
    				n = generateRowMirrors(current,n);
    			}
    		}
    		
    	}
    	return n;
    	    	
    }
    private int generateColMirrors(Node current, int n) {
    	if(n>0) {
    		Random random = new Random();
    		boolean condition = random.nextBoolean() && !current.getlMirror() && !current.getrMirror();
    		if(condition) {
    			condition = random.nextBoolean();
    			if(condition) {
    				current.setlMirror(true);
    				
    			}
    			else {
    				
    				current.setrMirror(true);
    				
    			}
    			n--;
    		}
    		current = current.getNextNode();
    		if(current!=null) {
    			n = generateColMirrors(current,n);
    			
    		}
    	}
    	return n;
    }
    private Node searchNode(int i, int j) {
        Node current = searchRowsNode(i, j, firstNode);
        return current;
    }

    private Node searchRowsNode(int i, int j, Node current) {
        current = searchColumnsNode(i, j, current);
        if(current.getRow()<i) {
            current = current.getDownNode();
            current = searchRowsNode(i, j, current);
        }
        return current;
    }

    private Node searchColumnsNode(int i, int j, Node current) {
        if(current.getCol()<j) {
            current = current.getNextNode();
            current = searchColumnsNode(i, j, current);
        }
        return current;
    }
    public void laser(int i, int j) {    	
    	Node current = searchNode(i,j);
    	current.setTemp("S");
    	boolean horizontal = true;
    	boolean right = false;
    	boolean down = false;
    	if(i==0 || i+1==row) {
            horizontal = false;
        }
        if(i==0 || j==0) {
            down = true;
            right = true;
        }
        Node finish = shotLaser(horizontal, right, down, current);
        finish.setTemp("E");
        shoots++;
        if(current.equals(finish)) {
        	finish.setTemp("W");
        }
    	
    }
    public Node shotLaser(boolean horizontal, boolean rigth, boolean down, Node current) {
        int i = current.getRow();
        int j = current.getCol();
        if(current.getlMirror()||current.getrMirror()) {
            if(current.getrMirror()) {
                if(horizontal) {
                    if(rigth) {
                        horizontal = false;
                        down = false;
                    } else {
                        horizontal = false;
                        down = true;
                    }
                } else {
                    if(down) {
                        horizontal = true;
                        rigth = false;
                    } else {
                        horizontal = true;
                        rigth = true;
                    }
                }
            } else {
                if(horizontal) {
                    if(rigth) {
                        horizontal = false;
                        down = true;
                    } else {
                        horizontal = false;
                        down = false;
                    }
                } else {
                    if(down) {
                        horizontal = true;
                        rigth = true;
                    } else {
                        horizontal = true;
                        rigth = false;
                    }
                }
            }
            current = chooseDirection(horizontal, rigth, down, current);
        } else{
            current = chooseDirection(horizontal, rigth, down, current);
        }
        if(!(current.getRow()==i&&current.getCol()==j)) {
            current = shotLaser(horizontal, rigth, down, current);
        }
        return current;
    }
    
    
   
    
    private Node chooseDirection(boolean horizontal, boolean rigth, boolean down, Node current) {
		if(!horizontal) {
			if(down) {
				if(current.getDownNode()!=null) {
					return current.getDownNode();
				}
			}
			else {
				if(current.getUpNode()!=null) {
					return current.getUpNode();
				}
				
			}				
			
		}
		else {
			if(!rigth) {
				if(current.getPreNode()!=null) {
					return current.getPreNode();
				}
			}
			else {
				if(current.getNextNode()!=null) {
					return current.getNextNode();
				}
				
			}
			
		}
		return current;
	}
    public void locate(int i, int j, String h) {
    	Node current = searchNode(i,j);
    	if((h.equals("R") && current.getrMirror()) || (h.equals("L") && current.getlMirror())) {
            current.setVisMirror(true);
            hidden--;
        }
    	else {
    		current.setTemp("X");
    		fails++;
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
