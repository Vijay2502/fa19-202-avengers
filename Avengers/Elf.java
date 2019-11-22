import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elf extends Enemy
{
    IMoveStrategy sinusoidalMovementStrategy ;
    public Elf(Player mainPlayer, Counter counter) {
        super(mainPlayer, counter);
        this.health = 10;
        this.damage = 5;
        this.sinusoidalMovementStrategy = new SinusoidalMovementStrategy();
        this.sinusoidalMovementStrategy.setActor(this);
    }
    
    public void setScaling() {
        GreenfootImage image = getImage();
        image.scale(100, 108);
        
    }
    
    
    public void act(){
        this.sinusoidalMovementStrategy.moveActor();
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
    
}
