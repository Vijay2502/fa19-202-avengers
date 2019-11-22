import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyProjectile extends Actor
{
    protected int speed = 0;
    protected int damage = 0;
    public EnemyProjectile()
    {
    }  
    
    public void act() 
    {
        move(-1 * speed);
        if (isAtEdge()) getWorld().removeObject(this);
    } 
    
    public int getDamage() {
        return this.damage;
    }
}
