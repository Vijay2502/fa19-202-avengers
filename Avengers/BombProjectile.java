import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SphereProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BombProjectile extends EnemyProjectile
{
    private IMoveStrategy movementStrategy;
    public BombProjectile(Boolean isReverse)
    {
        GreenfootImage up = new GreenfootImage("./images/bomb.png");
        this.speed = 5;
        this.damage = 20;
        up.scale(40,40);
        setImage(up);
        this.movementStrategy = new SinusoidalMovementStrategy(isReverse);
        this.movementStrategy.setActor(this);
    }

    public void act(){
        this.movementStrategy.moveActor();
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
