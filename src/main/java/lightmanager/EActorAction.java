package lightmanager;

/**
 * Beschreibt die Aktion, die ein Actor ausführen kann.
 *
 * @author Korbinian, 23.09.16
 */
public enum EActorAction
{
    /**
     * Einschalten
     */
    TURN_ON,

    /**
     * Ausschalten
     */
    TURN_OFF,

    /**
     * Toggeln
     */
    TOGGLE,

    /**
     * Dimmen auf
     */
    DIM_TO,

    /**
     * Senden
     */
    SEND
}
