package lightmanager;

/**
 * Stellt einen Marker dar, welcher einen Marker-Zustand annehmen kann.
 *
 * @author Korbinian, 23.09.16
 */
public interface IMarker extends ILightManagerObject
{
    /**
     * Setzt den Marker Zustand
     * @param pState der zu setzende Zustand
     */
    void setState(EMarkerState pState);

    /**
     * Gibt den Markerzustand zurück
     * @return den Markerzustand
     */
    EMarkerState getState();

    /**
     * Fügt einen ChangeListener hinzu
     * @param pListener hinzuzufügender Listener
     */
    void addChangeListener(MarkerListener pListener);

    /**
     * Entfernt einen ChangeListener
     * @param pListener zu entfernender ChangeListener
     */
    void removeChangeListener(MarkerListener pListener);
}
