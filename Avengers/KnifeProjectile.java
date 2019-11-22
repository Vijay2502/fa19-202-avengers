import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KnifeProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KnifeProjectile extends EnemyProjectile
{
    IMoveStrategy movementStrategy;
    public KnifeProjectile(Boolean isReverse)
    {
        GreenfootImage up = new GreenfootImage("./images/knife.png");
        this.speed = 7;
        this.damage = 15;
        up.scale(80,40);
        setImage(up);
        if (isReverse)
            getImage().mirrorHorizontally();
        this.movementStrategy = new StraightMovementStrategy(isReverse);
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