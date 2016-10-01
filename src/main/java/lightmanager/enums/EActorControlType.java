package lightmanager.enums;

/**
 * Beschreibt den Steuertyp des Aktors.
 *
 * @author Korbinian, 23.09.16
 */
public enum EActorControlType
{
    /**
     * Ein/Aus Aktoren
     */
    DEFAULT,

    /**
     * Dimmbare Aktoren
     */
    REGULATOR,

    /**
     * Infrarot Aktoren
     */
    SENDER,

    /**
     * Nicht unterstützte Aktoren
     */
    NOT_SUPPORTED
}
