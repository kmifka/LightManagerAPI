package lightmanager.objects;

import com.sun.istack.internal.Nullable;
import lightmanager.XMLConstants;
import lightmanager.LightManagerUtil;
import lightmanager.enums.EActorActionType;
import lightmanager.enums.EActorControlType;
import lightmanager.enums.EActorType;
import lightmanager.intefaces.IActionExecutor;
import lightmanager.intefaces.objects.IActuator;
import org.jdom.Element;

/**
 * Stellt einen Aktor dar, wessen Aktionen ausgeführt werden können
 *
 * @author Korbinian, 24.09.16
 */
public class Actuator implements IActuator
{
    private IActionExecutor executor;
    private String name;
    private EActorControlType controlType;
    private EActorType type;

    public Actuator(IActionExecutor pExecutor, Element pElement)
    {
        executor = pExecutor;
        name = pElement.getChildText(XMLConstants.NAME);
        controlType = LightManagerUtil.getControlType(pElement);
        type = LightManagerUtil.getActorType(pElement);
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void startAction(EActorActionType pAction, @Nullable Object pData)
    {
        executor.executeAction(pAction, pData);
    }

    @Override
    public EActorActionType[] getSupportedActions()
    {
        return executor.getSupportedActions();
    }

    @Override
    public EActorControlType getControlType()
    {
        return controlType;
    }

    @Override
    public EActorType geType()
    {
        return type;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
