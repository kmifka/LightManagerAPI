package lightmanager.actionexecutor;

import lightmanager.Action;
import lightmanager.XMLConstants;
import lightmanager.enums.EActorActionType;
import lightmanager.listeners.IActionListener;
import org.jdom.Element;

/**
 * Stellt einen Executer für Szenen dar.
 *
 * @author Korbinian, 04.10.16
 */
public class SceneExecutor
{
    private IActionListener listener;
    private String command;

    public SceneExecutor(Element pElement)
    {
        command = pElement.getChildText(XMLConstants.PARAM);
    }

    /**
     * Setzt den Listener, welcher beim Starten der Szene auslöst.
     * @param pListener zu setztender Listener
     */
    public void setListener(IActionListener pListener)
    {
        listener = pListener;
    }

    /**
     * Startet die Szene
     */
    public void startScene()
    {
        listener.send(new Action(command, EActorActionType.SEND));
    }
}
