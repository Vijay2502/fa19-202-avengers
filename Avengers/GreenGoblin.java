

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GreenGoblin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreenGoblin extends Enemy
{
    IMoveStrategy ReflectiveMovementStrategy;
    public GreenGoblin(Player mainPlayer, Counter counter) {
        super(mainPlayer, counter);
        this.health = 30;
        this.damage = 15;
        this.ReflectiveMovementStrategy = new ReflectiveMovementStrategy();
        this.ReflectiveMovementStrategy.setActor(this);
        int rotation = Greenfoot.getRandomNumber(45);
        this.setRotation(30 + rotation);
    }  
    
    public void setScaling() {
        GreenfootImage image = getImage();
        image.scale(140, 145);
    }  
    public void act()
    {
     this.ReflectiveMovementStrategy.moveActor();
        if(!this.actorOnEdgeAction()){
            this.hitByProjectile();
        } 
    }
    public boolean actorOnEdgeAction(){
        if ( this.isAtEdge() && getX() ==0){
            getWorld().removeObject(this);
            return true;
        }
        return false;
    }
    public void fireProjectile() {        
        getWorld().addObject(new BombProjectile(), getX(), getY());
    }
}
