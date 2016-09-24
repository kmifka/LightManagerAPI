package lightmanager;

/**
 * Listener für den Marker.
 *
 * @author Korbinian, 24.09.16
 */
public abstract class MarkerListener
{
    /**
     * Löst aus, wenn sich der Status des Markers geändert hat
     * @param pNewState neue Marker Status
     * @param pOldState alter Marker Status
     */
    public void change(EMarkerState pNewState, EMarkerState pOldState)
    {}
}
