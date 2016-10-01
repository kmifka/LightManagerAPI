package lightmanager.intefaces;

import lightmanager.intefaces.objects.IMarker;
import lightmanager.intefaces.objects.IScene;
import lightmanager.intefaces.objects.IZone;

/**
 * Stellt grundlegende Funktionen des Ligthmanagers bereit.
 *
 * @author Korbinian, 24.09.16
 */
public interface ILightManagerBasic
{
    /**
     * Gibt alle Zonen des Managers zurück
     * @return alle Zonen
     */
    IZone[] getZones();

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
     * Sendet ein Kommando an den Lightmanager
     * @param pContent Inhalt des Requests
     * @return Gibt an, ob der Lightmanager das Kommando erfolgreich ausgeführt hat
     */
    default boolean sendCommand(String pContent)
    {
        return false;
    }
}
