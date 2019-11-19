import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class capmarvel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class capmarvel extends Player
{
    /**
     * Act - do whatever the capmarvel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public capmarvel()
    {
        GreenfootImage up = new GreenfootImage("./images/cap marvel.png");
        up.scale(150,150);
        setImage(up);
        
    }
    public void act() 
    {
        super.act();
    } 
    public void displayInfo() {
        String name = this.getClass().getName();
        getWorld().showText(name, 1100, 55);
        GreenfootImage character = new GreenfootImage("./images/cap marvel.png");
        GreenfootImage health = new GreenfootImage("./images/health.png");
        GreenfootImage superpower = new GreenfootImage("./images/power.png");
        character.scale(70,70);
        health.scale(30,30);
        superpower.scale(30,30);
        getWorld().getBackground().drawImage(character, 950, 45 );
        getWorld().getBackground().drawImage(health, 1020, 65 );
        getWorld().getBackground().drawImage(superpower, 1020, 95 );
        
    }
}
