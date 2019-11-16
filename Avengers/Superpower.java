import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Superpower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Superpower extends Actor
{
    final int SUPER_POWER_LIMIT = 100;
    int charge = 0;
    Player player;
    public Superpower(Player player)
    {
        setImage(new GreenfootImage(SUPER_POWER_LIMIT + 2,12));
        getImage().drawRect(0,0,SUPER_POWER_LIMIT + 1,11);
        getImage().setColor(Color.BLUE);
        getImage().fillRect(1,1,charge / 5,10);
        this.player = player;
    }
    public void act() 
    {
        setImage(new GreenfootImage(SUPER_POWER_LIMIT + 2,12));
        getImage().drawRect(0,0,SUPER_POWER_LIMIT + 1,11);
        getImage().setColor(Color.BLUE);
        getImage().fillRect(1,1,charge / 5,10);
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        setLocation(myWorld.getPlayer().getX() + 10, myWorld.getPlayer().getY() - 80);
        useSuper();
    }   
    public void useSuper()
    {
        charge++;
        if (charge > SUPER_POWER_LIMIT * 5)
        {
            charge = 0;
            player.superpowerUsed();
        }
    }
}
