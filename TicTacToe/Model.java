
/**
 * Write a description of class Model here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Model {
    private int x;
    private Controller controller;
    private Board board;
    private View view;
    
    public Model(Controller controller, Board board) {
        this.controller = controller;
        this.board = board;
    }
    
    public void setView(View view){
       this.view = view;
   }
   
   public void run(int lev){
       board.setLevel(lev);
   }
   
   public void humanPick(int pos){
       if (pos == 0) {board.humansMove(0,0);
           board.makeMoveForComputer(board.computersMove());}
       else if (pos == 1){board.humansMove(0,1);
           board.makeMoveForComputer(board.computersMove());}
       else if (pos == 2){board.humansMove(0,2);
           board.makeMoveForComputer(board.computersMove());}
       else if (pos == 3){board.humansMove(1,0);
           board.makeMoveForComputer(board.computersMove());}
       else if (pos == 4){board.humansMove(1,1);
          board.makeMoveForComputer(board.computersMove());}
       else if (pos == 5){board.humansMove(1,2);
          board.makeMoveForComputer(board.computersMove());}
       else if (pos == 6){board.humansMove(2,0);
          board.makeMoveForComputer(board.computersMove());}
       else if (pos == 7){board.humansMove(2,1);
          board.makeMoveForComputer(board.computersMove());}
       else if (pos == 8){board.humansMove(2,2);
          board.makeMoveForComputer(board.computersMove());}
   }
   
   public void computerPick(int row, int col){
       int pos = -1;
       if (row == 0 && col == 0){pos = 0;}
        else if (row == 0 && col == 1){pos = 1;}
        else if (row == 0 && col == 2){pos = 2;}
        else if (row == 1 && col == 0){pos = 3;}
        else if (row == 1 && col == 1){pos = 4;}
        else if (row == 1 && col == 2){pos = 5;}
        else if (row == 2 && col == 0){pos = 6;}
        else if (row == 2 && col == 1){pos = 7;}
        else if (row == 2 && col == 2){pos = 8;}
       
       if (pos == 0) {view.updateButton(2,0);}
        else if (pos == 1){view.updateButton(2,1);}
        else if (pos == 2){view.updateButton(2,2);}
        else if (pos == 3){view.updateButton(2,3);}
        else if (pos == 4){view.updateButton(2,4);}
        else if (pos == 5){view.updateButton(2,5);}
        else if (pos == 6){view.updateButton(2,6);}
        else if (pos == 7){view.updateButton(2,7);}
        else if (pos == 8){view.updateButton(2,8);}
   }
       
}
