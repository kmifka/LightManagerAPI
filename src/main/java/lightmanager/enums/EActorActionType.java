package lightmanager.enums;

/**
 * Beschreibt die Aktion, die ein Actuator ausführen kann.
 *
 * @author Korbinian, 23.09.16
 */
public enum EActorActionType
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
     * Heller
     */
    DIM_UP,

    /**
     * Dunkler
     */
    DIM_DOWN,

    /**
     * Hochfahren
     */
    UP,

    /**
     * Runterfahren
     */
    DOWN,

    /**
     * Anhalten
     */
    STOP,

    /**
     * Senden
     */
    SEND,

    /**
     * Play
     */
    PLAY,

    /**
     * Pause
     */
    PAUSE,

    /**
     * Überspringen
     */
    SKIP_PLUS,

    /**
     * Überspringen
     */
    SKIP_MINUS,

    /**
     * Lauter
     */
    VOL_PLUS,

    /**
     * Leiser
     */
    VOL_MINUS,

    /**
     * Szene 1
     */
    SCENE1,

    /**
     * Szene 2
     */
    SCENE2,

    /**
     * Szene 3
     */
    SCENE3,

    /**
     * Szene 4
     */
    SCENE4,

    /**
     * Szene 5
     */
    SCENE5,

    /**
     * Alles Ein
     */
    MASTER_ON,

    /**
     * Alles Aus
     */
    MASTER_OFF
}
