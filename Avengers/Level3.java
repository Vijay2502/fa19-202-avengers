import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends MyWorld
{
    int count = 0;
    int spawnSpeed = 125;
    int randomSpawn;
    public Player mainPlayer;
    Counter counter = new Counter();
    HealthBar healthbar = new HealthBar();
    SuperPowerBar superbar;
    PlayerStateMachine psm;
    /**
     * Constructor for objects of class Level3.
     * 
     */
    public Level3(Player player)
    {    
        super(player);
        this.setBackground( new GreenfootImage("./images/SoulStoneLevel.png"));
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

    public void nextLevelProgressCheck(){
        if(counter.score == 10){
            // Need to change subsequent levels when world class is changed.
            // Greenfoot.setWorld(new Level3(mainPlayer));
        }
    }
    
    public void act() {
        count++;
        spawnEnemies();
        nextLevelProgressCheck();
    }
}
