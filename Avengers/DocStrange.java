import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DocStrange here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DocStrange extends Player implements IPlayer
{
    /**
     * Act - do whatever the DocStrange wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public DocStrange()
    {
        superpowerstrategy = new AttackRainStrategy(this, "CRACK");
        imagefactory = new ImageFactory("DOC");
        this.health = 80;
    }
    public void act() 
    {
        super.act();
    }
    public GreenfootImage getSuperPowerImage()
    {
        GreenfootImage spimage = new GreenfootImage("./images/hero/drstrange/super.png");
        spimage.scale(150,150);
        if (facing == -1)
            spimage.mirrorHorizontally();
        return spimage;
    }
    public GreenfootImage getAttackingImage()
    {
        GreenfootImage attimage = new GreenfootImage("./images/hero/drstrange/shoot.png");
        attimage.scale(160,150);
        if (facing == -1)
            attimage.mirrorHorizontally();
        return attimage;
    }
    public GreenfootImage getIdleImage()
    {
        GreenfootImage idleimage = new GreenfootImage("./images/hero/drstrange/idle.png");
        idleimage.scale(140,160);
        if (facing == -1)
            idleimage.mirrorHorizontally();
        return idleimage;
    }
    public void fireProjectile()
    {
        getWorld().addObject(new MagicSpellProjectile(facing), getX(), getY());
    }
}
