package lightmanager;

/**
 * Beschreibt den Typen des Aktors.
 *
 * @author Korbinian, 23.09.16
 */
public enum EActorType
{
    /**
     * Ein/Aus Aktoren
     */
    DEFAULT,

    /**
     * Dimmbare Aktoren
     */
    DIMMER,

    /**
     * Infrarot Aktoren
     */
    IR,

    /**
     * Alle Unbekannten Aktoren
     */
    UNDEFINED
}
