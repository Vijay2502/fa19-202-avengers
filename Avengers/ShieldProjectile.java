import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShieldProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShieldProjectile extends HeroProjectile
{
    private IProjectileMoveStrategy movementStrategy;
    public ShieldProjectile(int facing) 
    {
        GreenfootImage up = new GreenfootImage("./images/shield.png");
        this.speed = 5;
        this.damage = 13;
        this.facing = facing;
        up.scale(80,80);
        setImage(up);
        this.movementStrategy = new RotatingMovementStrategy(facing == -1);
        this.movementStrategy.setProjectile(this);
    } 

    public void act(){
        this.movementStrategy.moveProjectile();
        this.actorOnEdgeAction();
    }

     public boolean actorOnEdgeAction(){
        if ( this.isAtEdge()){
            getWorld().removeObject(this);
            return true;
        }
        return false;
    }  
}
