package lightmanager.intefaces.objects;

/**
 * Stellt eine Zone dar
 *
 * @author Korbinian, 24.09.16
 */
public interface IZone extends ILightManagerObject
{
    /**
     * Gibt die Aktoren zurück
     * @return Aktoren
     */
    IActuator[] getActuators();

    /**
     * Gibt die Anzahl der Aktoren zurück
     * @return anzahl der Aktoren
     */
    int getLength();
}
