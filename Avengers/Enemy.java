import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    protected int health;
    protected int rotation = 0;
    protected Player player;
    protected Counter counter;
    protected int hitImageCounter = 0;
    
    public Enemy(Player mainPlayer, Counter counter) {
        this.counter = counter;
        player = mainPlayer;        
    }
    
    /**
    * Act - do whatever the Enemy wants to do. This method is called whenever
    * the 'Act' or 'Run' button gets pressed in the environment.
    */
    public void act() 
    {
        moveAround();
       
        hitByProjectile();        
    }    
    
    public void moveAround() {
        if (this.hitImageCounter > 0)
            this.hitImageCounter--;
        else 
            setDefaultImage();
        turnTowards(player.getX(), player.getY());
        move(1);
        setRotation(getRotation() - 180);
    } 
    
    public void hitByProjectile() {
        Actor projectile = getOneIntersectingObject(Projectile.class);
        Actor superprojectile = getOneIntersectingObject(SuperProjectile.class);
        
        if(projectile != null)
        {
            health--;
            setHitImage();
            getWorld().removeObject(projectile);
        }
        if(superprojectile != null)
        {
            counter.score++;
            getWorld().removeObject(superprojectile);
            getWorld().removeObject(this);
        }
        
        if (health == 0) {
            counter.score++;
           getWorld().removeObject(this);
        }
    }
    
    
    public void setHitImage() {
        this.hitImageCounter = 50;
    }
    
    public void setDefaultImage() {
    }
}
