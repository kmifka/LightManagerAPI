package lightmanager;

/**
 * Stellt den speziellen Aktor "Dimmer" dar.
 *
 * @author Korbinian, 23.09.16
 */
public interface IActorDimmer extends IActor
{
    /**
     * Gibt die Helligkeit des Dimmers in Prozent (z.B. 0.34) zurück
     * @return Helligkeit in Prozent
     */
    double getBrightness();

    /**
     * Setzt die Helligkeit des Dimmers in Prozent
     * @param pValue die zu setztende Helligkeit in Prozent (z.B. 0.34)
     */
    void setBrightness(double pValue);
}
