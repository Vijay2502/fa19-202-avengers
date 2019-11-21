import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IronMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IronMan extends Player implements IPlayer
{
    public IronMan()
    {
        GreenfootImage up = new GreenfootImage("./images/iron man.png");
        up.scale(150,150);
        setImage(up);
        this.projSpeed = 10;
        this.projDamage = 10;
    }
    public void act() 
    {
        super.act();
    }
    public void displayInfo() {
        String name = this.getClass().getName();
        getWorld().showText(name, 1100, 55);
        GreenfootImage character = new GreenfootImage("./images/ironman_face.jpeg");
        GreenfootImage health = new GreenfootImage("./images/health.png");
        GreenfootImage superpower = new GreenfootImage("./images/power.png");
        character.scale(70,70);
        health.scale(30,30);
        superpower.scale(30,30);
        getWorld().getBackground().drawImage(character, 950, 45 );
        getWorld().getBackground().drawImage(health, 1020, 65 );
        getWorld().getBackground().drawImage(superpower, 1020, 95 );
        
    }
    public GreenfootImage getSuperPowerImage()
    {
        GreenfootImage spimage = new GreenfootImage("./images/thor.png");
        spimage.scale(150,150);
        return spimage;
    }
    public GreenfootImage getAttackingImage()
    {
        GreenfootImage attimage = new GreenfootImage("./images/thor.png");
        attimage.scale(150,150);
        return attimage;
    }
    public GreenfootImage getIdleImage()
    {
        GreenfootImage idleimage = new GreenfootImage("./images/thor.png");
        idleimage.scale(150,150);
        return idleimage;
    }
    public void fireProjectile()
    {
        getWorld().addObject(new BeamProjectile(), getX(), getY());
    }
}
