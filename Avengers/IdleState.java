/**
 * Write a description of class IdleState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IdleState implements AnimationState
{
    private PlayerStateMachine psm;
    private Player player;
    public IdleState (PlayerStateMachine psm, Player player)
    {
        this.psm = psm;
        this.player = player;
    }
    public void attack()
    {
        psm.setAnimationState(new AttackingState(psm, player));
    }
    public void flipHorizontally()
    {
        player.flipOrientation ();
    }
    public void superPower()
    {
        if (player.isSuperPowerReady())
            psm.setAnimationState(new SuperPowerState(psm, player));
    }
    public void initAnimation()
    {
        player.setImage(player.getIdleImage());
    }
    public void autoStateChange()
    {
    }
}
