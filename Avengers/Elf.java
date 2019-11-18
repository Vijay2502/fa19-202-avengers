import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elf extends Enemy
{
    public Elf(Player mainPlayer, Counter counter) {
        super(mainPlayer, counter);
        this.health = 2;
        
    }
    
    public void setHitImage() {
        super.setHitImage();
        setImage("elf_hit.png");
        getImage().scale(80,80);        
    }
    
    public void setDefaultImage() {        
        setImage("elf.png");
        getImage().scale(80,80);
    }
}
