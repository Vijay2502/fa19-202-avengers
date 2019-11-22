import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TrackingMissile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrackingMissile extends SuperProjectile
{
    public TrackingMissile()
    {
        GreenfootImage up = new GreenfootImage("./images/lightning.png");
        up.scale(40,40);
        setImage(up);
        setRotation(90);
    }
    public void act() 
    {
        move(10);
        if (isAtEdge()) getWorld().removeObject(this);
    }
}
