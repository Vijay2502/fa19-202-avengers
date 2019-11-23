import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IronMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IronMan extends Player implements IPlayer
{
    public IronMan()
    {
        superpowerstrategy = new TrackingProjectilesStrategy(this, "MISSILE");
        imagefactory = new ImageFactory("IRONMAN");
        this.health = 175;
    }
    public void fireProjectile()
    {
        getWorld().addObject(new BeamProjectile(facing), getX(), getY() - 40);
    }
}
