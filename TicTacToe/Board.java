import java.util.*;

class Board {

  private static final int NEITHER = 0;
  private static final int HUMAN = 1;
  private static final int COMPUTER = 2;
  private int diffLevel, finalWin;
  private int[][] board;
  private Model model;
  private View view;
  private Controller controller;
  
  
  public Board(Controller controller) {
    this.controller = controller;
    board = new int[3][3];
    clear();
    finalWin = 3;
  }
  
  public void setModel(Model model){
      this.model = model;
  }
  
  public void setView(View view){
      this.view = view;
  }
  
  public void clear() {
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        board[r][c] = NEITHER;
      }
    }
  }
  
  public int winner(int[][] board) {
    int player = HUMAN;
    if (board[0][0] == player && board[0][1] == player && board[0][2] == player) return player;
    else if (board[1][0] == player && board[1][1] == player && board[1][2] == player) return player;
    else if (board[2][0] == player && board[2][1] == player && board[2][2] == player) return player;
    else if (board[0][0] == player && board[1][0] == player && board[2][0] == player) return player;
    else if (board[0][1] == player && board[1][1] == player && board[2][1] == player) return player;
    else if (board[0][2] == player && board[1][2] == player && board[2][2] == player) return player;
    else if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return player;
    else if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return player;
    player = COMPUTER;
    if (board[0][0] == player && board[0][1] == player && board[0][2] == player) return player;
    else if (board[1][0] == player && board[1][1] == player && board[1][2] == player) return player;
    else if (board[2][0] == player && board[2][1] == player && board[2][2] == player) return player;
    else if (board[0][0] == player && board[1][0] == player && board[2][0] == player) return player;
    else if (board[0][1] == player && board[1][1] == player && board[2][1] == player) return player;
    else if (board[0][2] == player && board[1][2] == player && board[2][2] == player) return player;
    else if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return player;
    else if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return player;
    return NEITHER;
  }
  
  private void checkWinner(int[][] board){
      if (finalWin == 3){ 
        if (winner(board)== COMPUTER){
            //view.displayMessage("Game Over","Computer Wins");
            view.winner(2);
            controller.setReady(false);}
        else if (winner(board) == HUMAN){
            //view.displayMessage("Game Over","You Win");
            view.winner(1);
            controller.setReady(false);}
        else if (winner(board) == NEITHER){
            //view.displayMessage("Game Over", "Draw!")
            ;}
      }else { 
          view.displayMessage("Game Over", "Game Over");
          controller.setReady(false);
      }
  }
      
      

  public Position aboutToWin(int[][] board,int player) {
    //System.out.println("ABOUT TO WIN PLAYER = "+player);
    printBoard(board);
    LinkedList avail = generateAvailableList(board);
    if (avail.isEmpty()) return null;
    Iterator it = avail.iterator();
    while (it.hasNext()) {
      Position p = (Position)it.next();
      //System.out.println("POSSIBLE MOVE? "+p);
      int[][] newBoard = clone(board);
      newBoard[p.getRow()][p.getCol()] = player;
      //System.out.println("MADE MOVE");
      printBoard(newBoard);
      if (winner(newBoard) == player) {
        //System.out.println("SHOULD BE A WINNER FOR "+player);
    //System.out.println("\n\n");
        return p;
      }
    }
    //System.out.println("\n\n");
    return null;
  }
  

  public void printBoard(int[][] board) {
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        //System.out.print(board[r][c] + " ");
      }
      //System.out.println();
    }
  }
    
  public LinkedList generateAvailableList(int[][] board) {
    LinkedList list = new LinkedList();
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        if (board[r][c] == NEITHER) list.add(new Position(r,c));
      }
    }
    return list;
  }

  public void humansMove(int r,int c) {
    if (board[r][c] == NEITHER){
        board[r][c] = HUMAN;
        checkWinner(board);
    }else {;}
  }
  
  public void setLevel(int lev){
      diffLevel = lev;
  }
  
  public Position computersMove() {
    Position p = aboutToWin(board,COMPUTER);
    if (p == null) {
      p = aboutToWin(board,HUMAN);
      if (p == null) {
        int[][] board = clone(this.board);
        TTT_Tree root = new TTT_Tree(board,0,null);
        buildSearchTree(root,COMPUTER,1);
        p = root.evaluate(diffLevel);
      }
    }
    //System.out.println("COMPUTERS MOVE SHOULD BE: "+p);
    //root.print();
    return p;
  }
  
  public void makeMoveForComputer(Position p) {
    board[p.getRow()][p.getCol()] = COMPUTER;
    model.computerPick(p.getRow(),p.getCol());
    checkWinner(board);
    
  }
  
  public int[][] clone(int[][] board) {
    int[][] newBoard = new int[3][3];
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        newBoard[r][c] = board[r][c];
      }
    }
    return newBoard;
  }

  public static void print(int[][] board) {
    //for (int r = 0; r < 3; r++) {
    //  for (int c = 0; c < 3; c++) {
    //    System.out.print(board[r][c] + " ");
    // }
    //  System.out.println();
    //}
  }

  public Position buildSearchTree(TTT_Tree root,int player,int level) {
    //System.out.println("ROOT = ");
    //print(root.getBoard());
    
    if (winner(root.getBoard()) == HUMAN) {
      //System.out.println("Human Wins");
      root.setScore(-1);
      return null;
    }
    
    if (winner(root.getBoard()) == COMPUTER) {
      //System.out.println("Computer Wins");
      root.setScore(1);
      return null;
      /*
      while (root.getLevel() != 1) {
        root = root.getParent();
      }
      Position p = root.getPosition();
      return p;
      */
    }
    
    LinkedList avail = generateAvailableList(root.getBoard());
    //System.out.println("Available Moves: " + avail);
    if (avail.isEmpty()) {
      // 'root' is a leaf node
      //System.out.println("Draw");
      root.setScore(0);
      return null;
    }
    Iterator it = avail.iterator();
    while (it.hasNext()) {
      Position p = (Position)it.next();
      int[][] newBoard = clone(root.getBoard());
      newBoard[p.getRow()][p.getCol()] = player;
      //System.out.println("Making move "+player+" at "+p.getRow()+" "+p.getCol());
      TTT_Tree move = new TTT_Tree(newBoard,level,p);
      root.addChild(root,move);
      if (player == COMPUTER) {
        Position p2 = buildSearchTree(move,HUMAN,level+1);
        //if (p2 != null) return p2;
      } else {
        Position p2 = buildSearchTree(move,COMPUTER,level+1);
        //if (p2 != null) return p2;
      }
    }
    //System.out.println("No more available moves from this board position");
    return null;
  }
  
  
  /*public int findMove(int player) {
    System.out.println("In findMove(), player = " + player);
    if (winner(board) != NEITHER) {
      System.out.println("Winner = " + winner());
      return winner();
    }
    LinkedList avail = generateAvailableList();
    System.out.println("Available Moves: " + avail);
    Iterator it = avail.iterator();
    
    while (it.hasNext()) {
      Position p = (Position)it.next();
      
      board[p.getRow()][p.getCol()] = player;
      int w;
      if (player == COMPUTER) w = findMove(HUMAN);
      else w = findMove(COMPUTER);
      if (w == HUMAN) {
        board[p.getRow()][p.getCol()] = NEITHER;
      } else if (w == COMPUTER) {
        return COMPUTER;
      }
    }
    return NEITHER;
  }
  */
  
}

