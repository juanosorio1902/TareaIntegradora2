package model;

public class Positions {
    private Root first;
    private int position;
    private String msg;

    public Positions() {
    	first = null;
    }

    public void add(String nickname, int score, int row, int col, int mirrors) {
        Root current = new Root(nickname, score, row, col, mirrors);
        if(first==null) {
        	first = current;
        } else {
            add(first, current);
        }
    }

    private void add(Root current, Root nextCurrent) {
        if(current.getScore()>nextCurrent.getScore()) {
            if(current.getLeft()==null) {
                current.setLeft(nextCurrent);
                nextCurrent.setFather(current);
            } else {
                add(current.getLeft(), nextCurrent);
            }
        } else {
            if(current.getRight()==null) {
                current.setRight(nextCurrent);
                nextCurrent.setFather(current);
            } else {
                add(current.getRight(), nextCurrent);
            }
        }
    }
    @Override
    public String toString() {
    	msg = "";
        position = 1;
        print(first);
        return msg;
    }
   
    private void print(Root current) {
            if(current!=null) {
                print(current.getLeft());
                msg += "\n"+position+". "+current.getNickname()+": "+current.getScore()+" points. Matrix: "+current.getRows()+"x"+current.getCols()+" and "+current.getMirrors()+" mirrors";
                position++;
                print(current.getRight());
            }
         
    }
    
  


}