import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HeroProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HeroProjectile extends Actor
{
    protected int speed = 10;
    protected int damage = 10;
    protected int facing = 1;
    public HeroProjectile()
    {
    }    
    
    public void act() 
    {
        move(facing * speed);
        if (isAtEdge()) getWorld().removeObject(this);
    } 
    
    public int getDamage() {
        return this.damage;
    }
}
