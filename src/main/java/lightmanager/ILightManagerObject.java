package lightmanager;

/**
 * Stellt das zugrunde liegende Objekt von Markern, Aktoren und Szenen dar.
 *
 * @author Korbinian, 24.09.16
 */
public interface ILightManagerObject
{
    /**
     * Gibt den Namen des Objekts zurück
     * @return den Namen
     */
    String getName();

    /**
     * Setzt den Namen des Objekts
     * @param pName der zu setztende Name
     */
    void setName(String pName);

    /**
     * Gibt die ID des Objekts zurück
     * @return die ID
     */
    String getID();
}
