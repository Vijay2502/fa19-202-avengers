import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CapAmerica here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CapAmerica extends Player implements IPlayer
{
    /**
     * Act - do whatever the CapAmerica wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public CapAmerica()
    {
        this.superDuration = 500;
        superpowerstrategy = new InvincibleStrategy(this, null);
        imagefactory = new ImageFactory("CAP");
        this.health = 150;
    }
    public void act() 
    {
        super.act();
    }
    public GreenfootImage getSuperPowerImage()
    {
        GreenfootImage spimage = new GreenfootImage("./images/hero/capamerica/super.png");
        spimage.scale(130,130);
        if (facing == -1)
            spimage.mirrorHorizontally();
        return spimage;
    }
    public GreenfootImage getAttackingImage()
    {
        GreenfootImage attimage = new GreenfootImage("./images/hero/capamerica/shoot.png");
        attimage.scale(130,130);
        if (facing == -1)
            attimage.mirrorHorizontally();
        return attimage;
    }
    public GreenfootImage getIdleImage()
    {
        GreenfootImage idleimage = new GreenfootImage("./images/hero/capamerica/idle.png");
        idleimage.scale(130,130);
        if (facing == -1)
            idleimage.mirrorHorizontally();
        return idleimage;
    }
    public void fireProjectile()
    {
        getWorld().addObject(new ShieldProjectile(facing), getX(), getY());
    }
}
