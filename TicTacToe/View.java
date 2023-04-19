import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class View here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class View extends JFrame {
    private int width = 485;
    private int height = 600;
    private String title = "Ninja Tic-Tac-Toe";
    private aBetterButton  b0,b1,b2,b3,b4,b5,b6,b7,b8,fbutton;
    private Container c;
    private Controller controller;
    private Model model;
    private JLabel label;
    private ImageIcon cWin, hWin;
    
    public View(Controller controller){
        this.controller = controller;
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
        c = getContentPane();
        c.setLayout(null);
        setSize(width,height);
        setTitle(title);
        buildParts();
        setVisible(true);
        cWin = new ImageIcon("computerwin.gif");
        hWin = new ImageIcon("humanwin.gif");
    }
    
    //Sets the pointer to the model.
    public void setModel(Model model){
        this.model = model;
    }
    
    private void buildParts(){
        buildButtons();
        buildMenu();
        label = new JLabel();
        label.setBounds(10,475,525,70);
        label.setText("Select a level to start a new game at any time. Default difficulty is easy");
        c.add(label);
    }
    
    private void buildMenu(){
        JMenuBar mb = new JMenuBar();
        JMenu gm = new JMenu("Game");
        JMenu st = new JMenu("Settings");
        JMenuItem ab = new JMenuItem("About");
        JMenuItem ex = new JMenuItem("Exit");
        JMenuItem es = new JMenuItem("Easy");
        JMenuItem md = new JMenuItem("Medium");
        JMenuItem hd = new JMenuItem("Hard");
        ab.addActionListener(controller);
        ex.addActionListener(controller);
        es.addActionListener(controller);
        md.addActionListener(controller);
        hd.addActionListener(controller);
        es.setToolTipText("If you can breathe, you can beat me.");
        md.setToolTipText("I will not break easily, and I will pounce on your errors");
        hd.setToolTipText("I know what moves you will make, and how to counter them. Your defeat is at hand!");
        gm.add(ab);
        gm.add(ex);
        st.add(es);
        st.add(md);
        st.add(hd);
        mb.add(gm);
        mb.add(st);
        setJMenuBar(mb);
    }
    
    private void buildButtons(){
        b0 = new aBetterButton("0",0,0);
        b1 = new aBetterButton("1",0,1);
        b2 = new aBetterButton("2",0,2);
        b3 = new aBetterButton("3",1,0);
        b4 = new aBetterButton("4",1,1);
        b5 = new aBetterButton("5",1,2);
        b6 = new aBetterButton("6",2,0);
        b7 = new aBetterButton("7",2,1);
        b8 = new aBetterButton("8",2,2);
        b0.setBounds(10,10,150,150);
        b1.setBounds(165,10,150,150);
        b2.setBounds(320,10,150,150);
        b3.setBounds(10,165,150,150);
        b4.setBounds(165,165,150,150);
        b5.setBounds(320,165,150,150);
        b6.setBounds(10,320,150,150);
        b7.setBounds(165,320,150,150);
        b8.setBounds(320,320,150,150);
        b0.addActionListener(controller);
        b1.addActionListener(controller);
        b2.addActionListener(controller);
        b3.addActionListener(controller);
        b4.addActionListener(controller);
        b5.addActionListener(controller);
        b6.addActionListener(controller);
        b7.addActionListener(controller);
        b8.addActionListener(controller);
        c.add(b0);
        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(b4);
        c.add(b5);
        c.add(b6);
        c.add(b7);
        c.add(b8);
    }
    
    //This is a general output manager for any errors that occur.
    public void displayMessage(String msg, String title) {
        JOptionPane.showMessageDialog(null, title, msg, 1);
    }
    
    public void winner(int player){
        if (player == 1){
            removeButtons();
            fbutton = new aBetterButton("hWin",0,0);
            fbutton.setBounds(0,0,480,470);
            fbutton.addActionListener(controller);
            c.repaint();
            c.add(fbutton);
        }else {
            removeButtons();
            fbutton = new aBetterButton("cWin",0,0);
            fbutton.setBounds(0,0,480,470);
            fbutton.addActionListener(controller);
            c.add(fbutton);
            c.repaint();
        }
    }
    
    private void removeButtons(){
        c.remove(b0);
        c.remove(b1);
        c.remove(b2);
        c.remove(b3);
        c.remove(b4);
        c.remove(b5);
        c.remove(b6);
        c.remove(b7);
        c.remove(b8);
    }
        
    
    public void updateButton(int play, int but){
        if (play == 1){
            if (but == 0){b0.setSelected(1);}
            else if  (but == 1){b1.setSelected(1);}
            else if  (but == 2){b2.setSelected(1);}
            else if  (but == 3){b3.setSelected(1);}
            else if  (but == 4){b4.setSelected(1);}
            else if  (but == 5){b5.setSelected(1);}
            else if  (but == 6){b6.setSelected(1);}
            else if  (but == 7){b7.setSelected(1);}
            else if  (but == 8){b8.setSelected(1);}
            
        }else if  (but == 0){b0.setSelected(2);}
            else if  (but == 1){b1.setSelected(2);}
            else if  (but == 2){b2.setSelected(2);}
            else if  (but == 3){b3.setSelected(2);}
            else if  (but == 4){b4.setSelected(2);}
            else if  (but == 5){b5.setSelected(2);}
            else if  (but == 6){b6.setSelected(2);}
            else if  (but == 7){b7.setSelected(2);}
            else if  (but == 8){b8.setSelected(2);}
        }
    
    
    

        
        
}