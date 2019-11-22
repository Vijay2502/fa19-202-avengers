import greenfoot.*;
/**
 * Sinusoidal movement strategy.
 * 
 * @author Atharva Munshi
 */
public class SinusoidalMovementStrategy implements IMoveStrategy 
{
    private int changemovementafterstep =50;
    private int step =1;
    private int toggler =1;
    private int speed;
    private Actor actor;
    private Boolean isReverse;

    public SinusoidalMovementStrategy(Boolean isReverse){
        this.speed = 0-getRandomNumber(4,6);
        this.isReverse = isReverse;
    }
    

    public void setActor(Actor actor){
        this.actor = actor;
        this.actor.setRotation(-45);
    }
    

    public void moveActor(){
        int direction = isReverse ? -1 : 1;
        this.actor.move(direction * this.speed);
        rotateActor();
    }
    

    public void rotateActor(){
        if(step % changemovementafterstep ==0){
            this.actor.turn(90*toggler);
            toggler *= -1;
        }
        step++;
    }
    
    /**
     * chages the moving speed of actor
     */
    public void changeSpeed(int speed){
        this.speed = speed;
    }
    
    private int getRandomNumber(int s,int e)
    {
       int normal = Greenfoot.getRandomNumber(e-s+1);
       return normal+s;
    }
}