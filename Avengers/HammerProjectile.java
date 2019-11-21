import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HammerProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HammerProjectile extends HeroProjectile
{
    
    public HammerProjectile() 
    {
        GreenfootImage up = new GreenfootImage("./images/thor_hammer.png");
        this.speed = 4;
        this.damage = 25;
        up.scale(40,40);
        setImage(up);
    }    
}
