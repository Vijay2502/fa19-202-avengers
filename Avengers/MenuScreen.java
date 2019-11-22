import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuScreen extends World
{

    IMenuInvoker thorMenuOption;
    IMenuInvoker ironManOption;
    IMenuInvoker capMenuOption ;
    IMenuInvoker blackWidowOption ;
    IMenuInvoker hulkOption ;
    IMenuInvoker hawkEyeOption ;

    IMenuCommand thorCommand;
    IMenuCommand ironManCommand;
    IMenuCommand capCommand;
    IMenuCommand blackWidowCommand;
    IMenuCommand hulkCommand;
    IMenuCommand hawkCommand;
    
     /* Constructor for objects of class MenuScreen.
     * 
     */
    public MenuScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        thorMenuOption = new MenuOption();
        ironManOption = new MenuOption();
        capMenuOption = new MenuOption();
        blackWidowOption = new MenuOption();
        hulkOption = new MenuOption();
        hawkEyeOption = new MenuOption();

        PlayerFactory playerFactory = new PlayerFactory();

        thorCommand = new MenuCommand();
        ironManCommand = new MenuCommand();
        capCommand = new MenuCommand();
        blackWidowCommand = new MenuCommand();
        hulkCommand = new MenuCommand();
        hawkCommand = new MenuCommand();

        ((Actor)thorMenuOption).setImage("images/MenuThor.jpg");
        ((Actor)ironManOption).setImage("images/MenuIron.jpg");
        ((Actor)capMenuOption).setImage("images/MenuCap.jpg");
        ((Actor)blackWidowOption).setImage("images/MenuBlack.jpg");
        ((Actor)hulkOption).setImage("images/MenuHulk.jpg");
        ((Actor)hawkEyeOption).setImage("images/MenuHawk.jpg");
        
        thorMenuOption.setCommand(thorCommand);
        ironManOption.setCommand(ironManCommand);
        capMenuOption.setCommand(capCommand);
        blackWidowOption.setCommand(blackWidowCommand);
        hulkOption.setCommand(hulkCommand);
        hawkEyeOption.setCommand(hawkCommand);
        
        thorCommand.setReceiver(() -> {
            //get world from factory
            // inside factory get player from another factory
            Greenfoot.setWorld(new MyWorld(playerFactory.getPlayer("THOR")));
        });
        
        ironManCommand.setReceiver(() -> {
            Greenfoot.setWorld(new MyWorld(playerFactory.getPlayer("IRONMAN")));
        });
        
        capCommand.setReceiver(() -> {
            Greenfoot.setWorld(new MyWorld(playerFactory.getPlayer("CAPTAINAMERICA")));
        });
        
        blackWidowCommand.setReceiver(() -> {
            Greenfoot.setWorld(new MyWorld(playerFactory.getPlayer("DrStrange")));
        });
        
        hulkCommand.setReceiver(() -> {
            Greenfoot.setWorld(new MyWorld(playerFactory.getPlayer("SPIDERMAN")));
        });
        
        hawkCommand.setReceiver(() -> {
            Greenfoot.setWorld(new MyWorld(playerFactory.getPlayer("HAWKEYE")));
        });
        
        displayStats(((Actor)thorMenuOption), 100,1); // Thor
        displayStats(((Actor)ironManOption), 100,1); // ironman
        displayStats(((Actor)capMenuOption), 100,1); //cap
        displayStats(((Actor)blackWidowOption), 100,1); //
        displayStats(((Actor)hulkOption), 100,1); //
        displayStats(((Actor)hawkEyeOption), 100,1); //
        
        
        addObject((Actor)thorMenuOption, 111, 402);       
        addObject((Actor)ironManOption, 337, 402); 
        addObject((Actor)capMenuOption, 565, 402); 
        addObject((Actor)blackWidowOption, 767, 402); 
        addObject((Actor)hulkOption, 939, 402); 
        addObject((Actor)hawkEyeOption, 1118, 402); 
        
        
    }
    
    public void displayStats(Actor actor, int herohealth, int projectileDamage)
    {
        GreenfootImage health = new GreenfootImage("./images/health.png");
        GreenfootImage superpower = new GreenfootImage("./images/power.png");
        health.scale(30,30);
        superpower.scale(30,30);
        actor.getImage().drawImage(health, 30, 545 );
        actor.getImage().drawImage(superpower, 30, 585 );
        
        
        actor.getImage().drawRect(60,555,99,11);
        actor.getImage().setColor(Color.RED);
        actor.getImage().fillRect(60,555,100,10);
        
        actor.getImage().drawRect(60, 590,99,11);
        actor.getImage().setColor(Color.BLUE);
        actor.getImage().fillRect(60,590,100,13);
        
    }
}
