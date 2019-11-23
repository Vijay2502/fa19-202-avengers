import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level4 extends MyWorld
{
    int currentLevel = 4;
    /**
     * Constructor for objects of class Level4.
     * 
     */
    public Level4(Player player)
    {
        super(player);
        this.setBackground( new GreenfootImage("./images/PowerStoneLevel.jpg"));
    }
    
    public void spawnEnemies () {
        if (count % spawnSpeed == 0)
        {
            randomSpawn = Greenfoot.getRandomNumber(5);
            switch (randomSpawn) {
                case 0: addObject(new Elf(mainPlayer, counter), getWidth(), 0); break;
                case 1: addObject(new Ultron(mainPlayer, counter), getWidth(), getHeight() / 4); break;
                case 2: addObject(new Loki(mainPlayer, counter), getWidth(), getHeight() / 2); break;
                case 3: addObject(new GreenGoblin(mainPlayer, counter), getWidth(), 3 *getHeight() / 4); break;
                case 4: addObject(new Loki(mainPlayer, counter), getWidth(), getHeight()); break;
            }            
        }
    }

    public void nextLevelProgressCheck(){
        if(counter.score == 10){
            // Need to change subsequent levels when world class is changed.
            // Greenfoot.setWorld(new Level3(mainPlayer));
            mainPlayer.levelComplete(4);
        }
    }
    
    public void act() {
        count++;
        spawnEnemies();
        nextLevelProgressCheck();
    }
}
