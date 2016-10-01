package lightmanager.listeners;

import lightmanager.Action;

/**
 * Listenerfür die ActionExecutor
 *
 * @author Korbinian, 24.09.16
 */
public interface IActionListener
{
    /**
     * Löst aus, wenn eine Aktion ausgeführt werden soll
     * @param pSrc auszuführende Aktion
     */
    void send(Action pSrc);
}
