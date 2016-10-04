package lightmanager;

import com.sun.istack.internal.NotNull;
import lightmanager.actionexecutor.DefaultActionExecutor;
import lightmanager.actionexecutor.NullActionExecutor;
import lightmanager.actionexecutor.RegulatorActionExecutor;
import lightmanager.actionexecutor.SenderActionExecutor;
import lightmanager.enums.EActorActionType;
import lightmanager.enums.EActorControlType;
import lightmanager.enums.EActorType;
import lightmanager.intefaces.IActionExecutor;
import org.jdom.Element;

import java.util.ArrayList;

import static lightmanager.enums.EActorActionType.*;

/**
 * Utillity Klasse für den Lightmanager
 *
 * @author Korbinian, 24.09.16
 */
public class LightManagerUtil
{
    /**
     * Gibt den ControlType eines Elements zurück
     * @param pElement XML des Elements
     * @return ControlType
     */
    public static EActorControlType getControlType(Element pElement)
    {
        ArrayList<EActorActionType> actions = new ArrayList<>();
        String type = pElement.getChildText(XMLConstants.TYPE);
        Element xmlCommands = pElement.getChild(XMLConstants.COMMANDLIST);
        ArrayList<Element> children = new ArrayList<>(xmlCommands.getChildren(XMLConstants.COMMAND));
        for (Element element : children)
        {
            EActorActionType action = getActorActionType(element.getChildText(XMLConstants.NAME));

            if (action != null)
                actions.add(action);
        }

        if (type != null)
        {
            switch (type)
            {
                case XMLConstants.LAN:
                case XMLConstants.INFRARED:
                    return EActorControlType.SENDER;

                case XMLConstants.TRUST:
                case XMLConstants.FS20:
                case XMLConstants.IKEA:
                case XMLConstants.UNIROLL:
                case XMLConstants.SONOS:
                case XMLConstants.INSTA:
                    //case XMLConstants.ROMOTEC: Achtung: Typ existiert nicht!

                    if (_mask(actions, DIM_UP, DIM_TO, DIM_DOWN))
                        return EActorControlType.REGULATOR;
                    else
                        return EActorControlType.DEFAULT;
            }
        }

        return EActorControlType.NOT_SUPPORTED;
    }

    /**
     * Gibt den AktorType eines Elements zurück
     * @param pElement XML des Elements
     * @return AktorType
     */
    public static EActorType getActorType(Element pElement)
    {
        String type = pElement.getChildText(XMLConstants.TYPE);

        if(type != null)
        {
            switch (type)
            {
                case XMLConstants.LAN:
                    return EActorType.LAN;
                case XMLConstants.INFRARED:
                    return EActorType.INFRARED;
                case XMLConstants.TRUST:
                    return EActorType.TRUST;
                case XMLConstants.FS20:
                    return EActorType.FS20;
                case XMLConstants.IKEA:
                    return EActorType.IKEA;
                case XMLConstants.UNIROLL:
                    return EActorType.UNIROLL;
                case XMLConstants.SONOS:
                    return EActorType.SONOS;
                case XMLConstants.INSTA:
                    return EActorType.INSTA;

            }
        }

        return EActorType.NOT_SUPPORTED;
    }

    /**
     * Gibt die AktorActionTyp aufgrund des übergebene Strings zurück
     * @param pActorAction XML Value
     * @return AktorActionTyp
     */
    public static EActorActionType getActorActionType(String pActorAction)
    {
        switch (pActorAction)
        {
            case XMLConstants.ON:
                return EActorActionType.TURN_ON;

            case XMLConstants.OFF:
                return EActorActionType.TURN_OFF;

            case XMLConstants.TOGGLE:
                return EActorActionType.TOGGLE;

            case XMLConstants.UP:
                return EActorActionType.UP;

            case XMLConstants.DOWN:
                return EActorActionType.DOWN;

            case XMLConstants.STOP:
                return EActorActionType.STOP;

            case XMLConstants.SCENE1:
                return EActorActionType.SCENE1;

            case XMLConstants.SCENE2:
                return EActorActionType.SCENE2;

            case XMLConstants.SCENE3:
                return EActorActionType.SCENE3;

            case XMLConstants.SCENE4:
                return EActorActionType.SCENE4;

            case XMLConstants.SCENE5:
                return EActorActionType.SCENE5;

            case XMLConstants.MASTER_ON:
                return EActorActionType.MASTER_ON;

            case XMLConstants.MASTER_OFF:
                return EActorActionType.MASTER_OFF;

            case XMLConstants.DIMUP:
                return EActorActionType.DIM_UP;

            case XMLConstants.DIMDOWN:
                return EActorActionType.DIM_DOWN;

            case XMLConstants.PLAY:
                return EActorActionType.PLAY;

            case XMLConstants.PAUSE:
                return EActorActionType.PAUSE;

            case XMLConstants.SKIP_PLUS:
                return EActorActionType.SKIP_PLUS;

            case XMLConstants.SKIP_MINUS:
                return EActorActionType.SKIP_MINUS;

            case XMLConstants.VOL_PLUS:
                return EActorActionType.VOL_PLUS;

            case XMLConstants.VOL_MINUS:
                return EActorActionType.VOL_MINUS;

            default:
                if(pActorAction.contains("%"))
                    return EActorActionType.DIM_TO;
        }
        return null;
    }

    /**
     * Gibt den passenden ActionExecutor eines Elements zurück
     * @param pElement XML des Elements
     * @return ActionExecutor
     */
    @NotNull
    public static IActionExecutor getActionExecutor(Element pElement)
    {
        EActorControlType controlType = getControlType(pElement);

        switch (controlType)
        {
            case DEFAULT:
                return new DefaultActionExecutor(pElement);
            case REGULATOR:
                return new RegulatorActionExecutor(pElement);
            case SENDER:
                return new SenderActionExecutor(pElement);
        }

        return new NullActionExecutor();
    }

    /**
     * Überprüft, ob die übergebene Liste alle übergebenen Actions beinhaltet
     * @param pList zu durchsuchende Liste
     * @param pActions zu überprüfende Actions
     * @return true, wenn Liste alle beinhaltet
     */
    private static boolean _mask(ArrayList pList, EActorActionType... pActions)
    {
        boolean contains = true;
        for (EActorActionType action : pActions)
        {
            if (!pList.contains(action))
            {
                contains = false;
                break;
            }
        }
        return contains;
    }
}
