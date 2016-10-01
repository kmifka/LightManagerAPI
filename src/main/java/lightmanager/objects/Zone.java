package lightmanager.objects;

import lightmanager.intefaces.objects.IActuator;
import lightmanager.intefaces.objects.IZone;

/**
 * Stellt eine Zone dar, welche Aktoren beinhalten kann
 *
 * @author Korbinian, 24.09.16
 */
public class Zone implements IZone
{
    private String name;
    private IActuator[] actors;

    public Zone(String pName, IActuator[] pActors)
    {
        name = pName;
        actors = pActors;
    }

    @Override
    public IActuator[] getActuators()
    {
        return actors;
    }

    @Override
    public int getLength()
    {
        return actors != null ? actors.length : -1;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
