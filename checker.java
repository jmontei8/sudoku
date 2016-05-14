
/**
 * Write a description of class checker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Checker
{
    public Checker()
    {

    }

    public boolean checkPuzzle(Puzzle currentPuzzle)
    {
        boolean result = true;
                                
        
        int[][] solution = currentPuzzle.chooseSolution(currentPuzzle.getPuzzle());
        for(int r = 0; r<9; r++)
        {
            for(int c = 0; r<9; c++)
            {
                if(solution[r][c] != currentPuzzle.getPuzzle()[r][c])
                {
                    result = false;
                }
            }
        }
        return result;
    }
}