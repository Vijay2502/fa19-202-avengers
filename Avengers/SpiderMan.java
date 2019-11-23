import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpiderMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpiderMan extends Player implements IPlayer
{
    public SpiderMan()
    {
        superpowerstrategy = new TrackingProjectilesStrategy(this, "WEB");
        imagefactory = new ImageFactory("SPIDERMAN");
        this.health = 110;
    }
    public void fireProjectile()
    {
        getWorld().addObject(new SpiderWebProjectile(facing), getX(), getY()-30);
    }
}
