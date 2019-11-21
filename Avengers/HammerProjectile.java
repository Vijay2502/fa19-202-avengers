import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HammerProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HammerProjectile extends HeroProjectile
{
    
    public void act() 
    {
        GreenfootImage up = new GreenfootImage("./images/thor_hammer.png");
        this.speed = 5;
        this.damage = 20;
        up.scale(40,40);
        setImage(up);
    }    
}
