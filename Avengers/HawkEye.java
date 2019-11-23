import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hawkeye here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HawkEye extends Player
{
    public HawkEye() 
    {
        superpowerstrategy = new TrackingProjectilesStrategy(this, "ARROW");
        imagefactory = new ImageFactory("HAWKEYE");
        this.health = 100;
    }
    public void fireProjectile()
    {
        getWorld().addObject(new ArrowProjectile(facing), getX(), getY());
    }
}
