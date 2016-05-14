
/**
 * Write a description of class checker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class checker
{
    public checker()
    {

    }

    public boolean[][] check(Puzzle currentPuzzle)
    {
        boolean result;
        boolean[][] correct =  {{true,true,true,true,true,true,true,true,true},
                                {true,true,true,true,true,true,true,true,true},
                                {true,true,true,true,true,true,true,true,true},
                                {true,true,true,true,true,true,true,true,true},
                                {true,true,true,true,true,true,true,true,true},
                                {true,true,true,true,true,true,true,true,true},
                                {true,true,true,true,true,true,true,true,true},
                                {true,true,true,true,true,true,true,true,true},
                                {true,true,true,true,true,true,true,true,true}};
                                
        
        int[][] userPuzzle = currentPuzzle.choosePuzzle();
        int[][] solution = currentPuzzle.chooseSolution(userPuzzle);
        for(int r = 0; r<9; r++)
        {
            for(int c = 0; r<9; c++)
            {
                if(solution[r][c] != userPuzzle[r][c])
                {
                    result = false;
                    correct[r][c] = false;
                    
                }
            }
        }
        return correct;
    }
}