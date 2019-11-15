import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IronMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IronMan extends Actor
{
    int time = 0;
    public IronMan()
    {
        GreenfootImage up = new GreenfootImage("./images/iron man.png");
        up.scale(150,150);
        setImage(up);
        //GreenfootImage down = new GreenfootImage("/Users/vijayghanshani/Downloads/cap marvel.png");
    }
    public void act() 
    {
        time++;
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
        
    }    
    public void fireProjectile()
    {
        Projectile beam = new Projectile();
        GreenfootImage beamImage = new GreenfootImage("./images/beam.jpeg");
        beamImage.scale(40,40);
        beam.setImage(beamImage);
        if(Greenfoot.mousePressed(null))
        getWorld().addObject(beam, getX(), getY());
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
}
