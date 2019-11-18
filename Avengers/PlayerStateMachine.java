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
    private AnimationState next;
    private int timer = 0;
    private int animationtime = 0;
    private boolean timerstart = false;
    /**
     * Constructor for objects of class PlayerStateMachine
     */
    public PlayerStateMachine()
    {
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
    public void setAnimationStateAfter(AnimationState newstate, int time)
    {
        next = newstate;
        animationtime = time;
        timerstart = true;
    }
    public void animationTimer()
    {
        if (!timerstart)
            return;
        if (timer >= animationtime)
        {
            current = next;
            
        }
    }
}
