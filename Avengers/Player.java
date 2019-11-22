import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract class Player extends Actor implements IScoreBoardHealthSubject
{
    // Need to set up oberver pattern for superpower.
    int time = 0;
    int supertimer = 0;
    boolean firingsuperpower = false;
    boolean superpowerReady = false;
    int facing = 1;
    private IScoreBoardHealthObserver observer;
    protected String projectileImage = "thor_hammer";
    protected int superDuration = 100;
    public Player()
    {
        Greenfoot.playSound("ThorSong.mp3");
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
            if(getX() <= 75){

            }
            else
                move(-3);
        }
        if(Greenfoot.isKeyDown("right"))
        { 
            if(getX() >= 1135){

            }
            else
                move(3);
        }
        if(Greenfoot.isKeyDown("up"))
        {
            if(getY() <= 73)
                setLocation(getX(),getY());
            else
                setLocation(getX(),getY()-3);
        }
        if(Greenfoot.isKeyDown("down"))
        { 
            if(getY() >= 727)
                setLocation(getX(),getY());
            else
            setLocation(getX(),getY()+3);
        }
        hitByEnemy();
        firingSuperpower();
    }
    public void hitByEnemy() {
        Enemy enemy = (Enemy) getOneObjectAtOffset(0,0, Enemy.class);
        EnemyProjectile projectile = (EnemyProjectile) getOneObjectAtOffset(0,0, EnemyProjectile.class); 
        
        if (enemy != null) {
            notifyScoreBoardForHealthUpdate(firingsuperpower ? 0 : enemy.getDamage());
            getWorld().removeObject(enemy);
        }
        
        if (projectile != null) {
            notifyScoreBoardForHealthUpdate(firingsuperpower ? 0 : projectile.getDamage());
            getWorld().removeObject(projectile);
        }
        
    }
    abstract void firingSuperpower();
    abstract void fireProjectile();
    public void fireSuperPower()
    {
        firingsuperpower = true;
        superpowerReady = false;
    }
    public void youLose() {
        if (isTouching(Enemy.class)) {
            getWorld().showText("You Lose ! You lasted " + (time / 60) + " seconds", getWorld().getWidth()/ 2, getWorld().getHeight() / 2);
            Greenfoot.stop();
        }
    }
    abstract void displayInfo();
    abstract GreenfootImage getSuperPowerImage();
    abstract GreenfootImage getAttackingImage();
    abstract GreenfootImage getIdleImage();
    public void flipOrientation ()
    {
        facing *= -1;
    }
    
    public void registerScoreBoardHealthObserver(IScoreBoardHealthObserver observer){
        this.observer = observer;
    }
    
    public void unregisterScoreBoardHealthObserver(IScoreBoardHealthObserver observer){
        
    }
    
    public void notifyScoreBoardForHealthUpdate(int damage){
        observer.updateScoreBoardHealth(damage);
    }
    
    public int getSuperDuration() {
        return this.superDuration;
    }
}
