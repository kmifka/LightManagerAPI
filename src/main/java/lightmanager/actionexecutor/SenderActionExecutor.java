package lightmanager.actionexecutor;

import com.sun.istack.internal.Nullable;
import lightmanager.Action;
import lightmanager.XMLConstants;
import lightmanager.enums.EActorActionType;
import lightmanager.intefaces.IActionExecutor;
import lightmanager.listeners.IActionListener;
import org.jdom.Element;

/**
 * Stellt einen Sender ActionExecutor dar, welcher bei Aktoren zum Einsatz kommt, die lediglich die Action "SEND" unterstützten
 *
 * @author Korbinian, 24.09.16
 */
public class SenderActionExecutor implements IActionExecutor
{
    private String command;
    private IActionListener listener;

    public SenderActionExecutor(Element pElement)
    {
        Element xmlCommands = pElement.getChild(XMLConstants.COMMANDLIST);
        command = xmlCommands.getChild(XMLConstants.COMMAND)
                .getChildText(XMLConstants.PARAM);
    }


    @Override
    public void executeAction(EActorActionType pAction, @Nullable Object pData)
    {
        if (pAction == EActorActionType.SEND)
            listener.send(new Action(command, EActorActionType.SEND));
        else
            throw new RuntimeException("Diese Aktion wird nicht unterstützt -> " + pAction);
    }

    @Override
    public EActorActionType[] getSupportedActions()
    {
        return new EActorActionType[]{EActorActionType.SEND};
    }

    @Override
    public void setListener(IActionListener pListener)
    {
        listener = pListener;
    }
}
