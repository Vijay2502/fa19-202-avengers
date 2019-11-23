import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ThanosProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThanosProjectile extends Actor
{
    protected int damage = 10;
    protected Player player;
    Boolean isReverse;
    int thanosX;
    int projectileHealth = 1;
    
    public ThanosProjectile(Player player, int thanosX, Boolean isReverse)
    {
        this.thanosX = thanosX;
        this.player = player;
        this.isReverse = isReverse;
        GreenfootImage up = new GreenfootImage("./images/bomb.png");
        up.scale(40,40);
        setImage(up);
    }
    
    public void act() 
    {
        hitByHeroProjectile();
        if(thanosX > player.getX())
            {
                turnTowards(player.getX(), player.getY());
                move(1);
            
            }
        
         else{
        int direction = isReverse ? 1 : -1;
        turnTowards(player.getX(), player.getY());
        move(direction);
        
        }
        
        if(isAtEdge() || projectileHealth <= 0) 
        {
            getWorld().removeObject(this);
        }
    } 
    
    public int getDamage() {
        return this.damage;
    }
    
    public void hitByHeroProjectile() {    
        HeroProjectile projectile = (HeroProjectile) getOneIntersectingObject(HeroProjectile.class);
        //Actor superprojectile = getOneIntersectingObject(SuperProjectile.class);
        
        if(projectile != null)
        {
            projectileHealth -= 1;
            getWorld().removeObject(projectile);
        }
        
        
        
    }
}

