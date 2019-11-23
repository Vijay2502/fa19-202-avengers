import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hawkeye here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HawkEye extends Player implements IPlayer
{
    /**
     * Act - do whatever the HawkEye wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public HawkEye() 
    {
        superpowerstrategy = new TrackingProjectilesStrategy(this, "ARROW");
        imagefactory = new ImageFactory("HAWKEYE");
        this.health = 100;
    }  
    public void act() 
    {
        super.act();
    }
    public void fireProjectile()
    {
        getWorld().addObject(new ArrowProjectile(facing), getX(), getY());
    }
}
