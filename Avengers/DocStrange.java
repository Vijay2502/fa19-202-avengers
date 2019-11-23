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
    public void fireProjectile()
    {
        getWorld().addObject(new MagicSpellProjectile(facing), getX(), getY());
    }
}
