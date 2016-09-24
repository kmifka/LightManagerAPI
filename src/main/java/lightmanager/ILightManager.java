package lightmanager;

/**
 * Stellt den LightManager dar.
 *
 * @author Korbinian, 23.09.16
 */
public interface ILightManager
{
    /**
     * Gibt alle Aktoren des Managers zurück
     * @return alle Aktoren
     */
    IActor[] getActors();

    /**
     * Gibt alle Marker des Managers zurück
     * @return alle Marker
     */
    IMarker[] getMarker();

    /**
     * Gibt alles Szenen des Managers zurück
     * @return alles Szenen
     */
    IScene[] getScenes();

    /**
     * Fügt einen Funk BUS Listener hinzu.
     * @param pListener hinzuzufügender Listener
     */
    void addRadioBUSListener(RadioBUSListener pListener);

    /**
     * Entfernt einen Funk BUS Listener
     * @param pListener zu entfernender Listener
     */
    void removeRadioBUSListener(RadioBUSListener pListener);

    /**
     * Gibt die aktuelle, vom LightManager gemessene Temperatur zurück
     * @return die Temperatur
     */
    double getTemperatur();
}
