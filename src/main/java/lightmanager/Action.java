package lightmanager;

import lightmanager.enums.EActorActionType;

/**
 * Stellt eine Aktion dar, welche den Name und den Command für den Lightmanager speichert
 *
 * @author Korbinian, 24.09.16
 */
public class Action
{
    private String command;
    private EActorActionType actionType;

    public Action(String pCommand, EActorActionType pActionType)
    {
        command = pCommand.trim();
        actionType = pActionType;
    }

    public String getCommand()
    {
        return command;
    }

    public EActorActionType getActionType()
    {
        return actionType;
    }
}
