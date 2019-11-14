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
    private int rotation = 0;
    Player player;
    Counter counter;
    public Elf(Player mainPlayer, Counter counter) {
        this.counter = counter;
        player = mainPlayer;
        setImage("elf.png");
        getImage().scale(80,80);
        
    }
    
   
    public void act() 
    {
        
        moveAround();
       
        hitByProjectile();
    }    
    
    public void moveAround() {
        turnTowards(player.getX(), player.getY());
        move(1);
        setRotation(getRotation() - 180);
        
    }
    

    
    public void hitByProjectile() {
        Actor projectile = getOneIntersectingObject(Projectile.class);
        
        if(projectile != null)
        {
            health--;
            getWorld().removeObject(projectile);
        }
        
        if (health == 0) {
            counter.score++;
           getWorld().removeObject(this);
        }
    }
}
