import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    int count = 0;
    int spawnSpeed = 50;
    int randomSpawn;
    public Player mainPlayer;
    Counter counter = new Counter();
    HealthBar healthbar = new HealthBar();
    Superpower superbar;
    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2(Player player)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);

        this.mainPlayer = player;
        this.mainPlayer.setSuperPower(superbar);
        superbar = new Superpower(player);
        this.setBackground( new GreenfootImage("./images/SoulStoneLevel.png"));

        addObject(mainPlayer, 100, getHeight() / 2);
        addObject(counter, 100, 80);
        addObject(healthbar, mainPlayer.getX()- 5, mainPlayer.getY() - 50);
        addObject(superbar, mainPlayer.getX()+ 10, mainPlayer.getY() - 80);
    }

    public Player getPlayer()
    {
        return mainPlayer;
    }

    public void spawnEnemies () {
        if (count % spawnSpeed == 0)
        {
            randomSpawn = Greenfoot.getRandomNumber(5);
            switch (randomSpawn) {
                case 0: addObject(new Elf(mainPlayer, counter), getWidth(), 0); break;
                case 1: addObject(new Elf(mainPlayer, counter), getWidth(), getHeight() / 4); break;
                case 2: addObject(new Elf(mainPlayer, counter), getWidth(), getHeight() / 2); break;
                case 3: addObject(new Elf(mainPlayer, counter), getWidth(), 3 *getHeight() / 4); break;
                case 4: addObject(new Elf(mainPlayer, counter), getWidth(), getHeight()); break;
            }            
        }
    }

    public void act() {
        count++;
        spawnEnemies();
    }
}
