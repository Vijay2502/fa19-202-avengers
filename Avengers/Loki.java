import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Loki here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Loki extends Enemy
{
     public Loki(Player mainPlayer, Counter counter) {
        super(mainPlayer, counter);
        this.health = 15;
        this.damage = 10;
    }
    
    public void setScaling() {
        GreenfootImage image = getImage();
        image.scale(100, 108);
    }
}
