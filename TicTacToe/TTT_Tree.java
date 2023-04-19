import java.util.*;
import java.util.Random;

class TTT_Tree {
  private int[][] board;
  private LinkedList children;
  private TTT_Tree parent;
  private int score;
  private int gScore;
  private int level;
  private Position position;
  
  public TTT_Tree(int[][] board,int level,Position p) {
    this.board = board;
    this.parent = null;
    children = new LinkedList();
    this.level = level;
    this.position = p;
    gScore = 0;
  }
  
  public void addChild(TTT_Tree parent,TTT_Tree child) {
    child.setParent(parent);
    children.add(child);
  }

  public int[][] getBoard() {
    return board;
  }

  
  public Position evaluate(int diffLevel) {
    TTT_Tree[] ranking = new TTT_Tree[children.size()];
    children.toArray(ranking);
    sortScores(ranking); 
    Random gen = new Random();
    if (diffLevel == 2){
        for (int i = 0; i < ranking.length; i++){return ranking[0].getPosition(); }
        //System.out.println("Score for move " + i + "= " + ranking[i].getGlobalScore());
    }
    else if (diffLevel == 1) {
        int r = gen.nextInt(3);
        return ranking[r].getPosition();
    }
    else if (diffLevel == 0) {
        int ii = 0;
        while (ii <= 4){
            int rr = gen.nextInt(3);
            rr += 4;
            ii = rr;
        }
        return ranking[ii].getPosition();
    }
    return null;
  }
  
  public void print() {
    Board.print(board);
    Iterator it = children.iterator();
    while (it.hasNext()) {
      TTT_Tree child = (TTT_Tree)it.next();
      child.print();
    }
    
  }
  public void setParent(TTT_Tree p){
      parent = p;
  }
  public TTT_Tree getParent(){
      return parent;
  }
  public int getLevel() {
    return level;
  }
  public Position getPosition() {
    return position;
  }
  public void setScore(int s) {
    if (level > 1) parent.setScore(s);
    else gScore += s;
  }
  public int getScore() {
    return score;
  }
  public int getGlobalScore() {
    return gScore;
  }
  
  private void sortScores(TTT_Tree[] array){ 
       for (int pass = 1; pass < array.length; pass++){
           for (int e = 0; e < array.length - 1; e++){
               if (array[e].getGlobalScore() < array[e + 1].getGlobalScore()) {
                   swap(array, e, e+1);
               }
           }
       }
   }
   
   private void swap(TTT_Tree[] array1, int a, int b){ 
       try {
       TTT_Tree holder;
       holder = array1[a];
       array1[a] = array1[b];
       array1[b] = holder;
   } catch (Exception e) {;
  }
   }
}
