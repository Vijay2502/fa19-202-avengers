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
            Greenfoot.setWorld(new MyWorld(new Player()));
        });
        
        ironManCommand.setReceiver(() -> {
            Greenfoot.setWorld(new MyWorld(new IronMan()));
        });
        
        capCommand.setReceiver(() -> {
            Greenfoot.setWorld(new MyWorld(new capmarvel()));
        });
        
        blackWidowCommand.setReceiver(() -> {
            Greenfoot.setWorld(new MyWorld(new DocStrange()));
        });
        
        hulkCommand.setReceiver(() -> {
            Greenfoot.setWorld(new MyWorld(new Player()));
        });
        
        hawkCommand.setReceiver(() -> {
            Greenfoot.setWorld(new MyWorld(new Hawkeye()));
        });
        
        addObject((Actor)thorMenuOption, 111, 402);       
        addObject((Actor)ironManOption, 337, 402); 
        addObject((Actor)capMenuOption, 565, 402); 
        addObject((Actor)blackWidowOption, 767, 402); 
        addObject((Actor)hulkOption, 939, 402); 
        addObject((Actor)hawkEyeOption, 1118, 402); 
    }
}
