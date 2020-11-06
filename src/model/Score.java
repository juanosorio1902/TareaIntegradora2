package model;

public class Score {

    private String userName;
    private int score;
    private int cols;
    private int rows;
    private int mirrors;

    private Score father;
    private Score right;
    private Score left;

    public Score(String user, int s, int c, int r, int m) {
        userName = user;
        score = s;
        cols = c;
        rows = r;
        mirrors = m;
    }

    public Score getFather() {
        return father;
    }

    public void setFather(Score f) {
        father = f;
    }

    public Score getRight() {
        return right;
    }

    public void setRight(Score r) {
        right = r;
    }

    public Score getLeft() {
        return left;
    }

    public void setLeft(Score l) {
        left = l;
    }

    public int getScore() {
        return score;
    }

    public String getUserName() {
        return userName;
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