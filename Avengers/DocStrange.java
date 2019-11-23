import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DocStrange here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DocStrange extends Player
{
    public DocStrange()
    {
        superpowerstrategy = new AttackRainStrategy(this, "CRACK");
        imagefactory = new ImageFactory("DOC");
        this.health = 80;
    }
    public void fireProjectile()
    {
        getWorld().addObject(new MagicSpellProjectile(facing), getX(), getY());
    }
}
