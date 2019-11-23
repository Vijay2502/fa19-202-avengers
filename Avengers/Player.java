import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract class Player extends Actor implements IScoreBoardHealthSubject, IPlayer
{
    // Need to set up oberver pattern for superpower.
    private int time = 0;
    private boolean superpowerReady = false;
    protected int facing = 1;
    private IScoreBoardHealthObserver observer;
    protected ISuperPowerStrategy superpowerstrategy;
    protected ImageFactory imagefactory;
    protected int superDuration = 100;
    protected int health = 100;
    public Player()
    {
    }
    public void superpowerReady()
    {
        superpowerReady = true;
    }
    public void superpowerUsed()
    {
        SoundManager.getInstance().playStaticSound(this.getClass().getName() + "super.mp3");
        superpowerReady = false;
    }
    public boolean isSuperPowerReady()
    {
        return superpowerReady;
    }
    public int getTime()
    {
        return time;
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
    private void hitByEnemy() {
        Enemy enemy = (Enemy) getOneObjectAtOffset(0,0, Enemy.class);
        EnemyProjectile projectile = (EnemyProjectile) getOneObjectAtOffset(0,0, EnemyProjectile.class); 
        ThanosProjectile tprojectile = (ThanosProjectile) getOneObjectAtOffset(0,0, ThanosProjectile.class); 
        if (enemy != null) {
            notifyScoreBoardForHealthUpdate(
            superpowerstrategy.isfiringSuperPower() ? 0 : enemy.getDamage());
            getWorld().removeObject(enemy);
        }
        
        if (projectile != null) {
            notifyScoreBoardForHealthUpdate(
            superpowerstrategy.isfiringSuperPower() ? 0 : projectile.getDamage());
            getWorld().removeObject(projectile);
        }
        if (tprojectile != null) {
            notifyScoreBoardForHealthUpdate(
            superpowerstrategy.isfiringSuperPower() ? 0 : tprojectile.getDamage());
            getWorld().removeObject(tprojectile);
        }
        
    }
    private void firingSuperpower()
    {
        superpowerstrategy.firingSuperpower();
    }
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
    
    public void levelComplete(int currentLevel){
        superpowerstrategy.stopFiringSuperpower();
        NextLevel nextLevel = new NextLevel();
        switch(currentLevel){
            case 1: 
            //getWorld().getBackground().drawImage(new GreenfootImage("./images/InfinityStone1.jpeg"), 600, 200); 
                    getWorld().showText("Go to level 2", 600, 100);
                    getWorld().addObject(nextLevel, 600, 700);
                    break;
            case 2: 
            //getWorld().getBackground().drawImage(new GreenfootImage("./images/InfinityStone2.jpeg"), 600, 200);
                    getWorld().showText("Go to level 3", 600, 100);
                    getWorld().addObject(nextLevel, 600, 700);
                    break;
                    
            case 3: 
            //getWorld().getBackground().drawImage(new GreenfootImage("./images/InfinityStone3.jpeg"), 600, 200);
                    getWorld().showText("Go to level 4", 600, 100);
                    getWorld().addObject(nextLevel, 600, 700);
                    break;
            
            case 4: 
            //getWorld().getBackground().drawImage(new GreenfootImage("./images/TimeStone.jpg"), 100, 100); 
                break;
        }
    }
    private void displayInfo() {
        String name = this.getClass().getName();
        getWorld().showText(name, 1100, 55);
        GreenfootImage character = imagefactory.getCharacterImage();
        GreenfootImage health = new GreenfootImage("./images/health.png");
        GreenfootImage superpower = new GreenfootImage("./images/power.png");
        character.scale(70,70);
        health.scale(30,30);
        superpower.scale(30,30);
        getWorld().getBackground().drawImage(character, 950, 45 );
        getWorld().getBackground().drawImage(health, 1020, 65 );
        getWorld().getBackground().drawImage(superpower, 1020, 95 );
        
    }
    //public void youLose() {
    //    if (isTouching(Enemy.class)) {
    //        getWorld().showText("You Lose ! You lasted " + (time / 60) + " seconds", getWorld().getWidth()/ 2, getWorld().getHeight() / 2);
    //        Greenfoot.stop();
    //    }
    //}
    public void fireSuperPower()
    {
        superpowerstrategy.fireSuperPower();
    }
    
    public int getHealth()
    {
        return this.health;
    }
    public GreenfootImage getSuperPowerImage()
    {
        GreenfootImage spimage = imagefactory.getSuperPowerImage();
        spimage.scale(150,150);
        if (facing == -1)
            spimage.mirrorHorizontally();
        return spimage;
    }
    public GreenfootImage getAttackingImage()
    {
        GreenfootImage attimage = imagefactory.getAttackingImage();
        attimage.scale(150,150);
        if (facing == -1)
            attimage.mirrorHorizontally();
        return attimage;
    }
    public GreenfootImage getIdleImage()
    {
        GreenfootImage idleimage = imagefactory.getIdleImage();
        idleimage.scale(120,150);
        if (facing == -1)
            idleimage.mirrorHorizontally();
        return idleimage;
    }
    abstract void fireProjectile();
}
