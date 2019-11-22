import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ThanosProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThanosProjectile extends Actor
{
    protected int damage = 10;
    protected Player player;
    Boolean isReverse;
    Thanos thanos ;
    public ThanosProjectile(Player player, Thanos thanos, Boolean isReverse)
    {
        this.thanos = thanos;
        this.player = player;
        this.isReverse = isReverse;
        GreenfootImage up = new GreenfootImage("./images/bomb.png");
        up.scale(40,40);
        setImage(up);
    }
    
    public void act() 
    {
        if(thanos.getX() > player.getX())
            {
                turnTowards(player.getX(), player.getY());
                move(1);
            
            }
        
         else{
        int direction = isReverse ? 1 : -1;
        turnTowards(player.getX(), player.getY());
        move(direction);
        }
        
        if (isAtEdge()) 
            getWorld().removeObject(this);
    } 
    
    public int getDamage() {
        return this.damage;
    }
}
