import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class ImageFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImageFactory  
{
    private String imagename;
    /**
     * Constructor for objects of class ImageFactory
     */
    public ImageFactory(String imagename)
    {
        this.imagename = imagename;
    }
    public GreenfootImage getCharacterImage () {
        if(imagename == null){
            return null;
        }
        GreenfootImage returnimage = null;
        switch (imagename.toUpperCase())
        {
            case "CAP" : returnimage = new GreenfootImage("./images/cap.png"); break;
            case "DOC" : returnimage = new GreenfootImage("./images/doc. strange.png"); break;
            case "HAWKEYE" : returnimage = new GreenfootImage("./images/hawkeye.png"); break;
            case "IRONMAN" : returnimage = new GreenfootImage("./images/iron man.png"); break;
            case "SPIDERMAN" : returnimage = new GreenfootImage("./images/spiderman.png"); break;
            case "THOR" : returnimage = new GreenfootImage("./images/thor.png"); break;
        }
        return returnimage;
    }
}
