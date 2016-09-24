package lightmanager;

/**
 * Listener für die Funk BUS Sender.
 *
 * @author Korbinian, 24.09.16
 */
public abstract class RadioBUSListener
{
    /**
     * Löst aus, wenn ein Funk BUS Sender gesendet hat
     * @param pRadioID die ID des Senders
     */
    public void send(String pRadioID)
    {}
}
