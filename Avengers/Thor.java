import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Thor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Thor extends Player implements IPlayer 
{
    public Thor(){
        superpowerstrategy = new AttackRainStrategy(this, "LIGHTNING");
        imagefactory = new ImageFactory("THOR");
        this.health = 200;
    }
    public void act() 
    {
        super.act();
    }
    public GreenfootImage getSuperPowerImage()
    {
        GreenfootImage spimage = new GreenfootImage("./images/hero/thor/super.png");
        spimage.scale(150,150);
        if (facing == -1)
            spimage.mirrorHorizontally();
        return spimage;
    }
    public GreenfootImage getAttackingImage()
    {
        GreenfootImage attimage = new GreenfootImage("./images/hero/thor/shoot.png");
        attimage.scale(150,150);
        if (facing == -1)
            attimage.mirrorHorizontally();
        return attimage;
    }
    public GreenfootImage getIdleImage()
    {
        GreenfootImage idleimage = new GreenfootImage("./images/hero/thor/idle.png");
        idleimage.scale(120,150);
        if (facing == -1)
            idleimage.mirrorHorizontally();
        return idleimage;
    }
    public void fireProjectile()
    {
        getWorld().addObject(new HammerProjectile(facing), getX(), getY());
    }
}
