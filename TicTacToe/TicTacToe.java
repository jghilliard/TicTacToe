import java.util.*;

class TicTacToe {
    private Controller controller;

  public static void main(String[] args) {
    new TicTacToe().run(0);
  }
  
  public void run(int lev) {
    controller = new Controller(this, lev);
  }
  
}
