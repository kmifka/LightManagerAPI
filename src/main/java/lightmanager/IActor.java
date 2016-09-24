package lightmanager;

/**
 * Stellt einen Aktor dar (z.B. Funkschalter, Funkdimmer oder IR-Empfänger).
 *
 * @author Korbinian, 23.09.16
 */
public interface IActor extends ILightManagerObject
{
    /**
     * Startet eine Aktion des Actors
     * @param pAction die zu startende Aktion
     * @param pData die Informationen für die Aktion
     */
    void startAction(EActorAction pAction, Object pData);

    /**
     * Startet eine Aktion des Actors
     * @param pAction die zu startende Aktion
     */
    void startAction(EActorAction pAction);

    /**
     * Gibt den Status des Actors zurück
     * @return Status (ON, OFF...)
     */
    EActorState getState();
}
