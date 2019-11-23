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
        addObject(new Thanos(mainPlayer, counter), getWidth(), getHeight() / 2);
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
