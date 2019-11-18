/**
 * Write a description of class PlayerStateMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerStateMachine  
{
    // instance variables - replace the example below with your own
    private Player player;
    private AnimationState current;
    private int timer = 0;
    private int animationtime = 0;
    private boolean timerstart = false;
    /**
     * Constructor for objects of class PlayerStateMachine
     */
    public PlayerStateMachine()
    {
        current = new IdleState(player);
    }
    public void attack()
    {
        current.attack();
    }
    public void flipHorizontally()
    {
        current.flipHorizontally();
    }
    public void superPower()
    {
        current.superPower();
    }
    public void setAnimationState(AnimationState newstate)
    {
        current = newstate;
        current.animationTime();
    }
    public void setAnimationTime(int time){
        timerstart = true;
        timer = 0;
        animationtime = time;
    }
    public void animationTimer()
    {
        if (!timerstart)
            return;
        if (timer >= animationtime)
        {
            current.autoStateChange();
            timerstart = false;
        }
        else
        {
            timer++;
        }
    }
}
