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
    public void fireProjectile()
    {
        getWorld().addObject(new HammerProjectile(facing), getX(), getY());
    }
}
