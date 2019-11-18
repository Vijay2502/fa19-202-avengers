import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int health = 100;
    double specificHealth = (double)health;
    public HealthBar()
    {
        setImage(new GreenfootImage(100,12));
        getImage().drawRect(0,0,99,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health,10);
    }
    public void act() 
    {
        setImage(new GreenfootImage(100,12));
        getImage().drawRect(0,0,99,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health,10);
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;   
        loseHealth();
    }  
    
    public void loseHealth()
    {
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        if(myWorld.getPlayer().hitByEnemy())
        health-=0.5;
        
        if(health<=0)
            {
               getWorld().showText("You Lose! \n You survived for " + (myWorld.getPlayer().time/60) + " seconds", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
}
