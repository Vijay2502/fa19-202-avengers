import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{ 
    // Need to set up oberver pattern for superpower.
    int time = 0;
    int supertimer = 0;
    boolean firingsuperpower = false;
    Superpower superpower;
    public Player()
    {
        GreenfootImage up = new GreenfootImage("./images/thor.png");
        up.scale(150,150);
        setImage(up);
        //GreenfootImage down = new GreenfootImage("/Users/vijayghanshani/Downloads/cap marvel.png");
    }
    public void setSuperPower(Superpower superpower)
    {
        this.superpower = superpower;
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
        fireProjectile();
        hitByEnemy();
        fireSuperpower();
    }    
    public void fireProjectile()
    {
        if(Greenfoot.mousePressed(null))
        getWorld().addObject(new Projectile(), getX(), getY());
    } 
    public void fireSuperpower()
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
    public void superpowerUsed()
    {
        firingsuperpower = true;
    }
    public void youLose() {
        if (isTouching(Elf.class)) {
            getWorld().showText("You Lose ! You lasted " + (time / 60) + " seconds", getWorld().getWidth()/ 2, getWorld().getHeight() / 2);
            Greenfoot.stop();
        }
    }
    
    public boolean hitByEnemy() {
        Actor elf = getOneObjectAtOffset(0,0, Elf.class);
        if (elf != null) {
            return true;
        }
        
        else
        return false;
    }
    
    public void displayInfo() {
        String name = this.getClass().getName();
        getWorld().showText(name, 1100, 55);
        GreenfootImage character = new GreenfootImage("./images/thor_face.jpeg");
        character.scale(70,70);
        getWorld().getBackground().drawImage(character, 950, 45 );
        
    }
}
