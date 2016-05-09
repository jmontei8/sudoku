import java.util.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.RenderingHints;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JComponent;
/**
 * Sudoku Board
 * 
 * @author (Milan K) 
 * @version (1)
 */
public class Sudoku
{
    // instance variables - replace the example below with your own
    private int[][] grid;
    private int[][] display;
    private int[][] orig;
    private boolean[][] valid;
    /**
     * Constructor for objects of class Sudoku
     */
    public Sudoku()
    {
        // initialise instance variables
        System.out.print("====================/n/nWelcome to Sudoku!/nPick your level of challenge!");
        System.out.print("====================/n/n1 for Easy, 2 for Medium, 3 for Hard");
        Scanner sc = new Scanner(System.in);
        int diff=sc.nextInt();
        generateBoard(diff);
        
    }
    public void generateBoard(int diff){
        if( diff==0){
            System.out.print("Thanks for playing Sudoku!");
        }
        else if( diff==1){
            puzzle=Math.random()*10;
            board(puzzle);
        }
        else if( diff==2){
            puzzle=Math.random()*10;
            board(puzzle);
        }
        else if( diff==3){
            puzzle=Math.random()*10;
            board(puzzle);
        }
        else{
            System.out.print("Invalid Input! Try again or quit with 0.");
            generateBoard(sc.nextInt());
        }
    }
    public void board(int puzzle){
        if (puzzle==0){
            
        }
        if (puzzle==1){
            
        }
        if (puzzle==2){
            
        }
        if (puzzle==3){
            
        }
        if (puzzle==4){
            
        }
        if (puzzle==5){
            
        }
        if (puzzle==6){
            
        }
        if (puzzle==7){
            
        }
        if (puzzle==8){
            
        }
        
    }
}
