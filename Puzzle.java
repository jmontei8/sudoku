
/**
 * Write a description of class Puzzle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Puzzle
{
    // instance variables - replace the example below with your own
    int[][] base;
    int[][] solution;
    int[][] user;
    private int[][] puzzle1={{0,2,0,0,5,0,7,0,0},
            {9,0,0,7,0,1,0,6,0},
            {0,0,7,0,0,0,0,0,5},
            {0,7,0,1,0,5,0,4,0},
            {4,0,6,0,7,0,9,0,3},
            {0,8,0,4,0,6,0,7,0},
            {8,0,0,0,0,0,4,0,0},
            {0,9,0,3,0,4,0,0,7},
            {0,0,3,0,2,0,0,1,0}};

    private int[][] puzzle2={{},
            { },
            { },
            { },
            { },
            { },
            { },
            { },
            { }};
    private int[][] puzzle3={{},
            { },
            { },
            { },
            { },
            { },
            { },
            { },
            { }};
    private int[][] puzzle4={{},
            { },
            { },
            { },
            { },
            { },
            { },
            { },
            { }};
    private int[][] puzzle5={{},
            { },
            { },
            { },
            { },
            { },
            { },
            { },
            { }};
    private int[][] solution1={{1,2,8,6,5,3,7,9,4},
            {9,5,4,7,8,1,3,6,2},
            {6,3,7,9,4,2,1,8,5},
            {2,7,9,1,3,5,6,4,8},
            {4,1,6,2,7,8,9,5,3},
            {3,8,5,4,9,6,2,7,1},
            {8,6,2,5,1,7,4,3,9},
            {5,9,1,3,6,4,8,2,7},
            {7,4,3,8,2,9,5,1,6}};
    private int[][] solution2={{5,3,4,6,7,8,9,1,2},
            {6,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            { },
            { },
            { },
            { },
            { },
            { }};
    private int[][] solution3={{},
            { },
            { },
            { },
            { },
            { },
            { },
            { },
            { }};
    private int[][] solution4={{},
            { },
            { },
            { },
            { },
            { },
            { },
            { },
            { }};
    private int[][] solution5={{},
            { },
            { },
            { },
            { },
            { },
            { },
            { },
            { }};
    /**
     * Constructor for objects of class Puzzle
     */
    public Puzzle()
    {
        //initialise instance variables
        
        base=choosePuzzle();
        solution=chooseSolution(base);
        user=base;
    
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
        return base;
    }

    public int[][] getSolutions(int x)
    {
        // put your code here
        return solution;

    }
    public int[][] choosePuzzle()
    {
        // put your code here
        int chosen=(int)Math.random()*5;
        if (chosen==0){
            return puzzle1;
        }
        else if (chosen==1){
            return puzzle2;
        }
        else if (chosen==2){
            return puzzle3;
        }
        else if (chosen==3){
            return puzzle4;
        }
        else if (chosen==4){
            return puzzle5;
        }
        else{
            return null;
        }
    }
     public int[][] chooseSolution(int[][] puzzle)
    {
        // put your code here
        
        if (puzzle==puzzle1){
            return solution1;
        }
        else if (puzzle==puzzle2){
            return solution2;
        }
        else if (puzzle==puzzle3){
            return solution3;
        }
        else if (puzzle==puzzle4){
            return solution4;
        }
        else if (puzzle==puzzle5){
            return solution5;
        }
        else{
            return null;
        }
    }
    public void updateUser(int[][] p)
    {
        // put your code here
        user=p;

    }
}
