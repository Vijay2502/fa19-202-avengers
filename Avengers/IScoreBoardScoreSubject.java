/**
 * Write a description of class IScoreBoardScoreSubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */  
public interface IScoreBoardScoreSubject  
{
    public void registerScoreBoardScoreObserver(IScoreBoardHealthObserver observer);
    public void unregisterScoreBoardScoreObserver(IScoreBoardHealthObserver observer);
    public void notifyScoreBoardForScoreUpdate(int health);
}
