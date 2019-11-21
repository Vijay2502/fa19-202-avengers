import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SphereProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BombProjectile extends EnemyProjectile
{
    public BombProjectile()
    {
        GreenfootImage up = new GreenfootImage("./images/bomb.png");
        this.speed = 5;
        this.damage = 20;
        up.scale(40,40);
        setImage(up);
    }
     
}
