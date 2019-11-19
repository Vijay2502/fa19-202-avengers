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
    protected int defaultImageCounter = 1;
    protected int imgNum = 0;
    protected int damage;
    
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
        setImage("/enemy/" + this.getClass().getName().toLowerCase() + "/" + "hit.png");
        setScaling(); 
    }
    
    public void setDefaultImage() {  
        defaultImageCounter--;
        if (defaultImageCounter == 0) {
            defaultImageCounter = 20;
            imgNum =(imgNum + 1) % 2;
            setImage("/enemy/" + this.getClass().getName().toLowerCase() + "/" + imgNum + ".png");
        }
        setScaling();
    }
    
    public void setScaling() {}
    
    public int getDamage() {
        return this.damage;
    }
}
