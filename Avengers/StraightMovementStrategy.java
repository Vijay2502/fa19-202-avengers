import greenfoot.*;
/**
 * Straight movement strategy.
 * 
 * @author Atharva Munshi
 */
public class StraightMovementStrategy implements IMoveStrategy 
{
    private int Speed;
    private Actor actor;
  
    public StraightMovementStrategy(){
        this.Speed = 0-getRandomNumber(2,6);
    }
    
    public void setActor(Actor actor){
        this.actor = actor;
    }
    
    public void moveActor(){
        this.actor.move(this.Speed);
    }
    
    public void rotateActor(){
        
    }
    
    public void changeSpeed(int speed){
        this.Speed = speed;
    }
    
    private int getRandomNumber(int s,int e)
    {
       int n = Greenfoot.getRandomNumber(e-s+1);
       return n+s;
    }
}
