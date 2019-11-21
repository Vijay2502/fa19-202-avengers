import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor implements IScoreBoardHealthSubject
{ 
    // Need to set up oberver pattern for superpower.
    int time = 0;
    int supertimer = 0;
    boolean firingsuperpower = false;
    boolean superpowerReady = false;
    private IScoreBoardHealthObserver observer;
    protected String projectileImage = "thor_hammer";
    protected int projSpeed = 10;
    protected int projDamage = 10;
    public Player()
    {
    }
    public void superpowerReady()
    {
        superpowerReady = true;
    }
    public boolean isSuperPowerReady()
    {
        return superpowerReady;
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        time++;
        displayInfo();
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
        hitByEnemy();
        firingSuperpower();
    }
    public void hitByEnemy() {
        Enemy enemy = (Enemy) getOneObjectAtOffset(0,0, Enemy.class);
        if (enemy != null) {
            notifyScoreBoardForHealthUpdate(enemy.getDamage());
            getWorld().removeObject(enemy);
        }
        
    }
    private void firingSuperpower()
    {
        if (!firingsuperpower)
            return;
        if (supertimer < 300)
        {
            if (supertimer % 10 == 0)
            {
                World world = getWorld();
                world.addObject(new SuperProjectile(), Greenfoot.getRandomNumber(world.getWidth()), 0);
            }
            supertimer++;
        }
        else
        {
            supertimer = 0;
            firingsuperpower = false;
        }
    }
    public void fireProjectile()
    {
        getWorld().addObject(new HammerProjectile(), getX(), getY());
    } 
    public void fireSuperPower()
    {
        firingsuperpower = true;
        superpowerReady = false;
    }
    public void youLose() {
        if (isTouching(Elf.class)) {
            getWorld().showText("You Lose ! You lasted " + (time / 60) + " seconds", getWorld().getWidth()/ 2, getWorld().getHeight() / 2);
            Greenfoot.stop();
        }
    }
    public void displayInfo() {
        String name = this.getClass().getName();
        getWorld().showText(name, 1100, 55);
        GreenfootImage character = new GreenfootImage("./images/thor_face.jpeg");
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
    
    public void registerScoreBoardHealthObserver(IScoreBoardHealthObserver observer){
        this.observer = observer;
    }
    
    public void unregisterScoreBoardHealthObserver(IScoreBoardHealthObserver observer){
        
    }
    
    public void notifyScoreBoardForHealthUpdate(int damage){
        observer.updateScoreBoardHealth(damage);
    }
}
