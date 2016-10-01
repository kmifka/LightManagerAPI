package lightmanager.listeners;

/**
 * Listener für den UDP Datenverkehr zum Lightmanager
 *
 * @author Korbinian, 01.10.16
 */
public interface IUDPListener
{
    /**
     * Löst aus, wenn ein neues UDP Packet empfangen wurde
     * @param pMessage UDP achricht
     */
    void receive(String pMessage);
}
