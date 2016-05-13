import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import javax.swing.*;
import java.awt.Font; 
import java.applet.*;
import java.net.*;

public class Sudoku extends Applet implements ActionListener, MouseListener, MouseMotionListener
{
    private int screen;
    private int num;
    private int mouseX,mouseY;
    private int selection;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private TextField textField1;
    private TextField textField2;
    private TextField textField3;
    private Choice drop = new Choice();
    private Choice drop2 = new Choice();
    private Choice drop3 = new Choice();
    private int[][] puzzleArray=new int[9][9];
    private Puzzle puz=new Puzzle();
    public void init()
    { 
        screen = 0;
        setSize(775,585);
        selection = 0;
        num = 1;
        button1 = new Button("START");
        add(button1);
        button1.addActionListener(this);
        button2 = new Button("RESTART");
        add(button2);
        button2.addActionListener(this); 
        button3 = new Button("SUBMIT");
        add(button3);
        button3.addActionListener(this);

        button4 = new Button("PLAY");
        add(button4);
        button4.addActionListener(this);

        button5 = new Button("ENTER");
        add(button5);
        button5.addActionListener(this);

        button6 = new Button("Back To Instructions >>>");
        add(button6);
        button6.addActionListener(this);
        //         textField1 = new TextField("ROW HERE ");
        //         add(textField1);
        //         textField2 = new TextField("COLUMN HERE ");
        //         add(textField2);
        //         textField3 = new TextField("NUMBER HERE");
        //         add(textField3);
        drop.addItem("1");
        drop.addItem("2");
        drop.addItem("3");
        drop.addItem("4");
        drop.addItem("5");
        drop.addItem("6");
        drop.addItem("7");
        drop.addItem("8");
        drop.addItem("9");
        add(drop);
        drop2.addItem("1");
        drop2.addItem("2");
        drop2.addItem("3");
        drop2.addItem("4");
        drop2.addItem("5");
        drop2.addItem("6");
        drop2.addItem("7");
        drop2.addItem("8");
        drop2.addItem("9");
        add(drop2);
        drop3.addItem("1");
        drop3.addItem("2");
        drop3.addItem("3");
        drop3.addItem("4");
        drop3.addItem("5");
        drop3.addItem("6");
        drop3.addItem("7");
        drop3.addItem("8");
        drop3.addItem("9");
        add(drop3);
        puzzleArray=puz.getPuzzle();
    }

    public void mouseExited(MouseEvent me)
    {

    }

    public void mouseEntered(MouseEvent me)
    {

    }

    public void mouseReleased(MouseEvent me)
    {

    }

    public void mousePressed(MouseEvent me)
    {
        mouseX=me.getX();
        mouseY=me.getY();
        repaint();
    }

    public void mouseClicked(MouseEvent me)
    {

    }

    public void mouseMoved(MouseEvent me)
    {

    }

    public void mouseDragged(MouseEvent me)
    {

    }

    public void actionPerformed(ActionEvent ae) {
        selection = 0;

        if(ae.getSource().equals(button4)){
            selection = 4;
        }
        if(ae.getSource().equals(button1)){
            selection = 1;
        }
        if(ae.getSource().equals(button6)){
            selection = 6;
        }
        if(ae.getSource().equals(button2)){
            selection = 2;
        }
        repaint(); 
    }

    public void paint(Graphics g)
    {   
        if(screen == 0)
        {
            g.setColor(Color.BLACK);
            g.setFont(new Font("TimesRoman", Font.BOLD, 42)); 
            g.drawString("INSTRUCTIONS",35,36);
            g.drawString("INSTRUCTIONS",35,35);
            g.drawString("INSTRUCTIONS",36,35);
            g.drawString("INSTRUCTIONS",35,35);

            button1.setLocation(11110, 553);
            button2.setLocation(21150, 553);
            button3.setLocation(61112, 190);
            button6.setLocation(61112, 190);
            button5.setLocation(61112, 190);
            drop.setLocation(11650,230);
            drop2.setLocation(11650,270);
            drop3.setLocation(11650,310);

            g.setFont(new Font("TimesRoman", Font.BOLD, 20)); 
            g.drawString("|[1]| If you do not know how to play sudoku please learn and then come back",35,100);
            g.drawString("|[2]| Click >Start< in order to start a new game",35,150);
            g.drawString("|[3]| If you want to restart click >restart<",35,200);
            g.drawString("|[4]| Choose the row and column that correspond to the board and enter your number",35,250);
            g.drawString("|[5]| Click >Enter< to sumbit the number",35,300);
            g.drawString("|[6]| To Sumbit and check your puzzle click >Submit<",35,350);
            setSize(775,375);
            button4.setLocation(650, 10);
            
            if(selection == 4)
            {
                screen = 1;
            }

        }
        if(screen == 1)
        {
            button4.setLocation(611150, 10);
            setSize(775,585);
            g.setColor(Color.WHITE);
            g.fillRect(0,0,10000,10000);
            g.setColor(Color.BLACK);
            g.drawRect(100,100,450,450);
            for(int x = 150; x <= 550; x += 50)
            {
                g.drawLine(x,100,x,550);
            }
            for(int x = 150; x <= 550; x += 50)
            {
                g.drawLine(100,x,550,x);
            }

            for(int x = 251; x <= 501; x += 150)
            {
                g.drawLine(x,100,x,550);
            }

            for(int x = 251; x <= 501; x += 150)
            {
                g.drawLine(100,x,550,x);
            }

            for(int x = 252; x <= 502; x += 150)
            {
                g.drawLine(x,100,x,550);
            }

            for(int x = 252; x <= 502; x += 150)
            {
                g.drawLine(100,x,550,x);
            }
            g.setColor(Color.BLACK);
            num = 1;
            for(int x = 105; x < 555; x+= 50)
            {
                g.drawString("Row " + num, x,95);
                num++;
            }
            num = 1;
            for(int x = 130; x < 560; x+= 50)
            {
                g.drawString("Column " + num, 30,x);
                num++;
            }
            g.drawLine(100,101,550,101);
            g.drawLine(99,101,550,101);
            g.drawLine(100,549,550,549);
            g.drawLine(549,100,549,549);
            g.drawLine(100,100,100,549);
            g.setColor(Color.BLACK);

            g.drawString("By: Jovan, John, Ronan, and Miki",65,60);
            button1.setLocation(465, 15);
            button2.setLocation(550, 15);
            button3.setLocation(650, 15);
            button5.setLocation(600, 350);
            button6.setLocation(560, 550);
            //             this.textField1.setLocation(455, 130);
            //             this.textField2.setLocation(560, 130);
            //             this.textField3.setLocation(506, 170);

            
            g.setFont(new Font("TimesRoman", Font.BOLD, 20)); 
            g.drawString("Row:",600,150);
            drop.setLocation(650,130);

            g.drawString("Column:",565,230);
            drop2.setLocation(650,210);

            g.drawString("Number:",565,310);
            drop3.setLocation(650,290);

            g.setFont(new Font("TimesRoman", Font.BOLD, 42)); 
            g.drawString("Welcome to Sudoku",35,36);
            g.drawString("Welcome to Sudoku",35,35);
            g.drawString("Welcome to Sudoku",36,35);
            g.drawString("Welcome to Sudoku",35,35);
            g.setColor(Color.RED);
            g.drawLine(35,40,400,40);
            g.setColor(Color.BLACK);
            g.drawLine(36,39,399,39);
            g.setColor(Color.RED);
            g.drawLine(34,41,401,41);
            g.setColor(Color.BLACK);
            g.drawLine(33,42,402,42);
            g.setFont(new Font("TimesRoman", Font.BOLD, 30)); 
            //             g.drawString("5", 118,135);
            //             g.drawString("5", 118,185);
            //             g.drawString("5", 168,135);
            if(selection == 6)
            {
                screen = 0;
            }

            if(selection == 1)
            {
                int x=118;
                int y=135;
                for(int r=0; r<9; r++)
                {
                    for(int c=0; c<9; c++)
                    {
                        if(puzzleArray[r][c]!=0)
                        {
                            g.drawString(""+puzzleArray[r][c], x, y);
                        }
                        x+=50;
                    }
                    x=118;
                    y+=50;
                }
            }
            if(selection == 2 )
            {
                puzzleArray=puz.getPuzzle();
            }
            if(selection == 3)
            {
                //check the userArray and the solution array using ronans checker class
            }

            //ctr + space
        }
    }
}