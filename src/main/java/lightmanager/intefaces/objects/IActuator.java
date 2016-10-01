package lightmanager.intefaces.objects;

import com.sun.istack.internal.Nullable;
import lightmanager.enums.EActorActionType;
import lightmanager.enums.EActorControlType;
import lightmanager.enums.EActorType;

/**
 * Stellt einen Aktor dar (z.B. Funkschalter, Funkdimmer oder IR-Empfänger).
 *
 * @author Korbinian, 23.09.16
 */
public interface IActuator extends ILightManagerObject
{
    /**
     * Startet eine Aktion des Actors
     * @param pAction die zu startende Aktion
     * @param pData die Informationen für die Aktion
     */
    void startAction(EActorActionType pAction, @Nullable Object pData);

    /**
     * Startet eine Aktion des Actors
     * @param pAction die zu startende Aktion
     */
    default void startAction(EActorActionType pAction)
    {
        startAction(pAction, null);
    }

    /**
     * Gibt die unterstützen Aktionen zurück
     * @return unterstützte Aktionen
     */
    EActorActionType[] getSupportedActions();

    /**
     * Gibt den Steuertypen zurück
     * @return Stertypen
     */
    EActorControlType getControlType();

    /**
     * Gibt den Aktortyp zurück
     * @return Aktortyp
     */
    EActorType geType();
}
