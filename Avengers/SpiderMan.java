import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpiderMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpiderMan extends Player implements IPlayer
{
    /**
     * Act - do whatever the SpiderMan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SpiderMan()
    {
        superpowerstrategy = new TrackingProjectilesStrategy(this, "WEB");
        imagefactory = new ImageFactory("SPIDERMAN");
        this.health = 110;
    }
    public void act() 
    {
        super.act();
    }
    public void fireProjectile()
    {
        getWorld().addObject(new SpiderWebProjectile(facing), getX(), getY()-30);
    }
}
