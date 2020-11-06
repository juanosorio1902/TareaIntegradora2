package model;

public class PositionsTable {
    private Score root;

    public PositionsTable() {
        root = null;
    }

    public void addScore(String name, int qualification, int n, int m, int k) {
        Score newScore = new Score(name, qualification, n, m, k);
        if(root==null) {
            root = newScore;
        } else {
            addScore(root, newScore);
        }
    }

    private void addScore(Score current, Score newScore) {
        if(current.getScore()>newScore.getScore()) {
            if(current.getLeft()==null) {
                current.setLeft(newScore);
                newScore.setFather(current);
            } else {
                addScore(current.getLeft(), newScore);
            }
        } else {
            if(current.getRight()==null) {
                current.setRight(newScore);
                newScore.setFather(current);
            } else {
                addScore(current.getRight(), newScore);
            }
        }
    }


}