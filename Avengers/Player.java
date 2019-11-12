import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{ 
    public Player()
    {
        GreenfootImage up = new GreenfootImage("/Users/vijayghanshani/Downloads/thor.png");
        up.scale(150,150);
        setImage(up);
        //GreenfootImage down = new GreenfootImage("/Users/vijayghanshani/Downloads/cap marvel.png");
    }
        
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("left"))
        { 
            move(-3);
        }
        if(Greenfoot.isKeyDown("right"))
        { 
            move(3);
        }
        if(Greenfoot.isKeyDown("up"))
        { 
          setLocation(getX(),getY()-3);
        }
        if(Greenfoot.isKeyDown("down"))
        { 
           setLocation(getX(),getY()+3);
        }
        fireProjectile();
        
    }    
    public void fireProjectile()
    {
        if(Greenfoot.mousePressed(null))
        getWorld().addObject(new Projectile(), getX(), getY());
    }
}
