import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class capamerica here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class capamerica extends Player
{
    /**
     * Act - do whatever the capamerica wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public capamerica()
    {
      GreenfootImage up = new GreenfootImage("./images/cap.jpg");
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
        GreenfootImage character = new GreenfootImage("./images/cap.jpg");
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
        getWorld().addObject(new ShieldProjectile(), getX(), getY());
    }
}
