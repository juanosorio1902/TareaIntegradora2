package model;

public class Root {

    private String nickname;
    private int score;
    private int cols;
    private int rows;
    private int mirrors;

    private Root father;
    private Root right;
    private Root left;

    public Root(String user, int s, int r, int c, int m) {
        nickname = user;
        score = s;        
        rows = r;
        cols = c;
        mirrors = m;
    }

    public Root getFather() {
        return father;
    }

    public void setFather(Root f) {
        father = f;
    }

    public Root getRight() {
        return right;
    }

    public void setRight(Root r) {
        right = r;
    }

    public Root getLeft() {
        return left;
    }

    public void setLeft(Root l) {
        left = l;
    }

    public int getScore() {
        return score;
    }

    public String getNickname() {
        return nickname;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getMirrors() {
        return mirrors;
    }
}