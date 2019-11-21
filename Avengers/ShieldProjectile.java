import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShieldProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShieldProjectile extends HeroProjectile
{
    public ShieldProjectile() 
    {
        GreenfootImage up = new GreenfootImage("./images/shield.png");
        this.speed = 5;
        this.damage = 13;
        up.scale(80,80);
        setImage(up);
    }   
}
