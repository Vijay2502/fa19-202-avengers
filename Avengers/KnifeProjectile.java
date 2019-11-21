import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KnifeProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KnifeProjectile extends EnemyProjectile
{
    public KnifeProjectile()
    {
        GreenfootImage up = new GreenfootImage("./images/knife.png");
        this.speed = 7;
        this.damage = 15;
        up.scale(40,40);
        setImage(up);
    }
     
}