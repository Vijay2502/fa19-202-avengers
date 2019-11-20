import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ElfWeapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfWeapon extends Enemy
{
    
    public ElfWeapon(Player mainPlayer, Counter counter) {
        super(mainPlayer, counter);
        this.health = 30;
        this.damage = 10;
    }
    
    public void setScaling() {
        GreenfootImage image = getImage();
        image.scale(110, 110);
    }  
}
