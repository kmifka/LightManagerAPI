package lightmanager;

/**
 * Beschreibt den Zustand eines Aktors.
 *
 * @author Korbinian, 23.09.16
 */
public enum EActorState
{
    /**
     * Eingeschaltet
     */
    ON,

    /**
     * Ausgeschaltet oder auf 0% gedimmt
     */
    OFF,

    /**
     * Auf mehr als 0% gedimmt
     */
    DIMMED,

    /**
     * Unbekannter Zustand
     */
    UNDEFINED
}
