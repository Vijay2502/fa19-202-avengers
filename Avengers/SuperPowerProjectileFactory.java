/**
 * Write a description of class SuperPowerProjectileFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SuperPowerProjectileFactory  
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class SuperPowerProjectileFactory
     */
    public SuperPowerProjectileFactory()
    {
    }
    public SuperProjectile getSuperProjectile(String superprojName){
        if(superprojName == null){
            return null;
        }
        SuperProjectile returnproj = null;
        switch (superprojName.toUpperCase())
        {
            case "WEB" : returnproj = new TrackingWeb (); break;
            case "MISSILE" : returnproj = new TrackingMissile (); break;
            case "LIGHTNING" : returnproj = new LightningBall (); break;
            case "ARROW" : returnproj = new Arrow (); break;
            case "CRACK" : returnproj = new SpaceCrack (); break;
        }
        return returnproj;
    }
}
