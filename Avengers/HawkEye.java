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
    public GreenfootImage getSuperPowerImage()
    {
        GreenfootImage spimage = new GreenfootImage("./images/hero/hawkeye/super.png");
        spimage.scale(130,130);
        if (facing == -1)
            spimage.mirrorHorizontally();
        return spimage;
    }
    public GreenfootImage getAttackingImage()
    {
        GreenfootImage attimage = new GreenfootImage("./images/hero/hawkeye/shoot.png");
        attimage.scale(130,130);
        if (facing == -1)
            attimage.mirrorHorizontally();
        return attimage;
    }
    public GreenfootImage getIdleImage()
    {
        GreenfootImage idleimage = new GreenfootImage("./images/hero/hawkeye/idle.png");
        idleimage.scale(160,130);
        if (facing == -1)
            idleimage.mirrorHorizontally();
        return idleimage;
    }
    public void fireProjectile()
    {
        getWorld().addObject(new ArrowProjectile(facing), getX(), getY());
    }
}
