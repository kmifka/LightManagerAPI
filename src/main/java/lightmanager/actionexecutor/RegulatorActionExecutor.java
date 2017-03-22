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
 * Stellt einen ActionExecutor dar, welcher bei regulierbaren/dimmbaren Aktoren zum Einsatz kommt
 *
 * @author Korbinian, 24.09.16
 */
public class RegulatorActionExecutor implements IActionExecutor
{
    private Map<EActorActionType, String> actions = new HashMap<>();
    private IActionListener listener;
    private Map<Integer, String> steps = new HashMap<>();

    public RegulatorActionExecutor(Element pElement)
    {
        Element xmlCommands = pElement.getChild(XMLConstants.COMMANDLIST);
        ArrayList<Element> children = new ArrayList<>(xmlCommands.getChildren(XMLConstants.COMMAND));
        for (Element element : children)
        {
            String name = element.getChildText(XMLConstants.NAME);
            String param = element.getChildText(XMLConstants.PARAM);
            EActorActionType action = LightManagerUtil.getActorActionType(name);

            if(action == EActorActionType.DIM_TO)
                steps.put(Integer.parseInt(name.replace("%", "")), param);

            if (action != null && !actions.keySet().contains(action))
                actions.put(action, param);
        }
    }


    @Override
    public void executeAction(EActorActionType pAction, @Nullable Object pData)
    {
        if (!actions.keySet().contains(pAction))
            throw new RuntimeException("Diese Aktion wird nicht unterstützt -> " + pAction);
        if (pAction == EActorActionType.DIM_TO && !(pData instanceof Integer))
            throw new RuntimeException("Es wird ein Dimmwert erwartet -> " + pAction + "; pData=" + pData);

        String command = actions.get(pAction);
        if (pAction == EActorActionType.DIM_TO)
            command = _getDimCommand((int) pData);
        listener.send(new Action(command, pAction));
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

    private String _getDimCommand(int pPercent)
    {
        int currPercent = -1;
        for (Integer value : steps.keySet())
            if(currPercent == - 1 || Math.abs(currPercent - pPercent) > Math.abs(value - pPercent))
                currPercent = value;

        return steps.get(currPercent);
    }
}
