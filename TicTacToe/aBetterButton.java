/**
 * FILE: aBetterButton.java
 * AUTHOR: Josh Hilliard (hilliardj@rockhurst.edu)
 * DATE: 11-4-04
 * DESCR: aBetterButton encapsulates the JButton class but adds a variable that is set at
 * button creation and can be used to identify that button later.
 */

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane.*;
import javax.swing.ImageIcon;

public class aBetterButton extends JButton {
    private String alias; //Variable to ID any button.
    private ImageIcon xicon, oicon, cWin, hWin;
    private boolean select;
    private int selection, row, col;
    
    public aBetterButton(String alias, int r, int c){
        //super(s);
        this.alias = alias;
        xicon = new ImageIcon("x.gif");
        oicon = new ImageIcon("o.gif");
        cWin = new ImageIcon("cWin.gif");
        hWin = new ImageIcon("hWin.gif");
        setBackground(Color.WHITE);
	    select = false;
	    row = r;
	    col = c;
	    if (alias.equals("cWin")){
	        setIcon(cWin);
	    }else if (alias.equals("hWin")){
	        setIcon(hWin);
	    }else{;}
    }
    
    
    //Accessor for the alias variable
    public String getAlias(){
        return alias;
    }
    
    public boolean checkSelected(){
        return select;
    }
    
    public int getRow(){
        return row;
    }
    
    public int getCol(){
        return col;
    }
    
    
    public void setSelected(int sel){
	  select = true;
        selection = sel;
        if (sel == 1){
            setIcon(xicon);
        }
        if (sel == 2) {
            setIcon(oicon);
        }else {;}
    }
    
    
  }  