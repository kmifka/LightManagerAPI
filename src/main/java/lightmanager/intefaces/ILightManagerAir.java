package lightmanager.intefaces;

import lightmanager.LightManagerMetaData;
import lightmanager.listeners.IBUSListener;

/**
 * Stellt den LightManager dar.
 *
 * @author Korbinian, 23.09.16
 */
public interface ILightManagerAir extends ILightManagerBasic
{
    /**
     * Fügt einen Funk BUS Listener hinzu.
     * @param pListener hinzuzufügender Listener
     */
    void addBUSListener(IBUSListener pListener);

    /**
     * Entfernt einen Funk BUS Listener
     * @param pListener zu entfernender Listener
     */
    void removeBUSListener(IBUSListener pListener);

    /**
     * Gibt die aktuelle, vom LightManager gemessene Temperatur zurück
     * @return die Temperatur
     */
    double getTemperature();

    /**
     * Gibt die Metadaten des Lightmanagers zurück
     * @return Metadaten des Lightmanagers
     */
    LightManagerMetaData getMetaData();
}
