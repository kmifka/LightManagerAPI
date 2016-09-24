package lightmanager;

/**
 * Stellt eine Szene (Zusammenschluss mehrerer Anweisungen) dar.
 *
 * @author Korbinian, 23.09.16
 */
public interface IScene extends ILightManagerObject
{
    /**
     * Startet die Szene
     */
    void Start();

    /**
     * Startet die Scene in einem neuen Thread
     */
    void StartAsync();
}
