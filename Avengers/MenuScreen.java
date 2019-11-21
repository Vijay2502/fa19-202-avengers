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
        // Thor
        GreenfootImage health = new GreenfootImage("./images/health.png");
        GreenfootImage superpower = new GreenfootImage("./images/power.png");
        health.scale(30,30);
        superpower.scale(30,30);
        ((Actor)thorMenuOption).getImage().drawImage(health, 30, 545 );
        ((Actor)thorMenuOption).getImage().drawImage(superpower, 30, 585 );
        ((Actor)thorMenuOption).getImage().drawRect(60,555,99,11);
        ((Actor)thorMenuOption).getImage().setColor(Color.RED);
        ((Actor)thorMenuOption).getImage().fillRect(60,555,100,10);
        
        ((Actor)thorMenuOption).getImage().drawRect(60,585,99,11);
        ((Actor)thorMenuOption).getImage().setColor(Color.BLUE);
        ((Actor)thorMenuOption).getImage().fillRect(60,585,100,13);
        // IronMan
        //GreenfootImage healthIronMan = new GreenfootImage("./images/health.png");
        //GreenfootImage superpowerIronMan = new GreenfootImage("./images/power.png");
        health.scale(30,30);
        superpower.scale(30,30);
        ((Actor)ironManOption).getImage().drawImage(health, 30, 545 );
        ((Actor)ironManOption).getImage().drawImage(superpower, 30, 585 );
        ((Actor)ironManOption).getImage().drawRect(60,555,99,11);
        ((Actor)ironManOption).getImage().setColor(Color.RED);
        ((Actor)ironManOption).getImage().fillRect(60,555,100,10);
        
        ((Actor)ironManOption).getImage().drawRect(60,585,99,11);
        ((Actor)ironManOption).getImage().setColor(Color.BLUE);
        ((Actor)ironManOption).getImage().fillRect(60,585,100,13);
        
        
        
        addObject((Actor)thorMenuOption, 111, 402);       
        addObject((Actor)ironManOption, 337, 402); 
        addObject((Actor)capMenuOption, 565, 402); 
        addObject((Actor)blackWidowOption, 767, 402); 
        addObject((Actor)hulkOption, 939, 402); 
        addObject((Actor)hawkEyeOption, 1118, 402); 
        
        
    }
}
