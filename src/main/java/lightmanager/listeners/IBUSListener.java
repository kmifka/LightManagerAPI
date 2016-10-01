package lightmanager.listeners;

/**
 * Listener für die Funk BUS Sender.
 *
 * @author Korbinian, 24.09.16
 */
public interface IBUSListener
{
    /**
     * Löst aus, wenn ein Funk BUS Sender gesendet hat
     * @param pRadioID die ID des Senders
     */
    void receive(String pRadioID);
}
