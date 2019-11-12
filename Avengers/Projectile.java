import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Projectile()
    {
        GreenfootImage up = new GreenfootImage("/Users/vijayghanshani/Downloads/thor hammer.png");
        up.scale(40,40);
        setImage(up);
    }
    public void act() 
    {
        
        move(10);
    }    
}
