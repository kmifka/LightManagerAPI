package lightmanager.actionexecutor;

import com.sun.istack.internal.Nullable;
import lightmanager.enums.EActorActionType;
import lightmanager.intefaces.IActionExecutor;
import lightmanager.listeners.IActionListener;

/**
 * Stellt einen leeren ActionExecutor dar, welcher bei nicht unterstützten Aktoren zum Einsatz kommt.
 * Dieser hat keinerlei Funktion.
 *
 * @author Korbinian, 01.10.16
 */
public class NullActionExecutor implements IActionExecutor
{
    @Override
    public void executeAction(EActorActionType pAction, @Nullable Object pData)
    {
        throw new RuntimeException("Das Ausführen von Aktionen ist nicht möglich!");
    }

    @Override
    public EActorActionType[] getSupportedActions()
    {
        return new EActorActionType[0];
    }

    @Override
    public void setListener(IActionListener pListener)
    {
        //Leer
    }
}
