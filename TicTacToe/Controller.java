
/**
 * Write a description of class Controller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.ButtonGroup.*;


public class Controller implements ActionListener {

    private View view;
    private Model model;
    private String alias;
    private TicTacToe ttt;
    private Board board;
    private int lev;
    private boolean ready;
    
    public Controller(TicTacToe ttt, int lev){
        this.ttt = ttt;
        this.lev = lev;
        board = new Board(this);
        board.setLevel(lev);
        view = new View(this);
        model = new Model(this, board);
        board.setModel(model);
        board.setView(view);
        view.setModel(model);
        model.setView(view);
        ready = true;
    }
    
     //what kind of action was performed and route it to the correct result.
  public void actionPerformed(ActionEvent e){
      String actionCommand = e.getActionCommand();
      try {
        if (e.getSource() instanceof JMenuItem) {
          if (actionCommand.equals("About")){actions(0);}
          else if (actionCommand.equals("Exit")){actions(1);}
          else if (actionCommand.equals("Easy")){actions(2);}
          else if (actionCommand.equals("Medium")){actions(3);}
          else if (actionCommand.equals("Hard")){actions(4);}
       } else {
          aBetterButton be = (aBetterButton)e.getSource();
          alias = be.getAlias();
          if(ready){
          if (be.checkSelected()){;}
          else{
            if (alias.equals("0")) {actions(5);}
            else if (alias.equals("1")) {actions(6);}
            else if (alias.equals("2")) {actions(7);}
            else if (alias.equals("3")) {actions(8);}
            else if (alias.equals("4")) {actions(9);}
            else if (alias.equals("5")) {actions(10);}
            else if (alias.equals("6")) {actions(11);}
            else if (alias.equals("7")) {actions(12);}
            else if (alias.equals("8")) {actions(13);}
          }
     } else {;}
     }
       } catch (Exception newE) {;}
   }
   
   public void setReady(boolean a){
       ready = a;
   }
   
   //actions() method is the method that actually sorts out what to do
    //with an action event.
  public void actions(int num) throws Exception{
      if (num == 0){
         view.displayMessage( "About Ninja Tic-Tac-Toe","Josh Hilliard:2004");
      }else if (num == 1){
          System.exit(0);
      }else if (num == 2){
         view.dispose();
         ttt.run(0);
      }else if (num == 3){
         view.dispose();
         ttt.run(1);
      }else if (num == 4){
         view.dispose();
         ttt.run(2);
      }else if (num == 5){
              view.updateButton(1,0);
              model.humanPick(0);
      }else if (num == 6){
          view.updateButton(1,1);
	    model.humanPick(1);
      }else if (num == 7){
	    view.updateButton(1,2);
          model.humanPick(2);
          
      }else if (num == 8){
	    view.updateButton(1,3);
          model.humanPick(3);
          
      }else if (num == 9){
          view.updateButton(1,4);
          model.humanPick(4);
          
      }else if (num == 10){
          view.updateButton(1,5);
          model.humanPick(5);
          
      }else if (num == 11){
          view.updateButton(1,6);
          model.humanPick(6);
          
      }else if (num == 12){
          view.updateButton(1,7);
          model.humanPick(7);
          
      }else if (num == 13){
          view.updateButton(1,8);
          model.humanPick(8);
          
      }
      }
  }






