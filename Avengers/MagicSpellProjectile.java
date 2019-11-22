import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MagicSpellProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagicSpellProjectile extends HeroProjectile
{
    public MagicSpellProjectile(int facing) 
    {
        GreenfootImage up = new GreenfootImage("./images/spell.png");
        this.speed = 5;
        this.damage = 20;
        this.facing = facing;
        up.scale(60,60);
        setImage(up);
    }   
}