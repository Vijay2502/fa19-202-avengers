import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elf extends Actor
{
    int health = 2;
    Player player;
    public Elf(Player mainPlayer) {
        player = mainPlayer;
        setImage("elf.png");
        getImage().scale(80,80);
    }
    
    /**
     * Act - do whatever the Elf wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveAround();
        hitByProjectile();
    }    
    
    public void moveAround() {
        move(1);
        turnTowards(player.getX(), player.getY());
        //setRotation(0);
    }
    
    public void hitByProjectile() {
        Actor projectile = getOneIntersectingObject(Projectile.class);
        
        if(projectile != null)
        {
            health--;
            getWorld().removeObject(projectile);
        }
        
        if (health == 0) {
            getWorld().removeObject(this);
        }
    }
}
