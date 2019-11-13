import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Starter_Screen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Starter_Screen extends World
{

    /**
     * Constructor for objects of class Starter_Screen.
     * 
     */
    public Starter_Screen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        this.setBackground( new GreenfootImage("./images/Starter_Screen.jpg"));
        prepare();
    }
    
    public void prepare(){
        StarterScreenTitle titleScreen = new StarterScreenTitle();
        addObject(titleScreen, 543, 284);
    }
    
    public void act(){
    }
}
