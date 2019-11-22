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
    private int Speed;
    private Actor actor;

    public SinusoidalMovementStrategy(){
        this.Speed = 0-getRandomNumber(4,6);
    }
    

    public void setActor(Actor actor){
        this.actor = actor;
        this.actor.setRotation(-45);
    }
    

    public void moveActor(){
        this.actor.move(this.Speed);
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
        this.Speed = speed;
    }
    
    private int getRandomNumber(int s,int e)
    {
       int normal = Greenfoot.getRandomNumber(e-s+1);
       return normal+s;
    }
}