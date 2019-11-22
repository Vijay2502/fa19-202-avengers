import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HammerProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HammerProjectile extends HeroProjectile
{
    
    public HammerProjectile(int facing) 
    {
        GreenfootImage up = new GreenfootImage("./images/thor_hammer.png");
        this.speed = 4;
        this.damage = 25;
        this.facing = facing;
        up.scale(40,40);
        setImage(up);
    }    
}
