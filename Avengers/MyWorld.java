import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{ 
    int count = 0;
    int spawnSpeed = 50;
    int randomSpawn;
    public Player mainPlayer = new Player();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        this.setBackground( new GreenfootImage("./images/ThorSpaceImage.png"));
       
        addObject(mainPlayer, getWidth() / 2, getHeight() / 2);
       
    }
    
    public void spawnEnemies () {
        if (count % spawnSpeed == 0)
        {
            randomSpawn = Greenfoot.getRandomNumber(5);
            switch (randomSpawn) {
                case 0: addObject(new Elf(mainPlayer), getWidth(), 0); break;
                case 1: addObject(new Elf(mainPlayer), getWidth(), getHeight() / 4); break;
                case 2: addObject(new Elf(mainPlayer), getWidth(), getHeight() / 2); break;
                case 3: addObject(new Elf(mainPlayer), getWidth(), 3 *getHeight() / 4); break;
                case 4: addObject(new Elf(mainPlayer), getWidth(), getHeight()); break;
            }            
        }
    }
    
    public void act() {
        count++;
        spawnEnemies();
    }
}
