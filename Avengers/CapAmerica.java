import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CapAmerica here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CapAmerica extends Player
{
    public CapAmerica()
    {
        this.superDuration = 500;
        superpowerstrategy = new InvincibleStrategy(this, null);
        imagefactory = new ImageFactory("CAP");
        this.health = 150;
    }
    public void fireProjectile()
    {
        getWorld().addObject(new ShieldProjectile(facing), getX(), getY());
    }
}
