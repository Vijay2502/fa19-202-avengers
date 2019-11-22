import greenfoot.*;
/**
 * Straight movement strategy.
 * 
 * @author Atharva Munshi
 */
public class StraightMovementStrategy implements IMoveStrategy 
{
    private int speed;
    private Actor actor;
    private Boolean isReverse;
    public StraightMovementStrategy(Boolean isReverse){
        this.speed = 0-getRandomNumber(2,6);
        this.isReverse = isReverse;
    }
    
    public void setActor(Actor actor){
        this.actor = actor;
    }
    
    public void moveActor(){
        int direction = isReverse ? -1 : 1;
        this.actor.move(direction * this.speed);
    }
    
    public void rotateActor(){
        
    }
    
    public void changeSpeed(int speed){
        this.speed = speed;
    }
    
    private int getRandomNumber(int s,int e)
    {
       int n = Greenfoot.getRandomNumber(e-s+1);
       return n+s;
    }
}
