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
    private Button playBtn;
    private Button startBtn;
    private Button enterBtn;
    private Button restartBtn;
    private Button submitBtn;
    private boolean gameStarted;
    private boolean enterAllowed;
    private boolean canReset;
    private boolean checkWin;
    private Choice drop = new Choice();
    private Choice drop2 = new Choice();
    private Choice drop3 = new Choice();
    private int[][] puzzleArray=new int[9][9];
    private int[][] restartArray = new int[9][9];
    private int[][] solutionArray = new int[9][9];
    private Puzzle puz=new Puzzle();
    private boolean[][] takenSpot = new boolean[9][9];
    private int selRow;
    private int selCol;
    private int selNum;
    private int selCol1;
    private int selRow1;
    private int count;
    private AudioClip song;
    private URL songPath;
    private boolean solvedPuzzle;
    public class Sound // Holds one audio file
    {
        private AudioClip song; // Sound player
        private URL songPath; // Sound path
        Sound(String filename)
        {
            try
            {
                songPath = new URL(getCodeBase(),filename); // Get the Sound URL
                song = Applet.newAudioClip(songPath); // Load the Sound
            }
            catch(Exception e){} // Satisfy the catch
        }

        public void playSound()
        {
            song.loop(); // Play 
        }

        public void stopSound()
        {
            song.stop(); // Stop
        }

        public void playSoundOnce()
        {
            song.play(); // Play only once
        }
    }
    public void init()
    { 
        screen = 0;
        setSize(775,585);
        selection = 0;
        num = 1;
        solvedPuzzle = false;

        playBtn = new Button("PLAY");
        add(playBtn);
        playBtn.addActionListener(this); 

        startBtn = new Button("START");
        add(startBtn);
        startBtn.addActionListener(this);

        enterBtn = new Button("ENTER");
        add(enterBtn);
        enterBtn.addActionListener(this);

        restartBtn = new Button("RESTART");
        add(restartBtn);
        restartBtn.addActionListener(this);

        submitBtn = new Button("SUBMIT");
        add(submitBtn);
        submitBtn.addActionListener(this);

        drop.addItem("1r");
        drop.addItem("2r");
        drop.addItem("3r");
        drop.addItem("4r");
        drop.addItem("5r");
        drop.addItem("6r");
        drop.addItem("7r");
        drop.addItem("8r");
        drop.addItem("9r");
        add(drop);
        drop2.addItem("1c");
        drop2.addItem("2c");
        drop2.addItem("3c");
        drop2.addItem("4c");
        drop2.addItem("5c");
        drop2.addItem("6c");
        drop2.addItem("7c");
        drop2.addItem("8c");
        drop2.addItem("9c");
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
        takenSpot = puz.preTaken(puzzleArray);
        restartArray = puzzleArray.clone();
        solutionArray = puz.chooseSolution(puzzleArray);
        Sound testsong = new Sound("1Relaxing Instrumental Music- soft & calm background music - relaxdaily N°080.mp3.mid");
        testsong.playSoundOnce();
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

        if(ae.getSource().equals(playBtn)){
            screen = 1;
            enterAllowed = false;
        }
        if(ae.getSource().equals(startBtn))
        {
            selection = 1;
            gameStarted=true;
            enterAllowed = false;
        }
        if(ae.getSource().equals(enterBtn))
        {
            selection = 1;
            screen = 1;
            canReset = false;
            enterAllowed = true;
        }
        if(ae.getSource().equals(restartBtn))
        {
            canReset = true;
            if(gameStarted == true)
            {
                selection = 1;
            }
        }
        if(ae.getSource().equals(submitBtn))
        {
            selection = 1;
            checkWin = true;
        }
        repaint(); 
    }

    public void paint(Graphics g)
    {   
        if(screen == 0)
        {
            startBtn.setLocation(-100,-100);
            enterBtn.setLocation(-100,-100);
            submitBtn.setLocation(-100,-100);
            restartBtn.setLocation(-100,-100);
            drop.setLocation(-100,-100);
            drop2.setLocation(-100,-100);
            drop3.setLocation(-100,-100);
            g.setColor(Color.BLACK);
            g.setFont(new Font("TimesRoman", Font.BOLD, 42)); 
            g.drawString("INSTRUCTIONS",35,36);
            g.drawString("INSTRUCTIONS",35,35);
            g.drawString("INSTRUCTIONS",36,35);
            g.drawString("INSTRUCTIONS",35,35);

            g.setFont(new Font("TimesRoman", Font.BOLD, 20)); 
            g.drawString("|[1]| If you do not know how to play sudoku please learn and then come back",35,100);
            g.drawString("|[2]| Click >Start< in order to start a new game",35,150);
            g.drawString("|[3]| If you want to restart click >restart<",35,200);
            g.drawString("|[4]| Choose the row and column that correspond to the board and enter your number",35,250);
            g.drawString("|[5]| Click >Enter< to sumbit the number",35,300);
            g.drawString("|[6]| To Sumbit and check your puzzle click >Submit<",35,350);
            setSize(775,375);
            playBtn.setLocation(650, 10);

        }
        if(screen == 1)
        {
            playBtn.setLocation(-100,-100);
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
                g.drawString("Col " + num + "c", x,95);
                num++;
            }
            num = 1;
            for(int x = 130; x < 560; x+= 50)
            {
                g.drawString("Row " + num + "r", 30,x);
                num++;
            }
            g.drawLine(100,101,550,101);
            g.drawLine(99,101,550,101);
            g.drawLine(100,549,550,549);
            g.drawLine(549,100,549,549);
            g.drawLine(100,100,100,549);
            g.setColor(Color.BLACK);

            g.drawString("By: Jovan, John, Ronan, and Miki",65,60);

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

            startBtn.setLocation(465, 15);
            enterBtn.setLocation(600, 350);
            restartBtn.setLocation(550, 15);
            submitBtn.setLocation(650,15);
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

                if(enterAllowed == true)
                {
                    selNum = 0;
                    selRow = 0;
                    selCol = 0;
                    selRow1 = 0;
                    selCol1 = 0;
                    if(drop.getSelectedItem().equals("1r"))
                    {
                        selRow = 0;
                    }
                    else if(drop.getSelectedItem().equals("2r"))
                    {
                        selRow = 1;
                    }
                    else if(drop.getSelectedItem().equals("3r"))
                    {
                        selRow = 2;
                    }
                    else if(drop.getSelectedItem().equals("4r"))
                    {
                        selRow = 3;
                    }
                    else if(drop.getSelectedItem().equals("5r"))
                    {
                        selRow = 4;
                    }
                    else if(drop.getSelectedItem().equals("6r"))
                    {
                        selRow = 5;
                    }
                    else if(drop.getSelectedItem().equals("7r"))
                    {
                        selRow = 6;
                    }
                    else if(drop.getSelectedItem().equals("8r"))
                    {
                        selRow = 7;
                    }
                    else if(drop.getSelectedItem().equals("9r"))
                    {
                        selRow = 8;
                    }

                    if(selRow == 0)
                    {
                        selRow1 = 118;
                    }
                    else if(selRow == 1)
                    {
                        selRow1 = 168;
                    }
                    else if(selRow == 2)
                    {
                        selRow1 = 218;
                    }
                    else if(selRow == 3)
                    {
                        selRow1 = 268;
                    }
                    else if(selRow == 4)
                    {
                        selRow1 = 318;
                    }
                    else if(selRow == 5)
                    {
                        selRow1 = 368;
                    }
                    else if(selRow == 6)
                    {
                        selRow1 = 418;
                    }
                    else if(selRow == 7)
                    {
                        selRow1 = 468;
                    }
                    else if(selRow == 8)
                    {
                        selRow1 = 518;
                    }

                    if(drop2.getSelectedItem().equals("1c"))
                    {
                        selCol = 0;
                    }
                    else if(drop2.getSelectedItem().equals("2c"))
                    {
                        selCol = 1;
                    }
                    else if(drop2.getSelectedItem().equals("3c"))
                    {
                        selCol = 2;
                    }
                    else if(drop2.getSelectedItem().equals("4c"))
                    {
                        selCol = 3;
                    }
                    else if(drop2.getSelectedItem().equals("5c"))
                    {
                        selCol = 4;
                    }
                    else if(drop2.getSelectedItem().equals("6c"))
                    {
                        selCol = 5;
                    }
                    else if(drop2.getSelectedItem().equals("7c"))
                    {
                        selCol = 6;
                    }
                    else if(drop2.getSelectedItem().equals("8c"))
                    {
                        selCol = 7;
                    }
                    else if(drop2.getSelectedItem().equals("9c"))
                    {
                        selCol = 8;
                    }

                    if(selCol == 0)
                    {
                        selCol1 = 135;
                    }
                    else if(selCol == 1)
                    {
                        selCol1 = 185;
                    }
                    else if(selCol == 2)
                    {
                        selCol1 = 235;
                    }
                    else if(selCol == 3)
                    {
                        selCol1 = 285;
                    }
                    else if(selCol == 4)
                    {
                        selCol1 = 335;
                    }
                    else if(selCol == 5)
                    {
                        selCol1 = 385;
                    }
                    else if(selCol == 6)
                    {
                        selCol1 = 435;
                    }
                    else if(selCol == 7)
                    {
                        selCol1 = 485;
                    }
                    else if(selCol == 8)
                    {
                        selCol1 = 535;
                    }

                    if(drop3.getSelectedItem().equals("1"))
                    {
                        selNum = 1;
                    }
                    else if(drop3.getSelectedItem().equals("2"))
                    {
                        selNum = 2;
                    }
                    else if(drop3.getSelectedItem().equals("3"))
                    {
                        selNum = 3;
                    }
                    else if(drop3.getSelectedItem().equals("4"))
                    {
                        selNum = 4;
                    }
                    else if(drop3.getSelectedItem().equals("5"))
                    {
                        selNum = 5;
                    }
                    else if(drop3.getSelectedItem().equals("6"))
                    {
                        selNum = 6;
                    }
                    else if(drop3.getSelectedItem().equals("7"))
                    {
                        selNum = 7;
                    }
                    else if(drop3.getSelectedItem().equals("8"))
                    {
                        selNum = 8;
                    }
                    else if(drop3.getSelectedItem().equals("9"))
                    {
                        selNum = 9;
                    }

                    x = 118;
                    y = 135;
                    if(takenSpot[selRow][selCol] != true)
                    {
                        puzzleArray[selRow][selCol] = selNum;
                    }
                    selNum = 0;
                    selRow = 0;
                    selCol = 0;
                    selRow1 = 0;
                    selCol1 = 0;

                }

                if(canReset == true)
                {
                    for(int myX = 0; myX < 9; myX ++)
                    {
                        for(int myC = 0; myC < 9; myC++)
                        {
                            if(takenSpot[myC][myX] != true)
                            {
                                puzzleArray[myC][myX] = 0;
                            }
                        }
                    }
                }

                if(checkWin == true)
                {
                    for(int as = 0; as < 9; as ++)
                    {
                        for(int sa = 0; sa < 9; sa++)
                        {
                            if(solutionArray[as][sa] == puzzleArray[as][sa])
                            {
                                count++;
                            }
                        }
                    }
                }
                if(count == 81)
                {
                    screen = 2;
                }
            }

        }
    }
}
