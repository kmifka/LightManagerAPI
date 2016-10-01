package lightmanager.intefaces;


import com.sun.istack.internal.Nullable;
import lightmanager.enums.EActorActionType;
import lightmanager.listeners.IActionListener;


/**
 * Stellt einen ActionExecutor dar
 *
 * @author Korbinian, 24.09.16
 */
public interface IActionExecutor
{
    /**
     * Führt eine Aktion aus
     * @param pAction auszuführende Aktion
     */
    default void executeAction(EActorActionType pAction)
    {
        executeAction(pAction, null);
    }

    /**
     * Führt eine Aktion mit Übergabeparameter aus
     * @param pAction auszuführende Aktion
     * @param pData daten,
     */
    void executeAction(EActorActionType pAction, @Nullable Object pData);

    /**
     * Gibt die unterstützten Aktionen zurück
     * @return unterstützte Aktionen
     */
    EActorActionType[] getSupportedActions();

    /**
     * Setzt den Listener, der auslöst, sobald die Action ausgeführt wird
     * @param pListener zu setzender Listener
     */
    void setListener(IActionListener pListener);
}
