package lightmanager.actionexecutor;

import com.sun.istack.internal.Nullable;
import lightmanager.Action;
import lightmanager.LightManagerUtil;
import lightmanager.XMLConstants;
import lightmanager.enums.EActorActionType;
import lightmanager.intefaces.IActionExecutor;
import lightmanager.listeners.IActionListener;
import org.jdom.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Stellt einen Standard ActionExecutor dar, welcher die meisten Actions unterstützt
 *
 * @author Korbinian, 24.09.16
 */
public class DefaultActionExecutor implements IActionExecutor
{
    private Map<EActorActionType, String> actions = new HashMap<>();
    private IActionListener listener;

    public DefaultActionExecutor(Element pElement)
    {
        Element xmlCommands = pElement.getChild(XMLConstants.COMMANDLIST);
        ArrayList<Element> children = new ArrayList<>(xmlCommands.getChildren(XMLConstants.COMMAND));
        for (Element element : children)
        {
            EActorActionType action = LightManagerUtil.getActorActionType(element.getChildText(XMLConstants.NAME));

            if (action != null)
                actions.put(action, element.getChildText(XMLConstants.PARAM));
        }
    }

    @Override
    public void executeAction(EActorActionType pAction, @Nullable Object pData)
    {
        if (actions.keySet().contains(pAction))
            listener.send(new Action(actions.get(pAction), pAction));
        else
            throw new RuntimeException("Diese Aktion wird nicht unterstützt -> " + pAction);
    }

    @Override
    public EActorActionType[] getSupportedActions()
    {
        return actions.keySet().toArray(new EActorActionType[0]);
    }

    @Override
    public void setListener(IActionListener pListener)
    {
        listener = pListener;
    }
}
