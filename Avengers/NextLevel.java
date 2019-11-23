import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NextLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NextLevel extends Actor
{
    boolean clicked = false;
    /**
     * Act - do whatever the NextLevel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Greenfoot.setWorld(getWorld());
        // Add your action code here.
        click();
        
    }    
    
    public void click(){
        if(Greenfoot.mouseClicked(this)){
            //clicked = true;
            //getWorld()
            //Player mainPlayer = (Player)getWorld().getObject(Player.class);
            MyWorld my = (MyWorld)getWorld();
            my.nextLevelTransition();
        }
    }
}
