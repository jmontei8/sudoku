import java.util.*;
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

    private boolean[][] taken = {{false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false}};

    private int[][] puzzle2={{0,5,3,2,0,7,0,0,8},
            {6,0,1,5,0,0,0,0,2},
            {2,0,0,9,1,3,0,5,0},
            {7,1,4,6,9,2,0,0,0},
            {0,2,0,0,0,0,0,6,0},
            {0,0,0,4,5,1,2,9,7},
            {0,6,0,3,2,5,0,0,9},
            {1,0,0,0,0,6,3,0,4},
            {8,0,0,1,0,9,6,7,0}};

    private int[][] puzzle4={{0,0,0,8,0,7,1,2,9},
            {6,0,0,0,0,0,0,0,4},
            {0,0,2,5,0,4,0,0,8},
            {7,0,5,1,4,0,2,0,0},
            {0,1,0,6,0,2,0,3,0},
            {0,0,6,0,5,3,4,0,1},
            {9,0,0,3,0,5,8,0,0},
            {2,0,0,0,0,0,0,0,7},
            {5,4,7,2,0,8,0,0,0}};

    private int[][] puzzle6={{4,0,0,8,1,5,6,0,0},
            {0,0,7,0,0,3,0,1,0},
            {8,0,0,4,7,0,0,0,0},
            {2,0,0,1,0,0,7,9,8},
            {1,7,5,0,0,0,2,4,6},
            {6,8,9,0,0,7,0,0,1},
            {0,0,0,0,8,1,0,0,2},
            {0,2,0,9,0,0,1,0,0},
            {0,0,4,5,6,2,0,0,3}};

    private int[][] solution2={{9,5,3,2,6,7,1,4,8},
            {6,7,1,5,8,4,9,3,2},
            {2,4,8,9,1,3,7,5,6},
            {7,1,4,6,9,2,5,8,3},
            {5,2,9,7,3,8,4,6,1},
            {3,8,6,4,5,1,2,9,7},
            {4,6,7,3,2,5,8,1,9},
            {1,9,5,8,7,6,3,2,4},
            {8,3,2,1,4,9,6,7,5}};

    private int[][] solution4={{3,5,4,8,6,7,1,2,9},
            {6,7,8,9,2,1,3,5,4},
            {1,9,2,5,3,4,6,7,8},
            {7,3,5,1,4,9,2,8,6},
            {4,1,9,6,8,2,7,3,5},
            {8,2,6,7,5,3,4,9,1},
            {9,6,1,3,7,5,8,4,2},
            {2,8,3,4,9,6,5,1,7},
            {5,4,7,2,1,8,9,6,3}};

    private int[][] solution6={{4,3,2,8,1,5,6,7,9},
            {9,5,7,6,2,3,8,1,4},
            {8,6,1,4,7,9,3,2,5},
            {2,4,3,1,5,6,7,9,8},
            {1,7,5,3,9,8,2,4,6},
            {6,8,9,2,4,7,5,3,1},
            {3,9,6,7,8,1,4,5,2},
            {5,2,8,9,3,4,1,6,7},
            {7,1,4,5,6,2,9,8,3}};
    private int[][] solution1 = {{2,3,4,9,5,6,8,1,7},
        {9,5,7,8,1,4,2,6,3},
        {1,8,6,3,7,2,4,5,9},
        {5,4,9,6,8,1,7,3,2},
        {6,1,8,7,2,3,5,9,4},
        {7,2,3,4,9,5,6,8,1},
        {3,9,2,5,6,7,1,4,8},
        {4,7,5,1,3,8,9,2,6},
        {8,6,1,2,4,9,3,7,5}};

    private int[][] puzzle1 =
    {{0,3,4,0,0,6,0,0,7},
        {0,0,7,8,1,0,0,6,0},
        {1,8,6,3,0,2,4,5,0},
        {0,0,9,6,8,0,0,0,2},
        {6,0,0,0,0,0,0,0,4},
        {7,0,0,0,9,5,6,0,0},
        {0,9,2,5,0,7,1,4,8},
        {0,7,0,0,3,8,9,0,0},
        {8,0,0,2,0,0,3,7,0}};

    private int[][] solution3 = 
    {
        {2,6,3,5,7,4,8,9,1},
        {7,1,8,6,9,2,3,4,5},
        {5,9,4,8,1,3,2,7,6},
        {3,4,5,1,6,7,9,8,2},
        {1,2,6,3,8,9,4,5,7},
        {8,7,9,2,4,5,6,1,3},
        {6,3,1,4,5,8,7,2,9},
        {9,8,2,7,3,1,5,6,4},
        {4,5,7,9,2,6,1,3,8}
    };

    private int[][] puzzle3 =
    {
        {0,0,3,5,7,4,0,0,0},
        {0,0,8,0,9,0,0,4,0},
        {5,0,4,8,0,0,2,0,6},
        {0,0,0,1,0,7,0,8,0},
        {1,2,6,0,0,0,4,5,7},
        {0,7,0,2,0,5,0,0,0},
        {6,0,1,0,0,8,7,0,9},
        {0,8,0,0,3,0,5,0,0},
        {0,0,0,9,2,6,1,0,0}
    };

    private int[][] solution5 =
    {
        {9,1,8,2,3,5,4,6,7},
        {3,6,7,8,9,4,5,1,2},
        {2,4,5,6,1,7,9,8,3},
        {8,7,6,9,2,1,3,4,5},
        {1,9,2,4,5,3,6,7,8},
        {4,5,3,7,6,8,2,9,1},
        {5,2,9,1,7,6,8,3,4},
        {6,8,1,3,4,2,7,5,9},
        {7,3,4,5,8,9,1,2,6}
    };

    private int[][] puzzle5 =
    {
        {9,0,0,2,3,0,4,0,0},
        {0,0,7,8,0,4,0,1,0},
        {2,4,5,6,0,7,0,0,3},
        {8,7,0,9,2,0,3,0,0},
        {0,9,2,4,0,3,6,7,0},
        {0,0,3,0,6,8,0,9,1},
        {5,0,0,1,0,6,8,3,4},
        {0,8,0,3,0,2,7,0,0},
        {0,0,4,0,8,9,0,0,6}
    };


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
        int chosen=(int)(Math.random()*5);
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

    public boolean[][] preTaken(int[][] puzzle)
    {
        for(int x = 0; x < 9; x++)
        {
            for(int c = 0; c < 9; c++)
            {
                if(puzzle[x][c] > 0)
                {
                    taken[x][c] = true;
                }
            }
        }
        return taken;
    }

    public void updateUser(int[][] p)
    {
        // put your code here
        user=p;

    }

    public void print()
    {
        // put your code here
        System.out.print("===Here are the arrays===\n");
        System.out.println(Arrays.deepToString(puzzle1));
        System.out.println(Arrays.deepToString(solution1));
        System.out.println(Arrays.deepToString(puzzle2));
        System.out.println(Arrays.deepToString(solution2));
        System.out.println(Arrays.deepToString(puzzle3));
        System.out.println(Arrays.deepToString(solution3));
        System.out.println(Arrays.deepToString(puzzle4));
        System.out.println(Arrays.deepToString(solution4));
        System.out.println(Arrays.deepToString(puzzle5));
        System.out.println(Arrays.deepToString(solution5));

    }
}