
/**
 * Write a description of class Puzzle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Puzzle
{
    // instance variables - replace the example below with your own
    private int[][] puzzle;
    private int[][] puzzle1={{0,2,0,0,5,0,7,0,0},
            {9,0,0,7,0,1,0,6,0},
            {0,0,7,0,0,0,0,0,5},
            {0,7,0,1,0,5,0,4,0},
            {4,0,6,0,7,0,9,0,3},
            {0,8,0,4,0,6,0,7,0},
            {8,0,0,0,0,0,4,0,0},
            {0,9,0,3,0,4,0,0,7},
            {0,0,3,0,2,0,0,1,0}};
            
    private int[][] puzzle2;
    private int[][] puzzle3;
    private int[][] puzzle4;
    private int[][] puzzle5;
    private int[][] solution1={{1,2,8,6,5,3,7,9,4},
            {9,5,4,7,8,1,3,6,2},
            {6,3,7,9,4,2,1,8,5},
            {2,7,9,1,3,5,6,4,8},
            {4,1,6,2,7,8,9,5,3},
            {3,8,5,4,9,6,2,7,1},
            {8,6,2,5,1,7,4,3,9},
            {5,9,1,3,6,4,8,2,7},
            {7,4,3,8,2,9,5,1,6}};
    private int[][] solution2;
    private int[][] solution3;
    private int[][] solution4;
    private int[][] solution5;
    private int[][] userInput;
    /**
     * Constructor for objects of class Puzzle
     */
    public Puzzle()
    {
        // initialise instance variables
        int chosen=Math.random()*5+1;
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int[][] getPuzzle()
    {
        // put your code here
        
        return puzzle;
    }

    public int getSolutions(int x)
    {
        // put your code here
        return 0;

    }
}
